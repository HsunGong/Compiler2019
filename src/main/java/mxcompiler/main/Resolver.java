package mxcompiler.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import mxcompiler.utils.scope.*;
import mxcompiler.utils.entity.*;
import mxcompiler.type.*;

import mxcompiler.ast.statement.*;
import mxcompiler.error.CompileError;
import mxcompiler.error.SemanticError;
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
	private ClassEntity curClass; // UGLY: can also use a stack
	private int loop;
	private Type curReturnType;
	private FuncEntity curFuncEntity;
	// if no-return -> change to true;
	// if need return, change to false; and when has
	// return change to true

	public Resolver() {
		scopeStack = new LinkedList<Scope>();
		curClass = null;
		curReturnType = null;
		curFuncEntity = null;
		loop = 0;
	}

	/**
	 * start localresolver not main (cause use {@code this.visit(ASTNode node)}) or
	 * so called pre-scanner But just this top-level
	 * <p>
	 * add global-funcs, classes-funcs, classes - for only top decl FIX: not vars?
	 * 
	 * <p>
	 * class and function can not be override, and within sameScope, name can not be
	 * the same However, to support class.fun can be the same name as class and
	 * global fun, add special id with class name
	 */
	protected void resolve(ASTNode root) {
		if (!(getCurScope() instanceof ToplevelScope))
			throw new CompileError("toplevel");
		ToplevelScope toplevelScope = (ToplevelScope) getCurScope();

		putBuiltIn(toplevelScope);

		// add class and g-func
		if (!root.getDecl().isEmpty())
			for (DeclNode decl : root.getDecl()) {
				if (decl instanceof VarDeclNode)
					continue;
				resolve(decl);
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
		} catch (SemanticError e) {
			throw new Error("No main funcion");
		}
	}

	public void resolve(DeclNode node) {
		if (node instanceof VarDeclNode)
			resolve((VarDeclNode) node);// resolve((VarDeclNode) node);
		else if (node instanceof FuncDeclNode)
			resolve((FuncDeclNode) node);
		else if (node instanceof ClassDeclNode)
			resolve((ClassDeclNode) node);
	}

	/** add class func and class var here without check var */
	public void resolve(ClassDeclNode node) {
		try {
			ClassEntity entity = new ClassEntity((ClassDeclNode) node, getCurScope());
			if (!(getCurScope() instanceof ToplevelScope))
				throw new CompileError("toplevel");

			getCurScope().put(node.getName(), entity);

			pushScope(entity.getScope());
			curClass = entity;

			// currentClassScope = entity.getScope();
			// currentClassName = entity.getName();
			// currentOffset = 0;
			if (!node.getVar().isEmpty())
				for (VarDeclNode var : node.getVar())
					resolve(var);
			// entity.setMemorySize(currentOffset);

			if (!node.getFunc().isEmpty())
				for (FuncDeclNode fun : node.getFunc())
					resolve(fun);

			curClass = null;
			popScope();
		} catch (SemanticError e) {
			throw new Error("class Resolve " + e);
		}
	}

	/**
	 * not only add class.var, but global var
	 */
	public void resolve(VarDeclNode node) {
		try {
			VarEntity entity = (curClass == null) ? new VarEntity(node.getName(), node.getType().getType())
					: new VarEntity(node.getName(), node.getType().getType(), curClass.getName());

			entity.isGlobal = (getCurScope() instanceof ToplevelScope);

			/**
			 * TODO : get memorySize - for memory if (curClass != null)
			 * {entity.setAddrOffset(currentOffset); currentOffset +=
			 * node.getType().getType().getVarSize();}
			 */

			getCurScope().put(node.getName(), entity);
		} catch (SemanticError e) {
			throw new Error("var Resolve " + e);
		}
	}

	/**
	 * not only add class.func, but global func
	 */
	public void resolve(FuncDeclNode node) {
		try {
			if (curClass == null) { // global-fun
				if (!(getCurScope() instanceof ToplevelScope))
					throw new CompileError("toplevel");

				FuncEntity entity = new FuncEntity(node);
				getCurScope().put(node.getName(), entity);
			} else { // class-fun
				FuncEntity entity = new FuncEntity(node, node.getName());
				String key = curClass.getDomain() + node.getName();

				getCurScope().put(key, entity);
			}
		} catch (SemanticError e) {
			throw new Error("func Resolve " + e);
		}
	}

	@Override
	public void visit(ASTNode node) {
		ToplevelScope toplevelScope;
		toplevelScope = new ToplevelScope();
		scopeStack.add(toplevelScope);

		resolve(node);

		if (!node.getDecl().isEmpty()) {
			for (DeclNode decl : node.getDecl()) {
				visit(decl);
				if (decl instanceof VarDeclNode)
					resolve(decl);
			}
		}

		node.setScope((ToplevelScope) getCurScope());

		scopeStack.remove();
		if (!scopeStack.isEmpty())
			throw new CompileError("Scope stack err");

	}

	/** class scope */
	@Override
	public void visit(ClassDeclNode node) {
		if (!(getCurScope() instanceof ToplevelScope))
			throw new CompileError("toplevel");

		try {
			ClassEntity entity = (ClassEntity) getCurScope().get(node.getName());

			pushScope(entity.getScope());
			curClass = entity;// replaced by curClass = new ClassType(entity.getName());

			// means only this level
			// round 1 - check member vars
			visitDeclList(node.getVar());

			// round 2 - check functions
			visitDeclList(node.getFunc());

			// TODO: after resolve member, set Size
			// currentOffset = 0;
			// entity.setMemorySize(currentOffset);
			curClass = null;
			popScope();
		} catch (SemanticError e) {
			throw new Error("classEntity Check " + e);
		}
	}

	/**
	 * func scope is included in block-body
	 */
	@Override
	public void visit(FuncDeclNode node) {
		try {
			FuncEntity entity;

			if (curClass == null) {
				if (!(getCurScope() instanceof ToplevelScope))
					throw new CompileError("toplevel");
				entity = (FuncEntity) getCurScope().get(node.getName());
			} else
				entity = (FuncEntity) getCurScope().get(curClass.getDomain() + node.getName());

			curReturnType = entity.getReturnType();
			// check return Type
			if (!node.hasReturn()) { // may be construct
				// can not be construct 1-type
				if (curClass == null)
					throw new Error("Construct Function " + node.getName() + " do not belong to class");

				// can not be construct 2-type
				if (!node.getName().equals(curClass.getName()))
					throw new Error(
							"Function " + node.getName() + " should have a return type or construct name is wrong");
			} else {
				// check class exist
				if (curReturnType instanceof ClassType) {
					String name = ((ClassType) curReturnType).getName();
					if (!(getCurScope().get(name) instanceof ClassEntity))
						throw new CompileError("no such class");
				}

			}

			// to add scope first
			pushScope();
			/**
			 * ATTENTION:FIX: already add func name from global or from class-decl
			 * <p>
			 * class mem add __this; funcentity dont have __this; cause para dont need; use
			 * func-entity-body to have __this is enough
			 */
			if (curClass != null) {
				getCurScope().put("__this", new VarEntity("__this", curClass.getType()));
			}
			// Other-Parameters
			for (VarDeclNode var : node.getVar()) {
				visit(var); // check
				resolve(var); // add
			}

			// body
			node.getBody().setScope((LocalScope) getCurScope());
			popScope();

			visit(node.getBody());
			curReturnType = null;
		} catch (SemanticError e) {
			throw new Error("Func Entity check " + e);
		}
	}

	// check type
	@Override
	public void visit(TypeNode node) {
		try {
			if (node.getType() instanceof ClassType) {
				String typeName = ((ClassType) node.getType()).getName();
				if (!(getCurScope().get(typeName) instanceof ClassEntity))
					throw new CompileError("no such class");
			}
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	/**
	 * check variable of cur scope
	 * <p>
	 * attention: no add
	 */
	@Override
	public void visit(VarDeclNode node) {
		// try {
			visit(node.getType());

			// check init
			if (node.getInit() != null) {
				visit(node.getInit());

				boolean invalid; // init // UGLY: no need to check init-voidtype, cause never happen then
				if (node.getType().getType() instanceof VoidType || node.getInit().getType() instanceof VoidType)
					invalid = true;
				else if (node.getType().getType().isEqual(node.getInit().getType()))
					invalid = false;
				else if (node.getInit().getType() instanceof MNullType) // UGLY: can not use var without init
					invalid = !(node.getType().getType() instanceof ClassType
							|| node.getType().getType() instanceof ArrayType);
				else
					invalid = true;

				if (invalid)
					throw new Error("Invalid variable init value: expected " + node.getType().getType().toString()
							+ " but got " + node.getInit().getType().toString());
			}
		// } catch (SemanticError e) {
		// 	throw new Error("VarEntity Check " + e);
		// }
	}

	/**
	 * {@inheritDoc} temportory scope
	 * <p>
	 * {@literal add scope inside or outside} cause the block has order to define
	 * var, can not add var first
	 */
	@Override
	public void visit(BlockStmtNode node) {
		if (node.getScope() == null)
			node.setScope(new LocalScope(getCurScope())); // temportory scope
		pushScope(node.getScope());

		if (!node.getAll().isEmpty())
			for (Node n : node.getAll()) {
				visit(n);
				if (n instanceof VarDeclNode) {
					resolve((VarDeclNode) n); // add first, then check
				}
			}

		popScope();
	}

	// ------------------------------- type checking -------------------------------

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
		visit(node.getCond());
		// UGLY: maybe can check not to define cond-int again
		// CHECKING
		if (!(node.getCond().getType() instanceof BoolType))
			throw new Error("Condition expression of while loop statement should have type \"bool\"");

		++loop;
		visit(node.getBody());
		--loop;
	}

	@Override
	public void visit(ForStmtNode node) {
		visit(node.getCond());
		if (!(node.getCond().getType() instanceof BoolType))
			throw new Error("Condition expression of for loop statement should have type \"bool\"");

		visit(node.getInit());
		visit(node.getIncr());

		if (!node.getVar().isEmpty()) {
			pushScope();
			// visitDeclList(node.getVar());
			for (VarDeclNode var : node.getVar()) {
				resolve(var);
				visit(var);
			}
			popScope();

			if (!(node.getBody() instanceof BlockStmtNode))
				throw new CompileError("Body is not block");
			((BlockStmtNode) node.getBody()).setScope((LocalScope) getCurScope());
		}

		++loop;
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
		// UGLY: change all invalid into valid
		boolean invalid = false;
		visit(node.getExpr());

		if (node.getExpr() == null) {
			if (!(curReturnType instanceof NullType || curReturnType instanceof VoidType))
				invalid = true;
		} else {
			if (node.getExpr().getType() instanceof NullType || node.getExpr().getType() instanceof VoidType)
				invalid = true;
			else if (node.getExpr().getType() instanceof MNullType)
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
			throw new Error("Type " + node.getExpr().getType().toString() + " is not arrayType");

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
		Entity memEntity = null;

		// get mother class
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
			ClassEntity classEntity = (ClassEntity) scopeStack.getFirst().get(className);
			try {
				memEntity = classEntity.getScope().getCur(classEntity.getDomain() + node.getMember()); // NOTE: is //
																										// getCur
			} catch (Exception e) {
				memEntity = classEntity.getScope().getCur(node.getMember()); // NOTE: is getCur
				if (!(memEntity instanceof VarEntity))
					throw new Error("not varEntity of member");
			}

			// contain a funcall expr from before
			if (memEntity instanceof FuncEntity)
				curFuncEntity = (FuncEntity) memEntity;
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
			throw new Error(node.getExpr().getType().toString() + " is not funcall expr");

		// FIX: get funcEntity
		FuncEntity funcallEntity = curFuncEntity;
		node.funcEntity = funcallEntity;
		if (node.funcEntity == null) {
			throw new Error("May be never happen, but no cur func can be found");
		}

		// check param size
		int paraNum = funcallEntity.params.size();
		int firstParaIdx = node.funcEntity.isMember ? 1 : 0;
		if (paraNum - firstParaIdx != node.getParam().size())
			throw new Error(
					node.getLocation().toString() + "Function call has inconsistent number of arguments, expected "
							+ paraNum + " but got " + node.getParam().size());

		// check param type
		boolean invalid; // invalid of param type
		for (int i = 0; i < paraNum - firstParaIdx; ++i) {
			ExprNode curParam = node.getParam().get(i);
			VarEntity defParam = funcallEntity.params.get(i + firstParaIdx); // define in fun-decl
			visit(curParam);
			if (curParam.getType() instanceof VoidType) // UGLY: cause funcall-void
				invalid = true;
			else if (curParam.getType() instanceof MNullType)
				invalid = !(defParam.getType() instanceof ClassType || defParam.getType() instanceof ArrayType);
			else
				invalid = !(defParam.getType().isEqual(curParam.getType()));

			if (invalid) {
				throw new Error(curParam.getLocation().toString()
						+ "Function call has inconsistent type of arguments, expected " + defParam.getType().toString()
						+ " but got " + curParam.getType().toString());
			}
		}

		node.setType(funcallEntity.getReturnType());
		node.setIsLeftValue(false);
	}

	@Override
	public void visit(PrefixExprNode node) {
		ExprNode preExpr = node.getExpr(); // prefix-expr
		visit(preExpr);

		switch (node.getOp()) {
		case PRE_DEC:
		case PRE_INC:
			if (!(preExpr.getType() instanceof IntType))
				throw new Error("Operator " + node.getOp().toString() + " cannot be applied to type"
						+ preExpr.getType().toString());
			if (!(preExpr.isLeftValue()))
				throw new Error("Operator " + node.getOp().toString() + " cannot be applied to right value");

			node.setType(new IntType());
			node.setIsLeftValue(true);
			break;
		case POSI:
		case NEGA:
		case BIT_NOT:
			if (!(preExpr.getType() instanceof IntType))
				throw new Error("Operator " + node.getOp().toString() + " cannot be applied to type "
						+ preExpr.getType().toString());
			node.setType(new IntType());
			node.setIsLeftValue(false);
			break;
		case LOGIC_NOT:
			if (!(preExpr.getType() instanceof BoolType))
				throw new Error("Operator " + node.getOp().toString() + " cannot be applied to type "
						+ preExpr.getType().toString());
			node.setType(new BoolType());
			node.setIsLeftValue(false);
			break;
		default:
			throw new Error("Invalid prefix operator");
		}
	}

	@Override
	public void visit(NewExprNode node) {
		visit(node.getNewType());

		if (node.getDims() != null) {
			for (ExprNode dim : node.getDims()) {
				visit(dim);
				if (!(dim.getType() instanceof IntType)) {
					throw new Error("dimension size of array should be integer type");
				}
			}
		}
		// FIX: new construct ??

		node.setType(node.getNewType().getType());
		node.setIsLeftValue(false);
	}

	@Override
	public void visit(BinaryOpExprNode node) {
		visit(node.getLhs());
		visit(node.getRhs());
		Type lhsType = node.getLhs().getType();
		Type rhsType = node.getRhs().getType();

		switch (node.getOp()) {
		case MUL:
		case DIV:
		case MOD:
		case ADD:
			if (lhsType instanceof StringType && rhsType instanceof StringType) {
				node.setType(new StringType());
				node.setIsLeftValue(false);
				break;
			}
		case SUB:
		case SH_L:
		case SH_R:
		case BIT_OR:
		case BIT_AND:
		case BIT_XOR:
			if (!(lhsType instanceof IntType))
				throw new Error(node.getLocation().toString() + " Operator " + node.getOp().toString()
						+ " cannot be applied to type " + lhsType.toString());
			if (!(rhsType instanceof IntType))
				throw new Error(node.getLocation().toString() + "Operator " + node.getOp().toString()
						+ " cannot be applied to type " + rhsType.toString());

			node.setType(new IntType());
			node.setIsLeftValue(false);
			break;
		case GREATER:
		case LESS:
		case GREATER_EQUAL:
		case LESS_EQUAL:
			if (!(lhsType.isEqual(rhsType)))
				throw new Error(node.getLocation().toString() + "Operator " + node.getOp().toString()
						+ " cannot be applied to different types " + rhsType.toString() + " and " + lhsType.toString());
			if (!(lhsType instanceof IntType || lhsType instanceof StringType))
				throw new Error(
						"Operator " + node.getOp().toString() + " cannot be applied to type " + lhsType.toString());
			// UGLY: can del this
			if (!(rhsType instanceof IntType || rhsType instanceof StringType))
				throw new Error(
						"Operator " + node.getOp().toString() + " cannot be applied to type " + lhsType.toString());

			node.setType(new BoolType());
			node.setIsLeftValue(false);
			break;
		case EQUAL:
		case INEQUAL:
			boolean invalid;
			if (lhsType instanceof VoidType || rhsType instanceof VoidType)
				invalid = true;
			else if (lhsType.isEqual(rhsType))
				invalid = false;
			else if (lhsType instanceof MNullType)
				invalid = !(rhsType instanceof ClassType || rhsType instanceof ArrayType);
			else if (rhsType instanceof MNullType)
				invalid = !(lhsType instanceof ClassType || lhsType instanceof ArrayType);
			else
				invalid = true;

			if (invalid)
				throw new Error("Operator " + node.getOp().toString() + " cannot be applied to different types"
						+ lhsType.toString() + " and " + rhsType.toString());

			node.setType(new BoolType());
			node.setIsLeftValue(false);
			break;
		case LOGIC_OR:
		case LOGIC_AND:
			if (!(lhsType instanceof BoolType))
				throw new Error("Operator " + node.getOp().toString() + " cannot be applied to different types"
						+ lhsType.toString());
			if (!(rhsType instanceof BoolType))
				throw new Error("Operator " + node.getOp().toString() + " cannot be applied to different types"
						+ rhsType.toString());

			node.setType(new BoolType());
			node.setIsLeftValue(false);
			break;
		default:
			throw new Error("Invalid binary operator");
		}
	}

	@Override
	public void visit(AssignExprNode node) {
		visit(node.getLhs());
		visit(node.getRhs());
		Type lhsType = node.getLhs().getType();
		Type rhsType = node.getRhs().getType();

		if (!(node.getLhs().isLeftValue()))
			throw new Error("Lhs of assignment statement should be left value");

		boolean invalid;
		if (lhsType instanceof VoidType || rhsType instanceof VoidType)
			invalid = true;
		else if (lhsType.isEqual(rhsType))
			invalid = false;
		else if (rhsType instanceof MNullType)
			invalid = !(lhsType instanceof ClassType || lhsType instanceof ArrayType);
		else
			invalid = true;

		if (invalid)
			throw new Error("Assignment operator cannot be applied to different types " + lhsType.toString() + " and "
					+ rhsType.toString());

		// FIX: support for a = b = c
		node.setType(lhsType);
		node.setIsLeftValue(false);
	}

	@Override
	public void visit(IdentifierExprNode node) {
		try {
			String name = node.getIdentifier();
			Entity entity;

			// toplevel or class-level
			entity = getCurScope().getVarFun(name, (curClass == null) ? "" : curClass.getDomain());
			if (entity instanceof ClassEntity)
				throw new Error("get Idenfier as class");

			if (entity instanceof VarEntity) {
				node.entity = (VarEntity) entity;
				node.setIsLeftValue(true);
			} else if (entity instanceof FuncEntity) {
				curFuncEntity = (FuncEntity) entity;
				node.setIsLeftValue(false);
			} else
				throw new Error("Invalid entity type for identifier");

			node.setType(entity.getType());
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	@Override
	public void visit(ThisExprNode node) {
		try {
			// UGLY: how about add __this in class-scope not function-scope??
			Entity entity = getCurScope().get("__this");

			if (!(entity instanceof VarEntity))
				throw new Error("Invalid entity type for \"this\"");

			node.setIsLeftValue(false);
			node.setType(entity.getType());
		} catch (Exception e) {
			throw new Error(e);
		}

	}

	@Override
	public void visit(IntLiteralExprNode node) {
		node.setType(new IntType());
		node.setIsLeftValue(false);
	}

	@Override
	public void visit(StringLiteralExprNode node) {
		node.setType(new StringType());
		node.setIsLeftValue(false);
	}

	@Override
	public void visit(BoolLiteralExprNode node) {
		node.setType(new BoolType());
		node.setIsLeftValue(false);
	}

	@Override
	public void visit(NullExprNode node) {
		node.setType(new MNullType());
		node.setIsLeftValue(false);
	}

	// ------------- build-in classes and functions ---------------
	/** add BuiltIn func and BuiltIn class */
	private void putBuiltIn(ToplevelScope toplevelScope) {
		String name;
		Type type;
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
		// array
		name = Scope.BuiltIn.ARRAY.toString();
		type = new ClassType(name);
		ClassEntity arrayEntity = new ClassEntity(name, type, toplevelScope);
		curClass = arrayEntity;
		{
			type = new ArrayType(new NullType());
			params = Arrays.asList(new VarEntity("__this", type));
			returnType = new IntType();
			name = "size";
			putBuiltInFunc(arrayEntity.getScope(), name, params, returnType);
		}
		curClass = null;

		// string
		name = Scope.BuiltIn.STRING.toString();
		type = new ClassType(name);
		ClassEntity stringEntity = new ClassEntity(name, type, toplevelScope);
		curClass = stringEntity;
		{
			type = new StringType();
			params = Arrays.asList(new VarEntity("__this", type));
			returnType = new IntType();
			name = "length";
			putBuiltInFunc(stringEntity.getScope(), name, params, returnType);

			// type = new StringType();
			params = Arrays.asList(new VarEntity("__this", type), new VarEntity("left", new IntType()),
					new VarEntity("right", new IntType()));
			returnType = new StringType();
			name = "substring";
			putBuiltInFunc(stringEntity.getScope(), name, params, returnType);

			// type = new StringType();
			params = Arrays.asList(new VarEntity("__this", type));
			returnType = new IntType();
			name = "parseInt";
			putBuiltInFunc(stringEntity.getScope(), name, params, returnType);

			// type = new StringType();
			params = Arrays.asList(new VarEntity("__this", type), new VarEntity("pos", new IntType()));

			// returnType = new IntType();
			name = "ord";
			putBuiltInFunc(stringEntity.getScope(), name, params, returnType);
		}
		curClass = null;

		// put into toplevelScope
		try {
			name = Scope.BuiltIn.ARRAY.toString();
			toplevelScope.put(name, arrayEntity);
			name = Scope.BuiltIn.STRING.toString();
			toplevelScope.put(name, stringEntity);
		} catch (SemanticError e) {
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

		if (!curScope.isToplevel())
			entity.isMember = true;

		try {
			if (curClass == null)
				curScope.put(name, entity);
			else {
				entity.isMember = true;
				entity.className = curClass.getName();
				curScope.put(curClass.getDomain() + name, entity);
			}
		} catch (SemanticError e) {
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
