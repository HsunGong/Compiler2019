package mxcompiler.ast.statement;

import java.util.ArrayList;
import java.util.List;

import mxcompiler.ast.Dump;
import mxcompiler.entity.scope.LocalScope;

public class BlockStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("block stmt"); }
    
    private List<StmtNode> stmts;
    private LocalScope scope;
    // private List<Node> vars;

    // FIX: whether put vars here or not
    public BlockStmtNode (List<StmtNode> stmtsAndvars) {
        if(stmtsAndvars == null) stmts = new ArrayList<StmtNode>();
        else stmts = stmtsAndvars;
    }

    public void setScope(LocalScope scope) { this.scope = scope; }
    public LocalScope getScope() { return scope; }

    public void addStmt(StmtNode stmt) { stmts.add(stmt); }
    public List<StmtNode> getStmts() { return stmts; }
    // public List<Node> getVars() { return vars; }
}