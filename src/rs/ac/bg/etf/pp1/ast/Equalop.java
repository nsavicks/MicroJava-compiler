// generated with ast extension for cup
// version 0.8
// 31/11/2019 4:46:44


package rs.ac.bg.etf.pp1.ast;

public class Equalop extends Relop {

    public Equalop () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Equalop(\n");

        buffer.append(tab);
        buffer.append(") [Equalop]");
        return buffer.toString();
    }
}
