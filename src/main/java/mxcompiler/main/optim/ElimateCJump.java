package mxcompiler.main.optim;

import java.util.*;

import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;


public class ElimateCJump {
    public final Root root;

    public ElimateCJump(Root root) {
        this.root = root;
    }

    public void execute() {
        for (Function Function : root.getFunc().values()) {
            for (BasicBlock bb : Function.getReversePostOrder()) {
                // ListIterator<Quad> iter =
                // bb.getInsts().listIterator(bb.getInsts().size());
                // Quad inst = iter.previous();
                Quad inst = bb.getInsts().getLast();
                if (inst instanceof CJump && ((CJump) inst).getCond() instanceof IntImm) {
                    BasicBlock targetBB = ((IntImm) ((CJump) inst).getCond()).getValue() != 0
                            ? ((CJump) inst).getThen()
                            : ((CJump) inst).getElse();

                    // bb.removeInst();
                    bb.delJump(inst);
                    bb.setJump(new Jump(bb, targetBB));
                }
            }

            Function.initReversePostOrder();
        }
    }

}