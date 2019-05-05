package mxcompiler.ast.expression.unary;

import mxcompiler.ast.expression.ExprNode;

import java.util.HashMap;

import mxcompiler.ast.*;
import mxcompiler.utils.Dump;


/**
 * No longer support UnaryArithmeticOpNode. It is included
 * in {@link SuffixExprNode} and {@code PrefixExprNode}
 * <p>
 * Like {@code ++x}
 */
public class PrefixExprNode extends ExprNode {
	@Override
	public void _dump(Dump d) {
		d.printf("<PrefixExprNode> %s\n", location.toString());
		d.printf(" op: %s\n", getOp().toString());
	}

	public static enum Op {
		// SELF_INC, SELF_DEC, POSI, NEGE, LOGIC_NOT, BIT_NOT
		INC("++"), DEC("--"), POSI("+"), NEGA("-"), LOGIC_NOT("!"), BIT_NOT("~");

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

	private Op prefixOp;
	private ExprNode prefixExpr;

	public PrefixExprNode(String prefixOp, ExprNode prefixExpr, Location location) {
		super(location);
		this.prefixOp = Op.get(prefixOp);
		this.prefixExpr = prefixExpr;
	}

	// NOTE: maybe get string ???
	public Op getOp() {
		return prefixOp;
	}

	public ExprNode getExpr() {
		return prefixExpr;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}