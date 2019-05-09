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


/**
 * mem allocate and stack deal
 */
public class MemAndStack {
    private final Root root;
    int MaxNumFuncArgs = 3;

    public MemAndStack(Root root) {
        this.root = root;
    }

    public void execute() throws Error {
        dealFunc();

        return;
    }

    // region deal Funcall
    /** Info of Regs */
    private class FuncInfo {
        List<PhysicalRegister> usedCallerSaveRegs = new ArrayList<>();
        List<PhysicalRegister> usedCalleeSaveRegs = new ArrayList<>();
        Set<PhysicalRegister> recursiveUsedRegs = new HashSet<>();
        Map<StackSlot, Integer> stackOffsetMap = new HashMap<>();
        int numExtraArgs; // for before frame
        int numStackSlot = 0; // for frame
    }

    private Map<Function, FuncInfo> funcInfoMap = new HashMap<>();

    private void dealFunc() {
        // init funcInfo
        root.getBuiltInFunc().values().forEach(func -> funcInfoMap.put(func, new FuncInfo()));
        
        for (Function func : root.getFunc().values()) {
            FuncInfo info = new FuncInfo();

            // used regs
            for (PhysicalRegister preg : func.usedPhysicalGeneralRegs) {
                if (preg.isCalleeSave())
                    info.usedCalleeSaveRegs.add(preg);
                if (preg.isCallerSave())
                    info.usedCallerSaveRegs.add(preg);
            }
            // deal rbx if (!root.hasDivShiftInst) ??
            //if (!info.usedCalleeSaveRegs.contains(rbx))
            info.usedCalleeSaveRegs.add(rbx); // maybe have used ??, no need to add again
            info.usedCalleeSaveRegs.add(rbp);

            // stackSlot
            info.numStackSlot = func.stackSlots.size();
            for (int i = 0; i < info.numStackSlot; ++i)
                info.stackOffsetMap.put(func.stackSlots.get(i), i * RegSize);
            if ((info.usedCalleeSaveRegs.size() + info.numStackSlot) % 2 == 0) // align
                ++info.numStackSlot;

            // return need 1 : info.usedCalleeSaveRegs.size() + info.numStackSlot + 1

            // extra args ->> no need for builtIn
            int argOffset = (info.usedCalleeSaveRegs.size() + info.numStackSlot + 1) * RegSize;
            for (int i = 6; i < func.argVregs.size(); ++i) {
                info.stackOffsetMap.put(func.argsToStackSlot.get(func.argVregs.get(i)), argOffset);
                argOffset += RegSize;
            }
            info.numExtraArgs = func.argVregs.size() - Arg_Num;
            if (info.numExtraArgs < 0)
                info.numExtraArgs = 0;

            funcInfoMap.put(func, info);
        }

        // add recursive used regs from used-preg-general
        for (Function func : funcInfoMap.keySet()) {
            FuncInfo info = funcInfoMap.get(func);

            info.recursiveUsedRegs.addAll(func.usedPhysicalGeneralRegs);
            for (Function calleeFunc : func.recursiveCalleeSet)
                info.recursiveUsedRegs.addAll(calleeFunc.usedPhysicalGeneralRegs);
        }

        // execute func
        for (Function func : root.getFunc().values()) {
            FuncInfo info = funcInfoMap.get(func);
            BasicBlock enterBB = func.getStart(); // Tag
            ListIterator<Quad> firstIter = enterBB.getInsts().listIterator();
            firstIter.next(); // get First inst

            // push used_Reg(func)
            info.usedCalleeSaveRegs
                    .forEach(preg -> enterBB.addBeforeInst(firstIter, new Push(enterBB, preg)));

            // change rsp and rbp
            if (info.numStackSlot > 0) {
                IntImm stackOffset = new IntImm(info.numStackSlot * RegSize);
                enterBB.addBeforeInst(firstIter,
                        new Bin(enterBB, rsp, BinaryOpExprNode.Op.SUB, rsp, stackOffset));
            }
            enterBB.addBeforeInst(firstIter, new Move(enterBB, rbp, rsp));
            for (BasicBlock bb : func.getReversePostOrder()) {
                ListIterator<Quad> iter = bb.getInsts().listIterator();
                while (iter.hasNext()) { // Solved: iter.next outside
                    Quad inst = iter.next();
                    if (inst instanceof Funcall) {
                        dealCallee(func, info, (Funcall) inst, iter);
                    } else if (inst instanceof HeapAlloc) {
                        dealHeapAlloc(func, info, (HeapAlloc) inst, iter);
                    } else if (inst instanceof MemQuad) { // load and store
                        MemQuad tmpInst = (MemQuad) inst;
                        if (tmpInst.baseAddr instanceof StackSlot) {
                            tmpInst.offset = info.stackOffsetMap.get(tmpInst.baseAddr);
                            tmpInst.baseAddr = rbp;
                        }
                    } else if (inst instanceof Move) {
                        Move tmpInst = (Move) inst;
                        if (tmpInst.getDst() == tmpInst.getRhs())
                            bb.removeInst(iter);// remove useless move: a <- a
                    }
                }
            }

            Return retInst = func.returns.get(0); // will only get 1 return(merged)
            if (retInst.getReturnValue() != null) {
                BasicBlock retBB = retInst.getParent();
                retBB.delJump(retInst);
                retBB.addLastInst(new Move(retBB, rax, retInst.getReturnValue()));
                retBB.setJump(retInst);
            }
            // FIX: BUG: error when del + set Jump -> removed = true ??

            // recover rsp
            ListIterator<Quad> lastIter = func.getEnd().getInsts()
                    .listIterator(func.getEnd().getInsts().size() - 1);
            lastIter.next(); // Tag

            if (info.numStackSlot > 0) {
                IntImm offset = new IntImm(info.numStackSlot * RegSize);
                enterBB.addBeforeInst(lastIter,
                        new Bin(enterBB, rsp, BinaryOpExprNode.Op.ADD, rsp, offset));
            }

            // for (int i = info.usedCalleeSaveRegs.size() - 1; i >= 0; --i)
            // enterBB.addBeforeInst(lastIter,
            // new Pop(enterBB, info.usedCalleeSaveRegs.get(i)));

            // Solved: will work
            lastIter.previous();
            for (PhysicalRegister preg : info.usedCalleeSaveRegs) {
                enterBB.addAfterInst(lastIter, new Pop(enterBB, preg), true);
            }
            // info.usedCalleeSaveRegs
            // .forEach(preg -> enterBB.addAfterInst(lastIter, new Pop(enterBB,
            // preg)));
        }
    }

    /**
     * funcall : caller-args stored and push callee-args to reg
     */
    private void dealCallee(Function func, FuncInfo callerInfo, Funcall inst,
            ListIterator<Quad> iter) {
        Quad nextInst = iter.next();
        iter.previous();

        int callerArgSize = func.argVregs.size();
        BasicBlock parent = inst.getParent();

        FuncInfo calleeInfo = funcInfoMap.get(inst.getFunc());

        // region push: caller-comflict-regs and args
        /** Caller and Callee Conflict with registers */
        int ConflictNum = 0;

        // push caller save registers which would be changed by callee
        for (PhysicalRegister preg : callerInfo.usedCallerSaveRegs) {
            // preg is arg and idx is aviliable
            if (preg.isArg() && preg.getArgIdx() < callerArgSize)
                continue;

            // preg is used in both caller(func) and callee func(funcall)
            if (calleeInfo.recursiveUsedRegs.contains(preg)) {
                ++ConflictNum;
                parent.addBeforeInst(iter, new Push(parent, preg));
            }
        }

        // push argument registers
        int callerArgPregNum = (callerArgSize <= Arg_Num) ? callerArgSize : Arg_Num;
        for (int i = 0; i < callerArgPregNum; ++i)
            parent.addBeforeInst(iter, new Push(parent, arg6.get(i)));
        ConflictNum += callerArgPregNum;

        // align
        boolean extraPush = false;
        if ((ConflictNum + calleeInfo.numExtraArgs) % 2 != 0) {
            extraPush = true;
            parent.addBeforeInst(iter, new Push(parent, new IntImm(0)));
        }
        // endregion

        // region Args of preg
        List<RegValue> calleeArgs = inst.getArgs();

        // over-args push to stack
        for (int i = calleeArgs.size() - 1; i >= Arg_Num; --i) {
            if (calleeArgs.get(i) instanceof StackSlot) {
                parent.addBeforeInst(iter, new Load(parent, rax, RegSize, rbp,
                        callerInfo.stackOffsetMap.get(calleeArgs.get(i))));
                parent.addBeforeInst(iter, new Push(parent, rax));
            } else {
                parent.addBeforeInst(iter, new Push(parent, calleeArgs.get(i)));
            }
        }

        List<Integer> arg6BackOffset = new ArrayList<>();
        Map<PhysicalRegister, Integer> arg6BackOffsetMap = new HashMap<>();

        // back up caller's preg
        // (this is used for callee's arg and arg is override when callee is
        // processing)
        int backArgNum = 0;
        for (int i = 0; i < Arg_Num; ++i) {
            if (calleeArgs.size() <= i) // size = 0
                break;

            if (calleeArgs.get(i) instanceof PhysicalRegister
                    && ((PhysicalRegister) calleeArgs.get(i)).isArg()
                    && ((PhysicalRegister) calleeArgs.get(i)).getArgIdx() < calleeArgs.size()) {
                PhysicalRegister preg = (PhysicalRegister) calleeArgs.get(i);

                // UGLY: can it have contains and do this again ??
                if (!arg6BackOffsetMap.containsKey(preg)) {
                    arg6BackOffsetMap.put(preg, backArgNum);
                    parent.addBeforeInst(iter, new Push(parent, preg));
                    ++backArgNum;
                }
                arg6BackOffset.add(arg6BackOffsetMap.get(preg));
            } else {
                arg6BackOffset.add(-1);
            }
        }

        // push args to preg
        for (int i = 0; i < Arg_Num; ++i) {
            if (calleeArgs.size() <= i)
                break;

            if (arg6BackOffset.get(i) == -1) {
                if (calleeArgs.get(i) instanceof StackSlot) { // can merge load and move ??
                    parent.addBeforeInst(iter, new Load(parent, rax, RegSize, rbp,
                            callerInfo.stackOffsetMap.get(calleeArgs.get(i))));
                    parent.addBeforeInst(iter, new Move(parent, arg6.get(i), rax));
                } else {
                    parent.addBeforeInst(iter, new Move(parent, arg6.get(i), calleeArgs.get(i)));
                }
            } else {
                int offset = RegSize * (backArgNum - arg6BackOffset.get(i) - 1);
                parent.addBeforeInst(iter, new Load(parent, arg6.get(i), RegSize, rsp, offset));
            }
        }

        // figure new rsp
        if (backArgNum > 0) {
            parent.addBeforeInst(iter, new Bin(parent, rsp, BinaryOpExprNode.Op.ADD, rsp,
                    new IntImm(backArgNum * RegSize)));
        }
        // endregion

        // region after funcall

        // get return value from where funcal store
        if (inst.getDst() != null)
            parent.addAfterInst(iter, new Move(parent, inst.getDst(), rax), true);

        // NOTE: BUG: order error ???

        // restore caller save registers to Line: 745
        for (PhysicalRegister preg : callerInfo.usedCallerSaveRegs) {
            if (preg.isArg() && preg.getArgIdx() < callerArgSize)
                continue;

            if (calleeInfo.recursiveUsedRegs.contains(preg))
                parent.addAfterInst(iter, new Pop(parent, preg), true);
        }

        // restore argument registers to Line: 758
        for (int i = 0; i < callerArgPregNum; ++i)
            parent.addAfterInst(iter, new Pop(parent, arg6.get(i)), true);

        // remove extra args and restore rsp to Line: 765, Line: 775
        if (calleeInfo.numExtraArgs > 0 || extraPush) {
            int numPushArg = extraPush ? calleeInfo.numExtraArgs + 1 : calleeInfo.numExtraArgs;
            IntImm vv = new IntImm(numPushArg * RegSize);
            parent.addAfterInst(iter, new Bin(parent, rsp, BinaryOpExprNode.Op.ADD, rsp, vv), true);
        }
        // endregion

        // check iter is stick at Funcall ??
        while (iter.hasNext() && nextInst != iter.next()) {
        }
        iter.previous();
    }

    /** for alloc memory, call malloc */
    private void dealHeapAlloc(Function func, FuncInfo info, HeapAlloc inst,
            ListIterator<Quad> iter) {
        Quad nextInst = iter.next();
        iter.previous();

        BasicBlock parent = inst.getParent();

        // region before inst

        // which reg would not be changed by malloc -> TODO: optim ???
        // rdi is used, rsp is used, rax is used
        int callerSaveNum = 0;
        for (PhysicalRegister preg : info.usedCallerSaveRegs) {
            ++callerSaveNum;
            parent.addBeforeInst(iter, new Push(parent, preg));
        }

        // set arg
        parent.addBeforeInst(iter, new Move(parent, rdi, inst.getAllocSize()));

        // align for rsp
        if (callerSaveNum % 2 != 0)
            parent.addBeforeInst(iter, new Push(parent, new IntImm(0)));
        // endregion

        // region after inst

        // return Value
        parent.addAfterInst(iter, new Move(parent, inst.getDst(), rax), true);

        // but sometimes may not change -> TODO: optim ???
        for (PhysicalRegister preg : info.usedCallerSaveRegs)
            parent.addAfterInst(iter, new Pop(parent, preg), true);

        // restore rsp from align
        // can also do this with Pop
        if (callerSaveNum % 2 != 0) {
            IntImm offset = new IntImm(RegSize);
            parent.addAfterInst(iter, new Bin(parent, rsp, BinaryOpExprNode.Op.ADD, rsp, offset),
                    true);
        }
        // endregion

        // check iter is stick at HeapAlloc ??
        while (iter.hasNext() && nextInst != iter.next()) {
        }
        iter.previous();

    }
    // endregion

}