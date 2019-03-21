package mxcompiler.ast.statement;


import mxcompiler.ast.Location;
import mxcompiler.ast.expression.ExprNode;

public class WhileStmtNode extends StmtNode {
	private ExprNode cond;
	private StmtNode body;

	public WhileStmtNode(ExprNode cond, StmtNode body, Location location) {
		super(location);
		this.cond = cond;
		this.body = body; // may be null
	}

	public ExprNode getCond() {
		return cond;
	}

	public StmtNode getBody() {
		return body;
	}
}
