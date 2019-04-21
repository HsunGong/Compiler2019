package mxcompiler.main;

import java.util.*;

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
 * The whole IR is built under Control Flow Graph Considered no SSA, no tree
 */
public class IRBuilder implements ASTVisitor {

    private Root root = new Root();

    private ToplevelScope toplevelScope;
    private List<GlobalVarInit> globalInitList = new ArrayList<>();

    private ClassEntity curClass = null;
    private Function curFunc = null;
    private BasicBlock curBB = null;
    private BasicBlock curLoopIncrBB, curLoopAfterBB; // cur
    private Scope curScope;

    private boolean isFuncArgDecl = false;
    private boolean wantAddr = false;

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
                // processIRAssign(vreg, 0, node.getInit(),
                // node.getInit().getType().getVarSize(), false);
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

        // merge multiple return instructions to a single end basic block
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

    // region ----------------- global var func-init ------------------
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

    /**
     * set basicblock inside the stmt not block-stmt 
     * set new block outside block not
     * the block-stmt
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
        curBB.setJump(new Jump(curBB, curLoopIncrBB));
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
        BasicBlock tmpLoopIncrBB = curLoopIncrBB;
        BasicBlock tmpLoopAfterBB = curLoopAfterBB;
        curLoopIncrBB = incrBB;
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
        curLoopIncrBB = tmpLoopIncrBB;
        curLoopAfterBB = tmpLoopAfterBB;

    }

    public void visit(IfStmtNode node) {
    }

    public void visit(ReturnStmtNode node) {
    }

    public void visit(WhileStmtNode node) {
    }

    public void visit(LhsExprNode node) {
    }

    public void visit(ArefExprNode node) {
    }

    public void visit(MemberExprNode node) {
    }

    public void visit(BoolLiteralExprNode node) {
    }

    public void visit(IntLiteralExprNode node) {
    }

    public void visit(StringLiteralExprNode node) {
    }

    public void visit(PrefixExprNode node) {
    }

    public void visit(SuffixExprNode node) {
    }

    public void visit(AssignExprNode node) {
    }

    public void visit(BinaryOpExprNode node) {
    }

    public void visit(FuncallExprNode node) {
    }

    public void visit(IdentifierExprNode node) {
    }

    public void visit(NewExprNode node) {
    }

    public void visit(NullExprNode node) {
    }

    public void visit(ThisExprNode node) {
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

    // region utils

    // endregion
}