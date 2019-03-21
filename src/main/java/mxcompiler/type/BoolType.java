package mxcompiler.type;

public class BoolType extends Type {
    // name, size
    // private int size; // from configuration
    public BoolType() {
		super(Type.InnerType.BOOL);
    }
}