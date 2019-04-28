package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.utils.Dump;


/** return have to be the last of each basicblock */
public class Return extends JumpQuad {
    private RegValue val;

    public Return(BasicBlock parent, RegValue value) {
        super(parent);
        this.val = value;
        reloadUsedRegs();
    }

    public RegValue getReturnValue() {
        return val;
    }

    @Override
    public Return copyRename(Map<Object, Object> renameMap) {
        return new Return((BasicBlock) renameMap.getOrDefault(parent, parent),
                (RegValue) renameMap.getOrDefault(val, val));
    }

    /** {@inheritDoc} */
    @Override
    public void reloadUsedRegs() {
        usedRegisters.clear();
        usedRegValues.clear();
        if (val != null && val instanceof Register)
            usedRegisters.add((Register) val);
        if (val != null)
            usedRegValues.add(val);
    }

    /** {@inheritDoc} */
    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if (val != null && val instanceof Register)
            val = renameMap.get(val);
        reloadUsedRegs();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("return");
    }
}