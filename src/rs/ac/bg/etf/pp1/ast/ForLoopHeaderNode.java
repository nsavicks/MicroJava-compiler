// generated with ast extension for cup
// version 0.8
// 3/0/2020 15:40:53


package rs.ac.bg.etf.pp1.ast;

public class ForLoopHeaderNode extends ForLoopHeader {

    private ForInit ForInit;
    private ForConditionSingle ForConditionSingle;
    private ForStep ForStep;

    public ForLoopHeaderNode (ForInit ForInit, ForConditionSingle ForConditionSingle, ForStep ForStep) {
        this.ForInit=ForInit;
        if(ForInit!=null) ForInit.setParent(this);
        this.ForConditionSingle=ForConditionSingle;
        if(ForConditionSingle!=null) ForConditionSingle.setParent(this);
        this.ForStep=ForStep;
        if(ForStep!=null) ForStep.setParent(this);
    }

    public ForInit getForInit() {
        return ForInit;
    }

    public void setForInit(ForInit ForInit) {
        this.ForInit=ForInit;
    }

    public ForConditionSingle getForConditionSingle() {
        return ForConditionSingle;
    }

    public void setForConditionSingle(ForConditionSingle ForConditionSingle) {
        this.ForConditionSingle=ForConditionSingle;
    }

    public ForStep getForStep() {
        return ForStep;
    }

    public void setForStep(ForStep ForStep) {
        this.ForStep=ForStep;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ForInit!=null) ForInit.accept(visitor);
        if(ForConditionSingle!=null) ForConditionSingle.accept(visitor);
        if(ForStep!=null) ForStep.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForInit!=null) ForInit.traverseTopDown(visitor);
        if(ForConditionSingle!=null) ForConditionSingle.traverseTopDown(visitor);
        if(ForStep!=null) ForStep.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForInit!=null) ForInit.traverseBottomUp(visitor);
        if(ForConditionSingle!=null) ForConditionSingle.traverseBottomUp(visitor);
        if(ForStep!=null) ForStep.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForLoopHeaderNode(\n");

        if(ForInit!=null)
            buffer.append(ForInit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForConditionSingle!=null)
            buffer.append(ForConditionSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForStep!=null)
            buffer.append(ForStep.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForLoopHeaderNode]");
        return buffer.toString();
    }
}
