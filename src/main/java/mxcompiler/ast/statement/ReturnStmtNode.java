package mxcompiler.ast.statement;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;import mxcompiler.ast.ASTDump;
public class ReturnStmtNode extends StmtNode {
			@Override
	public void _dump(ASTDump d) {		d.printf("<ReturnStmtNode> %s\n", location.toString());
}
    /** can be null */
    private ExprNode expr;

    public ReturnStmtNode(ExprNode expr, Location location) {
		super(location);
        this.expr = expr;
    }

    public void setExpr(ExprNode e) { this.expr = e; }
    public ExprNode getExpr() { return this.expr; }
    
}