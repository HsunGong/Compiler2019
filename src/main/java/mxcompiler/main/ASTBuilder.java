package mxcompiler.main;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import mxcompiler.parser.MxBaseVisitor;
import mxcompiler.parser.MxParser;

import mxcompiler.type.*;
import mxcompiler.ast.*;
import mxcompiler.ast.statement.*;
import mxcompiler.ast.declaration.*;
import mxcompiler.ast.expression.*;
import mxcompiler.ast.expression.literal.*;
import mxcompiler.ast.expression.lhs.*;
import mxcompiler.ast.expression.unary.*;

import mxcompiler.error.*;

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
		List<DeclNode> decls = new ArrayList<>(); // Include class, function, variable
		if (ctx.translationUnit() != null)
			for (ParserRuleContext unit : ctx.translationUnit()) {
				Node decl = visit(unit);
				if (decl instanceof VarDeclListNode)
					decls.addAll(((VarDeclListNode) decl).getList());
				else if (decl instanceof DeclNode)
					decls.add((DeclNode) decl);
				else
					throw new SemanticError("not found decl from compilation unit");
			}
		return new ASTNode(decls, new Location(ctx));
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
			return visitFunctionDeclaration(ctx.functionDeclaration());
		if (ctx.classDeclaration() != null)
			return visit(ctx.classDeclaration());
		if (ctx.variableDeclaration() != null)
			return visit(ctx.variableDeclaration());

		throw new SemanticError("No translation part found");
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
		if (ctx.variableDeclarator() != null)
			for (ParserRuleContext varDecl : ctx.variableDeclarator())
				varDecls.add((VarDeclNode) visit(varDecl));

		return new VarDeclListNode(varDecls, new Location(ctx));
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
		init = (ctx.expression() == null) ? null : (ExprNode) visit(ctx.expression());
		return new VarDeclNode(ctx.Identifier().getText(), init, typeTransfer, new Location(ctx));
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
		// TODO: can get dims ?? - get support from type.arraytype and conflict with
		// array-creator
		return new TypeNode(new ArrayType(type.getType()), new Location(ctx));
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
		return new TypeNode(getType(ctx), new Location(ctx));
	}

	/** Nonarray, non-function */
	private Type getType(MxParser.TypeNameContext ctx) {
		if (ctx.Int() != null)
			return new IntType();
		if (ctx.Bool() != null)
			return new BoolType();
		if (ctx.String() != null)
			return new StringType();
		if (ctx.Identifier() != null)
			return new ClassType(ctx.Identifier().getText());

		throw new SemanticError("Invalid Type");
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
		// UGLY: new NullType() for null
		returnType = (ctx.typeReturn() == null) ? new TypeNode(new NullType(), new Location(ctx))
				: (TypeNode) visit(ctx.typeReturn());

		String name = ctx.Identifier().getText();
		VarDeclListNode varList = (ctx.paramDeclarationList() == null) ? new VarDeclListNode(null, new Location(ctx))
				: (VarDeclListNode) visit(ctx.paramDeclarationList());
		BlockStmtNode body = (BlockStmtNode) visit(ctx.block());

		return new FuncDeclNode(name, returnType, varList, body, new Location(ctx));
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
		return (ctx.Void() != null) ? new TypeNode(new VoidType(), new Location(ctx)) : visit(ctx.type());
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
		if (ctx.paramDeclaration() != null)
			for (ParserRuleContext param : ctx.paramDeclaration()) {
				paramList.add((VarDeclNode) visit(param));
			} // BUG: can be null
		return new VarDeclListNode(paramList, new Location(ctx));
	}

	/**
	 * {@inheritDoc}
	 *
	 * attention: current no init expr
	 */
	@Override
	public Node visitParamDeclaration(MxParser.ParamDeclarationContext ctx) {
		return new VarDeclNode(ctx.Identifier().getText(), null, (TypeNode) visit(ctx.type()), new Location(ctx));
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

		if (ctx.classBody() != null)
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

		return new ClassDeclNode(name, varList, funcList, new Location(ctx));
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
		List<Node> stmtsAndDecls = new ArrayList<>();

		if (ctx.blockBody() != null)
			for (ParserRuleContext body : ctx.blockBody()) {
				Node stmt = visit(body);
				if (stmt instanceof VarDeclListNode)
					stmtsAndDecls.addAll(((VarDeclListNode) stmt).getList());
				else if (stmt instanceof VarDeclNode)
					stmtsAndDecls.add((VarDeclNode) stmt);
				else if (stmt instanceof StmtNode){
					stmts.add((StmtNode) stmt);
					stmtsAndDecls.add(stmt);
				}
			}

		return new BlockStmtNode(stmts, stmtsAndDecls, new Location(ctx));
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

		throw new SemanticError("no such block-body-stmt");
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
		return new ExprStmtNode((ExprNode) visit(ctx.expression()), new Location(ctx));
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

		return new IfStmtNode(cond, thenBody, elseBody, new Location(ctx));
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

		return new WhileStmtNode(cond, body, new Location(ctx));
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
		ExprNode cond = (ctx.cond == null) ? null : (ExprNode) visit(ctx.cond);
		ExprNode incr = (ctx.incr == null) ? null : (ExprNode) visit(ctx.incr);
		VarDeclListNode varList = (VarDeclListNode) visit(ctx.init);
		StmtNode body = (StmtNode) visit(ctx.statement());

		return new ForStmtNode(null, cond, incr, body, varList, new Location(ctx));
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
		VarDeclListNode varList = null;

		ExprNode init = (ctx.init == null) ? null : (ExprNode) visit(ctx.init);
		ExprNode cond = (ctx.cond == null) ? null : (ExprNode) visit(ctx.cond);
		ExprNode incr = (ctx.incr == null) ? null : (ExprNode) visit(ctx.incr);
		StmtNode body = (StmtNode) visit(ctx.statement());

		return new ForStmtNode(init, cond, incr, body, varList, new Location(ctx));
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
		return new ContinueStmtNode(new Location(ctx));
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
		return new BreakStmtNode(new Location(ctx));
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

		return new ReturnStmtNode(returnExpr, new Location(ctx));
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
		// UGLY: try to change vardecllist into listnode but failed
		List<ExprNode> params = new ArrayList<ExprNode>();

		if (ctx.paramList() != null) // REVIEW: not parmList.expression
			for (ParserRuleContext param : ctx.paramList().expression()) {
				params.add((ExprNode) visit(param));
			}

		return new FuncallExprNode(func, params, new Location(ctx));
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
		throw new CompileError("What happened ??");
		// return visitChildren(ctx);
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
		throw new SemanticError("can not create this");
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

		if (ctx.expression() != null)
			for (ParserRuleContext dim : ctx.expression()) {
				dims.add((ExprNode) visit(dim));
			}
		int num = ctx.LeftBracket().size();
		// int num = (ctx.getChildCount() - 1 - dims.size()) / 2;

		// FIX: UGLY: NOTE: current is no array plain type how to figure how many dims
		// is
		// needed??
		for (int i = 0; i < num; ++i)
			newType.setType(new ArrayType(newType.getType()));
		// FIXED: newType.setType(new ArrayType(newType.getType()));

		return new NewExprNode(newType, dims, num, new Location(ctx));
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
		return new NewExprNode(newType, null, 0, new Location(ctx));
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

		return new PrefixExprNode(ctx.op.getText(), prefixExpr, new Location(ctx));
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

		return new SuffixExprNode(ctx.op.getText(), suffixExpr, new Location(ctx));
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

		return new MemberExprNode(expr, ctx.Identifier().getText(), new Location(ctx));
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

		return new ArefExprNode(arr, index, new Location(ctx));
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

		return new BinaryOpExprNode(lhs, ctx.op.getText(), rhs, new Location(ctx));
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

		return new AssignExprNode(lhs, rhs, new Location(ctx));
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
			return new IdentifierExprNode(ctx.getText(), new Location(ctx));
		if (ctx.This() != null)
			return new ThisExprNode(new Location(ctx));
		if (ctx.literal() != null)
			return visit(ctx.literal());
		if (ctx.expression() != null)
			return visit(ctx.expression());

		throw new SemanticError("not found primary expr");
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
				throw new SyntaxError("not found int literal" + e);
			}
			return new IntLiteralExprNode(v, new Location(ctx));
		}
		if (ctx.StringLiteral() != null) {
			String v = ctx.getText(); // BUG: escape-sequence??
			return new StringLiteralExprNode(v, new Location(ctx));
		}
		if (ctx.Null() != null) {
			return new NullExprNode(new Location(ctx));
		}
		if (ctx.True() != null | ctx.False() != null) {
			return new BoolLiteralExprNode(ctx.True() != null, new Location(ctx));
		}

		throw new SemanticError("not found literal type");
	}

}