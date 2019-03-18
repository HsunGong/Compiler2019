package mxcompiler.ast.expression.literal;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;

public class StringLiteralExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("string expr");}

    private String value;

    public StringLiteralExprNode(String s) { this.value = s; }
    public String getValue() { return value; }
}