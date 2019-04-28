package mxcompiler.main;

import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;

import java.util.*;


public class RegisterAllocator {
    private final Root root;

    public RegisterAllocator(Root root) {
        this.root = root;
    }

    public void execute() throws Error {
        PreProcess();
        LifeCycleAnalysis();
        this.physicalRegs = new ArrayList<>(NASMRegisterSet.generalRegs);
        for (Function func : root.getFuncs().values()) {
            if (func.getArgVRegList().size() > root.getMaxNumFuncArgs())
                root.setMaxNumFuncArgs(func.getArgVRegList().size());
        }
        if (root.getMaxNumFuncArgs() >= 5)
            physicalRegs.remove(r8);
        if (root.getMaxNumFuncArgs() >= 6)
            physicalRegs.remove(r9);
        if (root.isHasDivShiftInst()) {
            preg0 = physicalRegs.get(0);
            preg1 = physicalRegs.get(1);
        } else {
            preg0 = rbx;
            preg1 = physicalRegs.get(0);
        }
        root.setPreg0(preg0);
        root.setPreg1(preg1);
        this.physicalRegs.remove(preg0);
        this.physicalRegs.remove(preg1);
        numColors = this.physicalRegs.size();

        Allocate();
    }

    // region pre process
    public void PreProcess() {
        for (Function func : root.getFunc().values()) {
            List<Quad> insts = func.start.getInsts();

            for (int i = 6; i < func.getArgVRegList().size(); ++i) {
                VirtualRegister argVreg = func.getArgVRegList().get(i);
                StackSlot argSlot = new StackSlot(func, "arg" + i, true);
                func.getArgsStackSlotMap().put(argVreg, argSlot);
                firtInst.prependInst(new IRLoad(firtInst.getParentBB(), argVreg,
                        Configuration.getRegSize(), argSlot, 0));
            }

            if (func.getArgVRegList().size() > 0)
                func.getArgVRegList().get(0).setForcedPhysicalRegister(NASMRegisterSet.rdi);
            if (func.getArgVRegList().size() > 1)
                func.getArgVRegList().get(1).setForcedPhysicalRegister(NASMRegisterSet.rsi);
            if (func.getArgVRegList().size() > 2)
                func.getArgVRegList().get(2).setForcedPhysicalRegister(NASMRegisterSet.rdx);
            if (func.getArgVRegList().size() > 3)
                func.getArgVRegList().get(3).setForcedPhysicalRegister(NASMRegisterSet.rcx);
            if (func.getArgVRegList().size() > 4)
                func.getArgVRegList().get(4).setForcedPhysicalRegister(NASMRegisterSet.r8);
            if (func.getArgVRegList().size() > 5)
                func.getArgVRegList().get(5).setForcedPhysicalRegister(NASMRegisterSet.r9);

        }
    }
    // endregion

    // region reg-live
    private boolean eliminationChanged;

    private void livelinessAnalysis(IRFunction irFunction) {
        List<BasicBlock> reversePreOrder = irFunction.getReversePreOrder();
        for (BasicBlock bb : reversePreOrder) {
            // init basic block
            for (IRInstruction inst = bb.getFirstInst(); inst != null; inst = inst
                    .getNextInst()) {
                if (inst.liveIn == null)
                    inst.liveIn = new HashSet<>();
                else
                    inst.liveIn.clear();
                if (inst.liveOut == null)
                    inst.liveOut = new HashSet<>();
                else
                    inst.liveOut.clear();
            }
        }
        Set<VirtualRegister> liveIn = new HashSet<>();
        Set<VirtualRegister> liveOut = new HashSet<>();

        // iterations to solve liveliness equation
        boolean converged = false;
        while (!converged) {
            converged = true;
            for (BasicBlock bb : reversePreOrder) {
                for (IRInstruction inst = bb.getLastInst(); inst != null; inst = inst
                        .getPrevInst()) {
                    liveIn.clear();
                    liveOut.clear();
                    if (inst instanceof IRJumpInstruction) {
                        if (inst instanceof IRJump) {
                            liveOut.addAll(
                                    ((IRJump) inst).getTargetBB().getFirstInst().liveIn);
                        } else if (inst instanceof IRBranch) {
                            liveOut.addAll(
                                    ((IRBranch) inst).getThenBB().getFirstInst().liveIn);
                            liveOut.addAll(
                                    ((IRBranch) inst).getElseBB().getFirstInst().liveIn);
                        }
                    } else {
                        if (inst.getNextInst() != null)
                            liveOut.addAll(inst.getNextInst().liveIn);
                    }
                    liveIn.addAll(liveOut);
                    IRRegister definedReg = inst.getDefinedRegister();
                    if (definedReg instanceof VirtualRegister) {
                        liveIn.remove(definedReg);
                    }
                    for (IRRegister usedReg : inst.getUsedRegisters()) {
                        if (usedReg instanceof VirtualRegister) {
                            liveIn.add((VirtualRegister) usedReg);
                        }
                    }
                    if (!inst.liveIn.equals(liveIn)) {
                        converged = false;
                        inst.liveIn.clear();
                        inst.liveIn.addAll(liveIn);
                    }
                    if (!inst.liveOut.equals(liveOut)) {
                        converged = false;
                        inst.liveOut.clear();
                        inst.liveOut.addAll(liveOut);
                    }
                }
            }
        }
    }

    void tryEliminate(IRFunction func) {
        List<BasicBlock> reversePreOrder = func.getReversePreOrder();
        for (BasicBlock bb : reversePreOrder) {
            for (IRInstruction inst = bb
                    .getLastInst(), prevInst; inst != null; inst = prevInst) {
                prevInst = inst.getPrevInst();
                if (inst instanceof IRBinaryOperation || inst instanceof IRComparison
                        || inst instanceof IRLoad || inst instanceof IRMove
                        || inst instanceof IRUnaryOperation || inst instanceof IRHeapAlloc) {
                    IRRegister dest = inst.getDefinedRegister();
                    if (dest == null || !inst.liveOut.contains(dest)) {
                        eliminationChanged = true;
                        inst.remove();
                    }
                }
            }
        }

        for (IRRoot.ForRecord forRec : root.forRecMap.values()) {
            if (forRec.processed)
                continue;
            boolean isFieldOutside = false;
            if (forRec.condBB == null || forRec.stepBB == null || forRec.bodyBB == null
                    || forRec.afterBB == null)
                continue;
            List<BasicBlock> bbList = new ArrayList<>();
            bbList.add(forRec.condBB);
            bbList.add(forRec.stepBB);
            bbList.add(forRec.bodyBB);
            bbList.add(forRec.afterBB);
            IRInstruction afterFirstInst = forRec.afterBB.getFirstInst();
            for (int i = 0; i < 3; ++i) {
                for (IRInstruction inst = bbList.get(i)
                        .getFirstInst(); inst != null; inst = inst.getNextInst()) {
                    if (inst instanceof IRFunctionCall) {
                        isFieldOutside = true;
                        continue;
                    }
                    if (inst.getDefinedRegister() != null) {
                        if (afterFirstInst.liveIn.contains(inst.getDefinedRegister())) {
                            isFieldOutside = true;
                        }
                        continue;
                    }
                    if (inst instanceof IRStore) {
                        isFieldOutside = true;
                        continue;
                    }
                    if (inst instanceof IRJump) {
                        if (!bbList.contains(((IRJump) inst).getTargetBB()))
                            isFieldOutside = true;
                        continue;
                    }
                    if (inst instanceof IRBranch) {
                        if (!bbList.contains(((IRBranch) inst).getThenBB())
                                || !bbList.contains(((IRBranch) inst).getElseBB()))
                            isFieldOutside = true;
                        continue;
                    }
                    if (inst instanceof IRReturn || inst instanceof IRPush
                            || inst instanceof IRStore) {
                        isFieldOutside = true;
                        continue;
                    }
                }
            }
            if (!isFieldOutside) {
                forRec.condBB.reInit();
                forRec.condBB.setJumpInst(new IRJump(forRec.condBB, forRec.afterBB));
                forRec.processed = true;
            }
        }
    }

    private Map<BasicBlock, BasicBlock> jumpTargetBBMap = new HashMap<>();

    BasicBlock replaceJumpTarget(BasicBlock bb) {
        BasicBlock ret = bb, query = jumpTargetBBMap.get(bb);
        while (query != null) {
            ret = query;
            query = jumpTargetBBMap.get(query);
        }
        return ret;
    }

    void removeBlankBB(IRFunction func) {
        jumpTargetBBMap.clear();
        for (BasicBlock bb : func.getReversePostOrder()) {
            if (bb.getFirstInst() == bb.getLastInst()) {
                IRInstruction inst = bb.getFirstInst();
                if (inst instanceof IRJump) {
                    jumpTargetBBMap.put(bb, ((IRJump) inst).getTargetBB());
                }
            }
        }
        for (BasicBlock bb : func.getReversePostOrder()) {
            if (bb.getLastInst() instanceof IRJump) {
                IRJump jumpInst = (IRJump) bb.getLastInst();
                jumpInst.setTargetBB(replaceJumpTarget(jumpInst.getTargetBB()));
            } else if (bb.getLastInst() instanceof IRBranch) {
                IRBranch branchInst = (IRBranch) bb.getLastInst();
                branchInst.setThenBB(replaceJumpTarget(branchInst.getThenBB()));
                branchInst.setElseBB(replaceJumpTarget(branchInst.getElseBB()));
                if (branchInst.getThenBB() == branchInst.getElseBB()) {
                    branchInst.replace(new IRJump(bb, branchInst.getThenBB()));
                }
            }
        }
    }

    public void LifeCycleAnalysis() {
        for (IRFunction irFunction : root.getFuncs().values()) {
            livelinessAnalysis(irFunction);
        }
        eliminationChanged = true;
        while (eliminationChanged) {
            eliminationChanged = false;
            for (IRFunction irFunction : root.getFuncs().values()) {
                if (irFunction.isBuiltIn())
                    continue;
                tryEliminate(irFunction);
                removeBlankBB(irFunction);
                livelinessAnalysis(irFunction);
            }
        }
    }
    // endregion

    // region allocate
    private List<PhysicalRegister> physicalRegs;
    private PhysicalRegister preg0, preg1;
    private int numColors;

    private class VirtualRegInfo {
        Set<VirtualRegister> neighbours = new HashSet<>();
        boolean removed = false;
        IRRegister color = null;
        int degree = 0;
        Set<VirtualRegister> suggestSameVRegs = new HashSet<>();
    }

    private VirtualRegInfo getVregInfo(VirtualRegister vreg) {
        VirtualRegInfo vregInfo = vregInfoMap.get(vreg);
        if (vregInfo == null) {
            vregInfo = new VirtualRegInfo();
            vregInfoMap.put(vreg, vregInfo);
        }
        return vregInfo;
    }

    private Map<VirtualRegister, VirtualRegInfo> vregInfoMap = new HashMap<>();
    private List<VirtualRegister> vregOrder = new ArrayList<>();
    private Set<PhysicalRegister> usedColors = new HashSet<>();
    private Set<VirtualRegister> vregNodes = new HashSet<>();
    private Set<VirtualRegister> degreeSmallVregNodes = new HashSet<>();

    private Map<IRRegister, IRRegister> renameMap = new HashMap<>();

    private void addEdge(VirtualRegister x, VirtualRegister y) {
        getVregInfo(x).neighbours.add(y);
        getVregInfo(y).neighbours.add(x);
    }

    private void removeVregNode(VirtualRegister vreg) {
        VirtualRegInfo vregInfo = vregInfoMap.get(vreg), neigbhourInfo;
        vregInfo.removed = true;
        vregNodes.remove(vreg);
        for (VirtualRegister neighbour : vregInfo.neighbours) {
            neigbhourInfo = vregInfoMap.get(neighbour);
            if (neigbhourInfo.removed)
                continue;
            ;
            --neigbhourInfo.degree;
            if (neigbhourInfo.degree < numColors) {
                degreeSmallVregNodes.add(neighbour);
            }
        }
    }

    public void Allocate() {
        for (Function irFunction : root.getFuncs().values()) {
            vregInfoMap.clear();
            vregNodes.clear();
            degreeSmallVregNodes.clear();

            for (VirtualRegister argVreg : irFunction.getArgVRegList()) {
                getVregInfo(argVreg);
            }
            for (BasicBlock bb : irFunction.getReversePreOrder()) {
                for (Quad inst = bb.getFirstInst(); inst != null; inst = inst.getNextInst()) {
                    IRRegister definedReg = inst.getDefinedRegister();
                    if (!(definedReg instanceof VirtualRegister))
                        continue;
                    VirtualRegInfo vregInfo = getVregInfo((VirtualRegister) definedReg);
                    if (inst instanceof IRMove) {
                        RegValue rhs = ((IRMove) inst).getRhs();
                        if (rhs instanceof VirtualRegister) {
                            vregInfo.suggestSameVRegs.add((VirtualRegister) rhs);
                            getVregInfo((VirtualRegister) rhs).suggestSameVRegs
                                    .add((VirtualRegister) definedReg);
                        }
                        for (VirtualRegister vreg : inst.liveOut) {
                            if (vreg != rhs && vreg != definedReg) {
                                addEdge(vreg, (VirtualRegister) definedReg);
                            }
                        }
                    } else {
                        for (VirtualRegister vreg : inst.liveOut) {
                            if (vreg != definedReg) {
                                addEdge(vreg, (VirtualRegister) definedReg);
                            }
                        }
                    }
                }
            }
            for (VirtualRegInfo vregInfo : vregInfoMap.values()) {
                vregInfo.degree = vregInfo.neighbours.size();
            }
            vregNodes.addAll(vregInfoMap.keySet());
            for (VirtualRegister vreg : vregNodes) {
                if (vregInfoMap.get(vreg).degree < numColors) {
                    degreeSmallVregNodes.add(vreg);
                }
            }

            vregOrder.clear();
            while (!vregNodes.isEmpty()) {
                while (!degreeSmallVregNodes.isEmpty()) {
                    Iterator<VirtualRegister> iterator = degreeSmallVregNodes.iterator();
                    VirtualRegister vreg = iterator.next();
                    iterator.remove();
                    removeVregNode(vreg);
                    vregOrder.add(vreg);
                }
                if (vregNodes.isEmpty())
                    break;
                Iterator<VirtualRegister> iterator = vregNodes.iterator();
                VirtualRegister vreg = iterator.next();
                iterator.remove();
                removeVregNode(vreg);
                vregOrder.add(vreg);
            }
            Collections.reverse(vregOrder);
            for (VirtualRegister vreg : vregOrder) {
                VirtualRegInfo vregInfo = vregInfoMap.get(vreg);
                vregInfo.removed = false;
                usedColors.clear();
                for (VirtualRegister neighbour : vregInfo.neighbours) {
                    VirtualRegInfo neighbourInfo = vregInfoMap.get(neighbour);
                    if (!neighbourInfo.removed
                            && neighbourInfo.color instanceof PhysicalRegister) {
                        usedColors.add((PhysicalRegister) neighbourInfo.color);
                    }
                }
                PhysicalRegister forcedPhysicalRegister = vreg.getForcedPhysicalRegister();
                if (forcedPhysicalRegister != null) {
                    if (usedColors.contains(forcedPhysicalRegister)) {
                        throw new CompilerError("forced physical register has been used");
                    }
                    vregInfo.color = forcedPhysicalRegister;
                } else {
                    for (VirtualRegister suggestSameVreg : vregInfo.suggestSameVRegs) {
                        IRRegister color = getVregInfo(suggestSameVreg).color;
                        if (color instanceof PhysicalRegister && !usedColors.contains(color)) {
                            vregInfo.color = color;
                            break;
                        }
                    }
                    if (vregInfo.color == null) {
                        for (PhysicalRegister physicalReg : physicalRegs) {
                            if (!usedColors.contains(physicalReg)) {
                                vregInfo.color = physicalReg;
                                break;
                            }
                        }
                        if (vregInfo.color == null) {
                            vregInfo.color = irFunction.getArgsStackSlotMap().get(vreg);
                            if (vregInfo.color == null)
                                vregInfo.color = new StackSlot(irFunction, vreg.getName(),
                                        false);
                        }
                    }
                }
            }

            updateInstruction(irFunction);
        }
    }

    private void updateInstruction(Function func) {
        for (BasicBlock bb : func.getReversePreOrder()) {
            for (Quad inst = bb.getFirstInst(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof IRFunctionCall) {
                    List<RegValue> args = ((IRFunctionCall) inst).getArgs();
                    for (int i = 0; i < args.size(); ++i) {
                        if (args.get(i) instanceof VirtualRegister) {
                            args.set(i, vregInfoMap.get(args.get(i)).color);
                        }
                    }
                } else {
                    Collection<IRRegister> usedRegisters = inst.getUsedRegisters();
                    if (!usedRegisters.isEmpty()) {
                        boolean usedPreg0 = false;
                        renameMap.clear();
                        for (IRRegister reg : usedRegisters) {
                            if (reg instanceof VirtualRegister) {
                                IRRegister color = vregInfoMap.get(reg).color;
                                if (color instanceof StackSlot) {
                                    PhysicalRegister preg;
                                    if (usedPreg0) {
                                        preg = preg1;
                                    } else {
                                        preg = preg0;
                                        usedPreg0 = true;
                                    }
                                    inst.prependInst(new IRLoad(bb, preg,
                                            Configuration.getRegSize(), color, 0));
                                    renameMap.put(reg, preg);
                                    func.getUsedPhysicalGeneralRegs().add(preg);
                                } else {
                                    renameMap.put(reg, color);
                                    func.getUsedPhysicalGeneralRegs()
                                            .add((PhysicalRegister) color);
                                }
                            } else {
                                renameMap.put(reg, reg);
                            }
                        }
                        inst.setUsedRegisters(renameMap);
                    }
                }
                IRRegister definedReg = inst.getDefinedRegister();
                if (definedReg instanceof VirtualRegister) {
                    IRRegister color = vregInfoMap.get(definedReg).color;
                    if (color instanceof StackSlot) {
                        inst.setDefinedRegister(preg0);
                        inst.appendInst(
                                new IRStore(bb, preg0, Configuration.getRegSize(), color, 0));
                        func.getUsedPhysicalGeneralRegs().add(preg0);
                        inst = inst.getNextInst();
                    } else {
                        inst.setDefinedRegister(color);
                        func.getUsedPhysicalGeneralRegs().add((PhysicalRegister) color);
                    }
                }
            }
        }
    }

    // endregion
}