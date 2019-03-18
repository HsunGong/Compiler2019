package mxcompiler.ast.expression;

import mxcompiler.ast.Dump;

/** no auto transfer type */
public class AssignExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) {
        d.print("assign expr");
    }

    private ExprNode lhs;
    private ExprNode rhs;

    public AssignExprNode(ExprNode lhs, ExprNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public ExprNode getLhs() { return lhs; }
    public ExprNode getRhs() { return rhs; }
    public void setRhs(ExprNode e) { this.rhs = e; }
}