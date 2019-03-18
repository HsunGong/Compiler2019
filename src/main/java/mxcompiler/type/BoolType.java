package mxcompiler.type;

public class BoolType extends Type {
    // name, size
    // private int size; // from configuration
    public BoolType() {
        innerType = InnerType.BOOL;
    }
}