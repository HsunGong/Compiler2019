package mxcompiler.main;


import mxcompiler.ast.Node;
import mxcompiler.parser.MxBaseVisitor;
import mxcompiler.parser.MxParser;

/** used for generate AST
 * to prepare for Semantic Check 
 * {@linkplain  mxcompiler.parser.MxBaseListener}
 * return value of {@linkplain Node} type
 * FIX: Whatif do this {@code with BaseListener}?
 */
public class ASTBuilder extends MxBaseVisitor<Node>{
    @Override
    public Node visitCompilationUnit(MxParser.CompilationUnitContext ctx) { return visitChildren(ctx); }
}