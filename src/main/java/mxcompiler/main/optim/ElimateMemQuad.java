package mxcompiler.main.optim;

import java.util.*;

import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;

public class ElimateMemQuad {
    public final Root root;

    public ElimateMemQuad(Root root) {
        this.root = root;
    }

    public void execute() {
        for (Function func : root.getFunc().values())
            for (BasicBlock bb : func.getReversePostOrder())
                elimateMoveMemQuad(bb);
    }

    /** pre-dump-elimate */
    private void elimateMoveMemQuad(BasicBlock bb) {
        Quad prevInst = null;
        Quad inst = null;
        boolean remove = false;

        ListIterator<Quad> iter = bb.getInsts().listIterator();
        while (iter.hasNext()) {
            inst = iter.next();
            remove = false;

            if (inst instanceof Move) {
                if (((Move) inst).getDst() == ((Move) inst).getRhs())
                    remove = true;
                else if (prevInst instanceof Move) {
                    // move a to b, but move b to a back
                    if (((Move) inst).getDst() == ((Move) prevInst).getRhs()
                            && ((Move) inst).getRhs() == ((Move) prevInst).getDst())
                        remove = true;
                }
            } else if (inst instanceof MemQuad && prevInst instanceof MemQuad) {
                if (((MemQuad) prevInst).baseAddr == ((MemQuad) inst).baseAddr
                        && ((MemQuad) prevInst).offset == ((MemQuad) inst).offset
                        && ((MemQuad) prevInst).getValue() == ((MemQuad) inst).getValue()
                        && ((MemQuad) prevInst).getSize() == ((MemQuad) inst).getSize()) {
                    // before store a to b, but load b to a again
                    // before load, but store again
                    // double load a to b or store a to b
                    remove = true;
                }
            } else if (inst instanceof Push || inst instanceof Pop) {

            }

            if (remove)
                bb.removeInst(iter);
            else
                prevInst = inst;
        }
    }

}