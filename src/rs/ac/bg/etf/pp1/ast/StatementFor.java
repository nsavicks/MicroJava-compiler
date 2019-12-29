// generated with ast extension for cup
// version 0.8
// 29/11/2019 17:20:38


package rs.ac.bg.etf.pp1.ast;

public class StatementFor extends Statement {

    private DesignatorStatementSingle DesignatorStatementSingle;
    private ForConditionSingle ForConditionSingle;
    private DesignatorStatementSingle DesignatorStatementSingle1;
    private Statement Statement;

    public StatementFor (DesignatorStatementSingle DesignatorStatementSingle, ForConditionSingle ForConditionSingle, DesignatorStatementSingle DesignatorStatementSingle1, Statement Statement) {
        this.DesignatorStatementSingle=DesignatorStatementSingle;
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.setParent(this);
        this.ForConditionSingle=ForConditionSingle;
        if(ForConditionSingle!=null) ForConditionSingle.setParent(this);
        this.DesignatorStatementSingle1=DesignatorStatementSingle1;
        if(DesignatorStatementSingle1!=null) DesignatorStatementSingle1.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
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

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.accept(visitor);
        if(ForConditionSingle!=null) ForConditionSingle.accept(visitor);
        if(DesignatorStatementSingle1!=null) DesignatorStatementSingle1.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.traverseTopDown(visitor);
        if(ForConditionSingle!=null) ForConditionSingle.traverseTopDown(visitor);
        if(DesignatorStatementSingle1!=null) DesignatorStatementSingle1.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementSingle!=null) DesignatorStatementSingle.traverseBottomUp(visitor);
        if(ForConditionSingle!=null) ForConditionSingle.traverseBottomUp(visitor);
        if(DesignatorStatementSingle1!=null) DesignatorStatementSingle1.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementFor(\n");

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

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementFor]");
        return buffer.toString();
    }
}
