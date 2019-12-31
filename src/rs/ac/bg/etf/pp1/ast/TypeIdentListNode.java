// generated with ast extension for cup
// version 0.8
// 31/11/2019 4:46:43


package rs.ac.bg.etf.pp1.ast;

public class TypeIdentListNode extends TypeIdentList {

    private TypeIdentList TypeIdentList;
    private TypeIdentSingle TypeIdentSingle;

    public TypeIdentListNode (TypeIdentList TypeIdentList, TypeIdentSingle TypeIdentSingle) {
        this.TypeIdentList=TypeIdentList;
        if(TypeIdentList!=null) TypeIdentList.setParent(this);
        this.TypeIdentSingle=TypeIdentSingle;
        if(TypeIdentSingle!=null) TypeIdentSingle.setParent(this);
    }

    public TypeIdentList getTypeIdentList() {
        return TypeIdentList;
    }

    public void setTypeIdentList(TypeIdentList TypeIdentList) {
        this.TypeIdentList=TypeIdentList;
    }

    public TypeIdentSingle getTypeIdentSingle() {
        return TypeIdentSingle;
    }

    public void setTypeIdentSingle(TypeIdentSingle TypeIdentSingle) {
        this.TypeIdentSingle=TypeIdentSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.accept(visitor);
        if(TypeIdentSingle!=null) TypeIdentSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeIdentList!=null) TypeIdentList.traverseTopDown(visitor);
        if(TypeIdentSingle!=null) TypeIdentSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.traverseBottomUp(visitor);
        if(TypeIdentSingle!=null) TypeIdentSingle.traverseBottomUp(visitor);
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

        if(TypeIdentSingle!=null)
            buffer.append(TypeIdentSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeIdentListNode]");
        return buffer.toString();
    }
}
