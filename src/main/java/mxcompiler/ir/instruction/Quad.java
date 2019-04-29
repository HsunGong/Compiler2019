package mxcompiler.ir.instruction;

import java.util.*;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.ir.register.VirtualRegister;
import mxcompiler.utils.Dump;


/** IR-Instruction */
abstract public class Quad {
    protected BasicBlock parent;
    public boolean removed = false;

    public Set<VirtualRegister> liveIn = new HashSet<>(), liveOut = new HashSet<>();

    public Quad(BasicBlock bb) {
        this.parent = bb;
    }

    public BasicBlock getParent() {
        return parent;
    }

    /**
     * get a copy of cur inst
     * <p>
     * change everything(BB, regValue) if has in renameMap
     */
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
     * <p>
     * For each inst, can only have 1 Defined register
     */
    public Register getDefinedRegister() {
        return null;
    }

    /**
     * reset all used Registers(in usedRegisters)
     * <p>
     * normally as RegValues(rather than DefinedRegisters)
     */
    public void setUsedRegisters(Map<Register, Register> renameMap) {
    }

    /**
     * reload all reg-List: usedRegValues, usedRegisters
     */
    protected void reloadUsedRegs() {
    }

    abstract public void accept(IRVisitor visitor);

    abstract public void _dump(Dump d);
}