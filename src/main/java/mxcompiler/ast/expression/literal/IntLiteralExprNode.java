package mxcompiler.ast.expression.literal;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
public class IntLiteralExprNode extends ExprNode {
	private int value;

	public IntLiteralExprNode(int s, Location location) {
		super(location);
		this.value = s;
	}

	public int getValue() {
		return value;
	}
}