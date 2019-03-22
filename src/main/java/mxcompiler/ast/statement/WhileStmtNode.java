package mxcompiler.ast.statement;


import mxcompiler.ast.Location;
import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.ASTDump;
public class WhileStmtNode extends StmtNode {
			@Override
	public void _dump(ASTDump d) {		d.printf("<WhileStmtNode> %s\n", location.toString());
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
}
