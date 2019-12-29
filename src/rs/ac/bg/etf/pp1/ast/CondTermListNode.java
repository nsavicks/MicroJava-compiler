// generated with ast extension for cup
// version 0.8
// 29/11/2019 21:50:5


package rs.ac.bg.etf.pp1.ast;

public class CondTermListNode extends CondTermList {

    private CondTermList CondTermList;
    private CondTermItem CondTermItem;

    public CondTermListNode (CondTermList CondTermList, CondTermItem CondTermItem) {
        this.CondTermList=CondTermList;
        if(CondTermList!=null) CondTermList.setParent(this);
        this.CondTermItem=CondTermItem;
        if(CondTermItem!=null) CondTermItem.setParent(this);
    }

    public CondTermList getCondTermList() {
        return CondTermList;
    }

    public void setCondTermList(CondTermList CondTermList) {
        this.CondTermList=CondTermList;
    }

    public CondTermItem getCondTermItem() {
        return CondTermItem;
    }

    public void setCondTermItem(CondTermItem CondTermItem) {
        this.CondTermItem=CondTermItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermList!=null) CondTermList.accept(visitor);
        if(CondTermItem!=null) CondTermItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermList!=null) CondTermList.traverseTopDown(visitor);
        if(CondTermItem!=null) CondTermItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermList!=null) CondTermList.traverseBottomUp(visitor);
        if(CondTermItem!=null) CondTermItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermListNode(\n");

        if(CondTermList!=null)
            buffer.append(CondTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTermItem!=null)
            buffer.append(CondTermItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermListNode]");
        return buffer.toString();
    }
}
