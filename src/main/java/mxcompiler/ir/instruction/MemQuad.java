package mxcompiler.ir.instruction;

import mxcompiler.ir.register.RegValue;

/** abstract class for Load and Move */
abstract public class MemQuad extends Quad {
    public RegValue baseAddr;
    public int offset;
    protected boolean isStaticData;

    protected RegValue value; // Register

    /**
     * value for store
     * <p>
     * destion for load (forced to register)
     */
    public RegValue getValue() {
        return value;
    }

    public boolean isStaticData() {
        return isStaticData;
    }

    protected int size;

    public int getSize() {
        return size;
    }

    public MemQuad(BasicBlock parent) {
        super(parent);
    }
}