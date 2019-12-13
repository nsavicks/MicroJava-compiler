// generated with ast extension for cup
// version 0.8
// 28/10/2019 19:19:40


package rs.ac.bg.etf.pp1.ast;

public class TypeIdentListNode extends TypeIdentList {

    private TypeIdentList TypeIdentList;
    private TypeIdentItem TypeIdentItem;

    public TypeIdentListNode (TypeIdentList TypeIdentList, TypeIdentItem TypeIdentItem) {
        this.TypeIdentList=TypeIdentList;
        if(TypeIdentList!=null) TypeIdentList.setParent(this);
        this.TypeIdentItem=TypeIdentItem;
        if(TypeIdentItem!=null) TypeIdentItem.setParent(this);
    }

    public TypeIdentList getTypeIdentList() {
        return TypeIdentList;
    }

    public void setTypeIdentList(TypeIdentList TypeIdentList) {
        this.TypeIdentList=TypeIdentList;
    }

    public TypeIdentItem getTypeIdentItem() {
        return TypeIdentItem;
    }

    public void setTypeIdentItem(TypeIdentItem TypeIdentItem) {
        this.TypeIdentItem=TypeIdentItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.accept(visitor);
        if(TypeIdentItem!=null) TypeIdentItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeIdentList!=null) TypeIdentList.traverseTopDown(visitor);
        if(TypeIdentItem!=null) TypeIdentItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.traverseBottomUp(visitor);
        if(TypeIdentItem!=null) TypeIdentItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TypeIdentListNode(\n");

        if(TypeIdentList!=null)
            buffer.append(TypeIdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TypeIdentItem!=null)
            buffer.append(TypeIdentItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeIdentListNode]");
        return buffer.toString();
    }
}
