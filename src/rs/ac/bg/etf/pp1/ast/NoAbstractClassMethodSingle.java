// generated with ast extension for cup
// version 0.8
// 23/11/2019 23:31:0


package rs.ac.bg.etf.pp1.ast;

public class NoAbstractClassMethodSingle extends AbstractClassMethodDeclSingle {

    public NoAbstractClassMethodSingle () {
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
        buffer.append("NoAbstractClassMethodSingle(\n");

        buffer.append(tab);
        buffer.append(") [NoAbstractClassMethodSingle]");
        return buffer.toString();
    }
}