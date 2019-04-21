package mxcompiler.ir.instruction;

import mxcompiler.ast.expression.unary.PrefixExprNode.Op;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
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
    }

    public Op getOp() { return op; }
    public RegValue getDst() { return dst; }
    public RegValue getRhs() { return rhs; }




    // @Override
    // public IRUnaryOperation copyRename(Map<Object, Object> renameMap) {
    //     return new IRUnaryOperation(
    //             (BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    //             (IRRegister) renameMap.getOrDefault(dest, dest),
    //             op,
    //             (RegValue) renameMap.getOrDefault(rhs, rhs)
    //     );
    // }


    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("unary");
    }
}