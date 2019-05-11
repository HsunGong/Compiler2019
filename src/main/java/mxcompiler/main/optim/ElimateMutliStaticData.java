package mxcompiler.main.optim;

import java.util.*;

import mxcompiler.utils.entity.*;
import mxcompiler.utils.scope.*;

import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;


/**
 * The whole IR is built under Control Flow Graph Considered no SSA, no
 * tree
 */
public class ElimateMutliStaticData {

    private final Root root;

    private ToplevelScope toplevelScope;
    private List<GlobalVarInit> globalInitList = new ArrayList<>();

    private ClassEntity curClass = null;
    private Function curFunc = null;
    private BasicBlock curBB = null;
    private BasicBlock curLoopStepBB, curLoopAfterBB; // cur
    private Scope curScope;

    public ElimateMutliStaticData(Root root) {
        this.root = root;
    }

    // region StaticData process
    private class FuncDataInfo {
        Set<StaticData> definedData = new HashSet<>();
        /** use more than 1 time in caller and callee */
        Set<StaticData> mutliDefinedData = new HashSet<>(); // recursiveDefinedData
        /** use more than 1 time in caller and callee */
        Set<StaticData> mutliUsedData = new HashSet<>(); // recursiveUsedData
        /** a staticData(of vreg) map, set in {@link #getStaticDataVreg} */
        Map<StaticData, VirtualRegister> dataVregMap = new HashMap<>();
    }

    private Map<Function, FuncDataInfo> funcDataInfoMap = new HashMap<>();

    private boolean isMemWithStatic(Quad inst) {
        return (inst instanceof MemQuad && ((MemQuad) inst).isStaticData());
    }

    /**
     * init with a copy-name only register
     * <p>
     * put into a dataVregMap
     * <p>
     * and return this copy
     */
    private VirtualRegister getStaticDataVreg(Map<StaticData, VirtualRegister> dataVregMap,
            RegValue data) {
        StaticData staticData = (StaticData) data;
        VirtualRegister vreg = dataVregMap.get(staticData);

        if (vreg == null) {
            vreg = new VirtualRegister(staticData.getName());
            dataVregMap.put(staticData, vreg);
        }
        return vreg;
    }

    public void execute() {
        // init dataVregMap
        for (Function irFunc : root.getFunc().values()) {
            FuncDataInfo funcInfo = new FuncDataInfo();
            funcDataInfoMap.put(irFunc, funcInfo);

            Map<Register, Register> renameMap = new HashMap<>();
            for (BasicBlock bb : irFunc.getReversePostOrder()) {
                for (Quad inst : bb.getInsts()) {
                    if (isMemWithStatic(inst))
                        continue;

                    List<Register> usedRegisters = inst.getUsedRegisters();
                    if (!usedRegisters.isEmpty()) {
                        renameMap.clear();
                        for (Register reg : usedRegisters) { // sel can optim regs
                            if (reg instanceof StaticData && !(reg instanceof StaticString))
                                renameMap.put(reg, getStaticDataVreg(funcInfo.dataVregMap, reg));
                            else
                                renameMap.put(reg, reg);
                        }
                        inst.setUsedRegisters(renameMap);
                    }

                    Register definedRegister = inst.getDefinedRegister();
                    if (definedRegister instanceof StaticData) {
                        VirtualRegister vreg = getStaticDataVreg(funcInfo.dataVregMap,
                                definedRegister);
                        inst.setDefinedRegister(vreg);
                        funcInfo.definedData.add((StaticData) definedRegister);
                    }
                }
            }

            // load static data at the beginning of function--with a lambda

            BasicBlock startBB = irFunc.getStart(); // Tag
            LinkedList<Quad> insts = startBB.getInsts();
            funcInfo.dataVregMap.forEach((sData, vReg) -> {
                insts.addFirst(new Load(startBB, vReg, RegValue.RegSize, sData,
                        sData instanceof StaticString));
            }); // does this matter ?

            // ListIterator<Quad> firstIter = startBB.getInsts().listIterator();
            // firstIter.next();
            // funcInfo.dataVregMap.forEach((sData, vReg) -> {
            // startBB.addBeforeInst(firstIter, new Load(startBB, vReg,
            // RegValue.RegSize, sData, sData instanceof StaticString));
            // });
        }

        for (Function builtFunc : root.getBuiltInFunc().values())
            funcDataInfoMap.put(builtFunc, new FuncDataInfo());

        // set mutli (used and defined) Data
        for (Function irFunc : root.getFunc().values()) {
            FuncDataInfo callerInfo = funcDataInfoMap.get(irFunc);

            callerInfo.mutliUsedData.addAll(callerInfo.dataVregMap.keySet());
            callerInfo.mutliDefinedData.addAll(callerInfo.definedData);

            for (Function calleeFunc : irFunc.recursiveCalleeSet) {
                FuncDataInfo calleeInfo = funcDataInfoMap.get(calleeFunc);
                callerInfo.mutliUsedData.addAll(calleeInfo.dataVregMap.keySet());
                callerInfo.mutliDefinedData.addAll(calleeInfo.definedData);
            }
        }

        // deal data:::>>> calling--decrecase store and load data in funcall
        for (Function irFunc : root.getFunc().values()) {
            FuncDataInfo callerInfo = funcDataInfoMap.get(irFunc);
            Set<StaticData> usedStaticData = callerInfo.dataVregMap.keySet();
            if (usedStaticData.isEmpty())
                continue;

            // deal funcall
            for (BasicBlock bb : irFunc.getReversePostOrder()) {
                ListIterator<Quad> iter = bb.getInsts().listIterator();
                while (iter.hasNext()) {
                    Quad inst = iter.next();
                    if (!(inst instanceof Funcall))
                        continue;

                    Function calleeFunc = ((Funcall) inst).getFunc();
                    FuncDataInfo calleeInfo = funcDataInfoMap.get(calleeFunc);

                    // store defined static data before function call
                    for (StaticData staticData : callerInfo.definedData) {
                        if (staticData instanceof StaticString)
                            continue;
                        if (calleeInfo.mutliUsedData.contains(staticData)) {
                            bb.addBeforeInst(iter,
                                    new Store(bb, callerInfo.dataVregMap.get(staticData),
                                            RegValue.RegSize, staticData));
                        }
                    }

                    // load used static data after function call
                    // callee.mutliDefinedData + callerInfo.dataVregMap
                    if (calleeInfo.mutliDefinedData.isEmpty())
                        continue;
                    Set<StaticData> loadStaticDataSet = new HashSet<>();
                    loadStaticDataSet.addAll(calleeInfo.mutliDefinedData);
                    loadStaticDataSet.retainAll(usedStaticData); // callerInfo.dataVregMap.key
                    for (StaticData staticData : loadStaticDataSet) {
                        if (staticData instanceof StaticString)
                            continue;
                        bb.addAfterInst(iter, new Load(bb, callerInfo.dataVregMap.get(staticData),
                                RegValue.RegSize, staticData, staticData instanceof StaticString),
                                false);
                    }
                }
            }
        }

        // store defined data at the end of function
        for (Function irFunc : root.getFunc().values()) {
            FuncDataInfo funcInfo = funcDataInfoMap.get(irFunc);
            Return retInst = irFunc.returns.get(0);
            BasicBlock retBB = retInst.getParent();

            retBB.delJump(retInst);
            for (StaticData staticData : funcInfo.definedData) {
                retBB.addLastInst(new Store(retInst.getParent(),
                        funcInfo.dataVregMap.get(staticData), RegValue.RegSize, staticData));
            }
            retBB.setJump(retInst);
        }
    }

    // endregion
}