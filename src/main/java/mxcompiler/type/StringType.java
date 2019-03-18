package mxcompiler.type;

public class StringType extends Type {
    // name, size
    // private int size; // from configuration
    public StringType() {
        innerType = InnerType.STRING;
    }
}