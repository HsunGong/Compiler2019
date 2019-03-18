package mxcompiler.type;

public class VoidType extends Type {
    // FIX: instance is needed??
    public VoidType() {
        innerType = InnerType.VOID;
    }
}