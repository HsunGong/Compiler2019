package mxcompiler.ir.instruction;

import java.util.*;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.*;
import mxcompiler.utils.Dump;
import mxcompiler.utils.Tool;
import mxcompiler.utils.entity.FuncEntity;


public class Function {
    // region normal
    private final FuncEntity entity; // funcEntity
    private String name;
    private String builtInLabel = null; // builtInCallLabel if null ==> isBuiltIn = False

    public List<Return> returns = new ArrayList<>();

    // public Function() {
    // entity = null;
    // }

    public Function(String name, String builtInLabel) {
        this.name = name;
        this.builtInLabel = builtInLabel;
        this.entity = null;
    }

    public Function(FuncEntity e) {
        this.entity = e;
        this.name = (e.isMember() ? e.className + Tool.DOMAIN : "") + e.getName();
    }

    public String getBuiltInLabel() {
        return builtInLabel;
    }

    public boolean isBuiltIn() {
        return builtInLabel != null;
    }

    public String getName() {
        return name;
    }

    /** genFirstBB */
    public BasicBlock initStart() {
        start = new BasicBlock(this, entity.getName() + "_entry");
        return start;
    }

    public FuncEntity getEntity() {
        return entity;
    }
    // endregion

    // region public label
    public final boolean isMemFunc = false; // FIX: waht is this ??
    public boolean isRecursiveCall = false;

    // args and stackslot
    public List<VirtualRegister> argVregs = new ArrayList<>(); // argVRegList
    public List<StackSlot> stackSlots = new ArrayList<>();
    public Map<VirtualRegister, StackSlot> argsToStackSlot = new HashMap<>(); // argsStackSlotMap

    // public regs
    public Set<PhysicalRegister> usedPhysicalGeneralRegs = new HashSet<>();
    // endregion

    // region BB-list and BB-order
    private BasicBlock start = null;
    private BasicBlock end = null;

    public BasicBlock getStart() {
        return start;
    }

    public BasicBlock getEnd() {
        return end;
    }

    public void setStart(BasicBlock bb) {
        this.start = bb;
    }

    public void setEnd(BasicBlock bb) {
        this.end = bb;
    }

    private List<BasicBlock> reversePostOrder = null;
    private List<BasicBlock> reversePreOrder = null;

    private Set<BasicBlock> dfsVisited = null;

    public List<BasicBlock> getReversePostOrder() {
        if (reversePostOrder == null)
            initReversePostOrder();
        return reversePostOrder;
    }

    /** calcReversePostOrder */
    public void initReversePostOrder() {
        reversePostOrder = new ArrayList<>();

        dfsVisited = new HashSet<>();
        dfsPostOrder(start);
        dfsVisited = null;

        for (int i = 0; i < reversePostOrder.size(); ++i)
            reversePostOrder.get(i).postOrder = i;

        Collections.reverse(reversePostOrder);
    }

    private void dfsPostOrder(BasicBlock bb) {
        if (dfsVisited.contains(bb)) // or set flag in BB
            return;
        dfsVisited.add(bb);
        for (BasicBlock nextBB : bb.getNext())
            dfsPostOrder(nextBB);

        // actually is post order now
        reversePostOrder.add(bb);
    }

    public List<BasicBlock> getReversePreOrder() {
        if (reversePreOrder == null)
            initReversePreOrder();
        return reversePreOrder;
    }

    public void initReversePreOrder() {
        reversePreOrder = new ArrayList<>();

        dfsVisited = new HashSet<>();
        dfsPreOrder(start);
        dfsVisited = null;

        for (int i = 0; i < reversePreOrder.size(); ++i)
            reversePreOrder.get(i).preOrder = i;
        Collections.reverse(reversePreOrder);
    }

    private void dfsPreOrder(BasicBlock bb) {
        if (dfsVisited.contains(bb))
            return;
        dfsVisited.add(bb);

        // actually is pre order now
        reversePreOrder.add(bb);
        for (BasicBlock nextBB : bb.getNext())
            dfsPreOrder(nextBB);
    }

    public void setNewGraph(BasicBlock newStart, BasicBlock newEnd) {
        start = newStart;
        end = newEnd;
        reversePreOrder = null;
        reversePostOrder = null;
        dfsVisited = null;
    }
    // endregion

    // region callee-sets
    public Set<Function> calleeSet = new HashSet<>();
    public Set<Function> recursiveCalleeSet = new HashSet<>();

    /**
     * @Usage: Update calleeSet
     */
    public void updateCalleeSet() {
        calleeSet.clear();
        for (BasicBlock bb : getReversePostOrder()) {
            for (Quad inst : bb.getInsts())
                if (inst instanceof Funcall)
                    calleeSet.add(((Funcall) inst).getFunc());
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