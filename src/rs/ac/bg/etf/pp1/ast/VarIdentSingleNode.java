// generated with ast extension for cup
// version 0.8
// 3/0/2020 15:40:53


package rs.ac.bg.etf.pp1.ast;

public class VarIdentSingleNode extends VarIdentSingle {

    private String varName;
    private SquareSingle SquareSingle;

    public VarIdentSingleNode (String varName, SquareSingle SquareSingle) {
        this.varName=varName;
        this.SquareSingle=SquareSingle;
        if(SquareSingle!=null) SquareSingle.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public SquareSingle getSquareSingle() {
        return SquareSingle;
    }

    public void setSquareSingle(SquareSingle SquareSingle) {
        this.SquareSingle=SquareSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SquareSingle!=null) SquareSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SquareSingle!=null) SquareSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SquareSingle!=null) SquareSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarIdentSingleNode(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(SquareSingle!=null)
            buffer.append(SquareSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarIdentSingleNode]");
        return buffer.toString();
    }
}
