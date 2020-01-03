// generated with ast extension for cup
// version 0.8
// 3/0/2020 14:11:39


package rs.ac.bg.etf.pp1.ast;

public class FactorFuncCall extends Factor {

    private FactorFuncCallDesignator FactorFuncCallDesignator;
    private ActParsSingle ActParsSingle;

    public FactorFuncCall (FactorFuncCallDesignator FactorFuncCallDesignator, ActParsSingle ActParsSingle) {
        this.FactorFuncCallDesignator=FactorFuncCallDesignator;
        if(FactorFuncCallDesignator!=null) FactorFuncCallDesignator.setParent(this);
        this.ActParsSingle=ActParsSingle;
        if(ActParsSingle!=null) ActParsSingle.setParent(this);
    }

    public FactorFuncCallDesignator getFactorFuncCallDesignator() {
        return FactorFuncCallDesignator;
    }

    public void setFactorFuncCallDesignator(FactorFuncCallDesignator FactorFuncCallDesignator) {
        this.FactorFuncCallDesignator=FactorFuncCallDesignator;
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
        if(FactorFuncCallDesignator!=null) FactorFuncCallDesignator.accept(visitor);
        if(ActParsSingle!=null) ActParsSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorFuncCallDesignator!=null) FactorFuncCallDesignator.traverseTopDown(visitor);
        if(ActParsSingle!=null) ActParsSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorFuncCallDesignator!=null) FactorFuncCallDesignator.traverseBottomUp(visitor);
        if(ActParsSingle!=null) ActParsSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorFuncCall(\n");

        if(FactorFuncCallDesignator!=null)
            buffer.append(FactorFuncCallDesignator.toString("  "+tab));
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
