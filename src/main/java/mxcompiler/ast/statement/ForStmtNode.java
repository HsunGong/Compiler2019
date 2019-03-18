package mxcompiler.ast.statement;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;

public class ForStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("For stmt"); }

    private StmtNode init;
    private ExprNode cond;
    private StmtNode incr;
    private StmtNode body;
    // private List<VarDeclNode> forInit; FIX:

    public ForStmtNode(StmtNode initiate, ExprNode cond, StmtNode increase, 
                    StmtNode body) {
        this.init = initiate;
        this.incr = increase;
        this.cond = cond;
        this.body = body; // may be null
    }

    public StmtNode getInit() { return init; }
    public ExprNode getCond() { return cond; }
    public StmtNode getIncr() { return incr; }
    public StmtNode getBody() { return body; }
}