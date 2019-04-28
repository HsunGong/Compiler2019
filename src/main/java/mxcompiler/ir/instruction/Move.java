package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.utils.Dump;


public class Move extends MemQuad {
    private RegValue dst; // lhs
    private RegValue rhs;

    public Move(BasicBlock parent, RegValue destion, RegValue rhs) {
        super(parent);
        this.dst = destion;
        this.rhs = rhs;
        reloadUsedRegs();
    }

    public RegValue getDst() {
        return dst;
    }

    private RegValue getLhs() {
        return dst;
    }

    public RegValue getRhs() {
        return rhs;
    }

    /** {@inheritDoc} */
    @Override
    public Move copyRename(Map<Object, Object> renameMap) {
        return new Move((BasicBlock) renameMap.getOrDefault(parent, parent),
                (Register) renameMap.getOrDefault(dst, dst),
                (RegValue) renameMap.getOrDefault(rhs, rhs));
    }

    /** {@inheritDoc} */
    @Override
    public void reloadUsedRegs() {
        usedRegisters.clear();
        usedRegValues.clear();
        if (rhs instanceof Register)
            usedRegisters.add((Register) rhs);
        usedRegValues.add(rhs);
    }

    /** {@inheritDoc} */
    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if (rhs instanceof Register)
            rhs = renameMap.get(rhs);
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

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Move");
    }
}
