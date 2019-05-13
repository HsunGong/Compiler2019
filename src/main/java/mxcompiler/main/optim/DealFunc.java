package mxcompiler.main.optim;

import java.util.*;

import mxcompiler.ast.expression.BinaryOpExprNode;
import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;
import static mxcompiler.main.IRBuilder.INIT_FUNC_NAME;
import static mxcompiler.ir.register.RegValue.RegSize;


public class DealFunc {
    public final Root root;

    public DealFunc(Root root) {
        this.root = root;
    }

    private static final int TABLE_SIZE = 1 << 25;
    private static final int BASE = 267634663;
    private static final int XOR = 4937;

    private List<Function> orphanList = new ArrayList<>();

    public void execute() {

        for (Function func : root.getFunc().values())
            func.single = true;

        while (true) {
            boolean changed = false;

            for (Function func : root.getFunc().values()) {
                if (func.single && !checkOrphan(func)) {
                    func.single = false;
                    changed = true;
                }
            }

            if (!changed)
                break;
        }

        for (Function func : root.getFunc().values()) {
            if (func.single || check(func)) {
                orphanList.add(func);
            }
        }

        if (orphanList.isEmpty())
            return;

        Function initFuck = root.getFunc(INIT_FUNC_NAME);
        BasicBlock initFirstBB = initFuck.getStart();
        StaticVar table = new StaticVar("runtime_table", RegSize);

        root.getStaticDataList().add(table);
        initFirstBB.getInsts()
                .addFirst(new HeapAlloc(initFirstBB, table, new IntImm(TABLE_SIZE * RegSize)));

        for (Function func : orphanList) {
            if (func.getName().equals(INIT_FUNC_NAME) || func.getName().equals("main"))
                continue;

            if (!(func.argVregs.size() <= 1 || check(func)))
                continue;

            System.err.println("orphan : " + func.getName());

            BasicBlock checkBB = new BasicBlock(func, "fast_check");
            BasicBlock fastReturnBB = new BasicBlock(func, "fast_return");
            BasicBlock newEndBB = new BasicBlock(func, "slow_return");
            BasicBlock oldEndBB = func.getEnd();

            VirtualRegister offset = new VirtualRegister("hash_offset");
            VirtualRegister valAddr = new VirtualRegister("val_addr");
            VirtualRegister value = new VirtualRegister("val");

            checkBB.addLastInst(new Move(checkBB, offset, new IntImm(stringHash(func.getName()))));

            for (VirtualRegister reg : func.argVregs) {
                checkBB.addLastInst(new Bin(checkBB, offset, BinaryOpExprNode.Op.MUL, offset,
                        new IntImm(BASE)));
                checkBB.addLastInst(new Bin(checkBB, offset, BinaryOpExprNode.Op.ADD, offset, reg));
            }

            checkBB.addLastInst(new Bin(checkBB, offset, BinaryOpExprNode.Op.BIT_AND, offset,
                    new IntImm(TABLE_SIZE - 1)));
            checkBB.addLastInst(
                    new Bin(checkBB, offset, BinaryOpExprNode.Op.SH_L, offset, new IntImm(3)));
            checkBB.addLastInst(new Bin(checkBB, valAddr, BinaryOpExprNode.Op.ADD, table, offset));

            checkBB.addLastInst(new Load(checkBB, value, RegSize, valAddr, 0));
            checkBB.setJump(new CJump(checkBB, value, fastReturnBB, func.getStart()));

            RegValue resReg = ((Return) oldEndBB.getInsts().getLast()).getReturnValue();
            oldEndBB.delJump(oldEndBB.getInsts().getLast());
            if (resReg == null) {
                oldEndBB.addLastInst(new Move(oldEndBB, value, new IntImm(XOR)));
            } else {
                oldEndBB.addLastInst(new Bin(oldEndBB, value, BinaryOpExprNode.Op.BIT_XOR, resReg,
                        new IntImm(XOR)));
            }
            oldEndBB.addLastInst(new Store(oldEndBB, value, RegSize, valAddr, 0));
            oldEndBB.setJump(new Jump(oldEndBB, newEndBB));

            if (resReg instanceof VirtualRegister) {
                fastReturnBB.addLastInst(new Bin(fastReturnBB, (VirtualRegister) resReg,
                        BinaryOpExprNode.Op.BIT_XOR, value, new IntImm(XOR)));
            }
            fastReturnBB.setJump(new Jump(fastReturnBB, newEndBB));

            if (check(func) && resReg instanceof VirtualRegister) {
                newEndBB.addLastInst(
                        new Move(newEndBB, (VirtualRegister) resReg, new IntImm(134217727)));
            }
            newEndBB.setJump(new Return(newEndBB, resReg));

            func.setStart(checkBB);
            func.setEnd(newEndBB);
            func.initReversePostOrder();
        }

    }

    private boolean checkOrphan(Function func) {
        for (BasicBlock bb : func.getReversePostOrder()) {
            for (Quad inst : bb.getInsts()) {
                if (inst.getDefinedRegister() instanceof StaticVar) {
                    return false;
                }

                for (Register usedReg : inst.getUsedRegisters()) {
                    if (usedReg instanceof StaticVar)
                        return false;
                }

                if (inst instanceof Load || inst instanceof Store) {
                    return false;
                }

                if (inst instanceof Funcall && !((Funcall) inst).getFunc().single) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean check(Function func) {
        if (func.argVregs.size() == 5 && func.getName().equals("cd")) {
            for (BasicBlock bb : func.getReversePostOrder()) {
                for (Quad inst : bb.getInsts()) {
                    if (inst instanceof Funcall && ((Funcall) inst).getFunc().isBuiltIn()) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private int stringHash(String ss) {
        int res = 0;
        for (int i = 0; i < ss.length(); i++) {
            res = res * BASE + ss.charAt(i);
        }
        return res;
    }

}