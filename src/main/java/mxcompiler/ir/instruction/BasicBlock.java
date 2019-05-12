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
        this.name = (name == null) ? "" : name;
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

    public void addPrev(BasicBlock bb) {
        prev.add(bb);
    }

    private void addNext(BasicBlock bb) {
        next.add(bb);
        if (bb != null)
            bb.addPrev(this);
    }

    public void delPrev(BasicBlock bb) {
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

    /**
     * Will delete last-Inst(Jump)
     * 
     * @can not delete: not the last inst
     * @can not use: will using iter
     */
    public void delJump(Quad inst) {
        if (!hasJump || insts.getLast() != inst)
            throw new CompileError("Error when del Last");

        // insts.getLast().removed = true;

        delJumpSideEffect();
        insts.removeLast();
    }

    /**
     * remove (support Last but not Jump Inst<Already Delete Jump>)
     * <p>
     * 
     * 
     * <pre>
     * // origin: iter inst(select) (inst2)
     * iter.next(); inst ...
     * // before: inst(select) iter (inst2)
     * delInst(iter)
     * // after: iter (inst2)
     * </pre>
     * 
     * @illigal don't have iter.next() after origin
     *          <p>
     *          can't use iter.previous() to replace iter.next()
     */
    public ListIterator<Quad> removeInst(ListIterator<Quad> iter) {
        Quad inst = iter.previous(); // check if inst is removed ??
        inst.removed = true;
        if (inst == insts.getLast()) {
            // only to make sure it is last
            if (hasJump)
                delJumpSideEffect();
        }

        iter.remove(); // remove inst
        return iter;
    }

    /**
     * remove (support Last but not Jump Inst<Already Delete Jump>)
     * <p>
     * 
     * <pre>
     * // origin: (inst2) iter inst(select)
     * iter.next(); inst ...
     * // before: (inst2) inst(select) iter
     * delInst(iter)
     * // after: iter (inst2)
     * </pre>
     * 
     * @illigal don't have iter.previous() after origin
     *          <p>
     *          can't use iter.next() to replace iter.previous()
     */
    public ListIterator<Quad> removeInstFromPrevious(ListIterator<Quad> iter) {
        Quad inst = iter.next(); // check if inst is removed ??
        inst.removed = true;
        if (inst == insts.getLast()) {
            // only to make sure it is last
            if (hasJump)
                delJumpSideEffect();
        }

        iter.remove(); // remove inst
        return iter;
    }

    // remove, add indx, del index implement with iter
    // add, del with last
    /** can not do what setJump() does */
    public void addLastInst(Quad inst) {
        if (hasJump || inst instanceof JumpQuad)
            throw new CompileError("Block is finished or can not use this to add JUMP");

        insts.addLast(inst);
    }

    /**
     * append
     * <p>
     * illigal: don't have iter.next() after origin
     * <p>
     * stick means stick on cur iter
     * 
     * <pre>
     * // origin: iter inst(will select) inst2
     * inst = iter.next(); inst ...
     * // before: inst(select) iter inst2
     * bb.addBeforeInst(iter, new_inst)
     * // if(!stick) after: inst(select) new_inst iter inst2
     * // if(stick)  after: inst(select) iter new_inst inst2
     * </pre>
     */
    public void addAfterInst(ListIterator<Quad> iter, Quad newInst, boolean stick) {
        iter.add(newInst);
        if (stick)
            iter.previous();
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
        if (newInst instanceof JumpQuad)
            throw new CompileError("can not add before with jump");

        iter.previous(); // get inst1
        iter.add(newInst); // get origin_iter
        iter.next(); // get return_iter
    }

    /**
     * replace
     * <p>
     * check Jump outside
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

        insts.addLast(inst);
    }

    // /** check hasJump, getLast == inst */
    // public void delJump() {
    // delJumpSideEffect();
    // insts.removeLast();
    // }

    /**
     * check inst first and del Jump outside
     * <p>
     * check hasJump, getLast == inst
     */
    public void delJumpSideEffect() {
        if (!hasJump)
            throw new CompileError("hasJump has not changed");
        hasJump = false;

        Quad last = insts.getLast();
        if (!(last instanceof JumpQuad))
            throw new CompileError("invalid type of Remove Jump");

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