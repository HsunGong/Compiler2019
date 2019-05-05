package mxcompiler.ast.statement;

import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.*;
import mxcompiler.utils.Dump;

public class WhileStmtNode extends StmtNode {
	@Override
	public void _dump(Dump d) {
		d.printf("<WhileStmtNode> %s\n", location.toString());
	}

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

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
