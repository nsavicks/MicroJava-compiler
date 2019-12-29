// generated with ast extension for cup
// version 0.8
// 29/11/2019 17:20:38


package rs.ac.bg.etf.pp1.ast;

public class ForConditionSingleNode extends ForConditionSingle {

    private ConditionSingle ConditionSingle;

    public ForConditionSingleNode (ConditionSingle ConditionSingle) {
        this.ConditionSingle=ConditionSingle;
        if(ConditionSingle!=null) ConditionSingle.setParent(this);
    }

    public ConditionSingle getConditionSingle() {
        return ConditionSingle;
    }

    public void setConditionSingle(ConditionSingle ConditionSingle) {
        this.ConditionSingle=ConditionSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConditionSingle!=null) ConditionSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionSingle!=null) ConditionSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionSingle!=null) ConditionSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForConditionSingleNode(\n");

        if(ConditionSingle!=null)
            buffer.append(ConditionSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForConditionSingleNode]");
        return buffer.toString();
    }
}
