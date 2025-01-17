// generated with ast extension for cup
// version 0.8
// 3/0/2020 15:40:53


package rs.ac.bg.etf.pp1.ast;

public class ForInitNode extends ForInit {

    private DesignatorStatementSingle DesignatorStatementSingle;

    public ForInitNode (DesignatorStatementSingle DesignatorStatementSingle) {
        this.DesignatorStatementSingle=DesignatorStatementSingle;
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.setParent(this);
    }

    public DesignatorStatementSingle getDesignatorStatementSingle() {
        return DesignatorStatementSingle;
    }

    public void setDesignatorStatementSingle(DesignatorStatementSingle DesignatorStatementSingle) {
        this.DesignatorStatementSingle=DesignatorStatementSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForInitNode(\n");

        if(DesignatorStatementSingle!=null)
            buffer.append(DesignatorStatementSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForInitNode]");
        return buffer.toString();
    }
}
