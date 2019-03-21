package mxcompiler.ast.expression.lhs;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;


/** This is the array index node */
public class ArefExprNode extends LhsExprNode {
    @Override
    public void _dump(Dump d) { d.print("Array index"); }
    private ExprNode expr;
    private ExprNode index;

    public ArefExprNode(ExprNode expr, ExprNode index) {
        this.expr = expr;
        this.index = index;
    }

    public ExprNode getExpr() { return expr; }
    public ExprNode getIndex() { return index; }

    // public int getDim() { return dims; }
}