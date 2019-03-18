package mxcompiler.type;

public class NullType extends Type {
    public NullType() {
        innerType = InnerType.NULL;
    }
}