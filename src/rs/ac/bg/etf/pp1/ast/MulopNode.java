// generated with ast extension for cup
// version 0.8
// 3/0/2020 14:11:39


package rs.ac.bg.etf.pp1.ast;

public class MulopNode extends Mulop {

    public MulopNode () {
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
        buffer.append("MulopNode(\n");

        buffer.append(tab);
        buffer.append(") [MulopNode]");
        return buffer.toString();
    }
}
