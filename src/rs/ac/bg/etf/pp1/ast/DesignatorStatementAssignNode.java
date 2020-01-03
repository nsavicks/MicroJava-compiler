// generated with ast extension for cup
// version 0.8
// 3/0/2020 15:40:53


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementAssignNode extends DesignatorStatement {

    private DesignatorAssignItem DesignatorAssignItem;

    public DesignatorStatementAssignNode (DesignatorAssignItem DesignatorAssignItem) {
        this.DesignatorAssignItem=DesignatorAssignItem;
        if(DesignatorAssignItem!=null) DesignatorAssignItem.setParent(this);
    }

    public DesignatorAssignItem getDesignatorAssignItem() {
        return DesignatorAssignItem;
    }

    public void setDesignatorAssignItem(DesignatorAssignItem DesignatorAssignItem) {
        this.DesignatorAssignItem=DesignatorAssignItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorAssignItem!=null) DesignatorAssignItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorAssignItem!=null) DesignatorAssignItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorAssignItem!=null) DesignatorAssignItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementAssignNode(\n");

        if(DesignatorAssignItem!=null)
            buffer.append(DesignatorAssignItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementAssignNode]");
        return buffer.toString();
    }
}
