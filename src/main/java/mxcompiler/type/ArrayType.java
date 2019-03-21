package mxcompiler.type;

public class ArrayType extends Type {
    // private int length, pointersize, undefined; // from configuration
	private Type baseType;
	
	public ArrayType(Type baseType) {
		super(Type.InnerType.ARRAY);
		this.baseType = baseType;
	}
	
	public Type getBaseType() { return baseType; }
	// public int getDim() { return dim; } maybe from entity
}