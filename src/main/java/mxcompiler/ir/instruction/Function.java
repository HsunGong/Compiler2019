package mxcompiler.ir.instruction;

import java.util.*;

import mxcompiler.ir.IRVisitor;
import mxcompiler.ir.register.StackSlot;
import mxcompiler.ir.register.VirtualRegister;
import mxcompiler.utils.Dump;

import mxcompiler.utils.entity.FuncEntity;


public class Function {
    public final FuncEntity entity; // funcEntity
    private String name;
    private String builtInLabel = null; // builtInCallLabel if null ==> isBuiltIn = False
    // private boolean isBuiltIn = false;

    public BasicBlock start = null;
    public BasicBlock end = null;
    public List<Return> returns = new ArrayList<>();

    public boolean recursiveCall = false;
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
        this.name = e.getName(); // name = "class.func"
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
        // TODO: dfs
    private List<BasicBlock> reversePostOrder = null;
    private List<BasicBlock> reversePreOrder = null;

    public Set<Function> calleeSet = new HashSet<>();

    public void updateCalleeSet() {
        // calleeSet.clear();
        // for (BasicBlock bb : getReversePostOrder()) {
        // for (IRInstruction inst = bb.getFirstInst(); inst != null; inst = inst
        // .getNextInst()) {
        // if (inst instanceof IRFunctionCall) {
        // calleeSet.add(((IRFunctionCall) inst).getFunc());
        // }
        // }
        // }
    }

    // public Set<Function> recursiveCalleeSet = new HashSet<>();
    public List<BasicBlock> getReversePostOrder() {
        // if (reversePostOrder == null) {
        // calcReversePostOrder();
        // }
        return reversePostOrder;
    }

    public void calcReversePostOrder() {
        // reversePostOrder = new ArrayList<>();
        // dfsVisited = new HashSet<>();
        // dfsPostOrder(startBB);
        // dfsVisited = null;
        // for (int i = 0; i < reversePostOrder.size(); ++i) {
        //     reversePostOrder.get(i).setPostOrderIdx(i);
        // }
        Collections.reverse(reversePostOrder);
    }
    // endregion

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    public void _dump(Dump d) {
        d.println("BasicBlock");
    }
}