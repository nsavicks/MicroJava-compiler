// generated with ast extension for cup
// version 0.8
// 31/11/2019 4:46:43


package rs.ac.bg.etf.pp1.ast;

public class MethoDeclTypeIdentNode extends MethodDeclTypeIdent {

    private RetType RetType;
    private String methName;

    public MethoDeclTypeIdentNode (RetType RetType, String methName) {
        this.RetType=RetType;
        if(RetType!=null) RetType.setParent(this);
        this.methName=methName;
    }

    public RetType getRetType() {
        return RetType;
    }

    public void setRetType(RetType RetType) {
        this.RetType=RetType;
    }

    public String getMethName() {
        return methName;
    }

    public void setMethName(String methName) {
        this.methName=methName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RetType!=null) RetType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RetType!=null) RetType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RetType!=null) RetType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethoDeclTypeIdentNode(\n");

        if(RetType!=null)
            buffer.append(RetType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+methName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethoDeclTypeIdentNode]");
        return buffer.toString();
    }
}
