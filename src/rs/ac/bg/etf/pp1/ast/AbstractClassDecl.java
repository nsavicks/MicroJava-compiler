// generated with ast extension for cup
// version 0.8
// 31/11/2019 4:46:43


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassDeclIdent ClassDeclIdent;
    private ExtendsSingle ExtendsSingle;
    private VarDeclList VarDeclList;
    private AbstractClassMethodDeclSingle AbstractClassMethodDeclSingle;

    public AbstractClassDecl (ClassDeclIdent ClassDeclIdent, ExtendsSingle ExtendsSingle, VarDeclList VarDeclList, AbstractClassMethodDeclSingle AbstractClassMethodDeclSingle) {
        this.ClassDeclIdent=ClassDeclIdent;
        if(ClassDeclIdent!=null) ClassDeclIdent.setParent(this);
        this.ExtendsSingle=ExtendsSingle;
        if(ExtendsSingle!=null) ExtendsSingle.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.AbstractClassMethodDeclSingle=AbstractClassMethodDeclSingle;
        if(AbstractClassMethodDeclSingle!=null) AbstractClassMethodDeclSingle.setParent(this);
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

    public AbstractClassMethodDeclSingle getAbstractClassMethodDeclSingle() {
        return AbstractClassMethodDeclSingle;
    }

    public void setAbstractClassMethodDeclSingle(AbstractClassMethodDeclSingle AbstractClassMethodDeclSingle) {
        this.AbstractClassMethodDeclSingle=AbstractClassMethodDeclSingle;
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
        if(AbstractClassMethodDeclSingle!=null) AbstractClassMethodDeclSingle.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclIdent!=null) ClassDeclIdent.traverseTopDown(visitor);
        if(ExtendsSingle!=null) ExtendsSingle.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(AbstractClassMethodDeclSingle!=null) AbstractClassMethodDeclSingle.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclIdent!=null) ClassDeclIdent.traverseBottomUp(visitor);
        if(ExtendsSingle!=null) ExtendsSingle.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(AbstractClassMethodDeclSingle!=null) AbstractClassMethodDeclSingle.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDecl(\n");

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

        if(AbstractClassMethodDeclSingle!=null)
            buffer.append(AbstractClassMethodDeclSingle.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDecl]");
        return buffer.toString();
    }
}
