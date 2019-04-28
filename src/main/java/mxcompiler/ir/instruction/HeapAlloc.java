package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.utils.Dump;


/**
 * alloc memory for class or array
 */
public class HeapAlloc extends Quad {
    private RegValue dst;
    private RegValue allocSize;

    public HeapAlloc(BasicBlock parent, RegValue destion, RegValue allocSize) {
        super(parent);
        // TOOD: copy to
        if (!(destion instanceof Register))
            throw new CompileError("Error with register");
        this.dst = destion;
        this.allocSize = allocSize;
        reloadUsedRegs();
    }

    public RegValue getDst() {
        return dst;
    }

    public RegValue getAllocSize() {
        return allocSize;
    }

    @Override
    public HeapAlloc copyRename(Map<Object, Object> renameMap) {
        return new HeapAlloc((BasicBlock) renameMap.getOrDefault(parent, parent),
                (Register) renameMap.getOrDefault(dst, dst),
                (RegValue) renameMap.getOrDefault(allocSize, allocSize));
    }

    /** {@inheritDoc} */
    @Override
    public void reloadUsedRegs() {
        usedRegisters.clear();
        usedRegValues.clear();
        if (allocSize instanceof Register)
            usedRegisters.add((Register) allocSize);
        usedRegValues.add(allocSize);
    }

    /** {@inheritDoc} */
    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if (allocSize instanceof Register)
            allocSize = renameMap.get(allocSize);
        reloadUsedRegs();
    }

    /** {@inheritDoc} */
    @Override
    public Register getDefinedRegister() {
        return (Register) dst;
    }

    @Override
    public void setDefinedRegister(Register vreg) {
        dst = vreg;
    }

    public void _dump(Dump d) {
        d.println("alloc mme");
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}