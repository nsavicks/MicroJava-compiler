// generated with ast extension for cup
// version 0.8
// 28/10/2019 19:19:40


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private Designator Designator;
    private FactorActParsSingle FactorActParsSingle;

    public FactorDesignator (Designator Designator, FactorActParsSingle FactorActParsSingle) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.FactorActParsSingle=FactorActParsSingle;
        if(FactorActParsSingle!=null) FactorActParsSingle.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public FactorActParsSingle getFactorActParsSingle() {
        return FactorActParsSingle;
    }

    public void setFactorActParsSingle(FactorActParsSingle FactorActParsSingle) {
        this.FactorActParsSingle=FactorActParsSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(FactorActParsSingle!=null) FactorActParsSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(FactorActParsSingle!=null) FactorActParsSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(FactorActParsSingle!=null) FactorActParsSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorActParsSingle!=null)
            buffer.append(FactorActParsSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
