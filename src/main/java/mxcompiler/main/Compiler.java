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
import mxcompiler.ast.*;

public final class Compiler {
	static final public String ProgName = "mxc";
	static final public String Version = "1.0.0";

	private final ExceptionHandler errHandler;

	public static void main(String[] args) throws Exception {
		Compiler c = new Compiler(ProgName);
		c.execute(args);
	}

	private Compiler(String name) {
		this.errHandler = new ExceptionHandler(name);
		in = System.in;

		try {
			out = new PrintStream(new FileOutputStream("/home/xun/Documents/mxc/src/test/test.out", false));
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	private void execute(String[] args) throws Exception {
		// parse options
		Option opts = new Option(args);
		this.in = opts.sourceFile();

		compile(opts);

	}

	private InputStream in;
	private PrintStream out;
	private ASTNode root;

	// file compiler with errorHandler
	private void compile(Option opts) throws Exception {
		buildAST(opts.mode());

		// semanticAnalyze
		semanticAnalyze(opts.mode());

	}

	private void semanticAnalyze(CompilerMode mode) throws Exception {
		// GlobalScopePreScanner ClassVarMemberScanner
		Resolver resolver = new Resolver();
		resolver.visit(root);
		
		// FunctionScopeScanner StaticUsagePreScanner
		// Checker checker = new Checker();
		// checker.visit(root);

		if (mode == CompilerMode.Dump) {
			new ScopeDump(out).visit(root);
		}

		
	}

	private void buildAST(CompilerMode mode) throws Exception {
		// System.out.println(src.toString());
		MxLexer lexer = new MxLexer(CharStreams.fromStream(in));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MxParser parser = new MxParser(tokens);
		// parser.removeErrorListeners();
		// parser.addErrorListener(new SyntaxErrorListener());

		ParseTree tree = parser.compilationUnit(); // the begin root of my g4 file

		ASTBuilder astBuilder = new ASTBuilder();
		root = (ASTNode) astBuilder.visit(tree);

		if (mode == CompilerMode.Dump) {
			// new ASTDump(out).visit(root);
		}
	}
}