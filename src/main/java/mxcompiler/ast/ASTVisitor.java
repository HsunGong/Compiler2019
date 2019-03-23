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
	public void visit(Node node);
	public void visit(ASTNode node);
	public void visit(TypeNode node);

	public void visit(DeclNode node);
	public void visit(ClassDeclNode node);
	public void visit(FuncDeclNode node);
	public void visit(VarDeclNode node);
	public void visit(VarDeclListNode node);

	public void visit(LhsExprNode node);
	public void visit(ArefExprNode node);
	public void visit(MemberExprNode node);

	public void visit(BoolLiteralExprNode node);
	public void visit(IntLiteralExprNode node);
	public void visit(StringLiteralExprNode node);
	public void visit(PrefixExprNode node);
	public void visit(SuffixExprNode node);

	public void visit(AssignExprNode node);
	public void visit(BinaryOpExprNode node);
	public void visit(ExprNode node);
	public void visit(FuncallExprNode node);
	public void visit(IdentifierExprNode node);
	public void visit(NewExprNode node);
	public void visit(NullExprNode node);
	public void visit(ThisExprNode node);

	public void visit(BlockStmtNode node);
	public void visit(BreakStmtNode node);
	public void visit(ContinueStmtNode node);
	public void visit(ExprStmtNode node);
	public void visit(ForStmtNode node);
	public void visit(IfStmtNode node);
	public void visit(ReturnStmtNode node);
	public void visit(StmtNode node);
	public void visit(WhileStmtNode node);
}