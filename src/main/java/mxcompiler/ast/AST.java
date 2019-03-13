package mxcompiler.ast;

import org.antlr.v4.runtime.tree.ParseTree;

/**
 * {@code AST} is the root or socalled pragram root
 * 
 */
public class AST extends Node {
    public Declarations declarations;
    public ToplevelScope scope;
    public ConstantTable constantTable;


    public void visit(ParseTree tree){

    }
    public void _dump(Dump d) {
        d.print("");
    }
}