package mxcompiler.ast.declaration;


import mxcompiler.ast.*;
import mxcompiler.ast.expression.ExprNode;

/** Will be used in declaration and statement
 *  Specially, change block-decl and for-decl into
 *  vardecl, so as to cancel {@code varDeclStmt}
 */
public class VarDeclNode extends DeclNode{
    @Override
    public void _dump(Dump d) { d.print("Var define"); }

	/** to support type transfer, maybe change into typeNode */
    private TypeNode type;
    private ExprNode init;
    // public int offset; // UGLY: what is this?
    // public IntValue intvalue; // TODO: for IR
    // public Location location; // NOTE: for debugging


    // or maybe init Location, intvalue, offset
    public VarDeclNode(String name, ExprNode init, 
                            TypeNode vartypeNode) {
        super(name);
        this.type = vartypeNode;
        this.init = init;
    }

    public TypeNode getType() { return type; }
    public ExprNode getInit() { return init; }
}