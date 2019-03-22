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

	@Deprecated
	public void visit(Node node) {
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

	@Deprecated
	public void visit(DeclNode node) {
	}

	public void visit(ClassDeclNode node) {
		addTab();
		node._dump(this);

		printVarDeclList(" varDecls:", node.getVar());
		printFuncDeclList(" funcMember:", node.getFunc());

		delTab();
	}

	public void visit(FuncDeclNode node) {
		addTab();
		node._dump(this);

		print(" returnType:");
		// if (getReturnType() != null) {
		// d.print("\n");
		visit(node.getReturnType());
		// } else
		// d.println(" null");

		printVarDeclList(" parameterList:", node.getVar());
		print(" body:");
		visit(node.getBody());
		delTab();
	}

	public void visit(VarDeclNode node) {
		addTab();
		node._dump(this);

		print(" type:");
		visit(node.getType());
		printExpr(" init:", node.getInit());

		delTab();
	}

	@Deprecated
	public void visit(VarDeclListNode node) {
	}

	@Deprecated
	public void visit(LhsExprNode node) {
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
		printf(" member: %s\n", node.getMember());
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

	@Deprecated
	public void visit(ExprNode node) {
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
		printVarDeclList(" varDecls:", node.getVar());

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

		printVarDeclList(" varDecl:", node.getVar());
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

	@Deprecated
	public void visit(StmtNode node) {
	}

	public void visit(WhileStmtNode node) {
		addTab();
		node._dump(this);
		printExpr(" cond:", node.getCond());

		printStmt(" body:", node.getBody());

		delTab();
	}

	private void printVarDeclList(String s, List<VarDeclNode> list) {
		print(s);
		if (!list.isEmpty()) {
			print("\n");
			for (VarDeclNode param : list) {
				visit(param);
			}
		} else
			println(" null");
	}

	private void printFuncDeclList(String s, List<FuncDeclNode> list) {
		print(s);
		if (!list.isEmpty()) {
			print("\n");
			for (FuncDeclNode param : list) {
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