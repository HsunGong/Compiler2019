package mxcompiler.ast.expression.literal;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
public class BoolLiteralExprNode extends ExprNode {
	private boolean value;

	public BoolLiteralExprNode(boolean b, Location location) {
		super(location);
		this.value = b;
	}

	public boolean getValue() {
		return value;
	}
}