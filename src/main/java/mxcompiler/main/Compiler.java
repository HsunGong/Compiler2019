package mxcompiler.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.InputStream;

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
        this.src = opts.sourceFile();
        
        switch(opts.mode()) {
            case Default: // So
                compile(opts);
                System.out.println(opts.mode().toString());
                break;
            case Dump:
                compileDump(opts);
                System.out.println(opts.mode().toString());
                break;
            case Check: // throw all Exception without errorHandler
                compileCheck(opts);
                System.out.println(opts.mode().toString());
                break;
            default:
            throw new Exception("No Compile Mode selected");
        }
        
    }
    
    private InputStream src;
    // PrintStream outputAST;
    private ASTNode root;


    // file compiler with errorHandler
    private void compile(Option opts) throws Exception {
        buildAST(opts.mode());
        /* 
            // SemanticAnalyze sem = new SemanticAnalyze.visit(ast);
            
            // IR ir = new ir.visit(ast);
            
            // ASM asm = generateAssembly(ir, ast);
            // writefile(opts.outputFile());
            
            //        if (astOutS != null) new ASTPrinter(astOutS).visit(ast);
            // GlobalScopePreScanner globalScopePreScanner = new GlobalScopePreScanner();
            // globalScopePreScanner.visit(ast);
            // Scope globalScope = globalScopePreScanner.getScope();
            // new ClassVarMemberScanner(globalScope).visit(ast);
            // new FunctionScopeScanner(globalScope).visit(ast);
            // new StaticUsagePreScanner(globalScope).visit(ast);
            // IRBuilder irBuilder = new IRBuilder(globalScope);
            // irBuilder.visit(ast);
            // IRRoot ir = irBuilder.getIR();
            // new TwoRegOpTransformer(ir).run();
            // if (Configuration.isEnableFunctionInline()) new FunctionInlineProcessor(ir).run();
            // if (irOutS != null) new IRPrinter(irOutS).visit(ir);
            // new StaticDataProcessor(ir).run();
            // new RegisterPreprocessor(ir).run();
            // new RegLivelinessAnalysis(ir).run();
            // new RegisterAllocator(ir).run();
            // new NASMTransformer(ir).run();
            // new ExtraInstructionOptimizer(ir).run();
            // new NASMPrinter(nasmOutS).visit(ir);
        */
    }

    // file compiler with errorHandler
    private void compileDump(Option opts) throws Exception {
        buildAST(opts.mode());
        // dumpAST();
    }

    // no errorHandler
    private void compileCheck(Option opts) throws Exception {
        buildAST(opts.mode());
    }


    private void buildAST(CompilerMode mode) throws Exception {
        // System.out.println(src.toString());
        MxLexer lexer = new MxLexer(CharStreams.fromStream(src));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxParser parser = new MxParser(tokens);
        // parser.removeErrorListeners();
        // parser.addErrorListener(new SyntaxErrorListener());
        
        
        ParseTree tree = parser.compilationUnit(); // the begin root of my g4 file
        
        
        ASTBuilder astBuilder = new ASTBuilder();
        root = (ASTNode) astBuilder.visit(tree);
		
		if (mode == CompilerMode.Dump) {
			new ASTDump(System.out).visit(root);
		}
    }

    private void TypeChecker() {}
}