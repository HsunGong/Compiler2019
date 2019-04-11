package mxcompiler.utils.type;

public class ClassType extends Type {
    // private int length, pointersize, undefined; // from configuration
    private String name;
    
    public ClassType(String name) {
		super(InnerType.CLASS);
        this.name = name;
    }

    public String getName() { return name; }
    @Override
    public String toString() {
        return super.toString() + " " + name;
    }
}