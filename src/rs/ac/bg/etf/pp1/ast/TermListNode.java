// generated with ast extension for cup
// version 0.8
// 21/11/2019 18:17:12


package rs.ac.bg.etf.pp1.ast;

public class TermListNode extends TermList {

    private TermList TermList;
    private TermItem TermItem;

    public TermListNode (TermList TermList, TermItem TermItem) {
        this.TermList=TermList;
        if(TermList!=null) TermList.setParent(this);
        this.TermItem=TermItem;
        if(TermItem!=null) TermItem.setParent(this);
    }

    public TermList getTermList() {
        return TermList;
    }

    public void setTermList(TermList TermList) {
        this.TermList=TermList;
    }

    public TermItem getTermItem() {
        return TermItem;
    }

    public void setTermItem(TermItem TermItem) {
        this.TermItem=TermItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermList!=null) TermList.accept(visitor);
        if(TermItem!=null) TermItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermList!=null) TermList.traverseTopDown(visitor);
        if(TermItem!=null) TermItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermList!=null) TermList.traverseBottomUp(visitor);
        if(TermItem!=null) TermItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermListNode(\n");

        if(TermList!=null)
            buffer.append(TermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TermItem!=null)
            buffer.append(TermItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermListNode]");
        return buffer.toString();
    }
}
