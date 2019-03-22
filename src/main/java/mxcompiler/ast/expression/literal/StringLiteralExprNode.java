package mxcompiler.ast.expression.literal;

import mxcompiler.ast.expression.ExprNode;

import mxcompiler.ast.*;
public class StringLiteralExprNode extends ExprNode {
	@Override
	public void _dump(ASTDump d) {
				d.printf("<StringExprNode> %s\n", location.toString());
		d.printf(" value: %s\n", getValue());
	}

	private String value;

	public StringLiteralExprNode(String s, Location location) {
		super(location);
		this.value = s;
	}

	public String getValue() {
		return value;
	}
		@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}