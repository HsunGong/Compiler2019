package mxcompiler.ast.statement;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;import mxcompiler.ast.ASTDump;
public class IfStmtNode extends StmtNode {
			@Override
	public void _dump(ASTDump d) {		d.printf("<IfStmtNode> %s\n", location.toString());
}
    private ExprNode cond;
    private StmtNode thenBody;
    /** may be null */
    private StmtNode elseBody; 

    public IfStmtNode(ExprNode cond, StmtNode thenBody, StmtNode elseBody, Location location) {
		super(location);
        this.cond = cond;
        this.thenBody = thenBody;
        this.elseBody = elseBody; // may be null
    }

    public ExprNode getCond() { return cond; }
    public StmtNode getThen() { return thenBody; }
    public StmtNode getElse() { return elseBody; }
}
