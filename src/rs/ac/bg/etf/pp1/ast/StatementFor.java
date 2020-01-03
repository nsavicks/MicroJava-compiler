// generated with ast extension for cup
// version 0.8
// 3/0/2020 15:40:53


package rs.ac.bg.etf.pp1.ast;

public class StatementFor extends Statement {

    private ForLoopHeader ForLoopHeader;
    private Statement Statement;

    public StatementFor (ForLoopHeader ForLoopHeader, Statement Statement) {
        this.ForLoopHeader=ForLoopHeader;
        if(ForLoopHeader!=null) ForLoopHeader.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ForLoopHeader getForLoopHeader() {
        return ForLoopHeader;
    }

    public void setForLoopHeader(ForLoopHeader ForLoopHeader) {
        this.ForLoopHeader=ForLoopHeader;
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
        if(ForLoopHeader!=null) ForLoopHeader.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForLoopHeader!=null) ForLoopHeader.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForLoopHeader!=null) ForLoopHeader.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementFor(\n");

        if(ForLoopHeader!=null)
            buffer.append(ForLoopHeader.toString("  "+tab));
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
