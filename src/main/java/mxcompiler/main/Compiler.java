package mxcompiler.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import mxcompiler.parser.*;
import mxcompiler.error.*;
import mxcompiler.ir.Root;
import mxcompiler.main.CompilerMode.DumpMode;
import mxcompiler.ast.*;


public final class Compiler {
	static final public String ProgName = "mxc";
	static final public String Version = "1.0.0";

	private final ErrorHandler errHandler;
	private Option opts;

	public static void main(String[] args) throws Error {
		Compiler c = new Compiler(ProgName);
		c.execute(args);
	}

	public Compiler(String name) {
		this.errHandler = new ErrorHandler(errOut);

	}

	public void execute(String[] args) throws Error {
		// parse options
		opts = new Option(args);

		try {
			this.fileIn = opts.sourceFile();
			try {
				this.dumpOut = new PrintStream(
						new FileOutputStream("./src/test/test.out", false));
				fileOut = new PrintStream(new FileOutputStream(opts.outputFile(), false));
			} catch (Exception e) {
				// throw new Error(e);
				fileOut = System.out;
			}

			compile();

		} catch (Error e) {
			if (opts.mode().equals(CompilerMode.Default))
				System.out.println(e.getMessage());
			else
				throw new Error(e);
		}

	}

	private InputStream fileIn;
	private PrintStream fileOut;
	private PrintStream errOut = System.out;
	private PrintStream dumpOut;
	private ASTNode astRoot;
	private Root irRoot;

	// file compiler with errorHandler
	private void compile() throws Error {
		try {
			buildAST();
			semanticAnalyze();

			buildIR();
			generateAssembly();

		} catch (Exception e) {
			throw new Error(e);
		}
	}

    private static final String link_asm_name = "./src/main/java/mxcompiler/asm/BuiltIn.asm";


	private void generateAssembly() throws Error {
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println("Generate asm begin");

		RegisterAllocator allocator = new RegisterAllocator(irRoot);
		allocator.execute();

		AssemblyDump asm = new AssemblyDump(irRoot, fileOut);
		asm.dump();

		// append builtIn function
        try {
            BufferedReader reader = new BufferedReader(new FileReader(link_asm_name));
            String line;
            while ((line = reader.readLine()) != null) {
                fileOut.println(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new CompileError("IO exception when reading builtin functions from file");
        }

		
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println(">>> Generate asm end");
	}

	private void buildIR() throws Error {
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println("IR Builder begin");

		UsagePreChecker usagePreChecker = new UsagePreChecker();
		usagePreChecker.visit(astRoot);

		IRBuilder treeIrBuilder = new IRBuilder(opts);
		irRoot = treeIrBuilder.build(astRoot);

		if (opts.dumpMode().contains(DumpMode.IRDump)
				|| opts.dumpMode().contains(DumpMode.AllDump)) {
			IRDump dump = new IRDump(dumpOut);
			dump.visit(irRoot);
		}

		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println(">>> IR Builder end");
	}

	private void semanticAnalyze() throws Error {
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println("Resolver begin");

		ResolverAndChecker RCer = new ResolverAndChecker();
		RCer.visit(astRoot);

		if (opts.dumpMode().contains(DumpMode.ScopeDump)
				|| opts.dumpMode().contains(DumpMode.AllDump)) {
			ScopeDump dump = new ScopeDump(dumpOut);
			dump.visit(astRoot);
		}
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println(">>> Resolver end");
	}

	private void buildAST() throws Error, Exception {
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println("AST Build begin");

		MxLexer lexer = new MxLexer(CharStreams.fromStream(fileIn));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MxParser parser = new MxParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(errHandler);

		ParseTree tree = parser.compilationUnit(); // the begin astRoot of my g4 file

		ASTBuilder astBuilder = new ASTBuilder();
		astRoot = (ASTNode) astBuilder.visit(tree);

		if (opts.dumpMode().contains(DumpMode.ASTDump)
				|| opts.dumpMode().contains(DumpMode.AllDump)) {
			ASTDump dump = new ASTDump(dumpOut);
			dump.visit(astRoot);
		}

		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println(">>> AST Build end");
	}
}