// generated with ast extension for cup
// version 0.8
// 29/11/2019 21:50:4


package rs.ac.bg.etf.pp1.ast;

public class VarIdentListNode extends VarIdentList {

    private VarIdentList VarIdentList;
    private VarIdentSingle VarIdentSingle;

    public VarIdentListNode (VarIdentList VarIdentList, VarIdentSingle VarIdentSingle) {
        this.VarIdentList=VarIdentList;
        if(VarIdentList!=null) VarIdentList.setParent(this);
        this.VarIdentSingle=VarIdentSingle;
        if(VarIdentSingle!=null) VarIdentSingle.setParent(this);
    }

    public VarIdentList getVarIdentList() {
        return VarIdentList;
    }

    public void setVarIdentList(VarIdentList VarIdentList) {
        this.VarIdentList=VarIdentList;
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
        if(VarIdentList!=null) VarIdentList.accept(visitor);
        if(VarIdentSingle!=null) VarIdentSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarIdentList!=null) VarIdentList.traverseTopDown(visitor);
        if(VarIdentSingle!=null) VarIdentSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarIdentList!=null) VarIdentList.traverseBottomUp(visitor);
        if(VarIdentSingle!=null) VarIdentSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarIdentListNode(\n");

        if(VarIdentList!=null)
            buffer.append(VarIdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarIdentSingle!=null)
            buffer.append(VarIdentSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarIdentListNode]");
        return buffer.toString();
    }
}
