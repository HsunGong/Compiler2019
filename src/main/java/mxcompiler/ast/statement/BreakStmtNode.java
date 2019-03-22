package mxcompiler.ast.statement;


import mxcompiler.ast.*;
public class BreakStmtNode extends StmtNode {
			@Override
	public void _dump(ASTDump d) {
				d.printf("<BreakStmtNode> %s\n", location.toString());

	}

	public BreakStmtNode(Location location) {
		super(location);}
    	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}