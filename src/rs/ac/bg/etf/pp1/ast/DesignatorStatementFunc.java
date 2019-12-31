// generated with ast extension for cup
// version 0.8
// 31/11/2019 4:46:43


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementFunc extends DesignatorStatement {

    private DesignatorStatementFuncDesignator DesignatorStatementFuncDesignator;
    private ActParsSingle ActParsSingle;

    public DesignatorStatementFunc (DesignatorStatementFuncDesignator DesignatorStatementFuncDesignator, ActParsSingle ActParsSingle) {
        this.DesignatorStatementFuncDesignator=DesignatorStatementFuncDesignator;
        if(DesignatorStatementFuncDesignator!=null) DesignatorStatementFuncDesignator.setParent(this);
        this.ActParsSingle=ActParsSingle;
        if(ActParsSingle!=null) ActParsSingle.setParent(this);
    }

    public DesignatorStatementFuncDesignator getDesignatorStatementFuncDesignator() {
        return DesignatorStatementFuncDesignator;
    }

    public void setDesignatorStatementFuncDesignator(DesignatorStatementFuncDesignator DesignatorStatementFuncDesignator) {
        this.DesignatorStatementFuncDesignator=DesignatorStatementFuncDesignator;
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
        if(DesignatorStatementFuncDesignator!=null) DesignatorStatementFuncDesignator.accept(visitor);
        if(ActParsSingle!=null) ActParsSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementFuncDesignator!=null) DesignatorStatementFuncDesignator.traverseTopDown(visitor);
        if(ActParsSingle!=null) ActParsSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementFuncDesignator!=null) DesignatorStatementFuncDesignator.traverseBottomUp(visitor);
        if(ActParsSingle!=null) ActParsSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementFunc(\n");

        if(DesignatorStatementFuncDesignator!=null)
            buffer.append(DesignatorStatementFuncDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsSingle!=null)
            buffer.append(ActParsSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementFunc]");
        return buffer.toString();
    }
}
