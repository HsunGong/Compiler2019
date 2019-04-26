package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.utils.Dump;


/** return have to be the last of each basicblock */
public class Return extends JumpQuad {
    private RegValue val;

    public Return(BasicBlock parent, RegValue value) {
        super(parent);
        this.val = value;
        // reloadUsedRegistersRegValues
    }

    public RegValue getReturnValue() {
        return val;
    }

    @Override
    public Return copyRename(Map<Object, Object> renameMap) {
        return new Return((BasicBlock) renameMap.getOrDefault(parent, parent),
                (RegValue) renameMap.getOrDefault(val, val));
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("return");
    }
}