// generated with ast extension for cup
// version 0.8
// 21/11/2019 18:17:11


package rs.ac.bg.etf.pp1.ast;

public class IdentListNode extends IdentList {

    private IdentList IdentList;
    private IdentSingle IdentSingle;

    public IdentListNode (IdentList IdentList, IdentSingle IdentSingle) {
        this.IdentList=IdentList;
        if(IdentList!=null) IdentList.setParent(this);
        this.IdentSingle=IdentSingle;
        if(IdentSingle!=null) IdentSingle.setParent(this);
    }

    public IdentList getIdentList() {
        return IdentList;
    }

    public void setIdentList(IdentList IdentList) {
        this.IdentList=IdentList;
    }

    public IdentSingle getIdentSingle() {
        return IdentSingle;
    }

    public void setIdentSingle(IdentSingle IdentSingle) {
        this.IdentSingle=IdentSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IdentList!=null) IdentList.accept(visitor);
        if(IdentSingle!=null) IdentSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentList!=null) IdentList.traverseTopDown(visitor);
        if(IdentSingle!=null) IdentSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentList!=null) IdentList.traverseBottomUp(visitor);
        if(IdentSingle!=null) IdentSingle.traverseBottomUp(visitor);
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

        if(IdentSingle!=null)
            buffer.append(IdentSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentListNode]");
        return buffer.toString();
    }
}
