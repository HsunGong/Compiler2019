package mxcompiler.ast.expression.literal;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.*;

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
		@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}