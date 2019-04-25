package mxcompiler.ast.expression;

import mxcompiler.ast.Node;
import mxcompiler.ir.instruction.BasicBlock;
import mxcompiler.ir.register.RegValue;
import mxcompiler.utils.type.Type;
// import mxcompiler.utils.type.VarType;
import mxcompiler.ast.Location;


abstract public class ExprNode extends Node {
	protected Type type;

	// regvalue, basicblock, addrOffset
	public ExprNode(Location location) {
		super(location);
		type = null;
	}

	public void setType(Type t) {
		this.type = t;
	}

	public Type getType() {
		return type;
	}

	public boolean isEqual(Type rhs) {
		return rhs.isEqual(this.type);
	}

	protected boolean isLeftValue = false;

	public void setIsLeftValue(boolean s) {
		this.isLeftValue = s;
	}

	public boolean isLeftValue() {
		return isLeftValue;
	}

	private BasicBlock thenBB, elseBB; // trueBB and FalseBB

	/** True */
	public void setThen(BasicBlock thenBB) {
		this.thenBB = thenBB;
	}

	/**
	 * True
	 * <p>
	 * if getThen() == null, means no more branchs
	 */
	public BasicBlock getThen() {
		return thenBB;
	}

	/** False */
	public void setElse(BasicBlock elseBB) {
		this.elseBB = elseBB;
	}

	/** False */
	public BasicBlock getElse() {
		return elseBB;
	}

	/**
	 * <p>
	 * for class(member), it is base-addr
	 * <p>
	 * for array(head), it is base-addr
	 * <p>
	 * for norm-expr, it is value
	 * <p>
	 * NOTE: TODO: (IRBuilder-MemberExprNode, ArefNode). sometimes no init,
	 * means how to deal it ?? FIX: BUG:
	 */
	public RegValue regValue;
	/** addr-base-value */
	public RegValue addrValue;
	/** addr-base-offset */
	public int offset;

}