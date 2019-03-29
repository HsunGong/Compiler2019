package mxcompiler.ast;

import mxcompiler.ast.statement.*;

import java.util.List;

import mxcompiler.ast.declaration.*;
import mxcompiler.ast.expression.*;
import mxcompiler.ast.expression.literal.*;
import mxcompiler.ast.expression.lhs.*;
import mxcompiler.ast.expression.unary.*;

/**
 * if any operator you gonna do during non-terminal node or terminal node, just
 * rewrite visit function
 * <p>
 * ATTITION: take care of null Node
 * <p>
 * Maybe it is no use, but give a good example of how to write visitor
 * <p>
 * use this class, so that dont need to implement all visit func in ASTVisitor
 */
abstract public class Visitor implements ASTVisitor {
	// NOTE: Wrong! visit DeclNode but can not change into detail instance
	// 2, accept function to fix
	public void visit(Node node) {
		if (node == null)
			return;
		node.accept(this);
	}

	public void visit(ASTNode node) {
		if (!node.getDecl().isEmpty()) {
			for (DeclNode decl : node.getDecl())
				visit(decl);
		}
	}

	public void visit(TypeNode node) {
		// ATTENTION:
		// wrong : node.accept(this);(loop forever)
		// right : null
	}

	public void visit(DeclNode node) {
		if (node == null)
			return;
		node.accept(this);
	}

	public void visit(ClassDeclNode node) {
		visitDeclList(node.getFunc());
		visitDeclList(node.getVar());
	}

	public void visit(FuncDeclNode node) {
		visit(node.getReturnType());
		visitDeclList(node.getVar());
		visit(node.getBody());
	}

	public void visit(VarDeclNode node) {
		visit(node.getType());
		visit(node.getInit());
	}

	public void visit(VarDeclListNode node) {
		visitDeclList(node.getList());
	}

	public void visit(LhsExprNode node) {
		if (node == null)
			return;
		node.accept(this);
	}

	public void visit(ArefExprNode node) {
		visit(node.getExpr());
		visit(node.getIndex());
	}

	public void visit(MemberExprNode node) {
		visit(node.getExpr());
	}

	public void visit(BoolLiteralExprNode node) {
		// null
	}

	public void visit(IntLiteralExprNode node) {
		// null
	}

	public void visit(StringLiteralExprNode node) {
		// null
	}

	public void visit(PrefixExprNode node) {
		visit(node.getExpr());
	}

	public void visit(SuffixExprNode node) {
		visit(node.getExpr());
	}

	public void visit(AssignExprNode node) {
		visit(node.getLhs());
		visit(node.getRhs());
	}

	public void visit(BinaryOpExprNode node) {
		visit(node.getLhs());
		visit(node.getRhs());
	}

	// IMPORTANT: FIX: can not use null.accept
	public void visit(ExprNode node) {
		if (node == null)
			return;
		node.accept(this);
	}

	public void visit(FuncallExprNode node) {
		visit(node.getExpr());
		visitExprList(node.getParam());
	}

	public void visit(IdentifierExprNode node) {
		// null
	}

	public void visit(NewExprNode node) {
		visit(node.getNewType());
		visitExprList(node.getDims());
	}

	public void visit(NullExprNode node) {
		// null
	}

	public void visit(ThisExprNode node) {
		// null
	}

	public void visit(BlockStmtNode node) {
		if (node != null && !node.getAll().isEmpty())
			for (Node n : node.getAll()) {
				visit(n);
			}
	}

	public void visit(BreakStmtNode node) {
		// null
	}

	public void visit(ContinueStmtNode node) {
		// null
	}

	public void visit(ExprStmtNode node) {
		visit(node.getExpr());
	}

	public void visit(ForStmtNode node) {
		visitDeclList(node.getVar());

		visit(node.getInit());
		visit(node.getCond());
		visit(node.getIncr());
		visit(node.getBody());
	}

	public void visit(IfStmtNode node) {
		visit(node.getCond());
		visit(node.getThen());
		visit(node.getElse());
	}

	public void visit(ReturnStmtNode node) {
		visit(node.getExpr());
	}

	public void visit(StmtNode node) {
		if (node == null)
			return;
		node.accept(this);
	}

	public void visit(WhileStmtNode node) {
		visit(node.getCond());
		visit(node.getBody());
	}

	// FIX: use ? extends Node to replace <Node>/**
	/*
	 * ATTENTION: can not use visit(this) for each node, cause error {@code if
	 * (!decls.isEmpty()) for (DeclNode e : decls) visit(e); }
	 */
	abstract protected void visitStmtList(List<? extends StmtNode> stmts);

	/**
	 * {@code
	 * if (!decls.isEmpty()) for (DeclNode e : decls) visit(e);
	 * }
	 */
	abstract protected void visitExprList(List<? extends ExprNode> exprs);

	/**
	 * {@code
	 * if (!decls.isEmpty()) for (DeclNode e : decls) visit(e);
	 * }
	 */
	abstract protected void visitDeclList(List<? extends DeclNode> decls);

}