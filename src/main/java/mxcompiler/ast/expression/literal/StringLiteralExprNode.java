package mxcompiler.ast.expression.literal;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
public class StringLiteralExprNode extends ExprNode {
    private String value;

    public StringLiteralExprNode(String s, Location location) {
		super(location); this.value = s; }
    public String getValue() { return value; }
}