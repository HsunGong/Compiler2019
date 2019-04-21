package mxcompiler.ir.instruction;

import mxcompiler.ast.expression.BinaryOpExprNode.Op;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.utils.Dump;

/** binary */
public class Bin extends Quad {
    // binary
    //  ADD, SUB, MUL, DIV, MOD,
    //  SHL, SHR,
    //  BITWISE_AND, BITWISE_OR, BITWISE_XOR

    // compare
    // GREATER, LESS, GREATER_EQUAL, LESS_EQUAL, EQUAL, INEQUAL

    private RegValue dst;
    private Op op;
    private RegValue lhs, rhs;

    public Bin(BasicBlock parent, RegValue destion, Op op, RegValue lhs, RegValue rhs){
        super(parent);
        this.dst = destion;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public Op getOp() { return op; }
    public RegValue getDst() { return dst; }
    public RegValue getRhs() { return rhs; }
    public RegValue getLhs() { return lhs; }



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
        d.println("binary");
    }
}