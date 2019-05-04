package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.ir.register.StackSlot;
import mxcompiler.ir.register.StaticData;
import mxcompiler.utils.Dump;


public class Load extends MemQuad {
    private RegValue dst; // Register
    private int size;
    private boolean isStaticData, isLoadAddr;
    public RegValue baseAddr;
    public int offset;

    public Load(BasicBlock parent, RegValue destion, int size, RegValue baseAddr, int addrOffset) {
        super(parent);
        if (size == 0)
            System.err.println("oh bad size 0");

        this.dst = destion;
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

    public Register getDst() {
        return (Register) dst;
    }

    public int getSize() {
        return size;
    }

    public boolean isStaticData() {
        return isStaticData;
    }

    @Override
    public Load copyRename(Map<Object, Object> renameMap) {
        if (isStaticData) {
            return new Load((BasicBlock) renameMap.getOrDefault(parent, parent),
                    (Register) renameMap.getOrDefault(dst, dst), size,
                    (StaticData) renameMap.getOrDefault(baseAddr, baseAddr), isLoadAddr);
        } else {
            return new Load((BasicBlock) renameMap.getOrDefault(parent, parent),
                    (Register) renameMap.getOrDefault(dst, dst), size,
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
        return (Register) dst;
    }

    /** {@inheritDoc} */
    @Override
    public void setDefinedRegister(Register vreg) {
        dst = vreg;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Load");
    }
}
