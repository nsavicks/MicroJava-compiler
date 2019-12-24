// generated with ast extension for cup
// version 0.8
// 23/11/2019 23:31:0


package rs.ac.bg.etf.pp1.ast;

public class AbstractMethodDeclListNode extends AbstractMethodDeclList {

    private AbstractMethodDeclList AbstractMethodDeclList;
    private AbstractMethodDeclItem AbstractMethodDeclItem;

    public AbstractMethodDeclListNode (AbstractMethodDeclList AbstractMethodDeclList, AbstractMethodDeclItem AbstractMethodDeclItem) {
        this.AbstractMethodDeclList=AbstractMethodDeclList;
        if(AbstractMethodDeclList!=null) AbstractMethodDeclList.setParent(this);
        this.AbstractMethodDeclItem=AbstractMethodDeclItem;
        if(AbstractMethodDeclItem!=null) AbstractMethodDeclItem.setParent(this);
    }

    public AbstractMethodDeclList getAbstractMethodDeclList() {
        return AbstractMethodDeclList;
    }

    public void setAbstractMethodDeclList(AbstractMethodDeclList AbstractMethodDeclList) {
        this.AbstractMethodDeclList=AbstractMethodDeclList;
    }

    public AbstractMethodDeclItem getAbstractMethodDeclItem() {
        return AbstractMethodDeclItem;
    }

    public void setAbstractMethodDeclItem(AbstractMethodDeclItem AbstractMethodDeclItem) {
        this.AbstractMethodDeclItem=AbstractMethodDeclItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractMethodDeclList!=null) AbstractMethodDeclList.accept(visitor);
        if(AbstractMethodDeclItem!=null) AbstractMethodDeclItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractMethodDeclList!=null) AbstractMethodDeclList.traverseTopDown(visitor);
        if(AbstractMethodDeclItem!=null) AbstractMethodDeclItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractMethodDeclList!=null) AbstractMethodDeclList.traverseBottomUp(visitor);
        if(AbstractMethodDeclItem!=null) AbstractMethodDeclItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractMethodDeclListNode(\n");

        if(AbstractMethodDeclList!=null)
            buffer.append(AbstractMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractMethodDeclItem!=null)
            buffer.append(AbstractMethodDeclItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractMethodDeclListNode]");
        return buffer.toString();
    }
}
