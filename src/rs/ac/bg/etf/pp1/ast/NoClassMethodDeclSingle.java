// generated with ast extension for cup
// version 0.8
// 23/11/2019 23:31:0


package rs.ac.bg.etf.pp1.ast;

public class NoClassMethodDeclSingle extends ClassMethodDeclSingle {

    public NoClassMethodDeclSingle () {
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
        buffer.append("NoClassMethodDeclSingle(\n");

        buffer.append(tab);
        buffer.append(") [NoClassMethodDeclSingle]");
        return buffer.toString();
    }
}