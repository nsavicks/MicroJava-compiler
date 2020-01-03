// generated with ast extension for cup
// version 0.8
// 3/0/2020 14:11:38


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListNode extends ConstDeclList {

    private ConstDeclList ConstDeclList;
    private ConstDeclListItem ConstDeclListItem;

    public ConstDeclListNode (ConstDeclList ConstDeclList, ConstDeclListItem ConstDeclListItem) {
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
        this.ConstDeclListItem=ConstDeclListItem;
        if(ConstDeclListItem!=null) ConstDeclListItem.setParent(this);
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public ConstDeclListItem getConstDeclListItem() {
        return ConstDeclListItem;
    }

    public void setConstDeclListItem(ConstDeclListItem ConstDeclListItem) {
        this.ConstDeclListItem=ConstDeclListItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
        if(ConstDeclListItem!=null) ConstDeclListItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
        if(ConstDeclListItem!=null) ConstDeclListItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        if(ConstDeclListItem!=null) ConstDeclListItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListNode(\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclListItem!=null)
            buffer.append(ConstDeclListItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListNode]");
        return buffer.toString();
    }
}
