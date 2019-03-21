package mxcompiler.ast.expression.unary;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
/** No longer support UnaryArithmeticOpNode 
*/
public class SuffixExprNode extends ExprNode {
    public static enum Op {
        SUF_INC("++"), SUF_DEC("--");
		private String label;

		private Op(String label) {
			this.label = label;
		}
    }

    private Op suffixOp;
    private ExprNode suffixExpr;

    public SuffixExprNode(String suffixOp, ExprNode suffixExpr, Location location) {
		super(location);
        this.suffixOp = Op.valueOf(suffixOp);
        this.suffixExpr = suffixExpr;
    }

    public Op getOp() { return suffixOp; }
    public ExprNode getExpr() { return suffixExpr; }
    
}