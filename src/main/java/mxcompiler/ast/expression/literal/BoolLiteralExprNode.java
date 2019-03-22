package mxcompiler.ast.expression.literal;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
import mxcompiler.ast.ASTDump;

public class BoolLiteralExprNode extends ExprNode {
		@Override
	public void _dump(ASTDump d) {
				d.printf("<BoolExprNode> %s\n", location.toString());
		d.printf(" value: %b\n", getValue());
	}
	private boolean value;

	public BoolLiteralExprNode(boolean b, Location location) {
		super(location);
		this.value = b;
	}

	public boolean getValue() {
		return value;
	}
}