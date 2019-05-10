package mxcompiler.main.optim;

import java.util.*;

import mxcompiler.utils.entity.*;
import mxcompiler.utils.scope.*;
import mxcompiler.utils.type.*;

import mxcompiler.ast.*;
import mxcompiler.ast.statement.*;
import mxcompiler.ast.declaration.*;
import mxcompiler.ast.expression.*;
import mxcompiler.ast.expression.lhs.*;


public class UsagePreChecker extends Visitor {
    private Set<VarEntity> usedStaticSet = new HashSet<>(), unUsedStaticSet = new HashSet<>();
    private ToplevelScope toplevelScope;
    private Scope curScope;
    private boolean inDefine = false;

    /** main function */
    @Override
    public void visit(ASTNode node) {
        toplevelScope = node.getScope();
        curScope = toplevelScope;
        for (DeclNode decl : node.getDecl()) {
            if (decl instanceof ClassDeclNode) {
                ClassEntity entity = (ClassEntity) curScope.get(decl.getName());
                curScope = entity.getScope();
                for (FuncDeclNode memberFunc : ((ClassDeclNode) decl).getFunc()) {
                    visit(memberFunc);
                }
                curScope = curScope.getParent();
            } else
                visit(decl);
        }

        for (VarEntity varEntity : unUsedStaticSet) {
            if (usedStaticSet.contains(varEntity))
                continue;
            varEntity.unUsed = true;
            // System.out.println("unUsedStatic: " + varEntity.getName());
        }
    }

    @Override
    public void visit(ClassDeclNode node) {
        // null
    }

    @Override
    public void visit(VarDeclNode node) {
        if (node.getInit() != null) {
            VarEntity varEntity = (VarEntity) curScope.get(node.getName());

            if (varEntity.getType() instanceof ArrayType || varEntity.isGlobal) {
                unUsedStaticSet.add(varEntity);
            }

            visit(node.getInit());
        }
    }

    @Override
    public void visit(BlockStmtNode node) {
        curScope = node.getScope();
        for (Node nn : node.getAll())
            visit(nn);
        curScope = curScope.getParent();
    }

    @Override
    public void visit(ArefExprNode node) {
        if (inDefine) {
            visit(node.getExpr());
            inDefine = false;
            visit(node.getIndex());
            inDefine = true;
        } else {
            visit(node.getExpr());
            visit(node.getIndex());

        }
    }

    @Override
    public void visit(AssignExprNode node) {
        if (node.getRhs().getType() instanceof ArrayType
                && !(node.getRhs() instanceof NewExprNode)) {
            visit(node.getLhs());
            visit(node.getRhs());
            return;
        }
        inDefine = true;
        visit(node.getLhs());
        inDefine = false;
        visit(node.getRhs());
    }

    @Override
    public void visit(IdentifierExprNode node) {
        Entity entity = curScope.get(node.getIdentifier());

        if (entity != null && entity instanceof VarEntity) {
            VarEntity varEntity = (VarEntity) entity;
            if (varEntity.getType() instanceof ArrayType || varEntity.isGlobal) {
                if (inDefine)
                    unUsedStaticSet.add(varEntity);
                else
                    usedStaticSet.add(varEntity);
            }
        }
    }

}