// generated with ast extension for cup
// version 0.8
// 28/10/2019 19:19:39


package rs.ac.bg.etf.pp1.ast;

public class IdentListItem implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private SquareSingle SquareSingle;

    public IdentListItem (String I1, SquareSingle SquareSingle) {
        this.I1=I1;
        this.SquareSingle=SquareSingle;
        if(SquareSingle!=null) SquareSingle.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public SquareSingle getSquareSingle() {
        return SquareSingle;
    }

    public void setSquareSingle(SquareSingle SquareSingle) {
        this.SquareSingle=SquareSingle;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SquareSingle!=null) SquareSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SquareSingle!=null) SquareSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SquareSingle!=null) SquareSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentListItem(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(SquareSingle!=null)
            buffer.append(SquareSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentListItem]");
        return buffer.toString();
    }
}
