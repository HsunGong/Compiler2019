package mxcompiler.ir.register;

import mxcompiler.ir.IRVisitor;

abstract public class RegValue {
    public static final int RegSize = 8;


    abstract public void accept(IRVisitor visitor);
    abstract public RegValue copy();
}