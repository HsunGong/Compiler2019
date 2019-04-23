package mxcompiler.main;

import java.util.*;

import mxcompiler.utils.Tool;
import mxcompiler.utils.entity.*;
import mxcompiler.utils.scope.*;
import mxcompiler.utils.type.*;

import mxcompiler.error.*;

import mxcompiler.ast.*;
import mxcompiler.ast.statement.*;
import mxcompiler.ast.declaration.*;
import mxcompiler.ast.expression.*;
import mxcompiler.ast.expression.literal.*;
import mxcompiler.ast.expression.lhs.*;
import mxcompiler.ast.expression.unary.*;

import mxcompiler.ir.*;
import mxcompiler.ir.instruction.*;
import mxcompiler.ir.register.*;


/**
 * The whole IR is built under Control Flow Graph Considered
 * no SSA, no tree
 */
public class IRBuilder implements ASTVisitor {

    private Root root = new Root();

    private ToplevelScope toplevelScope;
    private List<GlobalVarInit> globalInitList = new ArrayList<>();

    private ClassEntity curClass = null;
    private Function curFunc = null;
    private BasicBlock curBB = null;
    private BasicBlock curLoopStepBB, curLoopAfterBB; // cur
    private Scope curScope;
    private boolean curWantAddr = false;

    private boolean isFuncArgDecl = false;

    private boolean assignLhs = false;
    private boolean uselessStatic = false;

    public IRBuilder() {
    }

    // region visit

    public void visit(ASTNode node) {
        toplevelScope = node.getScope();
        curScope = toplevelScope;

        // add funcs
        for (DeclNode decl : node.getDecl()) {
            if (decl instanceof FuncDeclNode) {
                Entity entity = curScope.get(decl.getName());
                Function newIRFunc = new Function((FuncEntity) entity);
                root.putFunc(newIRFunc);
            } else if (decl instanceof ClassDeclNode) {
                ClassEntity entity = (ClassEntity) curScope.get(decl.getName());
                curScope = entity.getScope();
                curClass = entity;
                for (FuncDeclNode func : ((ClassDeclNode) decl).getFunc()) {
                    Entity funcEntity = curScope.get(curClass.getDomain() + func.getName());
                    Function newIRFunc = new Function((FuncEntity) funcEntity);
                    root.putFunc(newIRFunc);
                }
                curClass = null;
                curScope = curScope.getParent();
            }
        }

        // add global init list
        for (DeclNode decl : node.getDecl())
            if (decl instanceof VarDeclNode)
                visit(decl);
        // FIX: add global init in resolver
        visit(makeGlobalVarInit()); // has order, have to do at first

        for (DeclNode decl : node.getDecl())
            if (!(decl instanceof VarDeclNode))
                visit(decl);

        // for (Function irFunction : root.getFunc().values())
        // irFunction.updateCalleeSet();
        // root.updateCalleeSet();
    }

    public void visit(VarDeclNode node) {
        VarEntity entity = (VarEntity) curScope.get(node.getName());
        if (entity.unUsed)
            return;

        if (curScope == toplevelScope) { // global var
            StaticData data = new StaticVar(node.getName(), RegValue.RegSize);
            root.putStaticData(data); // has order
            if (node.getInit() != null) {
                GlobalVarInit init = new GlobalVarInit(node.getName(), node.getInit());
                globalInitList.add(init); // has order
            }
        } else { // other var
            VirtualRegister vreg = new VirtualRegister(node.getName());
            entity.register = vreg;

            if (isFuncArgDecl)
                curFunc.argVReg.add(vreg);

            if (node.getInit() == null) {
                if (!isFuncArgDecl) {
                    // curBB.addInst(new Move(curBB, vreg, new IntImm(0)));
                    System.out.println("Node init with args");
                }
            } else {
                // a init var; not literal
                if (node.getInit().getType() instanceof BoolType && !(node.getInit() instanceof BoolLiteralExprNode)) {
                    node.getInit().setThen(new BasicBlock(curFunc, null));
                    node.getInit().setElse(new BasicBlock(curFunc, null));
                }

                visit(node.getInit());
                processIRAssign(vreg, 0, node.getInit(), node.getInit().getType().getRegSize(), false);
            }
        }
    }

    public void visit(ClassDeclNode node) {
        if (curScope == toplevelScope)
            throw new CompileError("ClassDecl Have to be toplevelScope in IRBuilder");
        curClass = (ClassEntity) toplevelScope.get(node.getName());

        for (FuncDeclNode decl : node.getFunc())
            visit(decl);

        curClass = null;
    }

    public void visit(FuncDeclNode node) {
        String name = (curClass == null) ? node.getName() : curClass.getDomain() + node.getName();
        curFunc = root.getFunc(name);
        if (curFunc == null)
            throw new CompileError("Can not find funcdecl in ir:" + name);
        curBB = curFunc.initStart();

        Scope tmp = curScope;
        curScope = node.getBody().getScope(); // func-block-scope
        // region params

        if (curClass != null) { // deal this
            VarEntity entity = (VarEntity) curScope.get(Scope.BuiltIn.THIS.toString());

            VirtualRegister vreg = new VirtualRegister(Scope.BuiltIn.THIS.toString());
            entity.register = vreg;
            curFunc.argVReg.add(vreg);
        }
        isFuncArgDecl = true; // deal other param
        for (VarDeclNode argDecl : node.getVar())
            visit(argDecl);
        isFuncArgDecl = false;
        // endregion
        curScope = tmp;

        // region add inst
        // global init func
        if (node.getName().equals("main"))
            curBB.addInst(new Funcall(curBB, root.getFunc(INIT_FUNC_NAME), new ArrayList<>(), null));

        visit(node.getBody());

        // final-return (may have other return in other blocks)
        if (!curBB.hasJump()) { // return type
            if (node.getReturnType().getType() instanceof NullType
                    || node.getReturnType().getType() instanceof VoidType)
                curBB.setJump(new Return(curBB, null));
            else // has return value fix: todo: why need intImm ??
                curBB.setJump(new Return(curBB, new IntImm(0)));
        }

        // merge multiple return instructions to a single end basic
        // block
        if (curFunc.returns.size() > 1) {
            BasicBlock mergeEnd = new BasicBlock(curFunc, curFunc.getName() + "_end");

            // set return value
            VirtualRegister retReg;
            if (node.getReturnType().getType() instanceof NullType
                    || node.getReturnType().getType() instanceof VoidType)
                retReg = null;
            else
                retReg = new VirtualRegister("return_value");

            // transfer return block to jump block
            List<Return> retList = new ArrayList<>(curFunc.returns);
            for (Return ret : retList) {
                BasicBlock beforeRet = ret.getParent();
                beforeRet.delInst(ret);

                if (ret.getReturnVal() != null) { // add move to reg
                    Move tmpInst = new Move(beforeRet, retReg, ret.getReturnVal());
                    beforeRet.addInst(tmpInst);
                }

                beforeRet.setJump(new Jump(beforeRet, mergeEnd));
            }

            mergeEnd.setJump(new Return(mergeEnd, retReg));
            curFunc.end = mergeEnd;
        } else
            curFunc.end = curFunc.returns.get(0).getParent();
        // endregion

        curBB = null;
        curFunc = null;
    }

    // region ----------------- global var func-init
    // ------------------
    // NOTE: make global var init as a function
    private final String INIT_FUNC_NAME = "_init_func";

    private FuncDeclNode makeGlobalVarInit() {
        if (toplevelScope != curScope)
            throw new CompileError("Error when global var init");

        // exprs may used in global init
        List<Node> stmts = new ArrayList<>();
        for (GlobalVarInit init : globalInitList) {
            VarEntity entity = (VarEntity) toplevelScope.get(init.getName());

            IdentifierExprNode lhs = new IdentifierExprNode(init.getName(), null);
            lhs.entity = entity;

            AssignExprNode assignExpr = new AssignExprNode(lhs, init.getExpr(), null);
            stmts.add(new ExprStmtNode(assignExpr, null));
        }

        BlockStmtNode body = new BlockStmtNode(stmts, null);
        body.setScope(new LocalScope(toplevelScope));

        TypeNode returnType = new TypeNode(new VoidType(), null);
        List<VarDeclNode> params = new ArrayList<>();
        FuncDeclNode funcNode = new FuncDeclNode(INIT_FUNC_NAME, returnType, params, body, null);
        FuncEntity funcEntity = new FuncEntity(funcNode);
        toplevelScope.put(INIT_FUNC_NAME, funcEntity);

        Function newIRFunc = new Function(funcEntity);
        root.putFunc(newIRFunc);
        return funcNode;
    }
    // endregion

    // region stmt

    /**
     * set basicblock inside the stmt not block-stmt set new
     * block outside block not the block-stmt
     */
    public void visit(BlockStmtNode node) {
        curScope = node.getScope();

        for (Node stmt : node.getAll()) {
            visit(stmt); // vardecl or stmt
            if (curBB.hasJump())
                break;
        }

        curScope = curScope.getParent();
    }

    public void visit(BreakStmtNode node) {
        curBB.setJump(new Jump(curBB, curLoopAfterBB));
    }

    public void visit(ContinueStmtNode node) {
        curBB.setJump(new Jump(curBB, curLoopStepBB));
    }

    public void visit(ForStmtNode node) {
        BasicBlock condBB, incrBB, bodyBB, afterBB;
        ExprNode cond = node.getCond(), incr = node.getIncr();

        bodyBB = new BasicBlock(curFunc, "for_body");
        condBB = (cond != null) ? new BasicBlock(curFunc, "for_cond") : bodyBB;
        // FIX::?? why and why not bodyBB?
        incrBB = (incr != null) ? new BasicBlock(curFunc, "for_incr") : condBB;
        afterBB = new BasicBlock(curFunc, "for_after");
        condBB.forNode = incrBB.forNode = bodyBB.forNode = afterBB.forNode = node;

        root.forRecMap.put(node, new Root.ForRecord(condBB, incrBB, bodyBB, afterBB));

        // TODO: change into stack
        BasicBlock tmpLoopStepBB = curLoopStepBB;
        BasicBlock tmpLoopAfterBB = curLoopAfterBB;
        curLoopStepBB = incrBB;
        curLoopAfterBB = afterBB;
        // region deal loop

        if (node.getInit() != null) // can not put in body-BB
            visit(node.getInit());

        curBB.setJump(new Jump(curBB, condBB));

        if (cond != null) {
            curBB = condBB;
            cond.setThen(bodyBB);
            cond.setElse(afterBB);
            visit(cond);

            if (cond instanceof BoolLiteralExprNode)
                curBB.setJump(new CJump(curBB, cond.regValue, cond.getThen(), cond.getElse()));
            else
                throw new CompileError("For condition without bool");
        }

        if (incr != null) { // can not put in body-BB
            curBB = incrBB;
            visit(incr);
            curBB.setJump(new Jump(curBB, condBB));
        }

        curBB = bodyBB;
        if (node.getBody() != null)
            visit(node.getBody());
        if (!curBB.hasJump())
            curBB.setJump(new Jump(curBB, incrBB));
        curBB = afterBB;

        // endregion
        curLoopStepBB = tmpLoopStepBB;
        curLoopAfterBB = tmpLoopAfterBB;
    }

    public void visit(WhileStmtNode node) {
        BasicBlock condBB, bodyBB, afterBB;
        condBB = new BasicBlock(curFunc, "while_cond");
        bodyBB = new BasicBlock(curFunc, "while_body");
        afterBB = new BasicBlock(curFunc, "while_after");

        BasicBlock tmpLoopStepBB = curLoopStepBB;
        BasicBlock tmpLoopAfterBB = curLoopAfterBB;
        curLoopStepBB = condBB;
        curLoopAfterBB = afterBB;

        curBB.setJump(new Jump(curBB, condBB));
        curBB = condBB;
        ExprNode cond = node.getCond();
        cond.setThen(bodyBB);
        cond.setElse(afterBB);
        visit(cond);
        if (cond instanceof BoolLiteralExprNode)
            curBB.setJump(new CJump(curBB, cond.regValue, cond.getThen(), cond.getElse()));

        curBB = bodyBB;
        visit(node.getBody());
        if (!curBB.hasJump())
            curBB.setJump(new Jump(curBB, condBB));

        curLoopStepBB = tmpLoopStepBB;
        curLoopAfterBB = tmpLoopAfterBB;

        curBB = afterBB;
    }

    public void visit(IfStmtNode node) {
        BasicBlock thenBB, elseBB, afterBB;
        thenBB = new BasicBlock(curFunc, "if_then");
        elseBB = (node.getElse() == null) ? null : new BasicBlock(curFunc, "if_else");
        afterBB = new BasicBlock(curFunc, "if_after");

        // cond
        ExprNode cond = node.getCond();
        cond.setThen(thenBB);
        cond.setElse((node.getElse() == null) ? afterBB : elseBB);
        visit(cond);
        if (cond instanceof BoolLiteralExprNode)
            curBB.setJump(new CJump(curBB, cond.regValue, cond.getElse(), cond.getThen()));

        // then
        curBB = thenBB;
        visit(node.getThen());
        if (!curBB.hasJump())
            curBB.setJump(new Jump(curBB, afterBB));

        // else
        if (node.getElse() != null) {
            curBB = elseBB;
            visit(node.getElse());
            if (!curBB.hasJump())
                curBB.setJump(new Jump(curBB, afterBB));
        }

        curBB = afterBB;
    }

    public void visit(ReturnStmtNode node) {
        Type type = curFunc.getEntity().getReturnType();

        if (type instanceof NullType || type instanceof VoidType) {
            curBB.setJump(new Return(curBB, null));

        } else {
            ExprNode expr = node.getExpr();
            if (type instanceof BoolType && !(expr instanceof BoolLiteralExprNode)) {
                expr.setThen(new BasicBlock(curFunc, null));
                expr.setElse(new BasicBlock(curFunc, null));
                visit(expr);

                VirtualRegister vreg = new VirtualRegister("ret_bool_value");
                // set assign to vreg
                processIRAssign(vreg, 0, node.getExpr(), RegValue.RegSize, false);
                curBB.setJump(new Return(curBB, vreg));
            } else {
                visit(expr);
                curBB.setJump(new Return(curBB, expr.regValue));
            }
        }
    }

    // endregion

    public void visit(ArefExprNode node) {
        boolean tmpWantAddr = curWantAddr;
        curWantAddr = false;

        visit(node.getExpr());
        if (uselessStatic)
            return;
        assignLhs = false;
        visit(node.getIndex());

        curWantAddr = tmpWantAddr;

        VirtualRegister vreg = new VirtualRegister(null);
        IntImm elementSize = new IntImm(node.getType().getRegSize());
        // size of this level
        // FIX: BUG: what is this ?
        curBB.addInst(new Bin(curBB, vreg, BinaryOpExprNode.Op.MUL, node.getIndex().regValue, elementSize));
        curBB.addInst(new Bin(curBB, vreg, BinaryOpExprNode.Op.ADD, node.getExpr().regValue, vreg));

        if (curWantAddr) {
            node.addrValue = vreg;
            node.offset = RegValue.RegSize;
        } else {
            curBB.addInst(new Load(curBB, vreg, node.getType().getRegSize(), vreg, RegValue.RegSize));

            node.regValue = vreg;
            if (node.getThen() != null)
                curBB.setJump(new CJump(curBB, node.regValue, node.getThen(), node.getElse()));
        }
    }

    public void visit(MemberExprNode node) {
        boolean tmpWantAddr = curWantAddr;
        curWantAddr = false;

        visit(node.getExpr());
        assignLhs = false;

        curWantAddr = tmpWantAddr;

        RegValue classAddr = node.getExpr().regValue;
        String className = ((ClassType) (node.getExpr().getType())).getName();

        ClassEntity classEntity = (ClassEntity) toplevelScope.get(className);
        VarEntity memberEntity = (VarEntity) classEntity.getScope().getCur(node.getMember());

        if (curWantAddr) {
            node.addrValue = classAddr;
            node.offset = memberEntity.offset;
        } else {
            VirtualRegister vreg = new VirtualRegister(null);
            node.regValue = vreg;
            curBB.addInst(new Load(curBB, vreg, memberEntity.getType().getRegSize(), classAddr, memberEntity.offset));
            if (node.getThen() != null)
                curBB.setJump(new CJump(curBB, node.regValue, node.getThen(), node.getElse()));
        }
    }

    public void visit(FuncallExprNode node) {
        FuncEntity entity = node.funcEntity;
        String keyName = entity.getName();
        List<RegValue> args = new ArrayList<>();
        ExprNode thisExpr = null;

        if (entity.isMember()) {
            if (node.getExpr() instanceof MemberExprNode) { // has more member
                thisExpr = ((MemberExprNode) (node.getExpr())).getExpr();
            } else { // last level of member
                if (curClass == null)
                    throw new CompileError("invalid member function call of this pointer");

                thisExpr = new ThisExprNode(null);
                thisExpr.setType(curClass.getType());
            }
            visit(thisExpr);

            String className;
            if (thisExpr.getType() instanceof ClassType)
                className = ((ClassType) (thisExpr.getType())).getName();
            else if (thisExpr.getType() instanceof ArrayType)
                className = Scope.BuiltIn.ARRAY.toString();
            else
                className = Scope.BuiltIn.STRING.toString();

            keyName = className + Scope.BuiltIn.DOMAIN.toString() + keyName;
            args.add(thisExpr.regValue);
        }

        // process built-in functions
        if (entity.isBuiltIn) {
            processBuiltInFuncCall(node, thisExpr, entity, keyName);
            return;
        }

        // params -- args
        for (ExprNode arg : node.getParam()) {
            visit(arg);
            args.add(arg.regValue);
        }

        Function func = root.getFunc(keyName);
        VirtualRegister vreg = new VirtualRegister(null);
        curBB.addInst(new Funcall(curBB, func, args, vreg));
        node.regValue = vreg;

        if (node.getThen() != null) // FIX: getElse == null ?
            curBB.setJump(new CJump(curBB, node.regValue, node.getThen(), node.getElse()));
    }

    public void visit(AssignExprNode node) {
        boolean needMemOp = isMemoryAccess(node.getLhs());
        curWantAddr = needMemOp;
        assignLhs = true;

        uselessStatic = false;
        visit(node.getLhs());

        assignLhs = false;
        curWantAddr = false;

        if (uselessStatic) {
            uselessStatic = false;
            return;
        }

        if (node.getRhs().getType() instanceof BoolType && !(node.getRhs() instanceof BoolLiteralExprNode)) {
            node.getRhs().setThen(new BasicBlock(curFunc, null));
            node.getRhs().setElse(new BasicBlock(curFunc, null));
        }
        visit(node.getRhs());

        RegValue destion;
        int addrOffset;
        if (needMemOp) {
            destion = node.getLhs().addrValue;
            addrOffset = node.getLhs().offset;
        } else {
            destion = node.getLhs().regValue;
            addrOffset = 0;
        }

        processIRAssign(destion, addrOffset, node.getRhs(), RegValue.RegSize, needMemOp);
        node.regValue = node.getRhs().regValue;
    }

    public void visit(NewExprNode node) {
        VirtualRegister vreg = new VirtualRegister(null);
        Type newType = node.getNewType().getType();
        if (newType instanceof ClassType) {
            String className = ((ClassType) newType).getName();
            ClassEntity classEntity = (ClassEntity) globalScope.get(Scope.classKey(className));
            currentBB.addInst(new IRHeapAlloc(currentBB, vreg, new IntImmediate(classEntity.getMemorySize())));
            //  call construction function
            String funcName = IRRoot.irMemberFuncName(className, className);
            IRFunction irFunc = ir.getFunc(funcName);
            if (irFunc != null) {
                List<RegValue> args = new ArrayList<>();
                args.add(vreg);
                currentBB.addInst(new IRFunctionCall(currentBB, irFunc, args, null));
            }
        } else if (newType instanceof ArrayType) {
            processArrayNew(node, vreg, null, 0);
        } else {
            throw new CompilerError("invalid new type");
        }
        node.setRegValue(vreg);
    }

    public void visit(BinaryOpExprNode node) {
    }

    public void visit(PrefixExprNode node) {
    }

    public void visit(SuffixExprNode node) {
        processSelfIncDec(node.getExpr(), node, true, node.getOp() == SuffixExprNode.Op.SUF_INC);
    }

    public void visit(BoolLiteralExprNode node) {
    }

    public void visit(IntLiteralExprNode node) {
    }

    public void visit(StringLiteralExprNode node) {
    }

    public void visit(IdentifierExprNode node) {
    }

    public void visit(NullExprNode node) {
    }

    public void visit(ThisExprNode node) {
    }

    // region useless

    public void visit(LhsExprNode node) {
        node.accept(this);
    }

    public void visit(Node node) {
        node.accept(this);
    }

    public void visit(TypeNode node) {
        node.accept(this);
    }

    public void visit(DeclNode node) {
        node.accept(this);
    }

    public void visit(ExprNode node) {
        node.accept(this);
    }

    public void visit(StmtNode node) {
        node.accept(this);
    }

    public void visit(VarDeclListNode node) {
        throw new CompileError("IR error with vardecl list");
    }

    public void visit(ExprStmtNode node) {
        visit(node.getExpr());
    }
    // endregion

    // endregion

    // region utils

    /**
     * set rhs.value to destion
     * <p>
     * maybe (split to then or else)add this block into curBB
     * Assign, return, varInit
     */
    private void processIRAssign(RegValue destion, int addrOffset, ExprNode rhs, int size, boolean needMemOp) {
        BasicBlock thenBB, elseBB;
        thenBB = rhs.getThen();
        elseBB = rhs.getElse();

        if (thenBB != null) { // has branch
            BasicBlock mergeBB = new BasicBlock(curFunc, null);
            if (needMemOp) {
                thenBB.addInst(new Store(thenBB, new IntImm(1), RegValue.RegSize, destion, addrOffset));
                elseBB.addInst(new Store(elseBB, new IntImm(0), RegValue.RegSize, destion, addrOffset));
            } else {
                thenBB.addInst(new Move(thenBB, (VirtualRegister) destion, new IntImm(1)));
                elseBB.addInst(new Move(elseBB, (VirtualRegister) destion, new IntImm(0)));
            }

            if (!thenBB.hasJump())
                thenBB.setJump(new Jump(thenBB, mergeBB));
            if (!elseBB.hasJump())
                elseBB.setJump(new Jump(elseBB, mergeBB));

            curBB = mergeBB;
        } else { // no branch

            if (needMemOp)
                curBB.addInst(new Store(curBB, rhs.regValue, RegValue.RegSize, destion, addrOffset));
            else
                curBB.addInst(new Move(curBB, (Register) destion, rhs.regValue));
        }
    }

    private void processSelfIncDec(ExprNode expr, ExprNode node, boolean isSuffix, boolean isInc) {
    }

    // print(A + B); -> print(A); print(B);
    // println(A + B); -> print(A); println(B);
    private void processPrintFuncCall(ExprNode arg, String funcName) {
        if (arg instanceof BinaryOpExprNode) {
            processPrintFuncCall(((BinaryOpExprNode) arg).getLhs(), "print");
            processPrintFuncCall(((BinaryOpExprNode) arg).getRhs(), funcName);
            return;
        }

        Function calleeFunc;
        List<RegValue> vArgs = new ArrayList<>();
        // FIX: needed to add printINT
        if (arg instanceof FuncallExprNode && ((FuncallExprNode) arg).funcEntity.getName() == "toString") {
            // print(toString(n)); -> printInt(n);
            ExprNode intExpr = ((FuncallExprNode) arg).getParam().get(0);
            visit(intExpr);
            calleeFunc = root.getBuiltInFunc(funcName + "Int");
            vArgs.add(intExpr.regValue);
        } else {
            visit(arg);
            calleeFunc = root.getBuiltInFunc(funcName);
            vArgs.add(arg.regValue);
        }

        curBB.addInst(new Funcall(curBB, calleeFunc, vArgs, null));
    }

    private void processBuiltInFuncCall(FuncallExprNode node, ExprNode thisExpr, FuncEntity entity, String keyName) {
        boolean tmpWantAddr = curWantAddr;
        curWantAddr = false;

        ExprNode arg0, arg1;
        VirtualRegister vreg;
        Function calleeFunc;
        List<RegValue> vArgs = new ArrayList<>();

        switch (keyName) {
        case Tool.PRINT_KEY:
        case Tool.PRINTLN_KEY:
            arg0 = node.getParam().get(0); // have to be string
            processPrintFuncCall(arg0, keyName);
            break;

        case Tool.GETSTRING_KEY:
            vreg = new VirtualRegister("getString");
            vArgs.clear();

            calleeFunc = root.getBuiltInFunc(keyName);
            curBB.addInst(new Funcall(curBB, calleeFunc, vArgs, vreg));
            node.regValue = vreg;
            break;

        case Tool.GETINT_KEY:
            vreg = new VirtualRegister("getInt");
            vArgs.clear();

            calleeFunc = root.getBuiltInFunc(keyName);
            curBB.addInst(new Funcall(curBB, calleeFunc, vArgs, vreg));
            node.regValue = vreg;
            break;

        case Tool.TOSTRING_KEY:
            arg0 = node.getParam().get(0);
            visit(arg0);

            vreg = new VirtualRegister("toString");
            vArgs.clear();
            vArgs.add(arg0.regValue);

            calleeFunc = root.getBuiltInFunc(keyName);
            curBB.addInst(new Funcall(curBB, calleeFunc, vArgs, vreg));
            node.regValue = vreg;
            break;

        case Tool.SUBSTRING_KEY:
            arg0 = node.getParam().get(0);
            visit(arg0);
            arg1 = node.getParam().get(1);
            visit(arg1);

            vreg = new VirtualRegister("subString");
            vArgs.clear();
            vArgs.add(thisExpr.regValue);
            vArgs.add(arg0.regValue);
            vArgs.add(arg1.regValue);

            calleeFunc = root.getBuiltInFunc(keyName);
            curBB.addInst(new Funcall(curBB, calleeFunc, vArgs, vreg));
            node.regValue = vreg;
            break;

        case Tool.PARSEINT_KEY:
            vreg = new VirtualRegister("parseInt");
            vArgs.clear();
            vArgs.add(thisExpr.regValue);

            calleeFunc = root.getBuiltInFunc(keyName);
            curBB.addInst(new Funcall(curBB, calleeFunc, vArgs, vreg));
            node.regValue = vreg;
            break;

        case Tool.ORD_KEY:
            arg0 = node.getParam().get(0);
            visit(arg0);

            vreg = new VirtualRegister("ord");
            vArgs.clear();
            vArgs.add(thisExpr.regValue);
            vArgs.add(arg0.regValue);

            calleeFunc = root.getBuiltInFunc(keyName);
            curBB.addInst(new Funcall(curBB, calleeFunc, vArgs, vreg));
            node.regValue = vreg;

            // FIX: could be optimized by add and load
            break;

        case Tool.LENGTH_KEY:
        case Tool.SIZE_KEY:
            vreg = new VirtualRegister("size_length");

            curBB.addInst(new Load(curBB, vreg, RegValue.RegSize, thisExpr.regValue, 0));
            node.regValue = vreg;
            break;

        default:
            throw new CompileError("invalid built-in function call");
        }

        curWantAddr = tmpWantAddr;
    }

    private void processArrayNew(NewExprNode node, VirtualRegister oreg, RegValue addr, int idx) {
    }

    private void processLogicalBinaryOp(BinaryOpExprNode node) {
    }

    private void processStringBinaryOp(BinaryOpExprNode node) {
    }

    private void processArithBinaryOp(BinaryOpExprNode node) {
    }

    private void processCmpBinaryOp(BinaryOpExprNode node) {
    }

    // need to use memory store and load
    private boolean isMemoryAccess(ExprNode node) {
        // return node instanceof ArefExprNode || node instanceof
        // MemberExprNode
        // || (node instanceof IdentifierExprNode &&
        // checkIdentiferThisMemberAccess((IdentifierExprNode)
        // node));
        if (node instanceof ArefExprNode || node instanceof MemberExprNode)
            return true;
        if ((node instanceof IdentifierExprNode && checkIdentiferMemberAccess((IdentifierExprNode) node)))
            return true;
        return false;
    }

    /** check class-mem access */
    private boolean checkIdentiferMemberAccess(IdentifierExprNode node) {
        // only need to check once
        if (!node.isChecked()) {
            if (curClass != null) {
                VarEntity varEntity = (VarEntity) curScope.get(node.getIdentifier());
                node.setNeedMemOp(varEntity.register == null);
            } else {
                node.setNeedMemOp(false);
            }
            node.setChecked(true);
        }
        return node.isNeedMemOp();
    }

    // endregion
}