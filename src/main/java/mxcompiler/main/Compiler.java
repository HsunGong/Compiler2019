package mxcompiler.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import mxcompiler.parser.*;
import mxcompiler.exception.*;
import mxcompiler.ast.*;

public final class Compiler {
    static final public String ProgName = "mxc";
    static final public String Version = "1.0.0";

    private final ExceptionHandler errHandler;

    public static void main (String[] args) throws Exception {
        Compiler c = new Compiler(ProgName);
        c.execute(args);
    }
    
    private Compiler (String name) {
        this.errHandler = new ExceptionHandler(name);
    }
    
    private void execute(String[] args) throws Exception {
        // parse options
        Option opts = new Option(args);
        String src = opts.sourceFile();
        
        switch(opts.mode()) {
            case Default: // So
                compile(src, opts);
                System.out.println(opts.mode().toString());
                break;
            case Dump:
                break;
            case Check: // throw all Exception without errorHandler
                compileCheck(src, opts);
                break;
            default:
                throw new Exception("No Compile Mode selected");
        }
        
    }
    
    // file compiler
    private void compile(String src, Option opts) throws Exception {
        MxLexer lexer = new MxLexer(CharStreams.fromFileName(src));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxParser parser = new MxParser(tokens);
        
        ParseTree tree = parser.compilationUnit(); // the begin root of my g4 file
        
        ASTNode ast = new ASTNode(null);
        ast.visit(tree);
        
        // SemanticAnalyze sem = new SemanticAnalyze.visit(ast);
        
        // IR ir = new ir.visit(ast);
        
        // ASM asm = generateAssembly(ir, ast);
        // writefile(opts.outputFile());
    }

    private void compileCheck(String src, Option opts) throws Exception {
        MxLexer lexer = new MxLexer(CharStreams.fromFileName(src));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxParser parser = new MxParser(tokens);
        
        ParseTree tree = parser.compilationUnit(); // the begin root of my g4 file
        
        ASTNode ast = new ASTNode(null);
        ast.visit(tree);
        
        // SemanticAnalyze sem = new SemanticAnalyze.visit(ast);
        
        // IR ir = new ir.visit(ast);
        
        // ASM asm = generateAssembly(ir, ast);
        // writefile(opts.outputFile());
    }


}