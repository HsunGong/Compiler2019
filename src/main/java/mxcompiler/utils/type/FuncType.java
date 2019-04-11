package mxcompiler.utils.type;

public class FuncType extends Type {
    // private int length, pointersize, undefined; // from configuration
    private String name;
    
    public FuncType(String name) {
        super(InnerType.FUNCTION);
        this.name = name;
    }

    public String getName() { return name; }
    @Override
    public String toString() {
        return super.toString() + " " + name;
    }
}