package mxcompiler.ast.expression.literal;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;

public class IntLiteralExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("int expr");}

    private int value;

    public IntLiteralExprNode(int s) { this.value = s; }
    public int getValue() { return value; }
}