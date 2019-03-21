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

	private void println(String x) {
		os.println(getTab() + x);
	}

	private void printf(String str, Object... args) {
		os.printf(getTab() + str, args);
	}

	private void print(String str) {
		os.print(getTab() + str);
	}

	public void visit(Node node) {

	}

	public void visit(ASTNode node) {
		println("Program Start");
		printf("<ASTNode> %s\n", node.location.toString());

		print(" declarations:");
		if (!node.getDecl().isEmpty()) {
			print("\n");
			for (DeclNode decl : node.getDecl())
				visit(decl);
		} else
			println(" null");
	}

	public void visit(TypeNode node) {
	}

	public void visit(DeclNode node) {
	}

	public void visit(ClassDeclNode node) {
		addTab();

		printf("<ClassDeclNode> %s\n", node.location.toString());
		printf(" name: %s\n", node.getName());
		
		printVarDeclList(" varDecls:", node.getVar());
		printFuncDeclList(" funcMember:", node.getFunc());

		delTab();
	}


	public void visit(FuncDeclNode node) {
		addTab();
		printf("<FuncDeclNode> %s\n", node.location.toString());
		printf(" name: %s\n", node.getName());
		printf(" isContruct: %b\n", node.isConstruct());

		print(" returnType:");
		if (node.getReturnType() != null) {
			print("\n");
			visit(node.getReturnType());
		} else {
			println(" null");
		}

		printVarDeclList(" parameterList:", node.getVar());

		print(" body:");
		visit(node.getBody());
		delTab();
	}

	public void visit(VarDeclNode node) {
		addTab();

		printf("<VaeDeclNode> %s\n", node.location.toString());
		printf(" name: %s\n", node.getName());
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
        printf("<ArrayrefExprNode> %s:\n", node.location.toString());
        printExpr(" arr:", node.getExpr());
        printExpr(" index:", node.getIndex());
        delTab();
	}

	public void visit(MemberExprNode node) {
	}

	public void visit(BoolLiteralExprNode node) {
	}

	public void visit(IntLiteralExprNode node) {
	}

	public void visit(StringLiteralExprNode node) {
	}

	public void visit(PrefixExprNode node) {
		addTab();
        printf("<SuffixExprNode> %s\n", node.location.toString());
        printf(" op: %s\n", node.getOp().toString());
        printExpr(" expr:", node.getExpr());
        delTab();
	}

	public void visit(SuffixExprNode node) {
		addTab();
        printf("<SuffixExprNode> %s\n", node.location.toString());
        printf(" op: %s\n", node.getOp().toString());
        printExpr(" expr:", node.getExpr());
        delTab();
	}

	public void visit(AssignExprNode node) {
		addTab();
        printf("<AssignExprNode> %s\n", node.location.toString());
        printExpr(" lhs:", node.getLhs());
        printExpr(" rhs:", node.getRhs());
        delTab();
	}

	public void visit(BinaryOpExprNode node) {
		addTab();
        printf("<BinaryOpExprNode> %s\n", node.location.toString());
        printf(" op: %s\n", node.getOp().toString());
        printExpr(" lhs:", node.getLhs());
        printExpr(" rhs:", node.getRhs());
        delTab();
	}

	@Deprecated
	public void visit(ExprNode node) {
	}

	public void visit(FuncallExprNode node) {
		addTab();
        printf("<BinaryOpExprNode> %s\n", node.location.toString());
        printExpr(" expr:", node.getExpr()); // FIX: node.getFunc
		
		if (!(node.getParam().isEmpty())) {
            println(" args:");
            for (ExprNode arg : node.getParam()) {
                visit(arg);
            }
        }
        else {
            println(" args: null");
        }
		delTab();
	}

	public void visit(IdentifierExprNode node) {
	}

	public void visit(NewExprNode node) {
	}

	public void visit(NullExprNode node) {
	}

	public void visit(ThisExprNode node) {
	}

	public void visit(BlockStmtNode node) {
		addTab();
		printf("<BlockStmtNode> %s\n", node.location.toString());
		printStmtList(" stmts:", node.getStmts());

		printVarDeclList(" varDecls:", node.getVar());

		delTab();
	}

	public void visit(BreakStmtNode node) {
		addTab();
        printf("<BreakStmtNode> %s\n", node.location.toString());
        delTab();
	}

	public void visit(ContinueStmtNode node) {
		addTab();
        printf("<ContinueStmtNode> %s\n", node.location.toString());
        delTab();
	}

	public void visit(ExprStmtNode node) {
		addTab();
        printf("<ExprStmtNode> %s\n", node.location.toString());
        print(" expr:");
        visit(node.getExpr());
        delTab();
	}

	public void visit(ForStmtNode node) {
		addTab();
        printf("<ForStmtNode> %s\n", node.location.toString());
		
		printVarDeclList(" varDecl:", node.getVar());
		printExpr(" init:", node.getInit());
		printExpr(" cond:", node.getCond());
		printExpr(" incr:", node.getIncr());

		printStmt(" body:", node.getBody());
        delTab();
	}

	public void visit(IfStmtNode node) {
		addTab();
        printf("<CondStmtNode> %s\n", node.location.toString());
        println(" cond:");
        visit(node.getCond());
        printStmt(" then:", node.getThen());
		printStmt(" else:", node.getElse());
        delTab();
	}

	public void visit(ReturnStmtNode node) {
		addTab();
        printf("<ReturnStmtNode> %s\n", node.location.toString());
        printExpr(" value:", node.getExpr());
        delTab();
	}

	@Deprecated
	public void visit(StmtNode node) {
	}

	public void visit(WhileStmtNode node) {
		addTab();
        printf("<WhileStmtNode> %s\n", node.location.toString());
		println(" cond:");
		visit(node.getCond());
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