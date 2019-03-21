package mxcompiler.ast.statement;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.Dump;
import mxcompiler.ast.declaration.VarDeclListNode;
import mxcompiler.ast.declaration.VarDeclNode;
import mxcompiler.ast.expression.ExprNode;

public class ForStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("For stmt"); }

	private List<VarDeclNode> varList;
    private ExprNode init;
    private ExprNode cond;
	private ExprNode incr;
	/** attention: not block stmt */
	private StmtNode body;
	
    public ForStmtNode(ExprNode init, ExprNode cond, ExprNode incr, 
                    StmtNode body, List<VarDeclNode> varList) {
        this.init = init;
        this.incr = incr;
        this.cond = cond;
		this.body = body; // may be null
		if (varList != null) this.varList = varList;
		else this.varList = new ArrayList<VarDeclNode>();
	}
	
	public ForStmtNode(ExprNode init, ExprNode cond, ExprNode incr, 
                    StmtNode body, VarDeclListNode varList) {
		this(init, cond, incr, body, varList.getList());
	}

	public List<VarDeclNode> getList() { return varList; }
    public ExprNode getInit() { return init; }
    public ExprNode getCond() { return cond; }
    public ExprNode getIncr() { return incr; }
    public StmtNode getBody() { return body; }
}