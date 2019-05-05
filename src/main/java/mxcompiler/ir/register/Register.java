package mxcompiler.ir.register;

/**
 * father of {@link PhysicalRegister} and {@link VirtualRegister} and
 * {@link StaticData}
 */
abstract public class Register extends RegValue {
    protected String name;

    public Register(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}