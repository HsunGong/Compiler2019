package mxcompiler.ast;

import mxcompiler.type.Type;

/**
 * This class {@code TypeNode} is important cause, it connect astNodes with
 * inbuild types which details are in {@linkplain mxcompiler.type.Type }
 */
public class TypeNode extends Node {

	protected Type type;
	// protected dim; // UGLY:

	public TypeNode(Type type, Location location) {
		super(location);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type t) {
		type = t;
	}

	public boolean isEqual(TypeNode rhs) {
		return rhs.type == this.type;
	}

}