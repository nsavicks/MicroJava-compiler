// generated with ast extension for cup
// version 0.8
// 21/11/2019 18:17:11


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassDeclIdent ClassDeclIdent;
    private ExtendsSingle ExtendsSingle;
    private VarDeclList VarDeclList;
    private ClassMethodDeclSingle ClassMethodDeclSingle;

    public ClassDecl (ClassDeclIdent ClassDeclIdent, ExtendsSingle ExtendsSingle, VarDeclList VarDeclList, ClassMethodDeclSingle ClassMethodDeclSingle) {
        this.ClassDeclIdent=ClassDeclIdent;
        if(ClassDeclIdent!=null) ClassDeclIdent.setParent(this);
        this.ExtendsSingle=ExtendsSingle;
        if(ExtendsSingle!=null) ExtendsSingle.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.ClassMethodDeclSingle=ClassMethodDeclSingle;
        if(ClassMethodDeclSingle!=null) ClassMethodDeclSingle.setParent(this);
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
        if(ClassDeclIdent!=null) ClassDeclIdent.accept(visitor);
        if(ExtendsSingle!=null) ExtendsSingle.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(ClassMethodDeclSingle!=null) ClassMethodDeclSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclIdent!=null) ClassDeclIdent.traverseTopDown(visitor);
        if(ExtendsSingle!=null) ExtendsSingle.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(ClassMethodDeclSingle!=null) ClassMethodDeclSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclIdent!=null) ClassDeclIdent.traverseBottomUp(visitor);
        if(ExtendsSingle!=null) ExtendsSingle.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(ClassMethodDeclSingle!=null) ClassMethodDeclSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

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
