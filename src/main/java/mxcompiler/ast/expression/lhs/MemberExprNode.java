package mxcompiler.ast.expression.lhs;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;

/** MemberExpr is Member Access Node of '.' 
 * IN book file, it is ptrmember and membernode
*/
public class MemberExprNode extends LhsExprNode {
    @Override
    public void _dump(Dump d) { d.print("member expr"); }

    private ExprNode expr;
    private String member;

    public MemberExprNode(ExprNode expr, String member) {
        this.expr = expr;
        this.member = member;
    }

    public ExprNode getExpr() { return expr; }
    public String getMember() { return member; }

}