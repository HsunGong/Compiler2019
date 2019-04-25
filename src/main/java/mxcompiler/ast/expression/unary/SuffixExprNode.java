package mxcompiler.ast.expression.unary;

import mxcompiler.ast.expression.ExprNode;

import java.util.HashMap;

import mxcompiler.ast.*;


/**
 * No longer support UnaryArithmeticOpNode. It is included
 * in {@link SuffixExprNode} and {@code PrefixExprNode}
 * <p>
 * Like {@code x++}
 */
public class SuffixExprNode extends ExprNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<SuffixExprNode> %s\n", location.toString());
		d.printf(" op: %s\n", getOp().toString());
	}

	public static enum Op {
		// SELF_INC, SELF_DEC
		SUF_INC("++"), SUF_DEC("--");
		private String label;

		private Op(String label) {
			this.label = label;
		}

		private static final HashMap<String, Op> keyMap = new HashMap<String, Op>();
		static {
			for (Op op : Op.values()) {
				keyMap.put(op.label, op);
			}
		}

		public static Op get(String key) {
			return keyMap.get(key);
		}
	}

	private Op suffixOp;
	private ExprNode suffixExpr;

	public SuffixExprNode(String suffixOp, ExprNode suffixExpr, Location location) {
		super(location);
		this.suffixOp = Op.get(suffixOp);
		this.suffixExpr = suffixExpr;
	}

	public Op getOp() {
		return suffixOp;
	}

	public ExprNode getExpr() {
		return suffixExpr;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}