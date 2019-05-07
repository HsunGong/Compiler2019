package mxcompiler.main;

import java.io.PrintStream;
import java.util.*;

import mxcompiler.error.CompileError;
import mxcompiler.ir.*;
import mxcompiler.ir.register.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.utils.Dump;


public class IRDump implements IRVisitor, Dump {
    private PrintStream os;

    public IRDump(PrintStream os) {
        this.os = os;
    }

    private Map<BasicBlock, String> bbMap = new HashMap<>();
    private Map<VirtualRegister, String> vregMap = new HashMap<>();
    private Map<StaticData, String> staticDataMap = new HashMap<>();

    private Map<String, Integer> bbCnt = new HashMap<>();
    private Map<String, Integer> vregCnt = new HashMap<>();
    private Map<String, Integer> staticDataCnt = new HashMap<>();

    private Set<BasicBlock> bbVisited = new HashSet<>();

    private boolean isStaticDef, isStaticStr;

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
        println("Global static Data");
        addTab();
        isStaticDef = true;
        node.getStaticDataList().forEach(data -> visit(data));
        isStaticDef = false;
        delTab();

        println("Global static string");
        addTab();
        isStaticStr = true;
        node.getStaticStr().values().forEach(data -> visit(data));
        isStaticStr = false;
        delTab();

        println(">>>>>>>>>>>      Decl of functions      <<<<<<<<<<<<");
        node.getFunc().values().forEach(data -> visit(data));
    }

    @Override
    public void visit(Function node) {
        vregMap = new IdentityHashMap<>();
        vregCnt = new HashMap<>();

        printf("func %s\n", node.getName());
        printf(" argVregs:\t");
        node.argVregs.forEach(arg -> os.printf("$%s ", getVRegID(arg)));
        os.println("");

        println(" blocks");
        node.getReversePostOrder().forEach(bb -> visit(bb));
    }

    @Override
    public void visit(BasicBlock node) {
        if (bbVisited.contains(node))
            return;

        bbVisited.add(node);
        println("  %" + getBBID(node) + ":");

        addTab();
        node.getInsts().forEach(inst -> visit(inst));
        delTab();

        println(""); // ???
    }

    public void visit(HeapAlloc node) {
        printf("alloc %s <size %s>\n", visit(node.getDst()), visit(node.getAllocSize()));
    }

    public void visit(Funcall node) {
        printf("funcall %s <- call %s\n", visit(node.getDst()), node.getFunc().getName());
        printf(" args: ");
        node.getArgs().forEach(arg -> os.printf(" %s", visit(arg)));
        os.println();
    }

    // region jump
    public void visit(Return node) {
        if (node.getReturnValue() == null) {
            printf("no return\n");
            return;
        }

        String ret = visit(node.getReturnValue());
        printf("return %s\n", ret);
    }

    public void visit(Jump node) {
        printf("jump %%%s\n", getBBID(node.getTarget()));
    }

    public void visit(CJump node) {
        String a = "%" + getBBID(node.getThen());
        String b = "%" + getBBID(node.getElse());

        printf("cjump <if> %s <then> %s <else> %s\n", visit(node.getCond()), a, b);
    }
    // endregion

    // region regValues
    public String visit(IntImm node) {
        return Integer.toString(node.getValue());
    }

    public String visit(PhysicalRegister node) {
        return "$" + node.getName();
    }

    public String visit(VirtualRegister node) {
        return "$" + getVRegID(node);
    }

    public String visit(StaticVar node) {
        if (isStaticDef) {
            printf("space @%s %d\n", getStaticDataID(node), node.getSize());
            return null;
        } else
            return "@" + getStaticDataID(node);
    }

    public String visit(StaticString node) {
        if (isStaticDef) {
            printf("asciiz @%s %s\n", getStaticDataID(node), node.getValue());
            return null;
        } else if (isStaticStr) {
            printf("@%s %s\n", getStaticDataID(node), node.getValue());
            return null;
        } else
            return String.format("@%s %s", getStaticDataID(node), node.getValue());
    }
    // endregion

    // region op
    public void visit(Uni node) {
        String op = node.getOp().toString();
        printf("OP-%s %s = %s%s\n", op, visit(node.getDst()), op, visit(node.getRhs()));
    }

    public void visit(Cmp node) {
        String op = node.getOp().toString();
        String dst = visit(node.getDst());
        printf("OP-%s %s = %s %s %s\n", op, dst, visit(node.getLhs()), op, visit(node.getRhs()));
    }

    public void visit(Bin node) {
        if (node instanceof Cmp)
            visit((Cmp) node);

        String op = node.getOp().toString();
        String dst = visit(node.getDst());
        printf("OP-%s %s = %s %s %s\n", op, dst, visit(node.getLhs()), op, visit(node.getRhs()));
    }

    // endregion

    // region mem
    public void visit(Move node) {
        printf("move %s <- %s\n", visit(node.getDst()), visit(node.getRhs()));
    }

    public void visit(Load node) {
        String dst = visit(node.getDst());
        String addr = visit(node.baseAddr);

        printf("load %s <- %s[%d] <size %d>\n", dst, addr, node.offset, node.getSize());
    }

    public void visit(Store node) {
        String val = visit(node.getValue());
        String addr = visit(node.baseAddr);

        printf("store %s[%d] <- %s <size %d>\n", addr, node.offset, val, node.getSize());
    }

    public void visit(Push node) {
        printf("push %s", visit(node.getValue()));
    }

    public void visit(Pop node) {
        printf("pop %s", visit(node.getValue()));
    }
    // endregion

    // region useless
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
    private String t = "\t";
    private int tab = 0;

    public void addTab() {
        ++tab;
    }

    public void delTab() {
        --tab;
    }

    public String getTab() {
        return t.repeat(tab);
    }

    public void println(String x) {
        os.println(getTab() + x);
    }

    public void printf(String str, Object... args) {
        os.printf(getTab() + str, args);
    }

    public void print(String str) {
        os.print(getTab() + str);
    }
    // endregion
}