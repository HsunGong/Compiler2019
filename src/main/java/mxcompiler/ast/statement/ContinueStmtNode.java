package mxcompiler.ast.statement;

import mxcompiler.ast.Location;
import mxcompiler.ast.ASTDump;

public class ContinueStmtNode extends StmtNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<ContinueStmtNode> %s\n", location.toString());
	}

	public ContinueStmtNode(Location location) {
		super(location);
	}

}