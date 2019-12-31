// generated with ast extension for cup
// version 0.8
// 31/11/2019 4:46:43


package rs.ac.bg.etf.pp1.ast;

public class ActParsListExpr extends ActParsList {

    private ActParsExpr ActParsExpr;

    public ActParsListExpr (ActParsExpr ActParsExpr) {
        this.ActParsExpr=ActParsExpr;
        if(ActParsExpr!=null) ActParsExpr.setParent(this);
    }

    public ActParsExpr getActParsExpr() {
        return ActParsExpr;
    }

    public void setActParsExpr(ActParsExpr ActParsExpr) {
        this.ActParsExpr=ActParsExpr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsExpr!=null) ActParsExpr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsExpr!=null) ActParsExpr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsExpr!=null) ActParsExpr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsListExpr(\n");

        if(ActParsExpr!=null)
            buffer.append(ActParsExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsListExpr]");
        return buffer.toString();
    }
}
