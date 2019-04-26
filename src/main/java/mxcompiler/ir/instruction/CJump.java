package mxcompiler.ir.instruction;

import java.util.Map;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.ir.register.Register;
import mxcompiler.utils.Dump;


/** branch */
public class CJump extends JumpQuad {
    private RegValue cond;
    public BasicBlock thenBB, elseBB;

    public CJump(BasicBlock parent, RegValue cond, BasicBlock thenBB, BasicBlock elseBB) {
        super(parent);
        this.cond = cond;
        this.thenBB = thenBB;
        this.elseBB = elseBB;
    }

    public RegValue getCond() {
        return cond;
    }

    public BasicBlock getThen() {
        return thenBB;
    }

    public BasicBlock getElse() {
        return elseBB;
    }

    @Override
    public CJump copyRename(Map<Object, Object> renameMap) {
        return new CJump((BasicBlock) renameMap.getOrDefault(parent, parent),
                (RegValue) renameMap.getOrDefault(cond, cond),
                (BasicBlock) renameMap.getOrDefault(thenBB, thenBB),
                (BasicBlock) renameMap.getOrDefault(elseBB, elseBB));
    }

    /** {@inheritDoc} */
    @Override
    protected void reloadUsedRegs() {
        usedRegisters.clear();
        usedRegValues.clear();
        if (cond instanceof Register)
            usedRegisters.add((Register) cond);
        usedRegValues.add(cond);
    }

    /** {@inheritDoc} */
    @Override
    public void setUsedRegisters(Map<Register, Register> renameMap) {
        if (cond instanceof Register)
            cond = renameMap.get(cond);
        reloadUsedRegs();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("CJUMP");
    }
}