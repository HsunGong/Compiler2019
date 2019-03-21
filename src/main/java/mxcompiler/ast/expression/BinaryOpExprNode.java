package mxcompiler.ast.expression;


import mxcompiler.type.Type;
import mxcompiler.ast.Location;
public class BinaryOpExprNode extends ExprNode {
	private static enum Oper {
		MUL("*"), DIV("/"), MOD("%"), 
		ADD("+"), SUB("-"), 
		SH_L("<<"), SH_R(">>"), 
		GREATER(">"), LESS("<"), 
		GREATER_EQUAL(">="), LESS_EQUAL("<="), 
		EQUAL("=="), INEQUAL("!="), 
		BIT_AND("&"), BIT_OR("|"), BIT_XOR("^"), 
		LOGIC_AND("&&"), LOGIC_OR("||");

		private String label;

		private Oper(String label) {
			this.label = label;
		}
	}

	private ExprNode lhs, rhs;
	private Oper op;

	/** type can be null and add later */
	public BinaryOpExprNode(ExprNode lhs, String op, ExprNode rhs, Location location) {
		super(location);
		// this.type = type;
		// UGLY: will throw IllegalArgumentException 
		this.op = Oper.valueOf(op);
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public ExprNode getlhs() {
		return lhs;
	}

	public ExprNode getrhs() {
		return rhs;
	}

	public void setlhs(ExprNode lhs) {
		this.lhs = lhs;
	}

	public void setrhs(ExprNode rhs) {
		this.rhs = rhs;
	}

	public Oper getOp() {
		return op;
	}
}