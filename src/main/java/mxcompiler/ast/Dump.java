package mxcompiler.ast;

import java.io.PrintStream;

public class Dump {
    private PrintStream os;

    public Dump(PrintStream x) {
        os = x;
    }

    public void print(String x) {
        os.println(x);
    }
}