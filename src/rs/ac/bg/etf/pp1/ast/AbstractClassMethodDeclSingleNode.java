// generated with ast extension for cup
// version 0.8
// 29/11/2019 21:50:4


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassMethodDeclSingleNode extends AbstractClassMethodDeclSingle {

    private AbstractMethodDeclList AbstractMethodDeclList;

    public AbstractClassMethodDeclSingleNode (AbstractMethodDeclList AbstractMethodDeclList) {
        this.AbstractMethodDeclList=AbstractMethodDeclList;
        if(AbstractMethodDeclList!=null) AbstractMethodDeclList.setParent(this);
    }

    public AbstractMethodDeclList getAbstractMethodDeclList() {
        return AbstractMethodDeclList;
    }

    public void setAbstractMethodDeclList(AbstractMethodDeclList AbstractMethodDeclList) {
        this.AbstractMethodDeclList=AbstractMethodDeclList;
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
        buffer.append("AbstractClassMethodDeclSingleNode(\n");

        if(AbstractMethodDeclList!=null)
            buffer.append(AbstractMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassMethodDeclSingleNode]");
        return buffer.toString();
    }
}
