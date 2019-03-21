package mxcompiler.ast.expression;


import mxcompiler.ast.Location;
/** no auto transfer type */
public class AssignExprNode extends ExprNode {
    private ExprNode lhs;
    private ExprNode rhs;

    public AssignExprNode(ExprNode lhs, ExprNode rhs, Location location) {
		super(location);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public ExprNode getLhs() { return lhs; }
    public ExprNode getRhs() { return rhs; }
    public void setRhs(ExprNode e) { this.rhs = e; }
}