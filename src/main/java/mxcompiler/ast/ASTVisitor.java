package mxcompiler.ast;

import mxcompiler.ast.statement.*;
import mxcompiler.ast.declaration.*;
import mxcompiler.ast.expression.*;
import mxcompiler.ast.expression.literal.*;
import mxcompiler.ast.expression.lhs.*;
import mxcompiler.ast.expression.unary.*;


/** {@code ASTVisitor} is a interface
 *  which include all nodes {@code visit} function
 * to avoid write to much codes {@code operators*nodes}
 * <p> Then, if want to do more works for Semantic
 * like PrintAST, Typecheck, LocalScoper, and so on
 * </p>
 * can add visitor return type with {@literal ASTVisitor<S, T, ...>}
 */
public interface ASTVisitor {
    /** No use just for display how to do a type */
	void visit(Node node);
	void visit(ASTNode node);
	void visit(TypeNode node);

	void visit(DeclNode node);
	void visit(ClassDeclNode node);
	void visit(FuncDeclNode node);
	void visit(VarDeclNode node);
	void visit(VarDeclListNode node);
	
	void visit(LhsExprNode node);
	void visit(ArefExprNode node);
	void visit(MemberExprNode node);

	void visit(BoolLiteralExprNode node);
	void visit(IntLiteralExprNode node);
	void visit(StringLiteralExprNode node);

	void visit(PrefixExprNode node);
	void visit(SuffixExprNode node);

	void visit(AssignExprNode node);
	void visit(BinaryOpExprNode node);
	void visit(ExprNode node);
	void visit(FuncallExprNode node);
	void visit(IdentifierExprNode node);
	void visit(NewExprNode node);
	void visit(NullExprNode node);
	void visit(ThisExprNode node);

	void visit(BlockStmtNode node);
	void visit(BreakStmtNode node);
	void visit(ContinueStmtNode node);
	void visit(ExprStmtNode node);
	void visit(ForStmtNode node);
	void visit(IfStmtNode node);
	void visit(ReturnStmtNode node);
	void visit(StmtNode node);
	void visit(WhileStmtNode node);
}