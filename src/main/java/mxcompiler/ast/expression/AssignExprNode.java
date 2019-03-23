package mxcompiler.ast.expression;

import mxcompiler.ast.*;

/** no auto transfer type */
public class AssignExprNode extends ExprNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<AssignExprNode> %s\n", location.toString());
	}

	private ExprNode lhs;
	private ExprNode rhs;

	public AssignExprNode(ExprNode lhs, ExprNode rhs, Location location) {
		super(location);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public ExprNode getLhs() {
		return lhs;
	}

	public ExprNode getRhs() {
		return rhs;
	}

	public void setRhs(ExprNode e) {
		this.rhs = e;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}