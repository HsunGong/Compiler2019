package mxcompiler.ir.register;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;


public class IntImm extends RegValue {
    private int val;

    public IntImm(int value) {
        this.val = value;
    }

    public int getValue() {
        return val;
    }

    public void _dump(Dump d) {
        d.println("int imm");
    }

    public String accept(IRVisitor visitor) {
        return visitor.visit(this);
    }

    public IntImm copy() {
        // FIX: return this ???
        return new IntImm(val);
    }
}