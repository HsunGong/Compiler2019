package mxcompiler.ir.instruction;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;

import java.util.*;

import mxcompiler.ast.statement.ForStmtNode;
import mxcompiler.error.CompileError;


public class BasicBlock {
    // private IRInstruction firstInst = null, lastInst = null;
    private LinkedList<Quad> insts = new LinkedList<>();

    private Function func;
    private String name;
    // private int ord

    private Set<BasicBlock> prev = new HashSet<>();
    private Set<BasicBlock> next = new HashSet<>(); // may be linked-List

    // FIX:??
    public ForStmtNode forNode = null; // StmtNode ??
    public int postOrderIdx, preOrderIdx;

    private boolean hasJump = false; // hasJumpInst

    public BasicBlock(Function func, String name) {
        this.func = func;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Function getFunc() {
        return func;
    }

    public LinkedList<Quad> getInsts() {
        return insts;
    }

    private void replaceInst(Quad before, Quad after) {
        int index = insts.indexOf(before);
        insts.remove(before);
        insts.add(index, after);
    }

    public void addInst(Quad inst) {
        if (hasJump)
            throw new CompileError("Block is finished");

        insts.add(inst);
    }

    public void delInst(Quad inst) {
        if (hasJump && inst == insts.getLast())
            delJump();
        else if (inst instanceof JumpQuad) // FIX: Fine
            throw new CompileError("Error when del Jump quad");
        else
            insts.remove(inst);
    }

    public void clearInsts() { // reInit
        insts = new LinkedList<>();
        hasJump = false;
    }

    // region prev-next
    public Set<BasicBlock> getPrev() {
        return prev;
    }

    public void addPrev(BasicBlock bb) {
        try {
            prev.add(bb);
        } catch (Exception e) {
            throw new CompileError("add" + e.getMessage());
        }
    }

    public void delPrev(BasicBlock bb) {
        try {
            prev.remove(bb);
        } catch (Exception e) {
            throw new CompileError("del" + e.getMessage());
        }
    }

    public Set<BasicBlock> getNext() {
        return next;
    }

    public void addNext(BasicBlock bb) {
        try {
            next.add(bb);
            if (bb != null)
                bb.addPrev(this);
        } catch (Exception e) {
            throw new CompileError("add" + e.getMessage());
        }
    }

    public void delNext(BasicBlock bb) {
        try {
            next.remove(bb);
            bb.delPrev(this);
        } catch (Exception e) {
            throw new CompileError("del" + e.getMessage());
        }
    }
    // endregion

    // region jump
    public boolean hasJump() {
        return this.hasJump;
    }

    // have mutli jumps
    public void setJump(JumpQuad inst) {
        if (hasJump)
            throw new CompileError("Already has jump");
        addInst(inst);
        hasJump = true;

        if (inst instanceof CJump) { // 2 branch
            CJump x = (CJump) inst;
            addNext(x.getThen());
            addNext(x.getElse());
        } else if (inst instanceof Jump) {
            Jump x = (Jump) inst;
            addNext(x.getTarget());
        } else if (inst instanceof Return) {
            Return x = (Return) inst;
            func.returns.add(x);
        }
    }

    public void delJump() {
        hasJump = false;
        Quad last = insts.getLast();
        if (!(last instanceof JumpQuad))
            throw new CompileError("invalid type of Remove Jump");

        insts.remove(last);

        // del block or returns
        if (last instanceof CJump) {
            CJump x = (CJump) last;
            delNext(x.getThen());
            delNext(x.getElse());
        } else if (last instanceof Jump) {
            Jump x = (Jump) last;
            delNext(x.getTarget());
        } else if (last instanceof Return) {
            Return x = (Return) last;
            func.returns.remove(x);
        }
    }
    // endregion

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("BasicBlock");
    }
}