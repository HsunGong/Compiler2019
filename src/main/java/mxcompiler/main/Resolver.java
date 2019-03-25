package mxcompiler.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import mxcompiler.utils.scope.*;
import mxcompiler.utils.entity.*;
import mxcompiler.type.*;

import mxcompiler.ast.statement.*;
import mxcompiler.exception.SemanticException;
import mxcompiler.ast.declaration.*;
import mxcompiler.ast.expression.*;
import mxcompiler.ast.expression.literal.*;
import mxcompiler.ast.expression.lhs.*;
import mxcompiler.ast.expression.unary.*;
import mxcompiler.ast.*;

public class Resolver extends Visitor {
	/** means can not change LinkedList's type */
	private final LinkedList<Scope> scopeStack;
	// private int isInLoop = 0;
	private ClassType curClass;
	private int loop;
	private Type curReturnType;
	private FuncEntity curFuncEntity;

	public Resolver() {
		System.out.print("Resolver begin");

		scopeStack = new LinkedList<Scope>();
		curClass = null;
		curReturnType = null;
		loop = 0;
	}

	/**
	 * start localresolver not main (cause use {@code this.visit(ASTNode node)}) or
	 * so called pre-scanner But just this top-level
	 * <p>
	 * add global-funcs, classes-funcs, classes - for only top decl FIX: not vars?
	 */
	protected void preResolve(ASTNode root) {
		ToplevelScope toplevelScope; // FIX:??no need to add to member
		toplevelScope = new ToplevelScope();
		scopeStack.add(toplevelScope);

		putBuiltIn(toplevelScope);

		// add class and g-func
		if (!root.getDecl().isEmpty())
			for (DeclNode decl : root.getDecl()) {
				try {
					if (decl instanceof VarDeclNode)
						continue; // FIX: what is this ? can add now!!
					if (decl instanceof FuncDeclNode) {
						Entity entity = new FuncEntity((FuncDeclNode) decl);
						toplevelScope.put(decl.getName(), entity);
					}
					if (decl instanceof ClassDeclNode) {
						Entity entity = new ClassEntity((ClassDeclNode) decl, toplevelScope);
						toplevelScope.put(decl.getName(), entity);
					}
				} catch (SemanticException e) {
					throw new Error(e);
				}
			}

		// TODO: move to checker: checkMainFunc((FuncEntity) toplevelScope.get("main"));
		try {
			FuncEntity mainFunc = (FuncEntity) toplevelScope.get("main");
			if (mainFunc == null)
				throw new Error("\"main\" function not found");
			if (!(mainFunc.getReturnType() instanceof IntType))
				throw new Error("\"main\" function's return type should be \"int\"");
			if (!mainFunc.params.isEmpty())
				throw new Error("\"main\" function should have no parameter");
		} catch (SemanticException e) {
			throw new Error("No main funcion");
		}
	}

	@Override
	public void visit(ASTNode node) {
		preResolve(node);

		// if (!node.getDecl().isEmpty())
		// for (DeclNode decl : node.getDecl())
		// if (!(decl instanceof ClassDeclNode))
		// continue;
		// else
		// visit(decl);

		if (!node.getDecl().isEmpty())
			for (DeclNode decl : node.getDecl())
				visit(decl);

		node.setScope((ToplevelScope) getCurScope());

		scopeStack.remove();
		assert (scopeStack.isEmpty() == true);
	}

	/** class scope */
	@Override
	public void visit(ClassDeclNode node) {
		assert (getCurScope() instanceof ToplevelScope);

		try {
			ClassEntity entity = (ClassEntity) getCurScope().get(node.getName());

			pushScope(entity.getScope());
			// replaced by curClass = new ClassType(entity.getName());
			curClass = (ClassType) entity.getType();

			// means only this level
			// round 1 - check member vars
			// FIX: decl can add leter via getCurScope
			resolveMember(node.getVar(), entity.getName());

			// round 2 - check functions
			visitDeclList(node.getFunc());
			// currentOffset = 0;
			// entity.setMemorySize(currentOffset);

			curClass = null;
			popScope();
		} catch (SemanticException e) {
			throw new Error("classEntity " + e);
		}
	}

	/**
	 * func scope is included in block-body
	 */
	@Override
	public void visit(FuncDeclNode node) {
		try {
			// pre add support no error
			FuncEntity entity = (FuncEntity) getCurScope().get(node.getName());

			// to add scope first
			pushScope();

			// return Type
			// FIX: allowed class{class{{}}}
			// check class exist
			curReturnType = entity.getReturnType();
			if (curReturnType instanceof ClassType) {
				// cause scope may not be the toplevel
				String name = ((ClassType) curReturnType).getName();
				// UGLY: curScope can not find anything
				assert (getCurScope().get(name) instanceof ClassEntity);
			} else if (curReturnType instanceof NullType && node.isConstruct()) {
				// can not be construct 1-type
				if (curClass == null)
					throw new Error("Function " + node.getName() + " do not belong to class");

				// can not be construct 2-type
				// UGLY: NOTE: == or != means the memory-Location
				if (!node.getName().equals(curClass.getName()))
					throw new Error(
							"Function " + node.getName() + " should have a return type or construct name is wrong");
			}

			// class mem add __this
			if (curClass != null) {
				getCurScope().put("__this", new VarEntity("__this", curClass));
			}

			// ATTENTION:FIX: already add func name from global or from class-decl

			// Parameters
			visitDeclList(node.getVar()); // varTypeExprCheck

			// body
			node.getBody().setScope((LocalScope) getCurScope());
			popScope();
			visit(node.getBody());
			curReturnType = null;
		} catch (SemanticException e) {
			throw new Error("classEntityt " + e);
		}
	}

	/**
	 * resolve variable into class cause class-name is included
	 */
	public void resolveMember(List<VarDeclNode> list, String className) {
		if (!list.isEmpty())
			for (VarDeclNode node : list)
				resolve(node, className);
	}

	@Override
	public void visit(VarDeclNode node) {
		resolve(node, null);
	}

	private void checkVarDeclInit(VarDeclNode node) {
		// if (node.getInit() != null) {
		// visit(node.getInit());

		// boolean invalidInitType;
		// if (node.getType().getType() instanceof VoidType || node.getInit().getType()
		// instanceof VoidType)
		// invalidInitType = true;
		// else if (node.getType().getType().equals(node.getInit().getType()))
		// invalidInitType = false;
		// else if (node.getInit().getType() instanceof NullType)
		// invalidInitType = !(node.getType().getType() instanceof ClassType
		// || node.getType().getType() instanceof ArrayType);
		// else
		// invalidInitType = true;
		// if (invalidInitType)
		// throw new Error("Invalid initialization value" + "expected" +
		// node.getType().getType().toString()
		// + " but got " + node.getInit().getType().toString());
		// }
	}

	/** resolve variable into cur scope */
	public void resolve(VarDeclNode node, String className) {
		try {
			// check type
			if (node.getType().getType() instanceof ClassType) {
				String typeName = ((ClassType) node.getType().getType()).getName();
				assert (getCurScope().get(typeName) instanceof ClassEntity);
			}

			// check init
			checkVarDeclInit(node);

			VarEntity entity = (className == null) ? new VarEntity(node.getName(), node.getType().getType())
					: new VarEntity(node.getName(), node.getType().getType(), className);

			entity.isGlobal = (getCurScope() instanceof ToplevelScope);

			// entity.setAddrOffset(currentOffset);
			// currentOffset += node.getType().getType().getVarSize();

			getCurScope().put(node.getName(), entity);
		} catch (SemanticException e) {
			throw new Error("VarEntity " + e);
		}
	}

	/**
	 * {@inheritDoc} temportory scope
	 * <p>
	 * {@literal add scope inside or outside}
	 */
	@Override
	public void visit(BlockStmtNode node) {
		if (node.getScope() == null)
			node.setScope(new LocalScope(getCurScope())); // temportory scope
		pushScope(node.getScope());

		visitDeclList(node.getVar());
		visitStmtList(node.getStmts());
		popScope();
	}

	// ----------------------------------- type checking
	// -------------------------------

	@Override
	public void visit(IfStmtNode node) {
		visit(node.getCond());
		// CHECKING
		if (!(node.getCond().getType() instanceof BoolType))
			throw new Error("Condition expression of while loop statement should have type \"bool\"");

		visit(node.getThen());
		visit(node.getElse());
	}

	@Override
	public void visit(WhileStmtNode node) {
		++loop;
		visit(node.getCond());
		// CHECKING
		if (!(node.getCond().getType() instanceof BoolType))
			throw new Error("Condition expression of while loop statement should have type \"bool\"");

		visit(node.getBody());
		--loop;
	}

	@Override
	public void visit(ForStmtNode node) {
		++loop;
		visit(node.getCond());
		if (!(node.getCond().getType() instanceof BoolType))
			throw new Error("Condition expression of for loop statement should have type \"bool\"");

		visit(node.getInit());
		visitDeclList(node.getVar());
		visit(node.getIncr());
		visit(node.getBody());
		--loop;
	}

	@Override
	public void visit(ContinueStmtNode node) {
		if (loop <= 0)
			throw new Error("Continue statement cannot be used outside of loop statement");
	}

	@Override
	public void visit(BreakStmtNode node) {
		if (loop <= 0)
			throw new Error("Break statement cannot be used outside of loop statement");
	}

	@Override
	public void visit(ReturnStmtNode node) {
		boolean invalid = false;
		if (node.getExpr() == null) {
			if (!(curReturnType instanceof NullType || curReturnType instanceof VoidType))
				invalid = true;
		} else {
			visit(node.getExpr());
			if (node.getExpr().getType() instanceof NullType || node.getExpr().getType() instanceof VoidType)
				invalid = true;
			else if (node.getExpr().getType() instanceof NullType)
				invalid = !(curReturnType instanceof ClassType || curReturnType instanceof ArrayType);
			else if (!(node.getExpr().getType().isEqual(curReturnType)))
				invalid = true;
		}
		if (invalid) {
			if (curReturnType instanceof NullType || curReturnType instanceof VoidType)
				throw new Error("Return statement should have no return value");
			else
				throw new Error("Return statement should have return value of type " + curReturnType.toString());
		}
	}

	@Override
	public void visit(SuffixExprNode node) {
		visit(node.getExpr());
		if (!(node.getExpr().getType() instanceof IntType))
			throw new Error("Operator " + node.getOp().toString() + " cannot be applied to type "
					+ node.getExpr().getType().toString());
		if (!(node.getExpr().isLeftValue()))
			throw new Error("Operator " + node.getOp().toString() + " cannot be applied to right value");
		node.setType(new IntType());
		node.setIsLeftValue(false);
	}

	@Override
	public void visit(ArefExprNode node) {
		visit(node.getExpr());
		if (!(node.getExpr().getType() instanceof ArrayType))
			throw new Error("Type" + node.getExpr().getType().toString() + " is not arrayType");
		visit(node.getIndex());
		if (!(node.getIndex().getType() instanceof IntType))
			throw new Error("ArrayIndexType should have Int but got " + node.getExpr().getType().toString());

		// FIX: double domian arrayType
		node.setType(((ArrayType) node.getExpr().getType()).getBaseType());
		node.setIsLeftValue(true);
	}

	@Override
	public void visit(MemberExprNode node) {
		visit(node.getExpr());
		String className = null;
		Entity memEntity;

		if (node.getExpr().getType() instanceof ClassType) {
			className = ((ClassType) node.getExpr().getType()).getName();
		} else if (node.getExpr().getType() instanceof StringType) {
			className = Scope.BuiltIn.STRING.toString();
		} else if (node.getExpr().getType() instanceof ArrayType) {
			className = Scope.BuiltIn.ARRAY.toString();
		} else
			throw new Error(
					node.getExpr().getType().toString() + ", No such Type can be used in member access expression");

		try {
			ClassEntity classEntity = (ClassEntity) getCurScope().get(className);
			memEntity = classEntity.getScope().getCur(node.getMember());
			// FIX: if(memEntity instanceof FuncEntity) curFuncEntity = (FuncEntity)
			// memEntity;
		} catch (Exception e) {
			throw new Error(e);
		}
		node.setType(memEntity.getType());
		node.setIsLeftValue(true);
	}

	@Override
	public void visit(FuncallExprNode node) {
		visit(node.getExpr());
		if (!(node.getExpr().getType() instanceof FuncType))
			throw new Error(node.getExpr().getType().toString() + " is not callable");

		node.funcEntity = curFuncEntity;

		int paraNum = curFuncEntity.params.size();
		int firstParaIdx = node.funcEntity.isMember ? 1 : 0;
		if (paraNum - firstParaIdx != node.getParam().size())
			throw new Error("Function call has inconsistent number of arguments, expected" + paraNum + "but got"
					+ node.getParam().size());

		boolean invalid; // invalid of param type
		for (int i = 0; i < paraNum - firstParaIdx; ++i) {
			ExprNode curParam = node.getParam().get(i);
			visit(curParam);
			if (curParam.getType() instanceof VoidType)
				invalid = true;
			else if (curParam.getType() instanceof NullType)
				invalid = !(curFuncEntity.params.get(i + firstParaIdx).getType() instanceof ClassType
						|| curFuncEntity.params.get(i + firstParaIdx).getType() instanceof ArrayType);
			else
				invalid = !(curFuncEntity.params.get(i + firstParaIdx).getType().equals(curParam.getType()));

			if (invalid) {
				throw new Error("Function call has inconsistent type of arguments, expected"
						+ curFuncEntity.params.get(i + firstParaIdx).getType().toString() + "but got "
						+ curParam.getType().toString());
			}
		}

		node.setType(curFuncEntity.getReturnType());
		node.setIsLeftValue(false);
	}

	@Override
	public void visit(PrefixExprNode node) {
		
	}




	// ------------- build-in classes and functions ---------------
	/** add BuiltIn func and BuiltIn class */
	private void putBuiltIn(ToplevelScope toplevelScope) {
		/** builtIn class */
		String name = Scope.BuiltIn.STRING.toString();
		Type type = new ClassType(name);
		ClassEntity stringEntity = new ClassEntity(name, type, toplevelScope);

		name = Scope.BuiltIn.ARRAY.toString();
		type = new ClassType(name);
		ClassEntity arrayEntity = new ClassEntity(name, type, toplevelScope);

		/** global builtIn funcs */
		List<VarEntity> params;
		Type returnType;

		type = new StringType();
		params = Collections.singletonList(new VarEntity("str", type));
		returnType = new VoidType();
		name = "print";
		putBuiltInFunc(toplevelScope, name, params, returnType);

		// type = new StringType(m4);
		// params = Collections.singletonList(new VarEntity("str", type));
		// returnType = nmew VoidType();
		name = "println";
		putBuiltInFunc(toplevelScope, name, params, returnType);

		// type = new VoidType();
		params = Arrays.asList();
		returnType = new StringType();
		name = "getString";
		putBuiltInFunc(toplevelScope, name, params, returnType);

		// type = new VoidType();
		// params = Arrays.asList();
		returnType = new IntType();
		name = "getInt";
		putBuiltInFunc(toplevelScope, name, params, returnType);

		type = new IntType();
		params = Collections.singletonList(new VarEntity("i", type));
		returnType = new StringType();
		name = "toString";
		putBuiltInFunc(toplevelScope, name, params, returnType);

		/** class builtIn funcs */
		Scope curScope;
		// array
		curScope = arrayEntity.getScope();
		type = new ArrayType(new NullType());
		// FIX: why need para??
		params = Arrays.asList(new VarEntity("__this", type));
		returnType = new IntType();
		name = "size";
		putBuiltInFunc(curScope, name, params, returnType);

		// string
		curScope = stringEntity.getScope();

		type = new StringType();
		params = Arrays.asList(new VarEntity("__this", type));
		returnType = new IntType();
		name = "length";
		putBuiltInFunc(curScope, name, params, returnType);

		// type = new StringType();
		params = Arrays.asList(new VarEntity("__this", type), new VarEntity("left", new IntType()),
				new VarEntity("right", new IntType()));
		returnType = new StringType();
		name = "substring";
		putBuiltInFunc(curScope, name, params, returnType);

		// type = new StringType();
		params = Arrays.asList(new VarEntity("__this", type));
		returnType = new IntType();
		name = "parseInt";
		putBuiltInFunc(curScope, name, params, returnType);

		// type = new StringType();
		params = Arrays.asList(new VarEntity("__this", type), new VarEntity("pos", new IntType()));

		// returnType = new IntType();
		name = "ord";
		putBuiltInFunc(curScope, name, params, returnType);

		// put into toplevelScope
		try {
			name = Scope.BuiltIn.ARRAY.toString();
			toplevelScope.put(name, arrayEntity);
			name = Scope.BuiltIn.STRING.toString();
			toplevelScope.put(name, stringEntity);
		} catch (SemanticException e) {
			throw new Error("Class name" + name + "is already defined");
		}
	}

	/**
	 * build builtIn funcs
	 * <p>
	 * From array, string
	 * <p>
	 * From global
	 * <p>
	 * Attention: FIX:BUG: these func dont have sub-scope!!!!!!!
	 */
	private void putBuiltInFunc(Scope curScope, String name, List<VarEntity> parameters, Type returnType) {
		FuncEntity entity = new FuncEntity(name, new FuncType(name), returnType);
		entity.params = parameters;
		entity.isBuiltIn = true;

		// FIX: why??
		if (!curScope.isToplevel())
			entity.isMember = true;

		// FIX: maybe no use
		// cause can not conflict
		try {
			curScope.put(name, entity);
		} catch (SemanticException e) {
			throw new Error("Fuck idiot!");
		}
	}

	// --------------- scope - stack -----------------------
	/** push without vars */
	private void pushScope() {
		LocalScope scope = new LocalScope(getCurScope());
		scopeStack.addLast(scope);
	}

	private void pushScope(LocalScope scope) {
		scopeStack.addLast(scope);
	}

	/**
	 * just pop, and get cur-poped scope Attention: have to judge if is the toplevel
	 * <p>
	 * Normally, it is not.(But what else ^_^)
	 */
	private Scope popScope() {
		return scopeStack.removeLast();
	}

	private Scope getCurScope() {
		return scopeStack.getLast();
	}

	// --------------- add List -----------------------
	protected final void visitStmtList(List<? extends StmtNode> stmts) {
		if (!stmts.isEmpty())
			for (StmtNode n : stmts)
				visit(n);
	}

	protected final void visitExprList(List<? extends ExprNode> exprs) {
		if (!exprs.isEmpty())
			for (ExprNode n : exprs)
				visit(n);
	}

	protected final void visitDeclList(List<? extends DeclNode> decls) {
		if (!decls.isEmpty())
			for (DeclNode n : decls)
				visit(n);
	}

}
