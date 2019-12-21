// generated with ast extension for cup
// version 0.8
// 21/11/2019 18:17:11


package rs.ac.bg.etf.pp1.ast;

public class ConstLiteralNum extends ConstLiteral {

    private Integer value;

    public ConstLiteralNum (Integer value) {
        this.value=value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value=value;
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
        buffer.append("ConstLiteralNum(\n");

        buffer.append(" "+tab+value);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstLiteralNum]");
        return buffer.toString();
    }
}
