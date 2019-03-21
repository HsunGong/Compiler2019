package mxcompiler.ast.statement;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;

/** This is Expr from stmt */
public class ExprStmtNode extends StmtNode {
    private ExprNode expr;

    public ExprStmtNode(ExprNode e, Location location) {
		super(location);
        this.expr = e;
    }

    public void setExpr(ExprNode e) { this.expr = e; }
    public ExprNode getExpr() { return this.expr; }

}