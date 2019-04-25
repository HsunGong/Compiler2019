package mxcompiler.ir.instruction;

import mxcompiler.ast.expression.BinaryOpExprNode.Op;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.utils.Dump;


/**
 * binary
 * <p>
 * No more LOGIC_AND("&&"), LOGIC_OR("||")
 * TODO: FIX: Optimize with inline call
 */
public class Cmp extends Bin {
    public Cmp(BasicBlock parent, RegValue destion, Op op, RegValue lhs, RegValue rhs) {
        super(parent, destion, op, lhs, rhs);
        // reloadUsedRegistersRegValues();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void _dump(Dump d) {
        d.println("binary-cmp");
    }
}