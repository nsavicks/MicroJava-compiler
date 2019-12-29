// generated with ast extension for cup
// version 0.8
// 29/11/2019 17:20:38


package rs.ac.bg.etf.pp1.ast;

public class FactorFuncCall extends Factor {

    private Designator Designator;
    private ActParsSingle ActParsSingle;

    public FactorFuncCall (Designator Designator, ActParsSingle ActParsSingle) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.ActParsSingle=ActParsSingle;
        if(ActParsSingle!=null) ActParsSingle.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public ActParsSingle getActParsSingle() {
        return ActParsSingle;
    }

    public void setActParsSingle(ActParsSingle ActParsSingle) {
        this.ActParsSingle=ActParsSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(ActParsSingle!=null) ActParsSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(ActParsSingle!=null) ActParsSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(ActParsSingle!=null) ActParsSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorFuncCall(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsSingle!=null)
            buffer.append(ActParsSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorFuncCall]");
        return buffer.toString();
    }
}
