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
	// private int tab; // tabSize
	private String t = "\t";
	private StringBuilder tab;


	public ScopeDump(PrintStream x) {
		os = x;
		// tab = 0;
		tab = new StringBuilder();
	}

	public void addTab() {
		// ++tab;
		tab.append(t);
	}

	public void delTab() {
		// --tab;
		tab.delete(tab.length() - t.length(), tab.length());
	}

	public String getTab() {
		// return t.repeat(tab);
		return tab.toString();
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