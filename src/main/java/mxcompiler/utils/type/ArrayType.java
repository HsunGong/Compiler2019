package mxcompiler.utils.type;

public class ArrayType extends Type {
    // private int length, pointersize, undefined; // from configuration
	private Type baseType;
	// private int dim;
	
	public ArrayType(Type baseType) {
		super(Type.InnerType.ARRAY);
		this.baseType = baseType;
		// this.dim = dim;
	}
	// public ArrayType(Type baseType, int dim) {
	// 	super(Type.InnerType.ARRAY);
	// 	this.baseType = baseType;
	// 	this.dim = dim;
	// }

	// public int getDim() {return dim; }
	
	public Type getBaseType() { return baseType; }
	// public int getDim() { return dim; } maybe from entity
}