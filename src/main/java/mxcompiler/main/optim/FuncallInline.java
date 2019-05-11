package mxcompiler.main.optim;

import java.util.*;

import mxcompiler.utils.entity.*;
import mxcompiler.utils.scope.*;

import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;


public class FuncallInline {

    private final Root root;

    private ToplevelScope toplevelScope;
    private List<GlobalVarInit> globalInitList = new ArrayList<>();

    private ClassEntity curClass = null;
    private Function curFunc = null;
    private BasicBlock curBB = null;
    private BasicBlock curLoopStepBB, curLoopAfterBB; // cur
    private Scope curScope;


    public FuncallInline(Root root) {
        this.root = root;
    }

    // region short cut to inline-funcall
    private final int MAX_INLINE_INST = 30;
    private final int MAX_LOW_INLINE_INST = 30;
    private final int MAX_FUNC_INST = 1 << 12;
    private final int MAX_INLINE_DEPTH = 5;

    private class FuncInfo {
        int numInst = 0, numCalled = 0;
        boolean recursiveCall, memFunc = false;
    }

    private Map<Function, FuncInfo> funcInfoMap = new HashMap<>();
    private Map<Function, Function> funcBackUpMap = new HashMap<>();

    private Function genBackUpFunc(Function func) {
        Function bakFunc = new Function(func.getEntity());
        Map<Object, Object> bbRenameMap = new HashMap<>();
        for (BasicBlock bb : func.getReversePostOrder())
            bbRenameMap.put(bb, new BasicBlock(bakFunc, bb.getName()));

        for (BasicBlock bb : func.getReversePostOrder()) {
            BasicBlock bakBB = (BasicBlock) bbRenameMap.get(bb);

            for (Quad inst : bb.getInsts()) {
                if (inst instanceof JumpQuad)
                    bakBB.setJump((JumpQuad) inst.copyRename(bbRenameMap));
                else
                    bakBB.addLastInst(inst.copyRename(bbRenameMap));
            }
        }

        // Tag
        bakFunc.setStart((BasicBlock) bbRenameMap.get(func.getStart()));
        bakFunc.setEnd((BasicBlock) bbRenameMap.get(func.getEnd()));
        bakFunc.argVregs = func.argVregs;
        return bakFunc;
    }

    public void execute() {
        // pre-resolve
        for (Function irFunc : root.getFunc().values()) { // add func
            irFunc.isRecursiveCall = irFunc.recursiveCalleeSet.contains(irFunc);
            FuncInfo funcInfo = new FuncInfo();

            funcInfo.recursiveCall = irFunc.isRecursiveCall;
            funcInfo.memFunc = irFunc.isMemFunc;
            funcInfoMap.put(irFunc, funcInfo);
        }
        for (Function irFunc : root.getFunc().values()) { // add calleeInfo
            FuncInfo funcInfo = funcInfoMap.get(irFunc);

            for (BasicBlock bb : irFunc.getReversePostOrder()) {
                for (Quad inst : bb.getInsts()) {
                    ++funcInfo.numInst;

                    if (inst instanceof Funcall) {
                        FuncInfo calleeInfo = funcInfoMap.get(((Funcall) inst).getFunc());

                        if (calleeInfo != null)
                            ++calleeInfo.numCalled;
                    }
                }
            }
        }

        // region remove unused function
        List<BasicBlock> reversePostOrder = new ArrayList<>();
        List<String> unCalledFuncs = new ArrayList<>();

        /** if changed, will restart func-bb-order */
        boolean thisFuncChanged;
        boolean changed;
        do {
            changed = false;
            unCalledFuncs.clear();

            for (Function irFunc : root.getFunc().values()) {
                thisFuncChanged = false;

                FuncInfo funcInfo = funcInfoMap.get(irFunc);
                reversePostOrder.clear(); // cur func
                reversePostOrder.addAll(irFunc.getReversePostOrder());

                for (BasicBlock bb : reversePostOrder) {
                    ListIterator<Quad> iter = bb.getInsts().listIterator();
                    while (iter.hasNext()) {
                        Quad inst = iter.next();
                        if (!(inst instanceof Funcall))
                            continue;
                        FuncInfo calleeInfo = funcInfoMap.get(((Funcall) inst).getFunc());
                        if (calleeInfo == null)
                            continue; // skip built-in functions
                        if (calleeInfo.recursiveCall)
                            continue; // skip self recursive function
                        if (calleeInfo.memFunc)
                            continue;
                        if (calleeInfo.numInst > MAX_LOW_INLINE_INST
                                || calleeInfo.numInst + funcInfo.numInst > MAX_FUNC_INST)
                            continue;

                        iter = inlineFuncall(iter);

                        changed = true;
                        thisFuncChanged = true;
                        funcInfo.numInst += calleeInfo.numInst;

                        --calleeInfo.numCalled;
                        if (calleeInfo.numCalled == 0)
                            unCalledFuncs.add(((Funcall) inst).getFunc().getName());
                    }
                }

                if (thisFuncChanged)
                    irFunc.initReversePostOrder();
            }

            // del-func
            for (String funcName : unCalledFuncs)
                root.delFunc(funcName); // Tag
        } while (changed);

        root.updateCalleeSet();
        // endregion

        // region inline recursive functions
        reversePostOrder = new ArrayList<>();

        changed = true;
        for (int i = 0; changed && i < MAX_INLINE_DEPTH; ++i) {
            changed = false;

            // bak up self recursive functions
            funcBackUpMap.clear();
            for (Function irFunc : root.getFunc().values()) {
                FuncInfo funcInfo = funcInfoMap.get(irFunc);
                if (!funcInfo.recursiveCall)
                    continue;
                funcBackUpMap.put(irFunc, genBackUpFunc(irFunc));
            }

            for (Function irFunc : root.getFunc().values()) {
                FuncInfo funcInfo = funcInfoMap.get(irFunc);
                reversePostOrder.clear();
                reversePostOrder.addAll(irFunc.getReversePostOrder());
                thisFuncChanged = false;

                for (BasicBlock bb : reversePostOrder) {
                    ListIterator<Quad> iter = bb.getInsts().listIterator();
                    while (iter.hasNext()) {
                        Quad inst = iter.next();

                        if (!(inst instanceof Funcall))
                            continue;
                        FuncInfo calleeInfo = funcInfoMap.get(((Funcall) inst).getFunc());
                        if (calleeInfo == null)
                            continue; // skip built-in functions
                        if (calleeInfo.memFunc)
                            continue;
                        if (calleeInfo.numInst > MAX_INLINE_INST
                                || calleeInfo.numInst + funcInfo.numInst > MAX_FUNC_INST)
                            continue;

                        iter = inlineFuncall(iter);
                        changed = true;
                        thisFuncChanged = true;
                        funcInfo.numInst += calleeInfo.numInst;
                    }
                }

                if (thisFuncChanged)
                    irFunc.initReversePostOrder();
            }
        }

        root.updateCalleeSet();
        // endregion
    }

    /**
     * iter has to point to next
     * <p>
     * make function into block(means inline)
     * <p>
     * 
     * <pre>
     * // before: inst(selected) iter inst2
     * // before: iter inst(selected) inst2
     * iter = inlineFuncall(iter)
     * </pre>
     * 
     * @Return iter of newEnd's FirstInst
     */
    private ListIterator<Quad> inlineFuncall(ListIterator<Quad> iter) {
        iter.previous();
        Funcall funcCallInst = (Funcall) iter.next();
        BasicBlock parent = funcCallInst.getParent(); // or newStartBB

        Function callerFunc = parent.getFunc();
        Function calleeFunc = funcBackUpMap.getOrDefault(funcCallInst.getFunc(),
                funcCallInst.getFunc());
        List<BasicBlock> inlineBBpostOrder = calleeFunc.getReversePostOrder();

        Map<Object, Object> renameMap = new HashMap<>();
        BasicBlock oldEndBB = calleeFunc.getEnd();
        BasicBlock newEndBB = new BasicBlock(callerFunc, oldEndBB.getName());
        renameMap.put(oldEndBB, newEndBB);
        renameMap.put(calleeFunc.getStart(), parent); // Tag

        if (callerFunc.getEnd() == parent)
            callerFunc.setEnd(newEndBB);

        // add after-funcall insts into new end(first)
        Map<Object, Object> callBBRenameMap = Collections.singletonMap(parent, newEndBB);
        while (iter.hasNext()) {
            Quad inst = iter.next();

            if (inst instanceof JumpQuad) {
                newEndBB.setJump((JumpQuad) ((JumpQuad) inst).copyRename(callBBRenameMap));
            } else {
                newEndBB.addLastInst(inst.copyRename(callBBRenameMap));
            }
            parent.removeInst(iter);
        }
        ListIterator<Quad> newEndFirstIter = newEndBB.getInsts().listIterator();
        newEndFirstIter.next();

        // add before-args
        for (int i = 0; i < funcCallInst.getArgs().size(); ++i) {
            VirtualRegister oldArgVreg = calleeFunc.argVregs.get(i);
            VirtualRegister newArgVreg = oldArgVreg.copy();

            parent.addBeforeInst(iter, new Move(parent, newArgVreg, funcCallInst.getArgs().get(i)));
            renameMap.put(oldArgVreg, newArgVreg);
        }

        parent.removeInst(iter);

        // copy funcall-block into parent(cause may have args move)
        for (BasicBlock bb : inlineBBpostOrder) { // put BB-rename
            if (!renameMap.containsKey(bb))
                renameMap.put(bb, new BasicBlock(callerFunc, bb.getName()));
        }

        for (BasicBlock oldBB : inlineBBpostOrder) { // add inst
            BasicBlock newBB = (BasicBlock) renameMap.get(oldBB);

            // change forRecord
            if (oldBB.forNode != null) {
                Root.ForRecord forRec = root.forRecMap.get(oldBB.forNode);
                if (forRec.cond == oldBB)
                    forRec.cond = newBB;
                if (forRec.incr == oldBB)
                    forRec.incr = newBB;
                if (forRec.body == oldBB)
                    forRec.body = newBB;
                if (forRec.after == oldBB)
                    forRec.after = newBB;
            }

            // change for insts(include regs)
            iter = oldBB.getInsts().listIterator();
            while (iter.hasNext()) {
                Quad inst = iter.next();

                // add new regValue(copy) into renameMap
                for (RegValue usedRegValue : inst.getUsedRegValues())
                    copyRegValue(renameMap, usedRegValue);
                if (inst.getDefinedRegister() != null)
                    copyRegValue(renameMap, inst.getDefinedRegister());

                // add insts
                if (newBB != newEndBB) { // normall BB
                    if (inst instanceof JumpQuad) {
                        if (!(inst instanceof Return)) {
                            newBB.setJump((JumpQuad) inst.copyRename(renameMap));
                        }
                    } else
                        newBB.addLastInst(inst.copyRename(renameMap));

                } else { // last BB -- add insts(second)
                    if (!(inst instanceof Return))
                        newEndBB.addBeforeInst(newEndFirstIter, inst.copyRename(renameMap));
                }
            }
        }

        // newStartBB(parent) ->(Jump) newEndBB
        if (!parent.hasJump())
            parent.setJump(new Jump(parent, newEndBB));

        Return returnInst = calleeFunc.returns.get(0);
        if (returnInst.getReturnValue() != null) {
            newEndBB.addBeforeInst(newEndFirstIter, new Move(newEndBB, funcCallInst.getDst(),
                    (RegValue) renameMap.get(returnInst.getReturnValue())));
        }

        return newEndBB.getInsts().listIterator();
    }

    /** put regvalue(copy) into renameMap */
    private void copyRegValue(Map<Object, Object> renameMap, RegValue regValue) {
        if (!renameMap.containsKey(regValue))
            renameMap.put(regValue, regValue.copy());
    }
    // endregion
}
