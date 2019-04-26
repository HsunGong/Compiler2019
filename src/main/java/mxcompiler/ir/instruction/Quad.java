package mxcompiler.ir.instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.utils.Dump;


/** IR-Instruction */
abstract public class Quad {
    protected BasicBlock parent;
    private boolean removed = false;

    public Quad(BasicBlock bb) {
        this.parent = bb;
    }

    public BasicBlock getParent() {
        return parent;
    }

    public abstract Quad copyRename(Map<Object, Object> renameMap);

    // public Set<VirtualRegister> liveIn = null, liveOut = null;
    public List<Register> usedRegisters = new ArrayList<>();
    public List<RegValue> usedRegValues = new ArrayList<>();

    /**
     * normally set vreg as destion(if has)
     */
    public void setDefinedRegister(Register vreg) {
    }

    /**
     * normally get destion(if has) or get null
     */
    public Register getDefinedRegister() {
        return null;
    }

    /**
     * normally reset all used regs
     */
    public void setUsedRegisters(Map<Register, Register> renameMap) {
    }

    /**
     * reload all regs: Register or RegValue(after setUsedRegs)
     */
    protected void reloadUsedRegs() {
    }

    abstract public void accept(IRVisitor visitor);

    abstract public void _dump(Dump d);
}