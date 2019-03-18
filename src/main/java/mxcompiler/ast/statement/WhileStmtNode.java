package mxcompiler.ast.statement;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;

public class WhileStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("While stmt"); }

    private ExprNode cond;
    private StmtNode body;

    public WhileStmtNode(ExprNode cond, StmtNode body) {
        this.cond = cond;
        this.body = body; // may be null
    }

    public ExprNode getCond() { return cond; }
    public StmtNode getBody() { return body; }
}
