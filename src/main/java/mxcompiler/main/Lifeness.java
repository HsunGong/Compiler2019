package mxcompiler.main;

import static mxcompiler.asm.x86_64RegisterSet.*;
import static mxcompiler.ir.register.RegValue.RegSize;
// import mxcompiler.asm.x86_64RegisterSet;

import mxcompiler.error.CompileError;
import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;
import java.util.*;


public class Lifeness {
    private final Root root;

    public Lifeness(Root root) {
        this.root = root;
    }

    private boolean eliminationChanged;

    public void execute() {
        for (Function irFunc : root.getFunc().values())
            livenessAnalysis(irFunc);

        do {
            eliminationChanged = false;

            for (Function irFunc : root.getFunc().values()) {
                if (irFunc.isBuiltIn())
                    continue;

                delete(irFunc);

                delBB(irFunc);

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
    private void delete(Function func) {
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
        for (Root.ForRecord record : root.forRecMap.values()) {
            if (record.processed)
                continue;
            if (record.cond == null || record.incr == null || record.body == null
                    || record.after == null)
                continue;

            boolean hasSideEffect = false;

            List<BasicBlock> bbList = new ArrayList<>();
            bbList.add(record.cond);
            bbList.add(record.incr);
            bbList.add(record.body);
            bbList.add(record.after);

            Quad afterFirstInst = record.after.getInsts().getFirst();

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
                record.cond.clearInsts();
                record.cond.setJump(new Jump(record.cond, record.after));
                record.processed = true;
            }
        }
    }

    // "from" -> "to" via jumpTarget
    private BasicBlock replaceTarget(BasicBlock from) {
        BasicBlock to = from, query = jumpTargetMap.get(from);

        while (query != null) {
            to = query;
            query = jumpTargetMap.get(query);
        }

        return to;
    }

    private Map<BasicBlock, BasicBlock> jumpTargetMap = new HashMap<>();

    private void delBB(Function func) {
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
                jumpInst.setTarget(replaceTarget(jumpInst.getTarget()));

            } else if (inst instanceof CJump) {
                CJump jumpInst = (CJump) inst;
                jumpInst.setThen(replaceTarget(jumpInst.getThen()));
                jumpInst.setElse(replaceTarget(jumpInst.getElse()));

                if (jumpInst.getThen() == jumpInst.getElse())
                    bb.replaceInst(bb.getInsts().listIterator(bb.getInsts().size()),
                            new Jump(bb, jumpInst.getThen()));
            }
        }
    }
}