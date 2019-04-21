package mxcompiler.ir.instruction;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.RegValue;
import mxcompiler.utils.Dump;


/** branch */
public class CJump extends JumpQuad {
    private RegValue cond;
    public BasicBlock thenBody, elseBody;

    public CJump(BasicBlock parent, RegValue cond, BasicBlock thenBody, BasicBlock elseBody) {
        super(parent);
        this.cond = cond;
        this.thenBody = thenBody;
        this.elseBody = elseBody;
    }

    public RegValue getCond() {
        return cond;
    }

    public BasicBlock getThen() {
        return thenBody;
    }
    public BasicBlock getElse() {
        return elseBody;
    }

    // @Override
    // public IRBranch copyRename(Map<Object, Object> renameMap) {
    // return new IRBranch(
    // (BasicBlock) renameMap.getOrDefault(getParentBB(), getParentBB()),
    // (RegValue) renameMap.getOrDefault(cond, cond),
    // (BasicBlock) renameMap.getOrDefault(thenBB, thenBB),
    // (BasicBlock) renameMap.getOrDefault(elseBB, elseBB)
    // );
    // }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("CJUMP");
    }
}