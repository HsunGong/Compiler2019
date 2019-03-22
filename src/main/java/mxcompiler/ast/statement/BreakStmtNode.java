package mxcompiler.ast.statement;


import mxcompiler.ast.Location;import mxcompiler.ast.ASTDump;
public class BreakStmtNode extends StmtNode {
			@Override
	public void _dump(ASTDump d) {
				d.printf("<BreakStmtNode> %s\n", location.toString());

	}

	public BreakStmtNode(Location location) {
		super(location);}
    
}