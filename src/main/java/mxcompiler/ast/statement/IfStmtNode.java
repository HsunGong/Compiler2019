package mxcompiler.ast.statement;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
public class IfStmtNode extends StmtNode {
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
