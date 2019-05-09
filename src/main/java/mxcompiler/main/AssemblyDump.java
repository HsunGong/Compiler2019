package mxcompiler.main;

import java.util.*;

import mxcompiler.ast.expression.BinaryOpExprNode;
// import mxcompiler.ast.expression.unary.PrefixExprNode;

import mxcompiler.error.CompileError;
import mxcompiler.ir.*;
import mxcompiler.ir.register.*;
import mxcompiler.ir.instruction.*;

import mxcompiler.utils.*;

import java.io.*;


public class AssemblyDump implements IRVisitor {
    private final PrintStream os;
    private final Option opts;

    public AssemblyDump(PrintStream x, Option opts) {
        os = x;
        this.opts = opts;
    }

    public void dump(Root root) {
        for (Function func : root.getFunc().values())
            for (BasicBlock bb : func.getReversePostOrder())
                elimateMoveMemQuad(bb);

        visit(root);
    }

    /** name -> cnt */
    private Map<String, Integer> idCounter = new HashMap<>();
    /** object -> id */
    private Map<Object, String> idMap = new HashMap<>();
    private PhysicalRegister preg0, preg1;
    private boolean isBssSection, isDataSection;

    /** only for user-functions(no builtIn func) */
    public void visit(Root node) {
        preg0 = node.preg0;
        preg1 = node.preg1;

        idMap.put(node.getFunc().get("main").getStart(), "main");

        // define functions
        printlnComment("Main Function");
        println("global", "main");
        println("extern", "malloc");
        println("");

        // text
        println("section", ".text");
        println("");

        for (Map.Entry<String, Function> func : node.getFunc().entrySet())
            if (!func.getKey().equals("main"))
                visit(func.getValue());
        visit(node.getFunc().get("main"));

        println("");

        // data
        if (node.getStaticStr().size() > 0) {
            isDataSection = true;

            println("section", ".data");
            node.getStaticStr().values().forEach(s -> visit(s));
            println("");

            isDataSection = false;
        }

        // bss
        if (node.getStaticDataList().size() > 0) {
            isBssSection = true;

            println("section", ".bss");
            node.getStaticDataList().forEach(data -> visit(data));
            println("");

            isBssSection = false;
        }
    }

    public void visit(Function node) {
        printlnComment("function " + node.getName());
        println("");

        int bbIdx = 0; // ???
        for (BasicBlock bb : node.getReversePostOrder()) {
            visit(bb);
            ++bbIdx;
        }

        println("");
    }

    private String bbId(BasicBlock bb) {
        String id = idMap.get(bb);
        if (id == null) {
            id = Tool.BLOCK + newId(bb.getName());
            idMap.put(bb, id);
        }

        return id;
    }

    public void visit(BasicBlock node) {
        if (node.getInsts().size() == 0)
            return;
        if (opts.OptimizationLevel() > 0) {
        } else {
        }

        printlnLabel(bbId(node));
        node.getInsts().forEach(inst -> visit(inst));
        // println("");
    }

    public void visit(Funcall node) {
        if (node.getFunc().isBuiltIn())
            println("call", node.getFunc().getBuiltInLabel());
        else
            println("call", bbId(node.getFunc().getStart()));
    }

    public void visit(HeapAlloc node) {
        println("call", "malloc");
    }

    // region jump
    public void visit(Return node) {
        println("\t\tret");
    }

    public void visit(Jump node) {
        // remove meaningless jump
        if (node.getTarget().postOrder + 1 == node.getParent().postOrder)
            return;

        println("jmp", bbId(node.getTarget()));
    }

    public void visit(CJump node) {
        if (node.getCond() instanceof IntImm) {
            int isJump = ((IntImm) node.getCond()).getValue();
            BasicBlock target = (isJump == 1) ? node.getThen() : node.getElse();

            if (target.postOrder + 1 == node.getParent().postOrder)
                return;
            println("jmp", bbId(target));
            return;
        }

        println("cmp", visit(node.getCond()), "1");
        println("je", bbId(node.getThen()));

        // remove meaningless jump
        if (node.getElse().postOrder + 1 == node.getParent().postOrder)
            return;
        println("jmp", bbId(node.getElse()));
    }
    // endregion

    // region regValues
    private String dataId(StaticData data) {
        String id = idMap.get(data);
        if (id == null) {
            id = Tool.STATIC_DATA + newId(data.getName());
            idMap.put(data, id);
        }
        return id;
    }

    public String visit(IntImm node) {
        return Integer.toString(node.getValue());
    }

    public String visit(PhysicalRegister node) {
        return node.getName();
    }

    public String visit(VirtualRegister node) {
        throw new CompileError("should not visit virtual register node in nasm");
    }

    public String visit(StaticVar node) {
        if (isBssSection) {
            String op;
            switch (node.getSize()) {
            case 1:
                op = "resb";
                break;
            case 2:
                op = "resw";
                break;
            case 4:
                op = "resd";
                break;
            case 8:
                op = "resq";
                break;
            default:
                throw new CompileError("invalid static data size");
            }
            printlnLabel(dataId(node));
            println(op, "1");
            return null;
        } else
            return dataId(node);
    }

    private String staticStrTransfer(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = str.length(); i < n; ++i) {
            char c = str.charAt(i);
            sb.append((int) c);
            sb.append(", ");
        }
        sb.append(0);
        return sb.toString();
    }

    public String visit(StaticString node) {
        if (isDataSection) {
            printlnLabel(dataId(node));
            println("dq", Integer.toString(node.getValue().length()));
            println("db", staticStrTransfer(node.getValue()));
            return null;
        } else {
            return dataId(node);
        }
    }
    // endregion

    // region op
    public void visit(Uni node) {
        String op;
        switch (node.getOp()) {
        case BIT_NOT:
            op = "not";
            break;
        case NEGA:
            op = "neg";
            break;
        default:
            throw new CompileError("impossible");
        }

        println("mov", visit(node.getDst()), visit(node.getRhs()));
        println(op, visit(node.getDst()));
    }

    public void visit(Cmp node) {
        if (node.getLhs() instanceof PhysicalRegister) {
            println("and", visit(node.getLhs()), "-1");
        }

        if (node.getRhs() instanceof PhysicalRegister) {
            println("and", visit(node.getRhs()), "-1");
        }

        // ZF or CF or SF
        println("xor", "rax", "rax");
        println("cmp", visit(node.getLhs()), visit(node.getRhs()));

        String op;
        switch (node.getOp()) {
        case EQUAL:
            op = "sete";
            break;
        case INEQUAL:
            op = "setne";
            break;
        case LESS:
            op = "setl";
            break;
        case LESS_EQUAL:
            op = "setle";
            break;
        case GREATER:
            op = "setg";
            break;
        case GREATER_EQUAL:
            op = "setge";
            break;
        default:
            throw new CompileError("impossible");
        }

        println(op, "al");
        println("mov", visit(node.getDst()), "rax");
    }

    public void visit(Bin node) {
        if (node instanceof Cmp) // UGLY:FIX:TODO: very important
            visit((Cmp) node);

        String op;
        switch (node.getOp()) {
        case DIV:
        case MOD:
            // to be optimized: not pushing rdx
            println("mov", "rbx", visit(node.getRhs()));
            println("mov", "rax", visit(node.getLhs()));
            println("mov", preg0.getName(), "rdx");

            println("\t\tcdq");
            // <rdx:rax> / rbx store rax(quotient), rdx(remain)
            println("idiv", "rbx");

            println("mov", visit(node.getDst()),
                    (node.getOp() == BinaryOpExprNode.Op.DIV) ? "rax" : "rdx");
            println("mov", "rdx", preg0.getName());

            return;

        case SH_L:
        case SH_R:
            println("mov", "rbx", "rcx");
            println("mov", "rcx", visit(node.getRhs()));

            op = (node.getOp() == BinaryOpExprNode.Op.SH_L) ? "sal" : "sar";
            println(op, visit(node.getLhs()), "cl");

            println("mov", "rcx", "rbx");
            println("and", visit(node.getLhs()), "-1");
            return;

        case ADD:
            if (node.getRhs() instanceof IntImm && ((IntImm) node.getRhs()).getValue() == 1) {
                println("inc", visit(node.getLhs()));
                return;
            }
            op = "add";
            break;
        case SUB:
            if (node.getRhs() instanceof IntImm && ((IntImm) node.getRhs()).getValue() == 1) {
                println("dec", visit(node.getLhs()));
                return;
            }
            op = "sub";
            break;
        case MUL:
            if (node.getRhs() instanceof IntImm && ((IntImm) node.getRhs()).getValue() == 1) {
                return;
            }
            op = "imul";
            break;
        case BIT_OR:
            op = "or";
            break;
        case BIT_XOR:
            op = "xor";
            break;
        case BIT_AND:
            op = "and";
            break;
        default:
            throw new CompileError("impossible");
        }

        if (node.getDst() != node.getLhs())
            throw new CompileError("binary operation should have same dest and lhs");

        println(op, visit(node.getLhs()), visit(node.getRhs()));
    }

    // endregion

    // region mem
    public void visit(Move node) {
        println("mov", visit(node.getDst()), visit(node.getRhs()));
    }

    /** include a empty symbol */
    private String getSize(int memSize) {
        String sizeStr;
        switch (memSize) {
        case 1:
            sizeStr = "byte ";
            break;
        case 2:
            sizeStr = "word ";
            break;
        case 4:
            sizeStr = "dword ";
            break;
        case 8:
            sizeStr = "qword ";
            break;
        default:
            throw new CompileError("invalid load size: " + memSize);
        }

        return sizeStr;
    }

    private String toAddr(MemQuad node) {
        String addr = visit(node.baseAddr);

        if (node.offset < 0) {
            addr += node.offset;
        } else if (node.offset > 0) {
            addr += "+" + node.offset;
        }

        return "[" + addr + "]";
    }

    private void printMove(String inst, String arg1, String arg2) {
        if (inst != "mov")
            throw new CompileError("impossible");

        os.printf("\t\t%s\t\t%s, %s\n", inst, arg1, arg2);
    }

    public void visit(Load node) {
        if (node.baseAddr instanceof StaticString) {
            printMove("mov", visit(node.getDst()), getSize(node.getSize()) + visit(node.baseAddr));
            return;
        }

        printMove("mov", visit(node.getDst()), getSize(node.getSize()) + toAddr(node));
    }

    public void visit(Store node) {
        if (node.baseAddr instanceof StaticString) {
            printMove("mov", getSize(node.getSize()) + visit(node.baseAddr),
                    visit(node.getValue()));
            return;
        }

        printMove("mov", getSize(node.getSize()) + toAddr(node), visit(node.getValue()));
    }

    public void visit(Push node) {
        println("push", visit(node.getValue()));
    }

    public void visit(Pop node) {
        println("pop", visit(node.getValue()));
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
            } else if (inst instanceof Push || inst instanceof Pop) {

            }

            if (remove)
                bb.removeInst(iter);
            else
                prevInst = inst;
        }
    }

    // region useless
    public String visit(StackSlot node) {
        throw new CompileError("should not visit stack sslot node in nasm");
    }

    public void visit(GlobalVarInit node) {
        throw new CompileError("should not visit stack sslot node in nasm");
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
        return node.accept(this);
    }

    public String visit(StaticData node) {
        return node.accept(this);
    }
    // endregion

    /**
     * Put all in idCounter
     * <p>
     * idCounter store: <id, cnt>
     * <p>
     * default id: id
     * <p>
     * recurence id: id_cnt
     * <p>
     * if id == "", just return _cnt
     */
    private String newId(String id) {
        int nowCnt = idCounter.getOrDefault(id, 0) + 1;
        idCounter.put(id, nowCnt); // overwrite
        return id + "_" + nowCnt;
    }

    // region Dump

    // private String toImm(Integer int) 0dxxx
    // private String toReg(Register reg) getName

    public void println(String x) {
        os.println(x);
    }

    public void print(String str) {
        os.print(str);
    }

    /**
     * @Format Normal: {@code \t\t inst \t\t arg1, arg2, ...}
     */
    public void print(String inst, String... args) {
        // s += (inst.length() > 8) ? "\t%s" : "\t\t%s";
        // s += (", %s").repeat(args.length - 1);
        // os.printf(pp.toString(), inst, args);

        StringBuilder pp = new StringBuilder("\t\t" + inst);
        pp.append((inst.length() > 8) ? "\t" : "\t\t" + args[0]);
        for (int i = 1; i < args.length; ++i)
            pp.append(", " + args[i]);

        os.print(pp.toString());
    }

    /**
     * @Format Normal: {@code \t\t inst \t\t arg1, arg2, ... \n}
     */
    public void println(String inst, Object... args) {
        StringBuilder pp = new StringBuilder("\t\t" + inst);
        pp.append((inst.length() > 8) ? "\t" : "\t\t" + args[0]);
        for (int i = 1; i < args.length; ++i)
            pp.append(", " + args[i]);

        os.println(pp.toString());
    }

    public void printLabel(String label) {
        os.print(label + ":");
    }

    public void printlnLabel(String label) {
        os.println(label + ":");
    }

    public void printlnComment(String cmt) {
        os.println("# " + cmt);
    }

    // endregion
}