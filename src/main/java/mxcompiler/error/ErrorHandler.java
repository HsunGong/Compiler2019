package mxcompiler.error;

import mxcompiler.ast.Location;

import java.io.PrintStream;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErrorHandler extends BaseErrorListener {
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		throw new SyntaxError((new Location(line, charPositionInLine)).toString() + msg);
	}

	public ErrorHandler(PrintStream s) {
		stream = s;
		nError = 0;
	}

	private PrintStream stream;
	private int nError;

	public int getErrorNum() {
		return nError;
	}

	public void error(Location loc, String e) {
		stream.println("Unfound Error:" + loc.toString() + e);
	}

	public void error(String e) {
		stream.println("Unfound Error: " + e);
	}

	public void error(Error e) {
		stream.println("Unfound Error: " + e.getMessage());
		nError++;
	}

	public void error(SemanticError e) {
		stream.println("Semantic Error: " + e.getMessage());
		nError++;
	}

	public void error(OptionError e) {
		stream.println("Option Error: " + e.getMessage());
		nError++;
	}

	public void error(CompileError e) {
		stream.println("Compile Error: " + e.getMessage());
		nError++;
	}

	public void error(SyntaxError e) {
		stream.println("Syntax Error: " + e.getMessage());
		nError++;
	}
}