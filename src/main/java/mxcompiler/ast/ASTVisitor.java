package mxcompiler.ast;

/** {@code ASTVisitor} is a interface
 *  which include all nodes {@code visit} function
 * to avoid write to much codes
 * Then, if want to do more works for Semantic
 * like Typecheck, LocalScoper, and so on
 * just realize the actual class and use antlr.parsertree
 * 
 * FIX: Current no use for build AST
 */
public interface ASTVisitor {
    /** No use just for display how to do a type */
    void visit(Node node);
}