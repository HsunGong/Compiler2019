package mxcompiler.ast;

import java.io.PrintStream;

import org.antlr.v4.runtime.ParserRuleContext;


/**
 * A {@code Node} is the abstract Abstract Syntax Tree abstract Node
 * <p> means new para
 * The {@link mxcompiler.ast.ASTNode} 
 * <p> 
 * The {@linkplain mxcompiler.ast.AST} 
 *
 * @author     Xun
 * @since      1.0
 */

abstract public class Node {
    public Node() {}

    public ParserRuleContext ctx; // reserve the location of each grammer
    abstract public void setCtx(ParserRuleContext ctx); 
    
    
    /**
     * dump output
     */
    public void dump(PrintStream x) {
        Dump d = new Dump(x);
        _dump(d);
    }

    abstract public void _dump(Dump d);
}