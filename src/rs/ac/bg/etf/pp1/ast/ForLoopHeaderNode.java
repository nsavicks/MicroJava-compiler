// generated with ast extension for cup
// version 0.8
// 31/11/2019 4:46:43


package rs.ac.bg.etf.pp1.ast;

public class ForLoopHeaderNode extends ForLoopHeader {

    private DesignatorStatementSingle DesignatorStatementSingle;
    private ForConditionSingle ForConditionSingle;
    private DesignatorStatementSingle DesignatorStatementSingle1;

    public ForLoopHeaderNode (DesignatorStatementSingle DesignatorStatementSingle, ForConditionSingle ForConditionSingle, DesignatorStatementSingle DesignatorStatementSingle1) {
        this.DesignatorStatementSingle=DesignatorStatementSingle;
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.setParent(this);
        this.ForConditionSingle=ForConditionSingle;
        if(ForConditionSingle!=null) ForConditionSingle.setParent(this);
        this.DesignatorStatementSingle1=DesignatorStatementSingle1;
        if(DesignatorStatementSingle1!=null) DesignatorStatementSingle1.setParent(this);
    }

    public DesignatorStatementSingle getDesignatorStatementSingle() {
        return DesignatorStatementSingle;
    }

    public void setDesignatorStatementSingle(DesignatorStatementSingle DesignatorStatementSingle) {
        this.DesignatorStatementSingle=DesignatorStatementSingle;
    }

    public ForConditionSingle getForConditionSingle() {
        return ForConditionSingle;
    }

    public void setForConditionSingle(ForConditionSingle ForConditionSingle) {
        this.ForConditionSingle=ForConditionSingle;
    }

    public DesignatorStatementSingle getDesignatorStatementSingle1() {
        return DesignatorStatementSingle1;
    }

    public void setDesignatorStatementSingle1(DesignatorStatementSingle DesignatorStatementSingle1) {
        this.DesignatorStatementSingle1=DesignatorStatementSingle1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.accept(visitor);
        if(ForConditionSingle!=null) ForConditionSingle.accept(visitor);
        if(DesignatorStatementSingle1!=null) DesignatorStatementSingle1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.traverseTopDown(visitor);
        if(ForConditionSingle!=null) ForConditionSingle.traverseTopDown(visitor);
        if(DesignatorStatementSingle1!=null) DesignatorStatementSingle1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.traverseBottomUp(visitor);
        if(ForConditionSingle!=null) ForConditionSingle.traverseBottomUp(visitor);
        if(DesignatorStatementSingle1!=null) DesignatorStatementSingle1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForLoopHeaderNode(\n");

        if(DesignatorStatementSingle!=null)
            buffer.append(DesignatorStatementSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForConditionSingle!=null)
            buffer.append(ForConditionSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementSingle1!=null)
            buffer.append(DesignatorStatementSingle1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForLoopHeaderNode]");
        return buffer.toString();
    }
}
