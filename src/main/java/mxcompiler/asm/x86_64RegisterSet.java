package mxcompiler.asm;

import java.util.*;
import mxcompiler.ir.register.PhysicalRegister;


/**
 * using linux 64-bit machine with nasm
 * <p>
 * actually a static class
 * <p>
 * Suggest: import x86_64RegisterSet and x86_64RegisterSet.RegisterName at
 * the same time
 */
public class x86_64RegisterSet {
    // public static enum RegisterName {
    // RAX("rax"), RCX("rcx"), RDX("rdx"), RBX("rbx"), RSI("rsi"), RDI("rdi"),
    // RSP("rsp"), RBP("rbp"), R8("r8"), R9("r9"), R10("r10"), R11("r11"),
    // R12("r12"), R13("r13"), R14("r14"), R15("r15");
    // private String label;
    // RegisterName(String l) { label = l; }
    // public String toString() { return label; }
    // public static RegisterName getName(String label) { return
    // keyMap.get(label); }
    // private static final HashMap<String, RegisterName> keyMap = new
    // HashMap<String, RegisterName>();
    // static { for (RegisterName op : RegisterName.values())
    // keyMap.put(op.label, op); }
    // public static RegisterName get(String key) { return keyMap.get(key); }
    // }

    // reg-single
    public static final PhysicalRegister rax, rcx, rdx, rbx, rsi, rdi, rsp, rbp, r8, r9, r10,
            r11, r12, r13, r14, r15;
    // rax rcx rdx rbx
    // rsi rdi rsp rbp
    // r8  r9  r10 r11 
    // r12 r13 r14 r15

    // reg-sets
    public static final Collection<PhysicalRegister> allRegs;
    public static final Collection<PhysicalRegister> generalRegs;
    public static final Collection<PhysicalRegister> callerSaveRegs;
    public static final Collection<PhysicalRegister> calleeSaveRegs;
    // 6 args for rdi, rsi, rdx, rcx, r8, and r9
    public static final Collection<PhysicalRegister> argRegs; // arg6

    static {
        List<PhysicalRegister> all = new ArrayList<>();
        List<PhysicalRegister> general = new ArrayList<>();
        List<PhysicalRegister> callerSave = new ArrayList<>();
        List<PhysicalRegister> calleeSave = new ArrayList<>();
        List<PhysicalRegister> arg6 = new ArrayList<>();
        
        rdi = new PhysicalRegister("rdi", false, true, false, 0);
        rsi = new PhysicalRegister("rsi", false, true, false, 1);
        rdx = new PhysicalRegister("rdx", false, true, false, 2);
        rcx = new PhysicalRegister("rcx", false, true, false, 3);
        
        r8 = new PhysicalRegister("r8", true, true, false, 4);
        r9 = new PhysicalRegister("r9", true, true, false, 5);

        rax = new PhysicalRegister("rax", false, true, false, -1);
        rbx = new PhysicalRegister("rbx", false, false, true, -1);
        rsp = new PhysicalRegister("rsp", false, true, false, -1);
        rbp = new PhysicalRegister("rbp", false, false, true, -1);

        // r8 and r9 are actually general registers
        r10 = new PhysicalRegister("r10", true, true, false, -1);
        r11 = new PhysicalRegister("r11", true, true, false, -1);

        r12 = new PhysicalRegister("r12", true, false, true, -1);
        r13 = new PhysicalRegister("r13", true, false, true, -1);
        r14 = new PhysicalRegister("r14", true, false, true, -1);
        r15 = new PhysicalRegister("r15", true, false, true, -1);

        arg6.add(rdi);
        arg6.add(rsi);
        arg6.add(rdx);
        arg6.add(rcx);
        arg6.add(r8);
        arg6.add(r9);

        all.add(rax);
        all.add(rcx);
        all.add(rdx);
        all.add(rbx);
        all.add(rsi);
        all.add(rdi);
        all.add(rsp);
        all.add(rbp);
        all.add(r8);
        all.add(r9);
        all.add(r10);
        all.add(r11);
        all.add(r12);
        all.add(r13);
        all.add(r14);
        all.add(r15);

        all.stream().filter(PhysicalRegister::isGeneral).forEach(general::add);
        all.stream().filter(PhysicalRegister::isCallerSave).forEach(callerSave::add);
        all.stream().filter(PhysicalRegister::isCalleeSave).forEach(calleeSave::add);

        // keep still
        allRegs = Collections.unmodifiableList(all);
        generalRegs = Collections.unmodifiableList(general);
        callerSaveRegs = Collections.unmodifiableList(callerSave);
        calleeSaveRegs = Collections.unmodifiableList(calleeSave);
        argRegs = Collections.unmodifiableList(arg6);
    }
}