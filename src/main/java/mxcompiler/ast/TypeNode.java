package mxcompiler.ast;

import mxcompiler.utils.type.Type;
import mxcompiler.utils.Dump;
/**
 * This class {@code TypeNode} is important cause, it connect astNodes with
 * inbuild types which details are in {@linkplain mxcompiler.utils.type.Type }
 */
public class TypeNode extends Node {
	@Override
	public void _dump(Dump d) {
		d.printf("<TypeNode> %s\n", location.toString());
		d.printf(" type: %s\n", getType().toString());
	}

	protected Type type;

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
		return rhs.type.isEqual(this.type);
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}