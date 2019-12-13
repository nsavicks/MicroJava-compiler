// generated with ast extension for cup
// version 0.8
// 28/10/2019 19:19:39


package rs.ac.bg.etf.pp1.ast;

public class IdentListNode extends IdentList {

    private IdentList IdentList;
    private IdentListItem IdentListItem;

    public IdentListNode (IdentList IdentList, IdentListItem IdentListItem) {
        this.IdentList=IdentList;
        if(IdentList!=null) IdentList.setParent(this);
        this.IdentListItem=IdentListItem;
        if(IdentListItem!=null) IdentListItem.setParent(this);
    }

    public IdentList getIdentList() {
        return IdentList;
    }

    public void setIdentList(IdentList IdentList) {
        this.IdentList=IdentList;
    }

    public IdentListItem getIdentListItem() {
        return IdentListItem;
    }

    public void setIdentListItem(IdentListItem IdentListItem) {
        this.IdentListItem=IdentListItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentList!=null) IdentList.accept(visitor);
        if(IdentListItem!=null) IdentListItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentList!=null) IdentList.traverseTopDown(visitor);
        if(IdentListItem!=null) IdentListItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentList!=null) IdentList.traverseBottomUp(visitor);
        if(IdentListItem!=null) IdentListItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentListNode(\n");

        if(IdentList!=null)
            buffer.append(IdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentListItem!=null)
            buffer.append(IdentListItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentListNode]");
        return buffer.toString();
    }
}
