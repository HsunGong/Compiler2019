package mxcompiler.main;

import java.util.*;

import mxcompiler.ir.*;
import mxcompiler.ir.register.*;
import mxcompiler.ir.instruction.*;

import mxcompiler.utils.Dump;

import java.io.*;


public class AssemblyDump implements IRVisitor {
    private PrintStream os;
    private final Root root;

    public AssemblyDump(Root root, PrintStream x) {
        this.root = root;
        os = x;
    }

    public void dump() {
        for (Function func : root.getFunc().values())
            for (BasicBlock bb : func.getReversePostOrder())
                elimateMoveMemQuad(bb);

        visit(root);
    }

    private Map<String, Integer> idCounter = new HashMap<>();
    private Map<Object, String> idMap = new HashMap<>();
    private PhysicalRegister preg0, preg1;

    public void visit(Root node) {
        preg0 = node.preg0;
        preg1 = node.preg1;

        idMap.put(node.getFuncs().get("main").getStartBB(), "main");

        out.println("\t\tglobal\tmain");
        out.println();

        out.println("\t\textern\tmalloc");
        out.println();

        if (node.getStaticDataList().size() > 0) {
            isBssSection = true;
            out.println("\t\tsection\t.bss");
            for (StaticData staticData : node.getStaticDataList()) {
                staticData.accept(this);
            }
            out.println();
            isBssSection = false;
        }

        if (node.getStaticStrs().size() > 0) {
            isDataSection = true;
            out.println("\t\tsection\t.data");
            for (StaticString staticString : node.getStaticStrs().values()) {
                staticString.accept(this);
            }
            out.println();
            isDataSection = false;
        }

        out.println("\t\tsection\t.text\n");
        for (IRFunction irFunction : node.getFuncs().values()) {
            irFunction.accept(this);
        }
        out.println();

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("lib/builtin_functions.asm"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            throw new CompilerError("IO exception when reading builtin functions from file");
        }
    }

    public void visit(BasicBlock node) {
    }

    public void visit(Function node) {
    }

    public void visit(Funcall node) {
    }

    public void visit(HeapAlloc node) {
    }

    // region op
    public void visit(Uni node) {
    }

    public void visit(Bin node) {
    }

    public void visit(Cmp node) {
    }
    // endregion

    // region jump
    public void visit(Jump node) {
    }

    public void visit(CJump node) {
    }

    public void visit(Return node) {
    }
    // endregion

    // region mem
    public void visit(MemQuad node) {
    }

    public void visit(Load node) {
    }

    public void visit(Store node) {
    }

    public void visit(Move node) {
    }

    public void visit(Pop node) {
    }

    public void visit(Push node) {
    }
    // endregion

    // region regValues

    public void visit(IntImm node) {
    }

    public void visit(PhysicalRegister node) {
    }

    public void visit(StackSlot node) {
    }

    public void visit(StaticString node) {
    }

    public void visit(StaticVar node) {
    }

    public void visit(VirtualRegister node) {
    }
    // endregion

    /** pre-dump-elimate */
    private void elimateMoveMemQuad(BasicBlock bb) {
        Quad prevInst = null;
        Quad inst = null;
        boolean remove = false;

        ListIterator<Quad> iter = bb.getInsts().listIterator();
        while (iter.hasNext()) {
            inst = iter.next();
            remove = false;

            if (inst instanceof Move) {
                if (((Move) inst).getDst() == ((Move) inst).getRhs())
                    remove = true;
                else if (prevInst instanceof Move) {
                    // move a to b, but move b to a back
                    if (((Move) inst).getDst() == ((Move) prevInst).getRhs()
                            && ((Move) inst).getRhs() == ((Move) prevInst).getDst())
                        remove = true;
                }
            } else if (inst instanceof MemQuad && prevInst instanceof MemQuad) {
                if (((MemQuad) prevInst).baseAddr == ((MemQuad) inst).baseAddr
                        && ((MemQuad) prevInst).offset == ((MemQuad) inst).offset
                        && ((MemQuad) prevInst).getValue() == ((MemQuad) inst).getValue()
                        && ((MemQuad) prevInst).getSize() == ((MemQuad) inst).getSize()) {
                    // before store a to b, but load b to a again
                    // before load, but store again
                    // double load a to b or store a to b
                    remove = true;
                }
            }

            if (remove)
                bb.removeInst(iter);
            else
                prevInst = inst;
        }
    }

    // region useless
    public void visit(GlobalVarInit node) {
        // empty
    }

    public void visit(Quad node) {
        node.accept(this);
    }

    public void visit(JumpQuad node) {
        node.accept(this);
    }

    public void visit(RegValue node) {
        node.accept(this);
    }

    public void visit(Register node) {
        node.accept(this);
    }

    public void visit(StaticData node) {
        node.accept(this);
    }
    // endregion

    // region Dump
    public void println(String x) {
        os.println(x);
    }

    public void printf(String str, Object... args) {
        os.printf(str, args);
    }

    public void print(String str) {
        os.print(str);
    }

    public void printLabel(String label) {
        os.println("\t\t" + label);
    }

    public void printQuad(String inst, String args) {
        os.printf("\t\t%s\t%s\n", inst, args);
    }

    /** order of nasm */
    public void printOrder(String order, String args) {
        os.printf("\t\t%s\t%s\n", order, args);
    }
    // endregion
}