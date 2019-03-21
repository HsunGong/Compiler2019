package mxcompiler.main;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import mxcompiler.parser.MxBaseVisitor;
import mxcompiler.parser.MxParser;
import mxcompiler.type.*;
import mxcompiler.ast.*;
import mxcompiler.ast.statement.*;
import mxcompiler.exception.CompileException;
import mxcompiler.ast.declaration.*;
import mxcompiler.ast.expression.*;
import mxcompiler.ast.expression.literal.*;
import mxcompiler.ast.expression.lhs.*;
import mxcompiler.ast.expression.unary.*;

import mxcompiler.exception.*;

/**
 * used for generate AST to prepare for Semantic Check
 * {@linkplain mxcompiler.parser.MxBaseListener} return value of
 * {@linkplain Node} type FIX: Whatif do this {@code with BaseListener}?
 */
public class ASTBuilder extends MxBaseVisitor<Node> {

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitCompilationUnit(MxParser.CompilationUnitContext ctx) {
		List<DeclNode> decls = new ArrayList<>();
		for (ParserRuleContext unit : ctx.translationUnit()) {
			Node decl = visit(unit);
			// FIX: attention to DeclListNode
			if (decl instanceof VarDeclListNode)
				decls.addAll(((VarDeclListNode) decl).getList());
			else
				decls.add((DeclNode) decl);
		}
		return new ASTNode(decls);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitTranslationUnit(MxParser.TranslationUnitContext ctx) {
		if (ctx.functionDeclaration() != null)
			return visit(ctx.functionDeclaration());
		if (ctx.classDeclaration() != null)
			return visit(ctx.classDeclaration());
		if (ctx.variableDeclaration() != null)
			return visit(ctx.variableDeclaration());

		// FIX: redo my own error type
		throw new Error("No translation part found");
	}

	/**
	 * translate into varlistNode
	 */

	private TypeNode typeTransfer;

	@Override
	public Node visitVariableDeclaration(MxParser.VariableDeclarationContext ctx) {
		typeTransfer = (TypeNode) visit(ctx.type());

		return visit(ctx.variableDeclaratorList());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitVariableDeclaratorList(MxParser.VariableDeclaratorListContext ctx) {
		List<VarDeclNode> varDecls = new ArrayList<>();
		for (ParserRuleContext varDecl : ctx.variableDeclarator())
			varDecls.add((VarDeclNode) visit(varDecl));

		return new VarDeclListNode(varDecls);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitVariableDeclarator(MxParser.VariableDeclaratorContext ctx) {
		ExprNode init;
		if (ctx.expression() == null)
			init = null;
		else
			init = (ExprNode) visit(ctx.expression());
		return new VarDeclNode(ctx.Identifier().getText(), init, typeTransfer);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitArrayType(MxParser.ArrayTypeContext ctx) {
		TypeNode type = (TypeNode) visit(ctx.type());
		// TODO: can get dims ?? - get support from type.arraytype
		return new TypeNode(new ArrayType(type.getType()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitNonarrayType(MxParser.NonarrayTypeContext ctx) {
		return visit(ctx.typeName());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitTypeName(MxParser.TypeNameContext ctx) {
		return new TypeNode(getType(ctx));
	}

	/** Nonarray, non-function */
	private Type getType(MxParser.TypeNameContext ctx) {
		if (ctx.Identifier() != null)
			return new ClassType(ctx.Identifier().getText());
		if (ctx.Int() != null)
			return new IntType();
		if (ctx.Bool() != null)
			return new BoolType();
		if (ctx.String() != null)
			return new StringType();

		throw new Error("Invalid Type");
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitFunctionDeclaration(MxParser.FunctionDeclarationContext ctx) {
		TypeNode returnType;
		if (ctx.typeReturn() == null)
			returnType = null; // new NullType();
		else
			returnType = (TypeNode) visit(ctx.typeReturn());

		String name = ctx.Identifier().getText();
		VarDeclListNode varList = (VarDeclListNode) visit(ctx.paramDeclarationList());
		BlockStmtNode body = (BlockStmtNode) visit(ctx.block());

		return new FuncDeclNode(name, returnType, varList, body);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitTypeReturn(MxParser.TypeReturnContext ctx) {
		if (ctx.Void() != null)
			return new TypeNode(new VoidType());
		else
			return visit(ctx.type());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitParamDeclarationList(MxParser.ParamDeclarationListContext ctx) {
		List<VarDeclNode> paramList = new ArrayList<>();
		for (ParserRuleContext param : ctx.paramDeclaration()) {
			paramList.add((VarDeclNode) visit(param));
		} // FIX: can be null
		return new VarDeclListNode(paramList);
	}

	/**
	 * {@inheritDoc}
	 *
	 * attention: current no init expr
	 */
	@Override
	public Node visitParamDeclaration(MxParser.ParamDeclarationContext ctx) {
		return new VarDeclNode(ctx.Identifier().getText(), null, (TypeNode) visit(ctx.type()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitClassDeclaration(MxParser.ClassDeclarationContext ctx) {
		String name = ctx.Identifier().getText();
		List<VarDeclNode> varList = new ArrayList<>();
		List<FuncDeclNode> funcList = new ArrayList<>();

		for (ParserRuleContext body : ctx.classBody()) {
			Node decl = visit(body);
			if (decl instanceof VarDeclListNode)
				varList.addAll(((VarDeclListNode) decl).getList());
			else if (decl instanceof VarDeclNode)
				varList.add((VarDeclNode) decl);
			else if (decl instanceof FuncDeclNode)
				funcList.add((FuncDeclNode) decl);
			// Never happen else throw new Error("not found such class body");
		}

		return new ClassDeclNode(name, varList, funcList);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitClassBody(MxParser.ClassBodyContext ctx) {
		if (ctx.functionDeclaration() != null)
			return visit(ctx.functionDeclaration());
		if (ctx.variableDeclaration() != null)
			return visit(ctx.variableDeclaration());

		throw new Error("not found such class body");
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 * 
	 * to divide block from stmt symbol function
	 */
	@Override
	public Node visitBlockStmt(MxParser.BlockStmtContext ctx) {
		return visit(ctx.block());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitBlock(MxParser.BlockContext ctx) {
		List<StmtNode> stmts = new ArrayList<>();
		List<VarDeclNode> varList = new ArrayList<>();

		for (ParserRuleContext body : ctx.blockBody()) {
			Node s = visit(body);
			if (s instanceof VarDeclListNode)
				varList.addAll(((VarDeclListNode) s).getList());
			else if (s instanceof VarDeclNode)
				varList.add((VarDeclNode) s);
			else if (s instanceof StmtNode)
				stmts.add((StmtNode) s);
		}

		return new BlockStmtNode(stmts, varList);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitBlockBody(MxParser.BlockBodyContext ctx) {
		if (ctx.statement() != null)
			return visit(ctx.statement());
		if (ctx.variableDeclaration() != null)
			return visit(ctx.variableDeclaration());

		throw new Error("no such block-body-stmt");
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitExprStmt(MxParser.ExprStmtContext ctx) {
		return new ExprStmtNode((ExprNode) visit(ctx.expression()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitIfStmt(MxParser.IfStmtContext ctx) {
		ExprNode cond = (ExprNode) visit(ctx.expression());
		StmtNode thenBody = (StmtNode) visit(ctx.statement(0));
		StmtNode elseBody = (ctx.statement(1) == null) ? null : (StmtNode) visit(ctx.statement(1));

		return new IfStmtNode(cond, thenBody, elseBody);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitWhileStmt(MxParser.WhileStmtContext ctx) {
		ExprNode cond = (ExprNode) visit(ctx.expression());
		StmtNode body = (StmtNode) visit(ctx.statement());

		return new WhileStmtNode(cond, body);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitForInitStmt(MxParser.ForInitStmtContext ctx) {
		ExprNode init, cond, incr;
		VarDeclListNode varList = null;
		StmtNode body;

		init = null;
		cond = (ctx.init == null) ? null : (ExprNode) visit(ctx.cond);
		incr = (ctx.init == null) ? null : (ExprNode) visit(ctx.cond);
		varList = (VarDeclListNode) visit(ctx.init);
		body = (StmtNode) visit(ctx.statement());

		return new ForStmtNode(init, cond, incr, body, varList);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitForNoneStmt(MxParser.ForNoneStmtContext ctx) {
		ExprNode init, cond, incr;
		StmtNode body;
		VarDeclListNode varList = null;

		init = (ctx.init == null) ? null : (ExprNode) visit(ctx.init);
		cond = (ctx.init == null) ? null : (ExprNode) visit(ctx.cond);
		incr = (ctx.init == null) ? null : (ExprNode) visit(ctx.cond);
		body = (StmtNode) visit(ctx.statement());

		return new ForStmtNode(init, cond, incr, body, varList);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitContinueStmt(MxParser.ContinueStmtContext ctx) {
		return new ContinueStmtNode();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitBreakStmt(MxParser.BreakStmtContext ctx) {
		return new BreakStmtNode();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitReturnStmt(MxParser.ReturnStmtContext ctx) {
		ExprNode returnExpr;
		returnExpr = (ctx.expression() == null) ? null : (ExprNode) visit(ctx.expression());

		return new ReturnStmtNode(returnExpr);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitBlankStmt(MxParser.BlankStmtContext ctx) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitNewExpr(MxParser.NewExprContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitPrefixExpr(MxParser.PrefixExprContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitFuncallExpr(MxParser.FuncallExprContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitSuffixExpr(MxParser.SuffixExprContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitMemberExpr(MxParser.MemberExprContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitArefExpr(MxParser.ArefExprContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitBinaryExpr(MxParser.BinaryExprContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitAssignExpr(MxParser.AssignExprContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitParamList(MxParser.ParamListContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitPrimaryExpr(MxParser.PrimaryExprContext ctx) {
		return visit(ctx.primaryExpression());
	}

	@Override
	public Node visitPrimaryExpression(MxParser.PrimaryExpressionContext ctx) {
		if(ctx.Identifier() != null) return new IdentifierExprNode(ctx.getText());
		if(ctx.This() != null) return new ThisExprNode();
		if(ctx.literal() != null) return visit(ctx.literal());

		throw new Error("not found primary expr");
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public Node visitLiteral(MxParser.LiteralContext ctx) {
		if (ctx.IntLiteral() != null) {
			int v;
			try {
				v = Integer.parseInt(ctx.getText());
			} catch (Exception e) {
				throw new Error("not found int literal" + e);
			}
			return new IntLiteralExprNode(v);
		}
		if (ctx.StringLiteral() != null) {
			String v = ctx.getText(); // FIX: escape-sequence??
			return new StringLiteralExprNode(v);
		}
		if (ctx.Null() != null) {
			return new NullExprNode();
		}
		if (ctx.True() != null | ctx.False() != null) {
			return new BoolLiteralExprNode(ctx.True() != null);
		}

		throw new Error("not found literal type");
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitSubExpr(MxParser.SubExprContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitErrorCreator(MxParser.ErrorCreatorContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitArrayCreator(MxParser.ArrayCreatorContext ctx) {
		return visitChildren(ctx);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Override
	public T visitNonArrayCreator(MxParser.NonArrayCreatorContext ctx) {
		return visitChildren(ctx);
	}
}