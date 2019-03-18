package mxcompiler.type;

public class FunctionType extends Type {
    // private int length, pointersize, undefined; // from configuration
    private String name;
    
    public FunctionType(String name) {
        innerType = InnerType.FUNCTION;
        this.name = name;
    }

    public String getName() { return name; }
    @Override
    public String toString() {
        return super.toString() + " " + name;
    }
}