package mxcompiler.main;

import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import mxcompiler.parser.*;
import mxcompiler.exception.*;

public final class Compiler {
    static final public String ProgName = "mxc";
    static final public String Version = "1.0.0";

    private final ExceptionHandler errHandler;

    public static void main (String[] args) {
        Compiler c = new Compiler(ProgName);
        c.command(args);
    }
    
    private Compiler (String name) {
        this.errHandler = new ExceptionHandler(name);
    }
    
    private void command(String[] args) {
        Option opts = new Option(args);
        List<String> srcs = opts.sourceFiles();
        
        try {
            System.out.println(srcs.get(0));
            build(srcs, opts);
        } catch (Exception e) {}
    }

    private void build(List<String> srcs, Option opts) throws Exception {
        for (String src : srcs) {
            compile(src);
        }
    }

    private void compile(String src) throws Exception {
        MxLexer lexer = new MxLexer(CharStreams.fromFileName(src));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxParser parser = new MxParser(tokens);

        ParseTree tree = parser.start();
        System.out.println(tree.toStringTree(parser));
    }
}