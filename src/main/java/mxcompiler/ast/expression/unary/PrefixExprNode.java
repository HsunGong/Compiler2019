package mxcompiler.ast.expression.unary;

import mxcompiler.ast.Dump;
import mxcompiler.ast.expression.ExprNode;

/** No longer support UnaryArithmeticOpNode
 * It is included in {@code suffix} and {@code prefix}
 */
public class PrefixExprNode extends ExprNode {
    @Override
    public void _dump(Dump d) { d.print("Suffix Expr"); }

    public static enum Op {
        PRE_INC, PRE_DEC, POS, NEG, LOGIC_NOT, BIT_NOT
    }

    private Op prefixOp;
    private ExprNode prefixExpr;

    public PrefixExprNode(Op prefixOp, ExprNode prefixExpr) {
        this.prefixOp = prefixOp;
        this.prefixExpr = prefixExpr;
    }

    public Op getOp() { return prefixOp; }
    public ExprNode getExpr() { return prefixExpr; }
    
}