package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ast.expression.BinaryOpExprNode.Op;
import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.utils.Dump;


/**
 * binary
 * <p>
 * No more LOGIC_AND("&&"), LOGIC_OR("||")
 * <p>
 * op Src, Dst
 */
public class Bin extends Quad {

    protected RegValue dst;
    protected Op op;
    protected RegValue lhs, rhs;

    public Bin(BasicBlock parent, RegValue destion, Op op, RegValue lhs, RegValue rhs) {
        super(parent);
        if (!(destion instanceof Register))
            throw new CompileError("Error init destion");
        this.dst = destion;
        this.lhs = lhs;
        this.rhs = rhs;
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

    public RegValue getLhs() {
        return lhs;
    }

    public void setLhs(RegValue lhs) {
        this.lhs = lhs;
    }

    public void setRhs(RegValue rhs) {
        this.rhs = rhs;
    }

    /**
     * false: sub, div, mod, sh_l, sh_r
     * <p>
     * E.g. true: {@code a + b} <-> {@code b + a}
     */
    public boolean isCommutative() {
        return op == Op.ADD || op == Op.MUL || op == Op.BIT_AND || op == Op.BIT_OR
                || op == Op.BIT_XOR;
    }

    /** {@inheritDoc} */
    @Override
    public Bin copyRename(Map<Object, Object> renameMap) {
        return new Bin((BasicBlock) renameMap.getOrDefault(parent, parent),
                (Register) renameMap.getOrDefault(dst, dst), op,
                (RegValue) renameMap.getOrDefault(lhs, lhs),
                (RegValue) renameMap.getOrDefault(rhs, rhs));
    }

    /** {@inheritDoc} */
    @Override
    protected void reloadUsedRegs() {
        usedRegisters.clear();
        usedRegValues.clear();
        if (lhs instanceof Register)
            usedRegisters.add((Register) lhs);
        if (rhs instanceof Register)
            usedRegisters.add((Register) rhs);
        usedRegValues.add(lhs);
        usedRegValues.add(rhs);
    }

    /** {@inheritDoc} */
    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if (lhs instanceof Register)
            lhs = renameMap.get(lhs);
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
        d.println("binary");
    }
}