package mxcompiler.utils.scope;

import java.io.PrintStream;
import java.util.List;

import mxcompiler.ast.*;

import mxcompiler.ast.statement.*;
import mxcompiler.utils.Dump;
import mxcompiler.ast.declaration.*;
import mxcompiler.ast.expression.*;
import mxcompiler.ast.expression.literal.*;
import mxcompiler.ast.expression.lhs.*;
import mxcompiler.ast.expression.unary.*;

public class ScopeDump implements Dump {
	private PrintStream os;
	private int tab; // tabSize
	private final String t = "\t";

	public ScopeDump(PrintStream x) {
		os = x;
		tab = 0;
	}

	public void addTab() {
		++tab;
	}

	public void delTab() {
		--tab;
	}

	public String getTab() {
		return t.repeat(tab);
	}

	public void println(String x) {
		os.println(getTab() + x);
	}

	public void printf(String str, Object... args) {
		os.printf(getTab() + str, args);
	}

	public void print(String str) {
		os.print(getTab() + str);
	}

	public void visit(ASTNode node) {
		println("Scope-Dump START");
		node.getScope()._dump(this);
		println("Scope-Dump END");
		println("\n\n");
	}

}