package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.*;
import mxcompiler.utils.Dump;


public class Load extends MemQuad {
    private boolean isLoadAddr;

    public Load(BasicBlock parent, RegValue destion, int size, RegValue baseAddr, int addrOffset) {
        super(parent);
        if (size == 0)
            System.err.println("oh bad size 0");

        if (!(destion instanceof Register))
            throw new CompileError("Error with load not reigster");
        this.value = destion;
        this.baseAddr = baseAddr;
        this.offset = addrOffset;
        this.size = size;
        this.isStaticData = false;
        reloadUsedRegs();
    }

    public Load(BasicBlock parent, RegValue destion, int size, StaticData baseAddr,
            boolean isLoadAddr) {
        this(parent, destion, size, baseAddr, 0);

        this.isStaticData = true;
        this.isLoadAddr = isLoadAddr;
    }

    /** seen at {@link #MemQuad.getValue()} */
    public Register getDst() {
        return (Register) getValue();
    }

    @Override
    public Load copyRename(Map<Object, Object> renameMap) {
        if (isStaticData) {
            return new Load((BasicBlock) renameMap.getOrDefault(parent, parent),
                    (Register) renameMap.getOrDefault(value, value), size,
                    (StaticData) renameMap.getOrDefault(baseAddr, baseAddr), isLoadAddr);
        } else {
            return new Load((BasicBlock) renameMap.getOrDefault(parent, parent),
                    (Register) renameMap.getOrDefault(value, value), size,
                    (RegValue) renameMap.getOrDefault(baseAddr, baseAddr), offset);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void reloadUsedRegs() {
        usedRegisters.clear();
        usedRegValues.clear();
        if (baseAddr instanceof Register && !(baseAddr instanceof StackSlot))
            usedRegisters.add((Register) baseAddr);
        usedRegValues.add(baseAddr);
    }

    /** {@inheritDoc} */
    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if (baseAddr instanceof Register && !(baseAddr instanceof StackSlot))
            baseAddr = renameMap.get(baseAddr);
        reloadUsedRegs();
    }

    /** {@inheritDoc} */
    @Override
    public Register getDefinedRegister() {
        return (Register) value;
    }

    /** {@inheritDoc} */
    @Override
    public void setDefinedRegister(Register vreg) {
        value = vreg;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Load");
    }
}
