package mxcompiler.ast.statement;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;

public class IfStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("If stmt"); }

    private ExprNode cond;
    private StmtNode thenBody;
    /** may be null */
    private StmtNode elseBody; 

    public IfStmtNode(ExprNode cond, StmtNode thenBody, StmtNode elseBody) {
        this.cond = cond;
        this.thenBody = thenBody;
        this.elseBody = elseBody; // may be null
    }

    public ExprNode getCond() { return cond; }
    public StmtNode getThen() { return thenBody; }
    public StmtNode getElse() { return elseBody; }
}
