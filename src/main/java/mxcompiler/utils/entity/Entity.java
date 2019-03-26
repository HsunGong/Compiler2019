package mxcompiler.utils.entity;

import mxcompiler.type.Type;
// import mxcompiler.type.VarType;
import mxcompiler.utils.Dump;

/**
 * The type here is functional type means, only class, function, variable type
 * is supported
 */
abstract public class Entity {
	protected String name;
	protected Type type; // not TypeNode anymore
	// no reference, private, address, mmeref
	// no location

	public Entity(String name, Type type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		// if (type instanceof VarType) return ((VarType) type).getBaseType();
		return type;
	}

	abstract public void _dump(Dump d);
}