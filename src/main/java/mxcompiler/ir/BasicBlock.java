package mxcompiler.ir;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import mxcompiler.error.CompileError;
import mxcompiler.utils.Dump;

/** As shown */
public class BasicBlock {
    private List<Quad> insts;

    // using linked list
    private LinkedList<BasicBlock> pre; // Successive
    private LinkedList<BasicBlock> post; // successor
    private boolean isForBody;
    public boolean isReverseVisit;
    public boolean isVisit;

    private static int cntBasicBlock;
    private int order;
    // private boolean flag;

    public BasicBlock() {
        insts = new ArrayList<>();
        pre = new LinkedList<>();
        post = new LinkedList<>();
        order = cntBasicBlock++;

        isReverseVisit = false;
        isVisit = false;
        isForBody = false;
    }

    public BasicBlock(boolean isForBody) {
        insts = new ArrayList<>();
        pre = new LinkedList<>();
        post = new LinkedList<>();
        order = cntBasicBlock++;

        isReverseVisit = false;
        isVisit = false;
        if (!isForBody)
            throw new CompileError("BasicBlock is ForBody");
        this.isForBody = true;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Quad> getQuads() {
        return insts;
    }

    public List<BasicBlock> getPre() {
        return pre;
    }

    public List<BasicBlock> getPost() {
        return post;
    }

    public boolean isForBody() {
        return isForBody;
    }
    // public boolean isReverseVisit() { return isReverseVisit; }
    // public boolean isVisit() { return isVisit; }
    // public void setIsVisit() { isVisit = true; }
    // public void setIsReverseVisit() { isReverseVisit = true; }

    // FIX
    // public Set<Register> getIn(){
    // return instList.get(0).getIn();
    // }

    public void resetPreBlock(BasicBlock oldBlock, BasicBlock newBlock) {
        for (Iterator<BasicBlock> iter = pre.iterator(); iter.hasNext();) {
            BasicBlock checkBlock = iter.next();
            if (checkBlock == oldBlock)
                iter.remove();
        }
        pre.addFirst(newBlock); // push as stack
    }

    public void resetPostBlock(BasicBlock oldBlock, BasicBlock newBlock) {
        for (Iterator<BasicBlock> iter = post.iterator(); iter.hasNext();) {
            BasicBlock checkBlock = iter.next();
            if (checkBlock == oldBlock)
                iter.remove();
        }
        post.addFirst(newBlock);
    }

    public void appendQuad(Quad inst) {
        insts.add(inst);
    }

    public void _dump(Dump d) {
        d.print("L_" + Integer.toString(order));
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}