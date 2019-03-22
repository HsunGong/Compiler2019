package mxcompiler.ast.expression.literal;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
import mxcompiler.ast.ASTDump;

public class IntLiteralExprNode extends ExprNode {
		@Override
	public void _dump(ASTDump d) {
				d.printf("<IntExprNode> %s\n", location.toString());
		d.printf(" value: %d\n", getValue());
	}
	private int value;

	public IntLiteralExprNode(int s, Location location) {
		super(location);
		this.value = s;
	}

	public int getValue() {
		return value;
	}
}