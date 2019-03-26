package mxcompiler.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import mxcompiler.parser.*;
import mxcompiler.utils.scope.ScopeDump;
import mxcompiler.exception.*;
import mxcompiler.main.CompilerMode.DumpMode;
import mxcompiler.ast.*;

public final class Compiler {
	static final public String ProgName = "mxc";
	static final public String Version = "1.0.0";

	private final ExceptionHandler errHandler;
	private Option opts;

	public static void main(String[] args) throws Exception {
		Compiler c = new Compiler(ProgName);
		c.execute(args);
	}

	private Compiler(String name) {
		this.errHandler = new ExceptionHandler(name);

	}

	private void execute(String[] args) throws Exception {
		// parse options
		opts = new Option(args);

		this.in = opts.sourceFile();
		this.dump = new PrintStream(new FileOutputStream("./src/test/test.out", false));
		try {
			out = new PrintStream(new FileOutputStream(opts.outputFile(), false));
		} catch (Exception e) {
			// throw new Error(e);
			out = System.out;
		}

		compile();
	}

	private InputStream in;
	private PrintStream out;
	private PrintStream dump;
	private ASTNode root;

	// file compiler with errorHandler
	private void compile() throws Exception {
		buildAST();
		semanticAnalyze();

	}

	private void semanticAnalyze() throws Exception {
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println("Resolver begin");

		Resolver resolver = new Resolver();
		resolver.visit(root);

		if (opts.dumpMode().contains(DumpMode.ScopeDump) || opts.dumpMode().contains(DumpMode.AllDump)) {
			new ScopeDump(dump).visit(root);
		}
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println(">>> Resolver end");
	}

	private void buildAST() throws Exception {
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println("AST Build begin");

		MxLexer lexer = new MxLexer(CharStreams.fromStream(in));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MxParser parser = new MxParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new ErrorHandler());

		ParseTree tree = parser.compilationUnit(); // the begin root of my g4 file

		ASTBuilder astBuilder = new ASTBuilder();
		root = (ASTNode) astBuilder.visit(tree);

		if (opts.dumpMode().contains(DumpMode.ASTDump) || opts.dumpMode().contains(DumpMode.AllDump)) {
			new ASTDump(dump).visit(root);
		}

		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println(">>> AST Build end");
	}
}