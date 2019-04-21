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
    private BasicBlock LoopStepBB, LoopAfterBB; // cur
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
            } else if (decl instanceof VarDeclNode)
                visit(decl);

        }

        // FIX: add global init in resolver
        visit(makeGlobalVarInit()); // has order, have to do at first

        for (DeclNode decl : node.getDecl()) {
            if (decl instanceof VarDeclNode) {
                // no actions to take
            } else if (decl instanceof ClassDeclNode) {
                decl.accept(this);
            } else if (decl instanceof FuncDeclNode) {
                decl.accept(this);
            } else {
                throw new CompilerError(decl.location(), "Invalid declaration node type");
            }
        }
        for (IRFunction irFunction : ir.getFuncs().values()) {
            irFunction.updateCalleeSet();
        }
        // ir.updateCalleeSet();
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

    public void visit(ClassDeclNode node) {
    }

    public void visit(FuncDeclNode node) {
    }

    public void visit(VarDeclListNode node) {
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

    public void visit(BlockStmtNode node) {
    }

    public void visit(BreakStmtNode node) {
    }

    public void visit(ContinueStmtNode node) {
    }

    public void visit(ExprStmtNode node) {
    }

    public void visit(ForStmtNode node) {
    }

    public void visit(IfStmtNode node) {
    }

    public void visit(ReturnStmtNode node) {
    }

    public void visit(WhileStmtNode node) {
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
    // endregion

    // region utils

    // endregion
}