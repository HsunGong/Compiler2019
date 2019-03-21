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
	public Node visitFuncallExpr(MxParser.FuncallExprContext ctx) {
		ExprNode func = (ExprNode) visit(ctx.expression());
		// FIX: try to change vardecllist into listnode but failed
		List<ExprNode> params = new ArrayList<ExprNode>();

		for (ParserRuleContext param : ctx.paramList().expression()) {
			params.add((ExprNode) visit(param));
		}

		return new FuncallExprNode(func, params);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.
	 * </p>
	 */
	@Deprecated // cause cannot transfer vardecl into expr
	@Override
	public Node visitParamList(MxParser.ParamListContext ctx) {
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
	public Node visitNewExpr(MxParser.NewExprContext ctx) {
		return visit(ctx.creator());
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
	public Node visitErrorCreator(MxParser.ErrorCreatorContext ctx) {
		throw new Error("can not create this");
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
	public Node visitArrayCreator(MxParser.ArrayCreatorContext ctx) {
		TypeNode newType = (TypeNode) visit(ctx.typeName());
		List<ExprNode> dims = new ArrayList<ExprNode>();
		for (ParserRuleContext dim : ctx.expression()) {
			dims.add((ExprNode) visit(dim));
		}
		int num = ctx.LeftBracket().size();
		
		// FIX: current is no array plain type how to figure how many dims is needed??
		//  for (int i = 0; i < numDim; ++i) newType.setType(new ArrayType(newType.getType()));
		newType.setType(new ArrayType(newType.getType()));
		
		return new NewExprNode(newType, dims, num);
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
	public Node visitNonArrayCreator(MxParser.NonArrayCreatorContext ctx) {
		TypeNode newType = (TypeNode) visit(ctx.typeName());
		return new NewExprNode(newType, null, 0);
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
	public Node visitPrefixExpr(MxParser.PrefixExprContext ctx) {
		ExprNode prefixExpr = (ExprNode) visit(ctx.expression());

		return new PrefixExprNode(ctx.op.getText(), prefixExpr);
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
	public Node visitSuffixExpr(MxParser.SuffixExprContext ctx) {
		ExprNode suffixExpr = (ExprNode) visit(ctx.expression());

		return new SuffixExprNode(ctx.op.getText(), suffixExpr);
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
	public Node visitMemberExpr(MxParser.MemberExprContext ctx) {
		ExprNode expr = (ExprNode) visit(ctx.expression());

		return new MemberExprNode(expr, ctx.Identifier().getText());
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
	public Node visitArefExpr(MxParser.ArefExprContext ctx) {
		ExprNode arr = (ExprNode) visit(ctx.arr);
		ExprNode index = (ExprNode) visit(ctx.index);

		return new ArefExprNode(arr, index);
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
	public Node visitBinaryExpr(MxParser.BinaryExprContext ctx) {
		ExprNode lhs = (ExprNode) visit(ctx.expression(0));
		ExprNode rhs = (ExprNode) visit(ctx.expression(1));

		return new BinaryOpExprNode(lhs, ctx.op.getText(), rhs);
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
	public Node visitAssignExpr(MxParser.AssignExprContext ctx) {
		ExprNode lhs = (ExprNode) visit(ctx.expression(0));
		ExprNode rhs = (ExprNode) visit(ctx.expression(1));

		return new AssignExprNode(lhs, rhs);
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
		if (ctx.Identifier() != null)
			return new IdentifierExprNode(ctx.getText());
		if (ctx.This() != null)
			return new ThisExprNode();
		if (ctx.literal() != null)
			return visit(ctx.literal());
		if (ctx.expression() != null)
			return visit(ctx.expression());

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

}