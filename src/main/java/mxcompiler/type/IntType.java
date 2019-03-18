package mxcompiler.type;

public class IntType extends Type {
    // name, size
    // private int size; // from configuration
    public IntType() {
        innerType = InnerType.INT;
    }
}