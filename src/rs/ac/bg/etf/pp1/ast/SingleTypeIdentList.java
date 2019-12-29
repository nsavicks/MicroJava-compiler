// generated with ast extension for cup
// version 0.8
// 29/11/2019 17:20:37


package rs.ac.bg.etf.pp1.ast;

public class SingleTypeIdentList extends TypeIdentList {

    private TypeIdentSingle TypeIdentSingle;

    public SingleTypeIdentList (TypeIdentSingle TypeIdentSingle) {
        this.TypeIdentSingle=TypeIdentSingle;
        if(TypeIdentSingle!=null) TypeIdentSingle.setParent(this);
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
        if(TypeIdentSingle!=null) TypeIdentSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeIdentSingle!=null) TypeIdentSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeIdentSingle!=null) TypeIdentSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleTypeIdentList(\n");

        if(TypeIdentSingle!=null)
            buffer.append(TypeIdentSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleTypeIdentList]");
        return buffer.toString();
    }
}
