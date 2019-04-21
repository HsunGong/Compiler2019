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

	// True
	public void setThen(BasicBlock thenBB) {
		this.thenBB = thenBB;
	}

	public BasicBlock getThen() {
		return thenBB;
	}

	// False
	public void setElse(BasicBlock elseBB) {
		this.elseBB = elseBB;
	}

	public BasicBlock getElse() {
		return elseBB;
	}

	public RegValue regValue, addValue;
	public RegValue offsetValue;
	
}