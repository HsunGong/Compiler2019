package mxcompiler.main;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import mxcompiler.parser.*;
import mxcompiler.utils.scope.ScopeDump;
import mxcompiler.error.*;
import mxcompiler.main.CompilerMode.DumpMode;
import mxcompiler.ast.*;

public final class Compiler {
	static final public String ProgName = "mxc";
	static final public String Version = "1.0.0";

	private final ErrorHandler errHandler;
	private Option opts;

	public static void main(String[] args) throws Exception {
		Compiler c = new Compiler(ProgName);
		c.execute(args);
	}

	private Compiler(String name) {
		this.errHandler = new ErrorHandler(errOut);

	}

	private void execute(String[] args) throws Exception {
		// parse options
		opts = new Option(args);

		this.fileIn = opts.sourceFile();
		this.dumpOut = new PrintStream(new FileOutputStream("./src/test/test.out", false));
		try {
			fileOut = new PrintStream(new FileOutputStream(opts.outputFile(), false));
		} catch (Exception e) {
			// throw new Error(e);
			fileOut = System.out;
		}

		compile();
	}

	private InputStream fileIn;
	private PrintStream fileOut;
	private PrintStream errOut = System.out;
	private PrintStream dumpOut;
	private ASTNode root;

	// file compiler with errorHandler
	private void compile() throws Exception {
		buildAST();
		semanticAnalyze();

	}

	private void semanticAnalyze() throws Exception {
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println("Resolver begin");

		ResolverAndChecker RCer = new ResolverAndChecker();
		RCer.visit(root);

		if (opts.dumpMode().contains(DumpMode.ScopeDump) || opts.dumpMode().contains(DumpMode.AllDump)) {
			new ScopeDump(dumpOut).visit(root);
		}
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println(">>> Resolver end");
	}

	private void buildAST() throws Exception {
		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println("AST Build begin");

		MxLexer lexer = new MxLexer(CharStreams.fromStream(fileIn));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MxParser parser = new MxParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(errHandler);

		ParseTree tree = parser.compilationUnit(); // the begin root of my g4 file

		ASTBuilder astBuilder = new ASTBuilder();
		root = (ASTNode) astBuilder.visit(tree);

		if (opts.dumpMode().contains(DumpMode.ASTDump) || opts.dumpMode().contains(DumpMode.AllDump)) {
			new ASTDump(dumpOut).visit(root);
		}

		if (opts.mode().equals(CompilerMode.Debug))
			System.out.println(">>> AST Build end");
	}
}