// generated with ast extension for cup
// version 0.8
// 29/11/2019 17:20:37


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassDeclSignature ClassDeclSignature;
    private VarDeclList VarDeclList;
    private ClassMethodDeclSingle ClassMethodDeclSingle;

    public ClassDecl (ClassDeclSignature ClassDeclSignature, VarDeclList VarDeclList, ClassMethodDeclSingle ClassMethodDeclSingle) {
        this.ClassDeclSignature=ClassDeclSignature;
        if(ClassDeclSignature!=null) ClassDeclSignature.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.ClassMethodDeclSingle=ClassMethodDeclSingle;
        if(ClassMethodDeclSingle!=null) ClassMethodDeclSingle.setParent(this);
    }

    public ClassDeclSignature getClassDeclSignature() {
        return ClassDeclSignature;
    }

    public void setClassDeclSignature(ClassDeclSignature ClassDeclSignature) {
        this.ClassDeclSignature=ClassDeclSignature;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public ClassMethodDeclSingle getClassMethodDeclSingle() {
        return ClassMethodDeclSingle;
    }

    public void setClassMethodDeclSingle(ClassMethodDeclSingle ClassMethodDeclSingle) {
        this.ClassMethodDeclSingle=ClassMethodDeclSingle;
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
        if(ClassDeclSignature!=null) ClassDeclSignature.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(ClassMethodDeclSingle!=null) ClassMethodDeclSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclSignature!=null) ClassDeclSignature.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(ClassMethodDeclSingle!=null) ClassMethodDeclSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclSignature!=null) ClassDeclSignature.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(ClassMethodDeclSingle!=null) ClassMethodDeclSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        if(ClassDeclSignature!=null)
            buffer.append(ClassDeclSignature.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassMethodDeclSingle!=null)
            buffer.append(ClassMethodDeclSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
