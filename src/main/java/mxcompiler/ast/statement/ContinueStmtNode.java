package mxcompiler.ast.statement;

import mxcompiler.ast.*;

public class ContinueStmtNode extends StmtNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<ContinueStmtNode> %s\n", location.toString());
	}

	public ContinueStmtNode(Location location) {
		super(location);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}