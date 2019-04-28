package mxcompiler.ir.register;

abstract public class Register extends RegValue {
    protected String name;
    
    public Register(String name) { this.name = name;}


    public String getName() { return name; }
}