package mxcompiler.utils.type;

public class StringType extends Type {
    // name, size
    // private int size; // from configuration
    public StringType() {
		super(Type.InnerType.STRING);
    }
}