package mxcompiler.ast.statement;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
public class ReturnStmtNode extends StmtNode {
    /** can be null */
    private ExprNode expr;

    public ReturnStmtNode(ExprNode expr, Location location) {
		super(location);
        this.expr = expr;
    }

    public void setExpr(ExprNode e) { this.expr = e; }
    public ExprNode getExpr() { return this.expr; }
    
}