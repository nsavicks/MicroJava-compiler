// generated with ast extension for cup
// version 0.8
// 29/11/2019 17:20:38


package rs.ac.bg.etf.pp1.ast;

public class Lesserop extends Relop {

    public Lesserop () {
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
        buffer.append("Lesserop(\n");

        buffer.append(tab);
        buffer.append(") [Lesserop]");
        return buffer.toString();
    }
}
