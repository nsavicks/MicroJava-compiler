// generated with ast extension for cup
// version 0.8
// 21/11/2019 18:17:12


package rs.ac.bg.etf.pp1.ast;

public class DesignatorItemActPars extends DesignatorStatementItem {

    private ActParsSingle ActParsSingle;

    public DesignatorItemActPars (ActParsSingle ActParsSingle) {
        this.ActParsSingle=ActParsSingle;
        if(ActParsSingle!=null) ActParsSingle.setParent(this);
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
        if(ActParsSingle!=null) ActParsSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsSingle!=null) ActParsSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsSingle!=null) ActParsSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorItemActPars(\n");

        if(ActParsSingle!=null)
            buffer.append(ActParsSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorItemActPars]");
        return buffer.toString();
    }
}
