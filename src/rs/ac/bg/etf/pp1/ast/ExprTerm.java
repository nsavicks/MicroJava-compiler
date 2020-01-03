// generated with ast extension for cup
// version 0.8
// 3/0/2020 15:40:54


package rs.ac.bg.etf.pp1.ast;

public class ExprTerm extends Expr {

    private SubSingle SubSingle;
    private Term Term;

    public ExprTerm (SubSingle SubSingle, Term Term) {
        this.SubSingle=SubSingle;
        if(SubSingle!=null) SubSingle.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public SubSingle getSubSingle() {
        return SubSingle;
    }

    public void setSubSingle(SubSingle SubSingle) {
        this.SubSingle=SubSingle;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SubSingle!=null) SubSingle.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SubSingle!=null) SubSingle.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SubSingle!=null) SubSingle.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprTerm(\n");

        if(SubSingle!=null)
            buffer.append(SubSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprTerm]");
        return buffer.toString();
    }
}
