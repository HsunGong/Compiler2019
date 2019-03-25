package mxcompiler.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Location {
	int line;
	int column;

	public Location(int line, int column) {
		this.line = line;
		this.column = column;
	}
	public Location(Token t) {
		this(t.getLine(), t.getCharPositionInLine());
	}
	public Location(ParserRuleContext ctx) {
		this(ctx.getStart());
	}

	public int getLine() { return line;}
	public int getColumn() { return column; }
	public String toString() { return '('+String.valueOf(line) + ":" + String.valueOf(column)+')'; }
}