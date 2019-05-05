package mxcompiler.ast.statement;

import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.*;
import mxcompiler.utils.Dump;

public class ReturnStmtNode extends StmtNode {
	@Override
	public void _dump(Dump d) {
		d.printf("<ReturnStmtNode> %s\n", location.toString());
	}

	/** can be null */
	private ExprNode expr;

	public ReturnStmtNode(ExprNode expr, Location location) {
		super(location);
		this.expr = expr;
	}

	public void setExpr(ExprNode e) {
		this.expr = e;
	}

	public ExprNode getExpr() {
		return this.expr;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}