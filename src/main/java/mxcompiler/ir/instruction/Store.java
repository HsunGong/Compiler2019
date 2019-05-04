package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.*;
import mxcompiler.utils.Dump;


public class Store extends Quad {
    private RegValue value;
    private int size;
    public RegValue baseAddr;
    public int offset;
    private boolean isStaticData;

    public Store(BasicBlock parent, RegValue value, int size, RegValue baseAddr,
            int addrOffset) {
        super(parent);
        if (size == 0)
            System.err.println("bad size 0");

        this.value = value;
        this.baseAddr = baseAddr;
        this.offset = addrOffset;
        this.size = size;
        this.isStaticData = false;
        reloadUsedRegs();
    }

    public Store(BasicBlock parent, RegValue value, int size, StaticData addr) {
        this(parent, value, size, addr, 0);

        this.isStaticData = true;
    }

    public RegValue getValue() {
        return value;
    }

    public int getSize() {
        return size;
    }

    public boolean isStaticData() {
        return isStaticData;
    }

    /** {@inheritDoc} */
    @Override
    public Store copyRename(Map<Object, Object> renameMap) {
        if (isStaticData) {
            return new Store((BasicBlock) renameMap.getOrDefault(parent, parent),
                    (RegValue) renameMap.getOrDefault(value, value), size,
                    (StaticData) renameMap.getOrDefault(baseAddr, baseAddr));
        } else {
            return new Store((BasicBlock) renameMap.getOrDefault(parent, parent),
                    (RegValue) renameMap.getOrDefault(value, value), size,
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
        if (value instanceof Register)
            usedRegisters.add((Register) value);
        usedRegValues.add(baseAddr);
        usedRegValues.add(value);
    }

    /** {@inheritDoc} */
    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if (baseAddr instanceof Register && !(baseAddr instanceof StackSlot))
            baseAddr = renameMap.get(baseAddr);
        if (value instanceof Register)
            value = renameMap.get(value);
        reloadUsedRegs();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Store");
    }
}
