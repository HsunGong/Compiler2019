package mxcompiler.type;

public class VarType extends Type {
    // private int length, pointersize, undefined; // from configuration
	private Type baseType;
	
	public VarType(Type baseType) {
		super(Type.InnerType.VARIABLE);
		// NOTE
		// assert(!(baseType instanceof VarType));
		this.baseType = baseType;
	}
	
	public Type getBaseType() { return baseType; }
	// public int getDim() { return dim; } maybe from entity
}