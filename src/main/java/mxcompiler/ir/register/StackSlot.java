package mxcompiler.ir.register;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.instruction.Function;
import mxcompiler.utils.Dump;


public class StackSlot extends Register {
    private Function parent;

    public StackSlot(String name, Function parent, boolean isArgSlot) {
        super(name);
        this.parent = parent;
        if (!isArgSlot)
            parent.stackSlots.add(this);
    }

    public Function getFunc() {
        return parent;
    }

    public void _dump(Dump d) {
        d.println("stack slot");
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public VirtualRegister copy() {
        return null;
    }
}