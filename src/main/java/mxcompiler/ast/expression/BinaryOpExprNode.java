package mxcompiler.ast.expression;

import mxcompiler.ast.Dump;
import mxcompiler.type.Type;

public class BinaryOpExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("BinaryOpExprNode expr");}

    private static enum Op {
        MUL, DIV, MOD,
        ADD, SUB, SHL, SHR,
        GREATER, LESS, 
        GREATER_EQUAL, LESS_EQUAL, 
        EQUAL, INEQUAL,
        BIT_AND, BIT_OR, BIT_XOR, 
        LOGIC_AND, LOGIC_OR
    }

    private ExprNode left, right;
    private Op op;

    /** type can be null and add later */
    public BinaryOpExprNode(ExprNode left, Op op, ExprNode right, Type type) {
        this.type = type;
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public ExprNode getLeft() { return left; }
    public ExprNode getRight() { return right; }
    public void setLeft(ExprNode left) { this.left = left; }
    public void setRight(ExprNode right) { this.right = right; }

    public Op getOp() { return op; }
}