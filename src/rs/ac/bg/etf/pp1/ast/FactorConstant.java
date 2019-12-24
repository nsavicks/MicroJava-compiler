// generated with ast extension for cup
// version 0.8
// 23/11/2019 23:31:0


package rs.ac.bg.etf.pp1.ast;

public class FactorConstant extends Factor {

    private ConstLiteral ConstLiteral;

    public FactorConstant (ConstLiteral ConstLiteral) {
        this.ConstLiteral=ConstLiteral;
        if(ConstLiteral!=null) ConstLiteral.setParent(this);
    }

    public ConstLiteral getConstLiteral() {
        return ConstLiteral;
    }

    public void setConstLiteral(ConstLiteral ConstLiteral) {
        this.ConstLiteral=ConstLiteral;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstLiteral!=null) ConstLiteral.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstLiteral!=null) ConstLiteral.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstLiteral!=null) ConstLiteral.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorConstant(\n");

        if(ConstLiteral!=null)
            buffer.append(ConstLiteral.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorConstant]");
        return buffer.toString();
    }
}
