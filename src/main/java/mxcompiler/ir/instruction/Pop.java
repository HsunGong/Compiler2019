package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.error.CompileError;
import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.PhysicalRegister;
import mxcompiler.utils.Dump;


public class Pop extends Quad {
    private RegValue val; // PhysicalRegister

    public Pop(BasicBlock parent, RegValue preg) {
        super(parent);
        this.val = preg;
    }

    @Override
    public Quad copyRename(Map<Object, Object> renameMap) {
        return null;
    }

    public PhysicalRegister getValue() {
        return (PhysicalRegister) val;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Push");
    }
}