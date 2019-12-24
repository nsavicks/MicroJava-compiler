// generated with ast extension for cup
// version 0.8
// 23/11/2019 23:31:0


package rs.ac.bg.etf.pp1.ast;

public class FactorActParsSingleNode extends FactorActParsSingle {

    private ActParsSingle ActParsSingle;

    public FactorActParsSingleNode (ActParsSingle ActParsSingle) {
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
        buffer.append("FactorActParsSingleNode(\n");

        if(ActParsSingle!=null)
            buffer.append(ActParsSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorActParsSingleNode]");
        return buffer.toString();
    }
}
