package mxcompiler.ast;

import java.io.PrintStream;
import java.util.List;

import mxcompiler.ast.statement.*;
import mxcompiler.ast.declaration.*;
import mxcompiler.ast.expression.*;
import mxcompiler.ast.expression.literal.*;
import mxcompiler.ast.expression.lhs.*;
import mxcompiler.ast.expression.unary.*;

public class ASTDump implements ASTVisitor {
	private PrintStream os;
	private int tab; // tabSize
	private final String t = "\t";

	public ASTDump(PrintStream x) {
		os = x;
		tab = 0;
	}

	private void addTab() {
		++tab;
	}

	private void delTab() {
		--tab;
	}

	private String getTab() {
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
	
	// UGLY: FIX: visit DeclNode but can not change into detail instance
	// 2, accept function to fix
	public void visit(Node node) {
		node.accept(this);
	}

	public void visit(ASTNode node) {
		node._dump(this);

		print(" declarations:");
		if (!node.getDecl().isEmpty()) {
			print("\n");
			for (DeclNode decl : node.getDecl())
				visit(decl);
		} else
			println(" null");
	}

	public void visit(TypeNode node) {
		addTab();
		node._dump(this);
		delTab();
	}

	// UGLY: FIX: visit DeclNode but can not change into detail instance
	// 1, instanceof to fix
	public void visit(DeclNode node) {
		if (node instanceof ClassDeclNode)
			visit((ClassDeclNode) node);
		if (node instanceof FuncDeclNode)
			visit((FuncDeclNode) node);
		if (node instanceof VarDeclNode)
			visit((VarDeclNode) node);
	}

	public void visit(ClassDeclNode node) {
		addTab();
		node._dump(this);

		printDeclList(" varDecls:", node.getVar());
		printDeclList(" funcMember:", node.getFunc());

		delTab();
	}

	public void visit(FuncDeclNode node) {
		addTab();
		node._dump(this);

		println(" returnType:");
		// if (getReturnType() != null) {
		// d.print("\n");
		visit(node.getReturnType());
		// } else
		// d.println(" null");

		printDeclList(" parameterList:", node.getVar());
		println(" body:");
		visit(node.getBody());
		delTab();
	}

	public void visit(VarDeclNode node) {
		addTab();
		node._dump(this);

		println(" type:");
		visit(node.getType());
		printExpr(" init:", node.getInit());

		delTab();
	}

	public void visit(VarDeclListNode node) {
		node._dump(this);
	}

	// UGLY
	public void visit(LhsExprNode node) {
		node.accept(this);
	}

	public void visit(ArefExprNode node) {
		addTab();
		node._dump(this);

		printExpr(" arr:", node.getExpr());
		printExpr(" index:", node.getIndex());
		delTab();
	}

	public void visit(MemberExprNode node) {
		addTab();
		node._dump(this);
		printExpr(" expr:", node.getExpr());
		delTab();
	}

	public void visit(BoolLiteralExprNode node) {
		addTab();
		node._dump(this);
		delTab();
	}

	public void visit(IntLiteralExprNode node) {
		addTab();
		node._dump(this);
		delTab();
	}

	public void visit(StringLiteralExprNode node) {
		addTab();
		node._dump(this);
		delTab();
	}

	public void visit(PrefixExprNode node) {
		addTab();
		node._dump(this);
		printExpr(" expr:", node.getExpr());
		delTab();
	}

	public void visit(SuffixExprNode node) {
		addTab();
		node._dump(this);

		printExpr(" expr:", node.getExpr());
		delTab();
	}

	public void visit(AssignExprNode node) {
		addTab();
		node._dump(this);
		printExpr(" lhs:", node.getLhs());
		printExpr(" rhs:", node.getRhs());
		delTab();
	}

	public void visit(BinaryOpExprNode node) {
		addTab();
		node._dump(this);
		printExpr(" lhs:", node.getLhs());
		printExpr(" rhs:", node.getRhs());
		delTab();
	}

	// UGLY: as DeclNode
	public void visit(ExprNode node) {
		node.accept(this);
	}

	public void visit(FuncallExprNode node) {
		addTab();
		node._dump(this);
		printExpr(" expr:", node.getExpr()); // FIX: getFunc
		printExprList(" args:", node.getParam());
		delTab();
	}

	public void visit(IdentifierExprNode node) {
		addTab();
		node._dump(this);
		delTab();
	}

	public void visit(NewExprNode node) {
		addTab();
		node._dump(this);
		println(" newType:");
		visit(node.getNewType());
		printExprList("dims:", node.getDims());

		delTab();
	}

	public void visit(NullExprNode node) {
		addTab();
		node._dump(this);
		delTab();
	}

	public void visit(ThisExprNode node) {
		addTab();
		node._dump(this);
		delTab();
	}

	public void visit(BlockStmtNode node) {
		addTab();
		node._dump(this);
		printStmtList(" stmts:", node.getStmts());
		printDeclList(" varDecls:", node.getVar());

		delTab();
	}

	public void visit(BreakStmtNode node) {
		addTab();
		node._dump(this);
		delTab();
	}

	public void visit(ContinueStmtNode node) {
		addTab();
		node._dump(this);
		delTab();
	}

	public void visit(ExprStmtNode node) {
		addTab();
		node._dump(this);
		printExpr(" expr:", node.getExpr());
		delTab();
	}

	public void visit(ForStmtNode node) {
		addTab();
		node._dump(this);

		printDeclList(" varDecl:", node.getVar());
		printExpr(" init:", node.getInit());
		printExpr(" cond:", node.getCond());
		printExpr(" incr:", node.getIncr());
		printStmt(" body:", node.getBody());
		delTab();
	}

	public void visit(IfStmtNode node) {
		addTab();
		node._dump(this);
		printExpr(" cond:", node.getCond());
		printStmt(" then:", node.getThen());
		printStmt(" else:", node.getElse());
		delTab();
	}

	public void visit(ReturnStmtNode node) {
		addTab();
		node._dump(this);
		printExpr(" value:", node.getExpr());
		delTab();
	}

	public void visit(StmtNode node) {
		node.accept(this);
	}

	public void visit(WhileStmtNode node) {
		addTab();
		node._dump(this);
		printExpr(" cond:", node.getCond());

		printStmt(" body:", node.getBody());

		delTab();
	}


	private void printDeclList(String s, List< ? extends DeclNode> list) {
		print(s);
		if (!list.isEmpty()) {
			print("\n");
			for (DeclNode param : list) {
				visit(param);
			}
		} else
			println(" null");
	}

	private void printStmtList(String s, List<StmtNode> list) {
		print(s);
		if (!list.isEmpty()) {
			print("\n");
			for (StmtNode param : list) {
				visit(param);
			}
		} else
			println(" null");
	}

	private void printExprList(String s, List<ExprNode> list) {
		print(s);
		if (!list.isEmpty()) {
			print("\n");
			for (ExprNode param : list) {
				visit(param);
			}
		} else
			println(" null");
	}

	private void printStmt(String s, StmtNode stmt) {
		print(s);
		if (stmt != null) {
			print("\n");
			visit(stmt);
		} else
			println(" null");
	}

	private void printExpr(String s, ExprNode expr) {
		print(s);
		if (expr != null) {
			print("\n");
			visit(expr);
		} else
			println(" null");
	}
}