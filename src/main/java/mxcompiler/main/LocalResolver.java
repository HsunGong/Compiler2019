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

public class LocalResolver extends Visitor {
	/** means can not change LinkedList's type */
	private final LinkedList<Scope> scopeStack;
	// private int isInLoop = 0;
	// private ClassTypeNode currentClass;
	// private FuncTypeNode currentFunc;

	public LocalResolver() {
		scopeStack = new LinkedList<Scope>();
	}

	/** start localresolver main-func
	 * or so called pre-scanner
	 * But just this top-level
	 * <p> add funcs, classes - for only top decl
	 * FIX: why not top vars?
	 */
	public void resolve(ASTNode root) {
		ToplevelScope toplevelScope; // FIX:??no need to add to member
		toplevelScope = new ToplevelScope();
		scopeStack.add(toplevelScope);

		putBuiltIn(toplevelScope);
		if (!root.getDecl().isEmpty())
			for (DeclNode decl : root.getDecl()) {
				if (decl instanceof VarDeclNode)
					continue; // FIX: what is this ? can add now!!
				if (decl instanceof FuncDeclNode)
					resolve((FuncDeclNode) decl, toplevelScope);
				if (decl instanceof ClassDeclNode)
					resolve((ClassDeclNode) decl, toplevelScope);
			}

		try {
			checkMainFunc((FuncEntity) toplevelScope.get("main"));
		} catch (SemanticException e) {
			throw new Error("No main funcion");
		}

	}
	private void resolve(FuncDeclNode node, ToplevelScope toplevelScope) {

	private void resolve(FuncDeclNode node, ToplevelScope toplevelScope) {
		Entity entity = new FuncEntity(node);
		try {
			toplevelScope.put(node.getName(), entity);
		} catch (SemanticException e) {
			throw new Error(e);
		}
	}

	private void resolve(ClassDeclNode node, ToplevelScope toplevelScope) {
		Entity entity = new ClassEntity(node, toplevelScope);
		try {
			toplevelScope.put(node.getName(), entity);
		} catch (SemanticException e) {
			throw new Error(e);
		}
	}

	protected void checkVarDeclInit(VarDeclNode node) {
		if (node.getInit() != null) {
			node.getInit().accept(this);
			boolean invalidInitType;
			if (node.getType().getType() instanceof VoidType || node.getInit().getType() instanceof VoidType)
				invalidInitType = true;
			else if (node.getType().getType().equals(node.getInit().getType()))
				invalidInitType = false;
			else if (node.getInit().getType() instanceof NullType)
				invalidInitType = !(node.getType().getType() instanceof ClassType
						|| node.getType().getType() instanceof ArrayType);
			else
				invalidInitType = true;
			if (invalidInitType)
				throw new Error("Invalid initialization value" + "expected" + node.getType().getType().toString()
						+ " but got " + node.getInit().getType().toString());
		}
	}

	// ------------- build-in classes and functions ---------------
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

		// type = new StringType();
		// params = Collections.singletonList(new VarEntity("str", type));
		// returnType = new VoidType();
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
		params = Arrays.asList(new VarEntity("__this", type));
		params.add(new VarEntity("left", new IntType()));
		params.add(new VarEntity("right", new IntType()));
		returnType = new StringType();
		name = "substring";
		putBuiltInFunc(curScope, name, params, returnType);

		// type = new StringType();
		params = Arrays.asList(new VarEntity("__this", type));
		returnType = new IntType();
		name = "parseInt";
		putBuiltInFunc(curScope, name, params, returnType);

		// type = new StringType();
		params = Arrays.asList(new VarEntity("__this", type));
		params.add(new VarEntity("pos", new IntType()));
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
	 */
	private void putBuiltInFunc(Scope curScope, String name, List<VarEntity> parameters, Type returnType) {
		FuncEntity entity = new FuncEntity(name, new FuncType(name));
		entity.params = parameters;
		entity.returnType = returnType;
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

	// check main is exist
	private void checkMainFunc(FuncEntity mainFunc) {
		if (mainFunc == null)
			throw new Error("\"main\" function not found");
		if (!(mainFunc.returnType instanceof IntType))
			throw new Error("\"main\" function's return type should be \"int\"");
		if (!mainFunc.params.isEmpty())
			throw new Error("\"main\" function should have no parameter");
	}

}
