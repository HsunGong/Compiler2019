package mxcompiler.type;

public class ArrayType extends Type {
    // private int length, pointersize, undefined; // from configuration
    public ArrayType() {
        innerType = InnerType.ARRAY;
    }
}