package mxcompiler.ir.instruction;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;

/** IR-Instruction */
abstract public class Quad {
    private BasicBlock parent;
    private boolean removed = false;

    // public Set<VirtualRegister> liveIn = null, liveOut = null;
    // protected List<IRRegister> usedRegisters = new ArrayList<>();
    // protected List<RegValue> usedRegValues = new ArrayList<>();

    public Quad(BasicBlock bb) {
        this.parent = bb;
    }

    // TODO: public abstract IRInstruction copyRename(Map<Object, Object>
    // renameMap);

    public void remove() {
        if (removed) {
            throw new CompileError("an instruction already removed");
        }
        removed = true;
        parent.delInst(this);
    }

    public void replace(Quad inst) {
        if (removed) {
            throw new CompileError("an instruction already removed");
        }
        removed = true;
        parent.delInst(this);
        parent.addInst(inst);
    }

    public BasicBlock getParent() {
        return parent;
    }

    abstract public void accept(IRVisitor visitor);

    abstract public void _dump(Dump d);
}