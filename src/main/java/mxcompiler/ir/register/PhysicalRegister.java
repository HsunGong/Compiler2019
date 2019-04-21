package mxcompiler.ir.register;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;


public class PhysicalRegister extends Register {

    public PhysicalRegister(String name) {
        super(name);
    }

    // public abstract String getName();
    // public abstract boolean isGeneral();
    // public abstract boolean isCallerSave();
    // public abstract boolean isCalleeSave();
    // public abstract boolean isArg6();
    // public abstract int getArg6Idx();
    

    public void _dump(Dump d) {
        d.println("physical Reigst");
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public PhysicalRegister copy() {
        return null;
    }
}