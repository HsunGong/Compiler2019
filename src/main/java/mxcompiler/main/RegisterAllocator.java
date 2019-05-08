package mxcompiler.main;

import static mxcompiler.asm.x86_64RegisterSet.*;
import static mxcompiler.ir.register.RegValue.RegSize;
// import mxcompiler.asm.x86_64RegisterSet;

import mxcompiler.ast.expression.BinaryOpExprNode;
import mxcompiler.error.CompileError;
import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;
import java.util.*;


public class RegisterAllocator {
    private final Root root;
    private final Option opts;
    int MaxNumFuncArgs = 3;

    public RegisterAllocator(Root root, Option opts) {
        this.root = root;
        this.opts = opts;
    }

    public void execute() throws Error {
        // pre analysis
        AllocateNaiveArgs();
        LifeCycleAnalysis();

        PaintColors();

        return;
    }

    private void AllocateNaiveArgs() {
        for (Function func : root.getFunc().values()) {
            LinkedList<Quad> insts = func.getStart().getInsts();
            BasicBlock parent = func.getStart(); // Tag
            int size = func.argVregs.size();

            for (int i = 6; i < size; ++i) {
                VirtualRegister argVreg = func.argVregs.get(i);

                StackSlot argSlot = new StackSlot("arg" + Integer.toString(i), func, true);
                func.argsToStackSlot.put(argVreg, argSlot);

                // Tag : has order ?
                insts.addFirst(new Load(parent, argVreg, RegSize, argSlot, 0));
                // ListIterator<Quad> firstIter = startBB.getInsts().listIterator();
                // firstIter.next();
                // funcInfo.dataVregMap.forEach((sData, vReg) -> {
                // startBB.addBeforeInst(firstIter, new Load(startBB, vReg,
                // RegValue.RegSize,
                // sData, sData instanceof StaticString));
                // });
            }

            if (size > 0)
                func.argVregs.get(0).forcedPhysicalRegister = rdi;
            if (size > 1)
                func.argVregs.get(1).forcedPhysicalRegister = rsi;
            if (size > 2)
                func.argVregs.get(2).forcedPhysicalRegister = rdx;
            if (size > 3)
                func.argVregs.get(3).forcedPhysicalRegister = rcx;
            if (size > 4)
                func.argVregs.get(4).forcedPhysicalRegister = r8;
            if (size > 5)
                func.argVregs.get(5).forcedPhysicalRegister = r9;

            if (size > MaxNumFuncArgs)
                MaxNumFuncArgs = size;
        }
    }

    // region reg-live
    private boolean eliminationChanged;

    private void LifeCycleAnalysis() {
        for (Function irFunc : root.getFunc().values())
            livenessAnalysis(irFunc);

        do {
            eliminationChanged = false;

            for (Function irFunc : root.getFunc().values()) {
                if (irFunc.isBuiltIn())
                    continue;

                if (opts.OptimizationLevel() > 0)
                    tryEliminate(irFunc);

                removeBlankBB(irFunc);

                livenessAnalysis(irFunc);
            }
        } while (eliminationChanged);
    }

    private void livenessAnalysis(Function func) {
        List<BasicBlock> reversePreOrder = func.getReversePreOrder();

        for (BasicBlock bb : reversePreOrder) {
            for (Quad inst : bb.getInsts()) {
                inst.liveIn.clear();
                inst.liveOut.clear();
            }
        }

        Set<VirtualRegister> liveIn = new HashSet<>();
        Set<VirtualRegister> liveOut = new HashSet<>();

        // iterations to solve liveliness equation
        boolean changed;
        do {
            changed = true;

            // add liveIn and liveOut for each inst
            for (BasicBlock bb : reversePreOrder) {
                ListIterator<Quad> loopIter = bb.getInsts().listIterator(bb.getInsts().size());
                // last --> first
                while (loopIter.hasPrevious()) {
                    Quad inst = loopIter.previous();
                    liveIn.clear();
                    liveOut.clear();

                    // liveOut = sum_succ{liveIn}
                    if (inst instanceof JumpQuad) {
                        if (inst instanceof Jump) {
                            liveOut.addAll(((Jump) inst).getTarget().getInsts().getFirst().liveIn);
                        } else if (inst instanceof CJump) {
                            liveOut.addAll(((CJump) inst).getThen().getInsts().getFirst().liveIn);
                            liveOut.addAll(((CJump) inst).getElse().getInsts().getFirst().liveIn);
                        }
                    } else {
                        loopIter.next(); // return cur-inst
                        if (loopIter.hasNext()) { // still have next
                            Quad nextInst = loopIter.next(); // return next-inst
                            liveOut.addAll(nextInst.liveIn);
                            loopIter.previous(); // return next-inst
                        }
                        loopIter.previous(); // return cur-inst
                    }

                    // liveIn = use + (liveOut - def) 
                    // Solved: Must have order
                    // def = assign in this inst
                    liveIn.addAll(liveOut);
                    Register definedReg = inst.getDefinedRegister();
                    if (definedReg instanceof VirtualRegister)
                        liveIn.remove(definedReg);

                    // use = use before assign found
                    for (Register usedReg : inst.getUsedRegisters()) {
                        if (usedReg instanceof VirtualRegister)
                            liveIn.add((VirtualRegister) usedReg);
                    }



                    // check change
                    if (!inst.liveIn.equals(liveIn)) {
                        changed = false;
                        inst.liveIn.clear();
                        inst.liveIn.addAll(liveIn);
                    }
                    if (!inst.liveOut.equals(liveOut)) {
                        changed = false;
                        inst.liveOut.clear();
                        inst.liveOut.addAll(liveOut);
                    }

                }
            }
        } while (!changed);
    }

    /** eliminate useless inst and for-Body */
    private void tryEliminate(Function func) {
        List<BasicBlock> reversePreOrder = func.getReversePreOrder();

        // eliminate inst
        for (BasicBlock bb : reversePreOrder) {
            ListIterator<Quad> iter = bb.getInsts().listIterator(bb.getInsts().size());

            while (iter.hasPrevious()) {
                Quad inst = iter.previous();

                if (inst instanceof Bin || inst instanceof Cmp || inst instanceof Load
                        || inst instanceof Move || inst instanceof Uni
                        || inst instanceof HeapAlloc) {
                    Register dest = inst.getDefinedRegister();
                    if (dest == null || !inst.liveOut.contains(dest)) {
                        eliminationChanged = true;
                        bb.removeInstFromPrevious(iter);
                    }
                }
            }
        }

        // eliminate for-BBs
        for (Root.ForRecord forRec : root.forRecMap.values()) {
            if (forRec.processed)
                continue;
            if (forRec.cond == null || forRec.incr == null || forRec.body == null
                    || forRec.after == null)
                continue;

            boolean hasSideEffect = false;

            List<BasicBlock> bbList = new ArrayList<>();
            bbList.add(forRec.cond);
            bbList.add(forRec.incr);
            bbList.add(forRec.body);
            bbList.add(forRec.after);

            Quad afterFirstInst = forRec.after.getInsts().getFirst();

            for (BasicBlock bb : bbList) {
                for (Quad inst : bb.getInsts()) {
                    if (inst instanceof Funcall) {
                        hasSideEffect = true;
                        continue;
                    }

                    if (inst.getDefinedRegister() != null) {
                        if (afterFirstInst.liveIn.contains(inst.getDefinedRegister())) {
                            hasSideEffect = true;
                        }
                        continue;
                    }

                    if (inst instanceof Store) {
                        hasSideEffect = true;
                        continue;
                    }

                    if (inst instanceof Jump) {
                        if (!bbList.contains(((Jump) inst).getTarget()))
                            hasSideEffect = true;
                        continue;
                    }

                    if (inst instanceof CJump) {
                        if (!bbList.contains(((CJump) inst).getThen())
                                || !bbList.contains(((CJump) inst).getElse()))
                            hasSideEffect = true;
                        continue;
                    }

                    if (inst instanceof Return) { // no Push here
                        hasSideEffect = true;
                        continue;
                    }
                }
            }

            if (!hasSideEffect) {
                forRec.cond.clearInsts();
                forRec.cond.setJump(new Jump(forRec.cond, forRec.after));
                forRec.processed = true;
            }
        }
    }

    // "from" -> "to" via jumpTarget
    private BasicBlock replaceJumpTarget(BasicBlock from) {
        BasicBlock to = from, query = jumpTargetMap.get(from);

        while (query != null) {
            to = query;
            query = jumpTargetMap.get(query);
        }

        return to;
    }

    private Map<BasicBlock, BasicBlock> jumpTargetMap = new HashMap<>();

    private void removeBlankBB(Function func) {
        jumpTargetMap.clear();
        // put blank bb into jumpTargetMap
        for (BasicBlock bb : func.getReversePostOrder()) {
            if (bb.getInsts().getFirst() == bb.getInsts().getLast()) {
                Quad inst = bb.getInsts().getFirst();
                if (inst instanceof Jump)
                    jumpTargetMap.put(bb, ((Jump) inst).getTarget());
            }

            if (bb.getInsts().isEmpty())
                throw new CompileError("Error accured while del BB.insts");
        }

        for (BasicBlock bb : func.getReversePostOrder()) {
            Quad inst = bb.getInsts().getLast();
            if (inst instanceof Jump) {
                Jump jumpInst = (Jump) inst;
                jumpInst.setTarget(replaceJumpTarget(jumpInst.getTarget()));

            } else if (inst instanceof CJump) {
                CJump jumpInst = (CJump) inst;
                jumpInst.setThen(replaceJumpTarget(jumpInst.getThen()));
                jumpInst.setElse(replaceJumpTarget(jumpInst.getElse()));

                if (jumpInst.getThen() == jumpInst.getElse())
                    bb.replaceInst(bb.getInsts().listIterator(bb.getInsts().size()),
                            new Jump(bb, jumpInst.getThen()));
            }
        }
    }
    // endregion

    // region allocate-interference-graph
    private List<PhysicalRegister> physicalRegs; // general regs not r**
    private PhysicalRegister preg0, preg1; // used for stack slot
    private int numColors; // can defined once

    private void PaintColors() {
        // pre analysis-getConclusion
        this.physicalRegs = new ArrayList<>(generalRegs);

        if (MaxNumFuncArgs >= 5)
            physicalRegs.remove(r8);
        if (MaxNumFuncArgs >= 6)
            physicalRegs.remove(r9);

        if (root.hasDivShiftInst) {
            preg0 = physicalRegs.get(0);
            preg1 = physicalRegs.get(1);
        } else {
            preg0 = rbx;
            preg1 = physicalRegs.get(0);
        }

        root.preg0 = preg0;
        root.preg1 = preg1;
        this.physicalRegs.remove(preg0);
        this.physicalRegs.remove(preg1);

        numColors = this.physicalRegs.size();

        for (Function func : root.getFunc().values())
            Allocate(func);
    }

    // non-direct-graph
    private class VregInfo {
        boolean removed = false;
        Register color = null; // neither Physical or StackSlot
        int degree = 0;

        /** non-direct */
        Set<VirtualRegister> neighbours = new HashSet<>();
        /** used in MOVE a <- c */
        Set<VirtualRegister> SameVregs = new HashSet<>();
    }

    // put before get
    private VregInfo pgVregInfo(VirtualRegister vreg) {
        VregInfo vregInfo = vregInfoMap.get(vreg);
        if (vregInfo == null) {
            vregInfo = new VregInfo();
            vregInfoMap.put(vreg, vregInfo);
        }
        return vregInfo;
    }

    private Map<VirtualRegister, VregInfo> vregInfoMap = new HashMap<>();
    private List<VirtualRegister> vregOrder = new ArrayList<>();
    private Set<PhysicalRegister> usedColors = new HashSet<>();
    private Set<VirtualRegister> vregNodes = new HashSet<>();
    /** degree small: can start coloring from these nodes cause degree < k */
    private Set<VirtualRegister> startVregNodes = new HashSet<>();

    private void addEdge(VirtualRegister x, VirtualRegister y) {
        pgVregInfo(x).neighbours.add(y);
        pgVregInfo(y).neighbours.add(x);
    }

    /** totally remove from vregInfo, vregNode, startVregNodes */
    private void removeVregInfo(VirtualRegister vreg) {
        VregInfo vregInfo = vregInfoMap.get(vreg), neigbhourInfo;
        vregInfo.removed = true;

        for (VirtualRegister neighbour : vregInfo.neighbours) {
            neigbhourInfo = vregInfoMap.get(neighbour);
            if (neigbhourInfo.removed)
                continue;

            --neigbhourInfo.degree;
            if (neigbhourInfo.degree < numColors) {
                startVregNodes.add(neighbour);
            }
        }
    }

    public void Allocate(Function func) {
        vregInfoMap.clear();
        vregNodes.clear();
        startVregNodes.clear();
        vregOrder.clear();

        // STEP1: build
        // init Vreg Info
        func.argVregs.forEach(vreg -> pgVregInfo(vreg));
        for (BasicBlock bb : func.getReversePreOrder())
            for (Quad inst : bb.getInsts()) {
                Register definedReg = inst.getDefinedRegister();
                if (!(definedReg instanceof VirtualRegister))
                    continue;

                VregInfo vregInfo = pgVregInfo((VirtualRegister) definedReg);

                // add edge
                if (inst instanceof Move) { // may be same Reg
                    RegValue rhs = ((Move) inst).getRhs(); // add same Vreg
                    if (rhs instanceof VirtualRegister) {
                        vregInfo.SameVregs.add((VirtualRegister) rhs);
                        pgVregInfo((VirtualRegister) rhs).SameVregs
                                .add((VirtualRegister) definedReg);
                    }

                    for (VirtualRegister vreg : inst.liveOut)
                        if (vreg != rhs && vreg != definedReg)
                            addEdge(vreg, (VirtualRegister) definedReg);
                } else {
                    for (VirtualRegister vreg : inst.liveOut)
                        if (vreg != definedReg)
                            addEdge(vreg, (VirtualRegister) definedReg);
                }
            }
        vregInfoMap.values().forEach(info -> info.degree = info.neighbours.size());

        // init Vreg Node and Start Vreg Node
        vregNodes.addAll(vregInfoMap.keySet());
        /**
         * vregNodes.forEach(vreg -> { if (vregInfoMap.get(vreg).degree <
         * numColors) startVregNodes.add(vreg); });
         */
        vregNodes.stream().filter(vreg -> (vregInfoMap.get(vreg).degree < numColors))
                .forEach(startVregNodes::add);

        // STEP2: simplify
        // get Vreg Order-Stack
        // TODO: make coalesce of graph
        while (!vregNodes.isEmpty()) {
            while (!startVregNodes.isEmpty()) {
                Iterator<VirtualRegister> iter = startVregNodes.iterator();
                VirtualRegister vreg = iter.next();

                iter.remove();
                vregNodes.remove(vreg);
                removeVregInfo(vreg);

                vregOrder.add(vreg);
            }
            if (vregNodes.isEmpty())
                break;

            // once can noly delete 1 (degree can change)
            VirtualRegister vreg = vregNodes.iterator().next();

            vregNodes.remove(vreg);
            removeVregInfo(vreg);

            // STEP2-3: spill
            vregOrder.add(vreg);
        }

        // STEP3: select
        // paint color
        Collections.reverse(vregOrder);
        for (VirtualRegister vreg : vregOrder) {
            // add color
            VregInfo vregInfo = vregInfoMap.get(vreg);
            vregInfo.removed = false;

            // set used color
            usedColors.clear();
            for (VirtualRegister neighbour : vregInfo.neighbours) {
                VregInfo neighbourInfo = vregInfoMap.get(neighbour);
                if (!neighbourInfo.removed && neighbourInfo.color instanceof PhysicalRegister)
                    usedColors.add((PhysicalRegister) neighbourInfo.color);
            }

            // paint
            PhysicalRegister allocatedPreg = vreg.forcedPhysicalRegister;
            if (allocatedPreg != null) { // forced-Pregs: args
                if (usedColors.contains(allocatedPreg))
                    throw new CompileError("forced physical register has been used");

                vregInfo.color = allocatedPreg;
            } else {
                // paint same color from move-inst
                for (VirtualRegister moveVreg : vregInfo.SameVregs) {
                    Register color = pgVregInfo(moveVreg).color; // may changed move-vreg

                    if (color instanceof PhysicalRegister && !usedColors.contains(color)) {
                        vregInfo.color = color; // changed vreg
                        break;
                    }
                }

                // real paint color
                if (vregInfo.color == null) {
                    // allocate preg by order
                    for (PhysicalRegister preg : physicalRegs)
                        if (!usedColors.contains(preg)) {
                            vregInfo.color = preg;
                            break;
                        }

                    // no preg can be used -- > spill
                    if (vregInfo.color == null) {
                        // already have stack ?
                        vregInfo.color = func.argsToStackSlot.get(vreg);

                        if (vregInfo.color == null) // still no stack -> add stack inside
                            vregInfo.color = new StackSlot(vreg.getName(), func, false);
                    }
                }
            }
        }

        // STEP4: start over(deal StackSlot)
        // update color after setting stack
        for (BasicBlock bb : func.getReversePreOrder()) {
            ListIterator<Quad> iter = bb.getInsts().listIterator();
            while (iter.hasNext()) // Solved: iter.next outside
                updateInstruction(func, iter);
        }
    }

    /** rename same name reg with colored reg */
    private void updateInstruction(Function func, ListIterator<Quad> iter) {
        Quad inst = iter.next();
        BasicBlock bb = inst.getParent();

        // set used Regs
        if (inst instanceof Funcall) { // set more args
            List<RegValue> args = ((Funcall) inst).getArgs();
            for (int i = 0; i < args.size(); ++i) {
                if (args.get(i) instanceof VirtualRegister) {
                    args.set(i, vregInfoMap.get(args.get(i)).color);
                }
            }

            // FIX: UGLY: why can not ??
            // List<Register> usedRegs = inst.getUsedRegisters();
            // for (int i = 0; i < usedRegs.size(); ++i) {
            // // can check args 1 to 6 is PhysicalRegister
            // if (usedRegs.get(i) instanceof VirtualRegister)
            // usedRegs.set(i, vregInfoMap.get(usedRegs.get(i)).color);
            // }
        } else { // rename used registers
            List<Register> usedRegs = inst.getUsedRegisters();
            if (!usedRegs.isEmpty()) {
                boolean usedPreg0 = false;
                Map<Register, Register> renameMap = new HashMap<>();

                for (Register reg : usedRegs) {
                    if (reg instanceof VirtualRegister) {
                        Register color = vregInfoMap.get(reg).color;

                        if (color instanceof StackSlot) {
                            PhysicalRegister preg;
                            if (usedPreg0) {
                                preg = preg1;
                            } else {
                                preg = preg0;
                                usedPreg0 = true;
                            }

                            bb.addBeforeInst(iter, new Load(bb, preg, RegSize, color, 0));
                            color = preg;
                        }

                        renameMap.put(reg, color);
                        func.usedPhysicalGeneralRegs.add((PhysicalRegister) color);
                    } else {
                        renameMap.put(reg, reg); // UGLY: NOTE: maybe can delete(no use)
                    }
                }

                inst.setUsedRegisters(renameMap);
            }
        }

        // set defined Regs
        Register definedReg = inst.getDefinedRegister();
        if (definedReg instanceof VirtualRegister) {
            Register color = vregInfoMap.get(definedReg).color;
            if (color instanceof StackSlot) {
                bb.addAfterInst(iter, new Store(bb, preg0, RegSize, color, 0), false);
                color = preg0;
            }

            inst.setDefinedRegister(color);
            func.usedPhysicalGeneralRegs.add((PhysicalRegister) color);
        }

    }

    // endregion
}
