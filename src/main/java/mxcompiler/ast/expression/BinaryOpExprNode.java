package mxcompiler.ast.expression;

import java.util.HashMap;

import mxcompiler.ast.*;

public class BinaryOpExprNode extends ExprNode {
	@Override
	public void _dump(ASTDump d) {
		d.printf("<BinaryOpExprNode> %s\n", location.toString());
		d.printf(" op: %s\n", getOp().toString());
	}

	public static enum Op {
		MUL("*"), DIV("/"), MOD("%"), ADD("+"), SUB("-"), SH_L("<<"), SH_R(">>"), GREATER(">"), LESS(
				"<"), GREATER_EQUAL(">="), LESS_EQUAL("<="), EQUAL(
						"=="), INEQUAL("!="), BIT_AND("&"), BIT_OR("|"), BIT_XOR("^"), LOGIC_AND("&&"), LOGIC_OR("||");

		private String label;

		private Op(String label) {
			this.label = label;
		}

		// NOTE: need this to transfer
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

	private ExprNode lhs, rhs;
	private Op op;

	/** type can be null and add later */
	public BinaryOpExprNode(ExprNode lhs, String op, ExprNode rhs, Location location) {
		super(location);
		// this.type = type;
		// UGLY: will throw IllegalArgumentException
		this.op = Op.get(op);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public ExprNode getLhs() {
		return lhs;
	}

	public ExprNode getRhs() {
		return rhs;
	}

	public void setLhs(ExprNode lhs) {
		this.lhs = lhs;
	}

	public void setRhs(ExprNode rhs) {
		this.rhs = rhs;
	}

	public Op getOp() {
		return op;
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}