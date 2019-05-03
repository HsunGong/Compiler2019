package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ast.expression.unary.PrefixExprNode.Op;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.utils.Dump;


/** Unary */
public class Uni extends Quad {
    private RegValue dst;
    private Op op;
    private RegValue rhs;

    public Uni(BasicBlock parent, RegValue destion, Op op, RegValue object) {
        super(parent);
        this.dst = destion;
        this.rhs = object;
        this.op = op;
        reloadUsedRegs();
    }

    public Op getOp() {
        return op;
    }

    public Register getDst() {
        return (Register) dst;
    }

    public RegValue getRhs() {
        return rhs;
    }

    /** {@inheritDoc} */
    @Override
    public Uni copyRename(Map<Object, Object> renameMap) {
        return new Uni((BasicBlock) renameMap.getOrDefault(parent, parent),
                (Register) renameMap.getOrDefault(dst, dst), op,
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

    /** {@inheritDoc} */
    @Override
    public void setDefinedRegister(Register vreg) {
        dst = vreg;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("unary");
    }
}