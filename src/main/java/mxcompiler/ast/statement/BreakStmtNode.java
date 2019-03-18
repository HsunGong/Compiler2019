package mxcompiler.ast.statement;

import mxcompiler.ast.Dump;

public class BreakStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("Break stmt"); }

    public BreakStmtNode() {}
    
}