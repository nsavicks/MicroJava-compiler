// generated with ast extension for cup
// version 0.8
// 3/0/2020 15:40:54


package rs.ac.bg.etf.pp1.ast;

public class NoActParsSingle extends ActParsSingle {

    public NoActParsSingle () {
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
        buffer.append("NoActParsSingle(\n");

        buffer.append(tab);
        buffer.append(") [NoActParsSingle]");
        return buffer.toString();
    }
}
