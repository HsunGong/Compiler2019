package mxcompiler.ast;

import java.io.PrintStream;

public class Dump {
    private PrintStream stream;

    public Dump(PrintStream x) {
        stream = x;
    }

    public void print(String x) {
        stream.println(x);
    }
}