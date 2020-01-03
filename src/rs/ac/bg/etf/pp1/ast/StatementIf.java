// generated with ast extension for cup
// version 0.8
// 3/0/2020 15:40:53


package rs.ac.bg.etf.pp1.ast;

public class StatementIf extends Statement {

    private IfHeader IfHeader;
    private Statement Statement;
    private ElseStatementSingle ElseStatementSingle;

    public StatementIf (IfHeader IfHeader, Statement Statement, ElseStatementSingle ElseStatementSingle) {
        this.IfHeader=IfHeader;
        if(IfHeader!=null) IfHeader.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ElseStatementSingle=ElseStatementSingle;
        if(ElseStatementSingle!=null) ElseStatementSingle.setParent(this);
    }

    public IfHeader getIfHeader() {
        return IfHeader;
    }

    public void setIfHeader(IfHeader IfHeader) {
        this.IfHeader=IfHeader;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ElseStatementSingle getElseStatementSingle() {
        return ElseStatementSingle;
    }

    public void setElseStatementSingle(ElseStatementSingle ElseStatementSingle) {
        this.ElseStatementSingle=ElseStatementSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfHeader!=null) IfHeader.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(ElseStatementSingle!=null) ElseStatementSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfHeader!=null) IfHeader.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ElseStatementSingle!=null) ElseStatementSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfHeader!=null) IfHeader.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ElseStatementSingle!=null) ElseStatementSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementIf(\n");

        if(IfHeader!=null)
            buffer.append(IfHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElseStatementSingle!=null)
            buffer.append(ElseStatementSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementIf]");
        return buffer.toString();
    }
}
