package mxcompiler.ir.register;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;


public class PhysicalRegister extends Register {
    private final boolean isGeneral, isCallerSave, isCalleeSave;
    private final int argIdx;

    public PhysicalRegister(String name, boolean isGeneral, boolean isCallerSave,
            boolean isCalleeSave, int argIdx) {
        super(name);
        this.isGeneral = isGeneral;
        this.isCallerSave = isCallerSave;
        this.isCalleeSave = isCalleeSave;
        this.argIdx = argIdx;
    }

    public boolean isGeneral() {
        return isGeneral;
    }

    public boolean isCallerSave() {
        return isCallerSave;
    }

    public boolean isCalleeSave() {
        return isCalleeSave;
    }

    // special for args
    public boolean isArg() {
        return argIdx != -1;
    }

    public int getArgIdx() {
        return argIdx;
    }

    public void _dump(Dump d) {
        d.println("physical Reigst");
    }

    public String accept(IRVisitor visitor) {
        return visitor.visit(this);
    }

    public PhysicalRegister copy() {
        throw new CompileError("error copy Physical register");
    }
}