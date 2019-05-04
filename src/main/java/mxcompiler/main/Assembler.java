package mxcompiler.main;

import java.util.*;

import mxcompiler.ir.*;

import java.io.*;


public class Assembler {
    ArrayList<String> code;

    public void print(PrintStream out) {
        code.forEach(s -> out.println(s));
    }

    public void visit(Root node) {}
}