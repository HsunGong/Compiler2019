package mxcompiler.main;

import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import mxcompiler.parser.*;
import mxcompiler.exception.*;
import mxcompiler.ast.*;

public final class Compiler {
    static final public String ProgName = "mxc";
    static final public String Version = "1.0.0";

    private final ExceptionHandler errHandler;

    public static void main (String[] args) {
        Compiler c = new Compiler(ProgName);
        c.execute(args);
    }
    
    private Compiler (String name) {
        this.errHandler = new ExceptionHandler(name);
    }
    
    private void execute(String[] args) {
        try {

            // parse options
            Option opts = new Option(args);
            List<String> srcs = opts.sourceFiles();
            
            // build each file
            for (String src : srcs) {
                compile(src, opts);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // file compiler
    private void compile(String src, Option opts) throws Exception {
        MxLexer lexer = new MxLexer(CharStreams.fromFileName(src));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxParser parser = new MxParser(tokens);
        
        ParseTree tree = parser.compilation_unit(); // the begin root of my g4 file
        
        switch(opts.mode()) {
            case Default:
                AST ast = new AST();
                ast.visit(tree);
                break;
            case Dump:
                break;
            case Check:
                break;
            default:
                throw new Exception("No Compile Mode selected");
        }
        
        // SemanticAnalyze sem = new SemanticAnalyze.visit(ast);
        
        // IR ir = new ir.visit(ast);
        
        // ASM asm = generateAssembly(ir, ast);
        // writefile(opts.outputFile());
    }
}