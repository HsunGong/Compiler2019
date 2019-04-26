package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;

/** IR-Instruction */
abstract public class Quad {
    protected BasicBlock parent;
    private boolean removed = false;

    // public Set<VirtualRegister> liveIn = null, liveOut = null;
    // protected List<IRRegister> usedRegisters = new ArrayList<>();
    // protected List<RegValue> usedRegValues = new ArrayList<>();

    public Quad(BasicBlock bb) {
        this.parent = bb;
    }

    public BasicBlock getParent() {
        return parent;
    }

    public abstract Quad copyRename(Map<Object, Object> renameMap);






    abstract public void accept(IRVisitor visitor);

    abstract public void _dump(Dump d);
}