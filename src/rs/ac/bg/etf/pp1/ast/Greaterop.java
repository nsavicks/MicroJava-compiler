// generated with ast extension for cup
// version 0.8
// 21/11/2019 18:17:12


package rs.ac.bg.etf.pp1.ast;

public class Greaterop extends Relop {

    public Greaterop () {
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
        buffer.append("Greaterop(\n");

        buffer.append(tab);
        buffer.append(") [Greaterop]");
        return buffer.toString();
    }
}