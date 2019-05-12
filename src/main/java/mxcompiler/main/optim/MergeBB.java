package mxcompiler.main.optim;

import java.util.*;

import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;


public class MergeBB {
    public final Root root;

    public MergeBB(Root root) {
        this.root = root;
    }

    public void execute() {
        for (Function func : root.getFunc().values()) {
            for (BasicBlock bb : func.getReversePostOrder())
                mergeBB(bb);

            func.initReversePostOrder();
        }
    }

    private void mergeBB(BasicBlock prev) {
        if (!(prev.getInsts().getLast() instanceof Jump))
            return;
        BasicBlock next = prev.getNext().iterator().next();
        if (next.getPrev().size() != 1)
            return;
            
        // prev -> next => next
        Function func = prev.getFunc();

        next.delPrev(prev);
        prev.getPrev().forEach(bb -> next.addPrev(bb));

        if (func.getStart() == prev)
            func.setStart(next);

        Map<Object, Object> renameMap = new HashMap<>();
        renameMap.put(prev, next);

        // add after-funcall insts into new end(first)
        ListIterator<Quad> iter = next.getInsts().listIterator();
        iter.next();
        for (Quad inst : prev.getInsts()) {
            if (inst instanceof Jump)
                continue;

            next.addBeforeInst(iter, inst.copyRename(renameMap));
        }

        if (prev.forNode != null) {
            Root.ForRecord forRec = root.forRecMap.get(prev.forNode);
            if (forRec.cond == prev)
                forRec.cond = next;
            if (forRec.incr == prev)
                forRec.incr = next;
            if (forRec.body == prev)
                forRec.body = next;
            if (forRec.after == prev)
                forRec.after = next;
        }
    }
}