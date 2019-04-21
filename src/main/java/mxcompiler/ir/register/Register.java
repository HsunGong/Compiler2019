package mxcompiler.ir.register;

abstract public class Register extends RegValue {
    
    public enum RegisterName {
        RAX("rax"), RCX("rcx"), RDX("rdx"), RBX("rbx"), 
        RSI("rsi"), RDI("rdi"), RSP("rsp"), RBP("rbp"), 
        R8("r8"), R9("r9"), R10("r10"), R11("r11"), 
        R12("r12"), R13("r13"), R14("r14"), R15("r15");
        
        private String label;
        RegisterName(String l) { label = l; }
    }
    
    protected String name;
    
    public Register(String name) { this.name = name;}


    public String getName() { return name; }
}