package mxcompiler.main;

import java.util.*;

import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;
import mxcompiler.ast.expression.*;


public class BinaryDstEqualLhs {
    public final Root root;

    public BinaryDstEqualLhs(Root root) {
        this.root = root;
    }


    public void execute() {
        for (Function irFunc : root.getFunc().values())
            for (BasicBlock bb : irFunc.getReversePostOrder()) {
                ListIterator<Quad> iter = bb.getInsts().listIterator();

                while (iter.hasNext()) { // Solved: iter.next outside
                    Quad next = iter.next();
                    if (!(next instanceof Bin) || next instanceof Cmp)
                        continue;

                    Bin bin = (Bin) next;
                    if (bin.getDst() == bin.getLhs())
                        continue;

                    if (bin.getDst() == bin.getRhs()) {
                        if (bin.isCommutative()) { // Solved : swap
                            RegValue tmp = bin.getLhs();
                            bin.setLhs(bin.getRhs());
                            bin.setRhs(tmp);
                        } else {
                            VirtualRegister vreg = new VirtualRegister("rhs_backup");
                            bb.addBeforeInst(iter, new Move(bb, vreg, bin.getRhs()));
                            bb.addBeforeInst(iter,
                                    new Move(bb, bin.getDst(), bin.getLhs()));

                            bin.setLhs(bin.getDst());
                            bin.setRhs(vreg);
                        }
                    } else if (bin.getOp() != BinaryOpExprNode.Op.DIV
                            && bin.getOp() != BinaryOpExprNode.Op.MOD) {
                        bb.addBeforeInst(iter, new Move(bb, bin.getDst(), bin.getLhs()));

                        bin.setLhs(bin.getDst());
                    }
                }
            }

    }
}