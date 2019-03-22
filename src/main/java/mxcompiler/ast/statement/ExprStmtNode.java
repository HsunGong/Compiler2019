package mxcompiler.ast.statement;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
import mxcompiler.ast.ASTDump;
/** This is Expr from stmt */
public class ExprStmtNode extends StmtNode {
			@Override
	public void _dump(ASTDump d) {		d.printf("<ExprStmtNode> %s\n", location.toString());
}
    private ExprNode expr;

    public ExprStmtNode(ExprNode e, Location location) {
		super(location);
        this.expr = e;
    }

    public void setExpr(ExprNode e) { this.expr = e; }
    public ExprNode getExpr() { return this.expr; }

}