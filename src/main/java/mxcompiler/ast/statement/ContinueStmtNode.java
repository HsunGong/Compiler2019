package mxcompiler.ast.statement;

import mxcompiler.ast.Dump;

public class ContinueStmtNode extends StmtNode {
    @Override
    public void _dump(Dump d) { d.print("Continue stmt"); }

    public ContinueStmtNode() {}
    
}