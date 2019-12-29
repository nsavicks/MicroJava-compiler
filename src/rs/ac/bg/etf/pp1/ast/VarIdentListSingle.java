// generated with ast extension for cup
// version 0.8
// 29/11/2019 21:50:4


package rs.ac.bg.etf.pp1.ast;

public class VarIdentListSingle extends VarIdentList {

    private VarIdentSingle VarIdentSingle;

    public VarIdentListSingle (VarIdentSingle VarIdentSingle) {
        this.VarIdentSingle=VarIdentSingle;
        if(VarIdentSingle!=null) VarIdentSingle.setParent(this);
    }

    public VarIdentSingle getVarIdentSingle() {
        return VarIdentSingle;
    }

    public void setVarIdentSingle(VarIdentSingle VarIdentSingle) {
        this.VarIdentSingle=VarIdentSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarIdentSingle!=null) VarIdentSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarIdentSingle!=null) VarIdentSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarIdentSingle!=null) VarIdentSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarIdentListSingle(\n");

        if(VarIdentSingle!=null)
            buffer.append(VarIdentSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarIdentListSingle]");
        return buffer.toString();
    }
}
