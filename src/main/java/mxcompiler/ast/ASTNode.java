package mxcompiler.ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import mxcompiler.ast.declaration.DeclNode;
import mxcompiler.entity.scope.ToplevelScope;

/**
 * {@code AST} is the root or socalled pragram root
 * Rewrite from down to top
 * For the book, it release the most declarations in Declaration
 * Here we simplify
 */
public class ASTNode extends Node {

    private List<DeclNode> declarations;
    private ToplevelScope scope;
    // public ConstantTable constantTable;
    // private Location location_source;

    /** can add with empty list */
    public ASTNode(List<DeclNode> decl, Location location) {
        super(location);
        if (decl == null) decl = new ArrayList<DeclNode>();
        else this.declarations = decl;
    }

    public void visit(ParseTree tree){}

    public List<DeclNode> getDeclarations() { return declarations; }
    public void addDeclaration(DeclNode n) { declarations.add(n); }

    public void setScope(ToplevelScope scope) { this.scope = scope; }
    public ToplevelScope getScope() { return scope; }
}