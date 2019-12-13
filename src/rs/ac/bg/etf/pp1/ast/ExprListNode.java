// generated with ast extension for cup
// version 0.8
// 28/10/2019 19:19:40


package rs.ac.bg.etf.pp1.ast;

public class ExprListNode extends ExprList {

    private ExprList ExprList;
    private ExprItem ExprItem;

    public ExprListNode (ExprList ExprList, ExprItem ExprItem) {
        this.ExprList=ExprList;
        if(ExprList!=null) ExprList.setParent(this);
        this.ExprItem=ExprItem;
        if(ExprItem!=null) ExprItem.setParent(this);
    }

    public ExprList getExprList() {
        return ExprList;
    }

    public void setExprList(ExprList ExprList) {
        this.ExprList=ExprList;
    }

    public ExprItem getExprItem() {
        return ExprItem;
    }

    public void setExprItem(ExprItem ExprItem) {
        this.ExprItem=ExprItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprList!=null) ExprList.accept(visitor);
        if(ExprItem!=null) ExprItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprList!=null) ExprList.traverseTopDown(visitor);
        if(ExprItem!=null) ExprItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprList!=null) ExprList.traverseBottomUp(visitor);
        if(ExprItem!=null) ExprItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprListNode(\n");

        if(ExprList!=null)
            buffer.append(ExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprItem!=null)
            buffer.append(ExprItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprListNode]");
        return buffer.toString();
    }
}
