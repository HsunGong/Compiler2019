package mxcompiler.ir.register;

/** father of {@link StaticString} and {@link StaticVar} */
abstract public class StaticData extends Register {
    // private String name;
    private int size;

    public StaticData(String name, int size) {
        super(name);
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public StaticData copy() {
        return this;
    }
}