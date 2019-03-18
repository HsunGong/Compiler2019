package mxcompiler.ast.statement;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;


/** This is Expr from stmt */
public class ExprStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("expr stmt"); }

    private ExprNode expr;

    public ExprStmtNode(ExprNode e) {
        this.expr = e;
    }

    public void setExpr(ExprNode e) { this.expr = e; }
    public ExprNode getExpr() { return this.expr; }

}