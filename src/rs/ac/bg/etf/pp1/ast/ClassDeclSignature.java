// generated with ast extension for cup
// version 0.8
// 3/0/2020 15:40:53


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclSignature implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private ClassDeclIdent ClassDeclIdent;
    private ExtendsSingle ExtendsSingle;

    public ClassDeclSignature (ClassDeclIdent ClassDeclIdent, ExtendsSingle ExtendsSingle) {
        this.ClassDeclIdent=ClassDeclIdent;
        if(ClassDeclIdent!=null) ClassDeclIdent.setParent(this);
        this.ExtendsSingle=ExtendsSingle;
        if(ExtendsSingle!=null) ExtendsSingle.setParent(this);
    }

    public ClassDeclIdent getClassDeclIdent() {
        return ClassDeclIdent;
    }

    public void setClassDeclIdent(ClassDeclIdent ClassDeclIdent) {
        this.ClassDeclIdent=ClassDeclIdent;
    }

    public ExtendsSingle getExtendsSingle() {
        return ExtendsSingle;
    }

    public void setExtendsSingle(ExtendsSingle ExtendsSingle) {
        this.ExtendsSingle=ExtendsSingle;
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
        if(ClassDeclIdent!=null) ClassDeclIdent.accept(visitor);
        if(ExtendsSingle!=null) ExtendsSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclIdent!=null) ClassDeclIdent.traverseTopDown(visitor);
        if(ExtendsSingle!=null) ExtendsSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclIdent!=null) ClassDeclIdent.traverseBottomUp(visitor);
        if(ExtendsSingle!=null) ExtendsSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclSignature(\n");

        if(ClassDeclIdent!=null)
            buffer.append(ClassDeclIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExtendsSingle!=null)
            buffer.append(ExtendsSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclSignature]");
        return buffer.toString();
    }
}
