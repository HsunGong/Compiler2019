package mxcompiler.ir.instruction;

import java.util.*;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.StackSlot;
import mxcompiler.ir.register.VirtualRegister;
import mxcompiler.utils.Dump;
import mxcompiler.utils.Tool;
import mxcompiler.utils.entity.FuncEntity;


public class Function {
    public final FuncEntity entity; // funcEntity
    private String name;
    private String builtInLabel = null; // builtInCallLabel if null ==> isBuiltIn = False
    // private boolean isBuiltIn = false;

    public BasicBlock start = null;
    public BasicBlock end = null;
    public List<Return> returns = new ArrayList<>();

    public boolean isMemFunc = false;

    public Function(String name, String builtInLabel) {
        this.name = name;
        this.builtInLabel = builtInLabel;
        this.entity = null;
    }
    

    public String getName() {
        return name;
    }

    public Function(FuncEntity e) {
        this.entity = e;
        this.name = (e.isMember() ? e.className + Tool.DOMAIN : "") + e.getName();
    }

    public BasicBlock initStart() { // genFirstBB
        start = new BasicBlock(this, entity.getName() + "_entry");
        return start;
    }

    public FuncEntity getEntity() {
        return entity;
    }

    // getStackSLots
    public List<StackSlot> stackSlots = new ArrayList<>();
    
    // getArgsStackSlotMap
    public Map<VirtualRegister, StackSlot> argsMap = new HashMap<>(); // argsStackSlotMap

    // TODO: register
    public List<VirtualRegister> argVReg = new ArrayList<>(); // argVRegList
    // private Set<PhysicalRegister> usedPhysicalGeneralRegs = new HashSet<>();


    // region dfs

    private boolean recursiveCall = false;
    private Set<BasicBlock> dfsVisited = null;

    private List<BasicBlock> reversePostOrder = null;
    private List<BasicBlock> reversePreOrder = null;

    public List<BasicBlock> getReversePostOrder() {
        if (reversePostOrder == null) {
            calcReversePostOrder();
        }
        return reversePostOrder;
    }

    public void calcReversePostOrder() {
        reversePostOrder = new ArrayList<>();
        dfsVisited = new HashSet<>();
        dfsPostOrder(startBB);
        dfsVisited = null;
        for (int i = 0; i < reversePostOrder.size(); ++i) {
            reversePostOrder.get(i).setPostOrderIdx(i);
        }
        Collections.reverse(reversePostOrder);
    }

    private void dfsPostOrder(BasicBlock bb) {
        if (dfsVisited.contains(bb))
            return;
        dfsVisited.add(bb);
        for (BasicBlock nextBB : bb.getNextBBSet()) {
            dfsPostOrder(nextBB);
        }
        // actually is post order now
        reversePostOrder.add(bb);
    }
    // endregion


    // region callee-sets

    public Set<Function> calleeSet = new HashSet<>();
    public Set<Function> recursiveCalleeSet = new HashSet<>();

    public void updateCalleeSet() {
        calleeSet.clear();
        for (BasicBlock bb : getReversePostOrder()) {
            for (IRInstruction inst = bb.getFirstInst(); inst != null; inst = inst.getNextInst()) {
                if (inst instanceof IRFunctionCall) {
                    calleeSet.add(((IRFunctionCall) inst).getFunc());
                }
            }
        }
    }

    // endregion

    public void setNewBBGraph(BasicBlock newStartBB, BasicBlock newEndBB) {
        startBB = newStartBB;
        endBB = newEndBB;
        reversePreOrder = null;
        reversePostOrder = null;
    }

    private Set<BasicBlock> dfsVisited = null;

    private void dfsPostOrder(BasicBlock bb) {
        if (dfsVisited.contains(bb)) return;
        dfsVisited.add(bb);
        for (BasicBlock nextBB : bb.getNextBBSet()) {
            dfsPostOrder(nextBB);
        }
        // actually is post order now
        reversePostOrder.add(bb);
    }

    private void dfsPreOrder(BasicBlock bb) {
        if (dfsVisited.contains(bb)) return;
        dfsVisited.add(bb);
        // actually is pre order now
        reversePreOrder.add(bb);
        for (BasicBlock nextBB : bb.getNextBBSet()) {
            dfsPreOrder(nextBB);
        }
    }

    public List<BasicBlock> getReversePostOrder() {
        if (reversePostOrder == null) {
            calcReversePostOrder();
        }
        return reversePostOrder;
    }

    public void calcReversePostOrder() {
        reversePostOrder = new ArrayList<>();
        dfsVisited = new HashSet<>();
        dfsPostOrder(startBB);
        dfsVisited = null;
        for (int i = 0; i < reversePostOrder.size(); ++i) {
            reversePostOrder.get(i).setPostOrderIdx(i);
        }
        Collections.reverse(reversePostOrder);
    }

    public List<BasicBlock> getReversePreOrder() {
        if (reversePreOrder == null) {
            calcReversePreOrder();
        }
        return reversePreOrder;
    }

    public void calcReversePreOrder() {
        reversePreOrder = new ArrayList<>();
        dfsVisited = new HashSet<>();
        dfsPreOrder(startBB);
        dfsVisited = null;
        for (int i = 0; i < reversePreOrder.size(); ++i) {
            reversePreOrder.get(i).setPreOrderIdx(i);
        }
        Collections.reverse(reversePreOrder);
    }

    public void setRecursiveCall(boolean recursiveCall) {
        this.recursiveCall = recursiveCall;
    }

    public boolean isRecursiveCall() {
        return recursiveCall;
    }

    public Set<PhysicalRegister> getUsedPhysicalGeneralRegs() {
        return usedPhysicalGeneralRegs;
    }

   






















    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("BasicBlock");
    }
}