package mxcompiler.ast.expression.unary;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;import mxcompiler.ast.ASTDump;
/** No longer support UnaryArithmeticOpNode 
*/
public class SuffixExprNode extends ExprNode {
		@Override
	public void _dump(ASTDump d) {
				d.printf("<SuffixExprNode> %s\n", location.toString());
		d.printf(" op: %s\n", getOp().toString());
	}
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