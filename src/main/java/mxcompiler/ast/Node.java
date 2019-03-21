package mxcompiler.ast;

import java.io.PrintStream;

import org.antlr.v4.runtime.ParserRuleContext;


/**
 * A {@code Node} is the abstract Abstract Syntax Tree abstract Node
 * <p>  * Rewrite from down to top
 * <p> 
 * The {@linkplain mxcompiler.ast.ASTNode} is root Node
 *
 * @author     Xun
 * @since      1.0
 */

abstract public class Node {
    public Node() {}

    public ParserRuleContext ctx; // reserve the location of each grammer
    /** NOTE: Does it have use?? */
    public void setCtx(ParserRuleContext ctx) { this.ctx = ctx; } 
    
    // abstract void visit(ASTVisitor visitor);
    
    /**
     * dump output
     */
    public void dump(PrintStream x) {
        Dump d = new Dump(x);
        _dump(d);
    }

    abstract public void _dump(Dump d);
}