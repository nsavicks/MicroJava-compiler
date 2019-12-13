// generated with ast extension for cup
// version 0.8
// 28/10/2019 19:19:40


package rs.ac.bg.etf.pp1.ast;

public class StatementPrint extends Statement {

    private Expr Expr;
    private CommaNumConstSingle CommaNumConstSingle;

    public StatementPrint (Expr Expr, CommaNumConstSingle CommaNumConstSingle) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.CommaNumConstSingle=CommaNumConstSingle;
        if(CommaNumConstSingle!=null) CommaNumConstSingle.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public CommaNumConstSingle getCommaNumConstSingle() {
        return CommaNumConstSingle;
    }

    public void setCommaNumConstSingle(CommaNumConstSingle CommaNumConstSingle) {
        this.CommaNumConstSingle=CommaNumConstSingle;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(CommaNumConstSingle!=null) CommaNumConstSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(CommaNumConstSingle!=null) CommaNumConstSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(CommaNumConstSingle!=null) CommaNumConstSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementPrint(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CommaNumConstSingle!=null)
            buffer.append(CommaNumConstSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementPrint]");
        return buffer.toString();
    }
}
