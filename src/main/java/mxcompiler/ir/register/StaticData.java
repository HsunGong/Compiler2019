package mxcompiler.ir.register;

abstract public class StaticData extends RegValue {
    private String name;
    private int size;

    public StaticData(String name, int size) {
        this.name = name;
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