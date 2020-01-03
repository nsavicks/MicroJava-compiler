// generated with ast extension for cup
// version 0.8
// 3/0/2020 14:11:38


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclPrototype implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private MethodDeclTypeIdent MethodDeclTypeIdent;
    private FormParsSingle FormParsSingle;

    public MethodDeclPrototype (MethodDeclTypeIdent MethodDeclTypeIdent, FormParsSingle FormParsSingle) {
        this.MethodDeclTypeIdent=MethodDeclTypeIdent;
        if(MethodDeclTypeIdent!=null) MethodDeclTypeIdent.setParent(this);
        this.FormParsSingle=FormParsSingle;
        if(FormParsSingle!=null) FormParsSingle.setParent(this);
    }

    public MethodDeclTypeIdent getMethodDeclTypeIdent() {
        return MethodDeclTypeIdent;
    }

    public void setMethodDeclTypeIdent(MethodDeclTypeIdent MethodDeclTypeIdent) {
        this.MethodDeclTypeIdent=MethodDeclTypeIdent;
    }

    public FormParsSingle getFormParsSingle() {
        return FormParsSingle;
    }

    public void setFormParsSingle(FormParsSingle FormParsSingle) {
        this.FormParsSingle=FormParsSingle;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclTypeIdent!=null) MethodDeclTypeIdent.accept(visitor);
        if(FormParsSingle!=null) FormParsSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclTypeIdent!=null) MethodDeclTypeIdent.traverseTopDown(visitor);
        if(FormParsSingle!=null) FormParsSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclTypeIdent!=null) MethodDeclTypeIdent.traverseBottomUp(visitor);
        if(FormParsSingle!=null) FormParsSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclPrototype(\n");

        if(MethodDeclTypeIdent!=null)
            buffer.append(MethodDeclTypeIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsSingle!=null)
            buffer.append(FormParsSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclPrototype]");
        return buffer.toString();
    }
}
