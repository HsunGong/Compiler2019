package mxcompiler.ir.instruction;

import mxcompiler.ast.expression.BinaryOpExprNode.Op;
import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.utils.Dump;


/**
 * binary
 * <p>
 * No more LOGIC_AND("&&"), LOGIC_OR("||")
 */
public class Bin extends Quad {

    protected RegValue dst;
    protected Op op;
    protected RegValue lhs, rhs;

    public Bin(BasicBlock parent, RegValue destion, Op op, RegValue lhs, RegValue rhs) {
        super(parent);
        this.dst = destion;
        this.lhs = lhs;
        this.rhs = rhs;
        this.op = op;
        // reloadUsedRegistersRegValues();
    }

    public Op getOp() {
        return op;
    }

    public RegValue getDst() {
        return dst;
    }

    public RegValue getRhs() {
        return rhs;
    }

    public RegValue getLhs() {
        return rhs;
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

    // @Override
    // public IRUnaryOperation copyRename(Map<Object, Object>
    // renameMap) {
    // return new IRUnaryOperation(
    // (BasicBlock) renameMap.getOrDefault(getParentBB(),
    // getParentBB()),
    // (IRRegister) renameMap.getOrDefault(dest, dest),
    // op,
    // (RegValue) renameMap.getOrDefault(rhs, rhs)
    // );
    // }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("binary");
    }
}