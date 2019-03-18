package mxcompiler.ast.expression.literal;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;

public class BoolLiteralExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("bool expr");}

    private boolean value;

    public BoolLiteralExprNode(boolean b) { this.value = b; }
    public boolean getValue() { return value; }
}