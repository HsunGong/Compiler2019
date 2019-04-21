package mxcompiler.ir.register;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;


public class IntImm extends RegValue {
    private int val;

    public IntImm(int value) {
        this.val = value;
    }

    public int getVal() {
        return val;
    }

    public void _dump(Dump d) {
        d.println("int imm");
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public IntImm copy() {
        return new IntImm(val);
    }
}