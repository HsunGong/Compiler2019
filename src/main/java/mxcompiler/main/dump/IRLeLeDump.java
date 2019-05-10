package mxcompiler.main.dump;

import java.io.PrintStream;
import java.util.*;

import mxcompiler.error.CompileError;
import mxcompiler.ir.*;
import mxcompiler.ir.register.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.utils.Dump;

// ************************************************************************************************
// This file is used to print out IR in the format of LeLeIR (LeLe -> Lequn Chen)
// so that one can use LLIRInterpreter to test IR.
// Actually LeLeIR is more like MIPS rather than NASM assembly, but for test purpose it's enough.
// [repo of LLIRInterpreter] https://github.com/abcdabcd987/LLIRInterpreter
// credit to Lequn Chen (@abcdabcd987)
// ************************************************************************************************


public class IRLeLeDump implements IRVisitor, Dump {
    private PrintStream os;

    public IRLeLeDump(PrintStream os) {
        this.os = os;
        tab = new StringBuilder();
    }

    private Map<BasicBlock, String> bbMap = new HashMap<>();
    private Map<VirtualRegister, String> vregMap = new HashMap<>();
    private Map<StaticData, String> staticDataMap = new HashMap<>();

    private Map<String, Integer> bbCnt = new HashMap<>();
    private Map<String, Integer> vregCnt = new HashMap<>();
    private Map<String, Integer> staticDataCnt = new HashMap<>();

    private Set<BasicBlock> bbVisited = new HashSet<>();

    private boolean isStaticDef;

    private String genID(String name, Map<String, Integer> cnt) {
        int cntName = cnt.getOrDefault(name, 0) + 1;
        cnt.put(name, cntName);
        if (cntName == 1)
            return name;
        return name + "_" + cntName;
    }

    private String getBBID(BasicBlock bb) {
        String id = bbMap.get(bb);
        if (id == null) {
            if (bb.getName() == null) {
                id = genID("bb", bbCnt);
            } else {
                id = genID(bb.getName(), bbCnt);
            }
            bbMap.put(bb, id);
        }
        return id;
    }

    private String getVRegID(VirtualRegister vreg) {
        String id = vregMap.get(vreg);
        if (id == null) {
            if (vreg.getName() == null) {
                id = genID("vreg", vregCnt);
            } else {
                id = genID(vreg.getName(), vregCnt);
            }
            vregMap.put(vreg, id);
        }
        return id;
    }

    private String getStaticDataID(StaticData data) {
        String id = staticDataMap.get(data);
        if (id == null) {
            if (data.getName() == null) {
                id = genID("staticData", staticDataCnt);
            } else {
                id = genID(data.getName(), staticDataCnt);
            }
            staticDataMap.put(data, id);
        }
        return id;
    }

    @Override
    public void visit(Root node) {
        // Static Data
        isStaticDef = true;
        for (StaticData staticData : node.getStaticDataList()) {
            staticData.accept(this);
        }
        isStaticDef = false;
        for (StaticString staticStr : node.getStaticStr().values()) {
            staticStr.accept(this);
        }
        os.println();
        for (Function func : node.getFunc().values()) {
            func.accept(this);
        }
    }

    @Override
    public void visit(Function node) {
        vregMap = new IdentityHashMap<>();
        vregCnt = new HashMap<>();
        os.printf("func %s ", node.getName());
        for (VirtualRegister paraVReg : node.argVregs) {
            os.printf("$%s ", getVRegID(paraVReg));
        }
        os.printf("{\n");
        for (BasicBlock bb : node.getReversePostOrder()) {
            bb.accept(this);
        }
        os.printf("}\n\n");
    }

    @Override
    public void visit(BasicBlock node) {
        if (bbVisited.contains(node))
            return;
        bbVisited.add(node);
        os.println("%" + getBBID(node) + ":");
        for (Quad inst : node.getInsts()) {
            inst.accept(this);
        }
    }

    @Override
    public void visit(CJump node) {
        os.print("    br ");
        node.getCond().accept(this);
        os.println(" %" + getBBID(node.getThen()) + " %" + getBBID(node.getElse()));
        os.println();
    }

    @Override
    public void visit(Jump node) {
        os.printf("    jump %%%s\n\n", getBBID(node.getTarget()));
    }

    @Override
    public void visit(Return node) {
        os.print("    ret ");
        if (node.getReturnValue() != null) {
            node.getReturnValue().accept(this);
        } else {
            os.print("0");
        }
        os.println();
        os.println();
    }

    @Override
    public void visit(Uni node) {
        os.print("    ");
        String op = null;
        switch (node.getOp()) {
        case NEGA:
            op = "neg";
            break;
        case BIT_NOT:
            op = "not";
            break;
        }
        node.getDst().accept(this);
        os.printf(" = %s ", op);
        node.getRhs().accept(this);
        os.println();
    }

    @Override
    public void visit(Bin node) {
        if (node instanceof Cmp)
            node.accept(this);
        os.print("    ");
        String op = null;
        switch (node.getOp()) {
        case ADD:
            op = "add";
            break;
        case SUB:
            op = "sub";
            break;
        case MUL:
            op = "mul";
            break;
        case DIV:
            op = "div";
            break;
        case MOD:
            op = "rem";
            break;
        case SH_L:
            op = "shl";
            break;
        case SH_R:
            op = "shr";
            break;
        case BIT_AND:
            op = "and";
            break;
        case BIT_OR:
            op = "or";
            break;
        case BIT_XOR:
            op = "xor";
            break;
        }
        node.getDst().accept(this);
        os.printf(" = %s ", op);
        node.getLhs().accept(this);
        os.printf(" ");
        node.getRhs().accept(this);
        os.println();
    }

    @Override
    public void visit(Cmp node) {
        os.print("    ");
        String op = null;
        switch (node.getOp()) {
        case EQUAL:
            op = "seq";
            break;
        case INEQUAL:
            op = "sne";
            break;
        case GREATER:
            op = "sgt";
            break;
        case GREATER_EQUAL:
            op = "sge";
            break;
        case LESS:
            op = "slt";
            break;
        case LESS_EQUAL:
            op = "sle";
            break;
        }
        node.getDst().accept(this);
        os.printf(" = %s ", op);
        node.getLhs().accept(this);
        os.printf(" ");
        node.getRhs().accept(this);
        os.println();
    }

    @Override
    public void visit(Move node) {
        os.print("    ");
        node.getDst().accept(this);
        os.print(" = move ");
        node.getRhs().accept(this);
        os.println();
    }

    @Override
    public void visit(Load node) {
        os.print("    ");
        node.getDst().accept(this);
        os.printf(" = load %d ", node.getSize());
        node.baseAddr.accept(this);
        os.println(" " + node.offset);
    }

    @Override
    public void visit(Store node) {
        os.printf("    store %d ", node.getSize());
        node.baseAddr.accept(this);
        os.print(" ");
        node.getValue().accept(this);
        os.println(" " + node.offset);
    }

    @Override
    public void visit(Funcall node) {
        os.print("    ");
        if (node.getDst() != null) {
            node.getDst().accept(this);
            os.print(" = ");
        }
        os.printf("call %s ", node.getFunc().getName());
        for (RegValue arg : node.getArgs()) {
            arg.accept(this);
            os.print(" ");
        }
        os.println();
    }

    @Override
    public void visit(HeapAlloc node) {
        os.print("    ");
        node.getDst().accept(this);
        os.print(" = alloc ");
        node.getAllocSize().accept(this);
        os.println();
    }

    @Override
    public String visit(VirtualRegister node) {
        os.print("$" + getVRegID(node));
        return null;
    }

    @Override
    public String visit(IntImm node) {
        os.print(node.getValue());
        return null;
    }

    @Override
    public String visit(StaticVar node) {
        if (isStaticDef)
            os.printf("space @%s %d\n", getStaticDataID(node), node.getSize());
        else
            os.print("@" + getStaticDataID(node));
        return null;
    }

    @Override
    public String visit(StaticString node) {
        if (isStaticDef)
            os.printf("asciiz @%s %s\n", getStaticDataID(node), node.getValue());
        else
            os.print("@" + getStaticDataID(node));
        return null;
    }

    @Override
    public String visit(PhysicalRegister node) {
        // no actions
        return null;
    }

    // region useless
    @Override
    public void visit(Push node) {
        // no actions
    }

    @Override
    public void visit(Pop node) {
    }

    public String visit(StackSlot node) {
        throw new CompileError("should not visit stack slot node in nasm");
    }

    public void visit(GlobalVarInit node) {
        throw new CompileError("should not visit global var init node in nasm");
    }

    public void visit(MemQuad node) {
        node.accept(this);
    }

    public void visit(Quad node) {
        if (node == null)
            return;
        node.accept(this);
    }

    public void visit(JumpQuad node) {
        node.accept(this);
    }

    public String visit(RegValue node) {
        if (node == null)
            return null;
        return node.accept(this);
    }

    public String visit(Register node) {
        if (node == null)
            return null;
        return node.accept(this);
    }

    public String visit(StaticData node) {
        return node.accept(this);
    }
    // endregion

    // region print
    private final String t = "\t";
    private StringBuilder tab;

    public void addTab() {
        // ++tab;
        tab.append(t);
    }

    public void delTab() {
        // --tab;
        tab.delete(tab.length() - t.length(), tab.length());
    }

    public String getTab() {
        // return t.repeat(tab);
        return tab.toString();
    }

    public void println(String x) {
        os.println(getTab() + x);
    }

    public void printplainln(String x) {
        os.println(x);
    }

    public void printf(String str, Object... args) {
        os.printf(getTab() + str, args);
    }

    public void print(String str) {
        os.print(getTab() + str);
    }
    // endregion
}