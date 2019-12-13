// generated with ast extension for cup
// version 0.8
// 28/10/2019 19:19:40


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private Type Type;
    private FactorExprSingle FactorExprSingle;

    public FactorNew (Type Type, FactorExprSingle FactorExprSingle) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FactorExprSingle=FactorExprSingle;
        if(FactorExprSingle!=null) FactorExprSingle.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FactorExprSingle getFactorExprSingle() {
        return FactorExprSingle;
    }

    public void setFactorExprSingle(FactorExprSingle FactorExprSingle) {
        this.FactorExprSingle=FactorExprSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FactorExprSingle!=null) FactorExprSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FactorExprSingle!=null) FactorExprSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FactorExprSingle!=null) FactorExprSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorExprSingle!=null)
            buffer.append(FactorExprSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
