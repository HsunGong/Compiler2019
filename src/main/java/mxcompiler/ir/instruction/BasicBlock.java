package mxcompiler.ir.instruction;

import mxcompiler.ir.IRVisitor;
import mxcompiler.utils.Dump;

import java.util.*;

import mxcompiler.ast.statement.ForStmtNode;
import mxcompiler.error.CompileError;


public class BasicBlock {
    private Function func;
    private String name;

    public ForStmtNode forNode;

    public int postOrder, preOrder; // get order of cfg


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

    // region prev-next BB <-- double direction
    private Set<BasicBlock> prev = new HashSet<>();
    private Set<BasicBlock> next = new HashSet<>(); // may be linked-List

    private void addPrev(BasicBlock bb) {
        prev.add(bb);
    }

    private void addNext(BasicBlock bb) {
        next.add(bb);
        if (bb != null)
            bb.addPrev(this);
    }

    private void delPrev(BasicBlock bb) {
        prev.remove(bb);
    }

    private void delNext(BasicBlock bb) {
        next.remove(bb);
        if (bb != null)
            bb.delPrev(this);
    }

    public Set<BasicBlock> getPrev() {
        return prev;
    }

    public Set<BasicBlock> getNext() {
        return next;
    }
    // endregion

    // region insts
    private LinkedList<Quad> insts = new LinkedList<>();
    private boolean hasJump = false; // hasJumpInst

    public LinkedList<Quad> getInsts() {
        return insts;
    }

    // remove, add indx, del index implement with iter
    // add, del with last
    public void addLastInst(Quad inst) {
        if (hasJump)
            throw new CompileError("Block is finished");

        insts.addLast(inst);
    }

    /**
     * double check
     */
    public void delLastInst(Quad inst) {
        if (hasJump && inst == insts.getLast())
            delJump();
        else if (insts.getLast() != inst || inst instanceof JumpQuad) // FIX: Fine
            throw new CompileError("Error when del Jump quad");
        else
            insts.removeLast();
    }

    /**
     * remove
     * <p>
     * illigal: don't have iter.next() after origin
     * 
     * <pre>
     * // origin: iter inst(select) (inst2)
     * iter.next(); inst ...
     * // before: inst(select) iter (inst2)
     * delInst(iter)
     * // after: iter (inst2)
     * </pre>
     */
    public void removeInst(ListIterator<Quad> iter) {
        Quad inst = iter.previous();
        if (hasJump && inst == insts.getLast())
            delJump();
        else if (insts.getLast() != inst || inst instanceof JumpQuad) // FIX: Fine
            throw new CompileError("Error when del Jump quad");
        else
            iter.remove(); // remove inst
    }

    /**
     * append
     * <p>
     * illigal: don't have iter.next() after origin
     * 
     * <pre>
     * // origin: iter inst(will select) inst2
     * inst = iter.next(); inst ...
     * // before: inst(select) iter inst2
     * bb.addBeforeInst(iter, new_inst)
     * // after: inst(select) new_inst iter inst2
     * </pre>
     */
    public void addAfterInst(ListIterator<Quad> iter, Quad newInst) {
        iter.add(newInst);
    }

    /**
     * prepend
     * <p>
     * illigal: don't have iter.next() before
     * 
     * <pre>
     * // origin: inst1 iter inst(will select) inst2
     * inst = iter.next(); inst ...
     * // before: inst1 inst(select) iter inst2
     * bb.addBeforeInst(iter, new_inst)
     * // after : inst1 new_inst origin_iter inst(select) return_iter inst2
     * </pre>
     */
    public void addBeforeInst(ListIterator<Quad> iter, Quad newInst) {
        if (!iter.hasPrevious()) // check origin inst
            throw new CompileError("Error add-before inst");

        iter.previous(); // get inst1
        iter.add(newInst); // get origin_iter
        iter.next(); // get return_iter
    }

    /**
     * replace
     * 
     * <pre>
     * // origin:  iter inst(will select) inst2
     * before: inst = iter.next(); inst ...
     * // before: inst(select) iter inst2
     * bb.addBeforeInst(iter, new_inst)
     * // after: new_inst iter inst2
     * </pre>
     */
    public void replaceInst(ListIterator<Quad> iter, Quad newInst) {
        if (!iter.hasPrevious()) // check origin inst
            throw new CompileError("can not get iter.previous");
        iter.set(newInst);
    }

    /** reInit() -- only for insts and jumps */
    public void clearInsts() {
        insts = new LinkedList<>();
        hasJump = false;
    }

    // region jump
    public boolean hasJump() {
        return this.hasJump;
    }

    // have mutli jumps
    public void setJump(JumpQuad inst) {
        if (hasJump)
            throw new CompileError("Already has jump");
        addLastInst(inst);
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

        insts.removeLast();

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

    // endregion

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("BasicBlock");
    }
}