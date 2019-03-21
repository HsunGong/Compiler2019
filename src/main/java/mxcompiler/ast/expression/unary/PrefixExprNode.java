package mxcompiler.ast.expression.unary;


import mxcompiler.ast.expression.ExprNode;
import mxcompiler.ast.Location;
/**
 * No longer support UnaryArithmeticOpNode It is included in {@code suffix} and
 * {@code prefix}
 */
public class PrefixExprNode extends ExprNode {
	public static enum Op {
		PRE_INC("++"), PRE_DEC("--"),
		POSI("+"), NEGA("-"), 
		LOGIC_NOT("!"), BIT_NOT("~");

		private String label;

		private Op(String label) {
				this.label = label;
			}
	}

	private Op prefixOp;
	private ExprNode prefixExpr;

	public PrefixExprNode(String prefixOp, ExprNode prefixExpr, Location location) {
		super(location);
		this.prefixOp = Op.valueOf(prefixOp);
		this.prefixExpr = prefixExpr;
	}

	// NOTE: maybe get string ???
	public Op getOp() {
		return prefixOp;
	}

	public ExprNode getExpr() {
		return prefixExpr;
	}

}