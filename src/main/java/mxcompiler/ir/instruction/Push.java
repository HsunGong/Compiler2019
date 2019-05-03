package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.utils.Dump;


public class Push extends Quad {
    private RegValue val;

    public Push(BasicBlock parent, RegValue value) {
        super(parent);
        this.val = value;
    }

    @Override
    public Quad copyRename(Map<Object, Object> renameMap) {
        return null;
    }

    public RegValue getValue() {
        return val;
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("Push");
    }
}