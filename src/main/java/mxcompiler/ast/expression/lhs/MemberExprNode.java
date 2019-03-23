package mxcompiler.ast.expression.lhs;

import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.*;

/**
 * MemberExpr is Member Access Node of '.' IN book file, it is ptrmember and
 * membernode
 */
public class MemberExprNode extends LhsExprNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<MemberExprNode> %s\n", location.toString());
		d.printf(" member: %s\n", member);
	}

	private ExprNode expr;
	private String member;

	public MemberExprNode(ExprNode expr, String member, Location location) {
		super(location);
		this.expr = expr;
		this.member = member;
	}

	public ExprNode getExpr() {
		return expr;
	}

	public String getMember() {
		return member;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}