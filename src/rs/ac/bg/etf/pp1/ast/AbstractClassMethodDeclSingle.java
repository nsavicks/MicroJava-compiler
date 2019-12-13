// generated with ast extension for cup
// version 0.8
// 28/10/2019 19:19:40


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassMethodDeclSingle implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private AbstractMethodDeclList AbstractMethodDeclList;

    public AbstractClassMethodDeclSingle (AbstractMethodDeclList AbstractMethodDeclList) {
        this.AbstractMethodDeclList=AbstractMethodDeclList;
        if(AbstractMethodDeclList!=null) AbstractMethodDeclList.setParent(this);
    }

    public AbstractMethodDeclList getAbstractMethodDeclList() {
        return AbstractMethodDeclList;
    }

    public void setAbstractMethodDeclList(AbstractMethodDeclList AbstractMethodDeclList) {
        this.AbstractMethodDeclList=AbstractMethodDeclList;
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
        if(AbstractMethodDeclList!=null) AbstractMethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractMethodDeclList!=null) AbstractMethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractMethodDeclList!=null) AbstractMethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassMethodDeclSingle(\n");

        if(AbstractMethodDeclList!=null)
            buffer.append(AbstractMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassMethodDeclSingle]");
        return buffer.toString();
    }
}
