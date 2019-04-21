package mxcompiler.ir.register;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;

public class VirtualRegister extends Register {
    // private PhysicalRegister forcedPhysicalRegister = null;

    public VirtualRegister(String name) {
        super(name);
    }

    public void _dump(Dump d) {d.println("virtual Reigst");}
    public void accept(IRVisitor visitor) { visitor.visit(this);}
    public VirtualRegister copy() { return new VirtualRegister(name); }
}