package mxcompiler.ast.statement;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;

public class ReturnStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("Continue stmt"); }

    /** can be null */
    private ExprNode expr;

    public ReturnStmtNode(ExprNode expr) {
        this.expr = expr;
    }

    public void setExpr(ExprNode e) { this.expr = e; }
    public ExprNode getExpr() { return this.expr; }
    
}