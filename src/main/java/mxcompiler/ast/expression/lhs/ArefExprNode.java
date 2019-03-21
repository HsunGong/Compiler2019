package mxcompiler.ast.expression.lhs;


import mxcompiler.ast.expression.ExprNode;

import mxcompiler.ast.Location;
/** This is the array index node */
public class ArefExprNode extends LhsExprNode {
    private ExprNode expr;
    private ExprNode index;

    public ArefExprNode(ExprNode expr, ExprNode index, Location location) {
		super(location);
        this.expr = expr;
        this.index = index;
    }

    public ExprNode getExpr() { return expr; }
    public ExprNode getIndex() { return index; }

    // public int getDim() { return dims; }
}