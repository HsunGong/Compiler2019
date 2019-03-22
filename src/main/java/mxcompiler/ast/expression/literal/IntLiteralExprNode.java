package mxcompiler.ast.expression.literal;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.*;

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

		@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}