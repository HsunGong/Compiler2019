package mxcompiler.ast.expression.literal;

import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.*;
import mxcompiler.utils.Dump;

public class BoolLiteralExprNode extends ExprNode {
	@Override
	public void _dump(Dump d) {
		d.printf("<BoolLiteralNode> %s\n", location.toString());
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