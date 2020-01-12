package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.ArrayList;
import java.util.Stack;

public class CodeGenerator extends VisitorAdaptor {

    private int mainPc;

    public int getMainPc() {
        return mainPc;
    }

    // PRINT & READ

    @Override
    public void visit(StatementPrint StatementPrint) {

        CommaNumConstSingle commaNumConstSingle = StatementPrint.getCommaNumConstSingle();
        int val = 1;

        if (commaNumConstSingle instanceof  CommaNumConstSingleNode){

            val = ((CommaNumConstSingleNode) commaNumConstSingle).getValue();

        }

        if (StatementPrint.getExpr().struct == Tab.intType || StatementPrint.getExpr().struct == TableExtensions.boolType){
            Code.loadConst(val);
            Code.put(Code.print);
        }
        else{
            Code.loadConst(val);
            Code.put(Code.bprint);
        }

    }

    @Override
    public void visit(StatementRead StatementRead) {

        Struct type = StatementRead.getDesignator().obj.getType();

        if (type == Tab.intType || type == TableExtensions.boolType){
            Code.put(Code.read);
        }
        else{
            Code.put(Code.bread);
        }

        Code.store(StatementRead.getDesignator().obj);
    }

    // FACTOR

    @Override
    public void visit(FactorConstant FactorConstant) {

        ConstLiteral constLiteral = FactorConstant.getConstLiteral();

        Obj obj = new Obj(Obj.Con, "$", constLiteral.struct);

        obj.setLevel(0);

        if (constLiteral instanceof ConstLiteralNum){
            obj.setAdr(((ConstLiteralNum) constLiteral).getValue());
        }

        if (constLiteral instanceof ConstLiteralChar){
            obj.setAdr(((ConstLiteralChar) constLiteral).getValue());
        }

        if (constLiteral instanceof ConstLiteralBool){
            obj.setAdr(((ConstLiteralBool) constLiteral).getValue() ? 1: 0);
        }

        Code.load(obj);
    }

    @Override
    public void visit(FactorNewArray FactorNewArray) {

        Struct elemType = FactorNewArray.struct.getElemType();

        Code.put(Code.newarray);

        if (elemType == Tab.intType || elemType == TableExtensions.boolType)
            Code.put(1);
        else
            Code.put(0);

    }

    // EXPRESSIONS AND TERMS

    @Override
    public void visit(TermMul TermMul) {

        Mulop mulop = TermMul.getMulop();

        if (mulop instanceof MulopNode) Code.put(Code.mul);
        else if (mulop instanceof DivopNode) Code.put(Code.div);
        else if (mulop instanceof ModopNode) Code.put(Code.rem);

    }

    @Override
    public void visit(ExprTerm ExprTerm) {

        if (ExprTerm.getSubSingle() instanceof SubSingleNode){
            Code.put(Code.neg);
        }

    }

    @Override
    public void visit(ExprAdd ExprAdd) {

        Addop addop = ExprAdd.getAddop();

        if (addop instanceof AddopNode) Code.put(Code.add);
        else if (addop instanceof SubopNode) Code.put(Code.sub);
    }

    // CONDITIONS

    ArrayList<Integer> andList = new ArrayList<>();
    ArrayList<Integer> orList = new ArrayList<>();

    @Override
    public void visit(ConditionOr ConditionOr) {

        if (!(ConditionOr.getParent() instanceof ConditionOr)){

            Code.loadConst(0);
            Code.putJump(Code.pc + 4);

            for (Integer adr: orList){

                Code.fixup(adr);

            }

            orList.clear();

            Code.loadConst(1);

        }

    }

    @Override
    public void visit(ConditionTerm ConditionTerm) {


        if (!(ConditionTerm.getParent() instanceof ConditionOr)){

            Code.loadConst(0);
            Code.putJump(Code.pc + 4);

            for (Integer adr: orList){

                Code.fixup(adr);

            }

            orList.clear();

            Code.loadConst(1);

        }

    }

    @Override
    public void visit(CondTermAnd CondTermAnd) {


        if (!(CondTermAnd.getParent() instanceof CondTermAnd)){
            // If finished with CondTerm fix jump addresses for optimized calculating (AND conditions)
            Code.loadConst(1);
            Code.putJump(Code.pc + 4);

            for (Integer adr: andList){

                Code.fixup(adr);

            }

            andList.clear();

            Code.loadConst(0);


            // Put false jump if other OR condterms dont need to be calculated
            Code.loadConst(1);
            Code.putFalseJump(Code.ne, 0);
            orList.add(Code.pc - 2);

        }

    }

    @Override
    public void visit(CondTermFact CondTermFact) {

        if (!(CondTermFact.getParent() instanceof CondTermAnd)){

            // If finished with CondTerm fix jump addresses for optimized calculating (AND conditions)
            Code.loadConst(1);
            Code.putJump(Code.pc + 4);

            for (Integer adr: andList){

                Code.fixup(adr);

            }

            andList.clear();

            Code.loadConst(0);

            // Put false jump if other OR condterms dont need to be calculated
            Code.loadConst(1);
            Code.putFalseJump(Code.ne, 0);
            orList.add(Code.pc - 2);

        }

    }

    @Override
    public void visit(CondFactRelop CondFactRelop) {

        int relop = 0;
        Relop rel = CondFactRelop.getRelop();

        if (rel instanceof Equalop) relop = Code.eq;
        if (rel instanceof NotEqualop) relop = Code.ne;
        if (rel instanceof Greaterop) relop = Code.gt;
        if (rel instanceof GreaterEqualop) relop = Code.ge;
        if (rel instanceof Lesserop) relop = Code.lt;
        if (rel instanceof LesserEqualop) relop = Code.le;

        Code.putFalseJump(relop, Code.pc + 7);
        Code.loadConst(1);
        Code.putJump(Code.pc + 4);
        Code.loadConst(0);

        // Jump to end of AND condition if not true
        Code.loadConst(1);
        Code.putFalseJump(Code.eq, 0);
        andList.add(Code.pc - 2);

    }

    @Override
    public void visit(CondFactExpr CondFactExpr) {

        // Jump to end of AND condition if not true
        Code.loadConst(1);
        Code.putFalseJump(Code.eq, 0);
        andList.add(Code.pc - 2);

    }

    // FUNCTIONS

    @Override
    public void visit(MethodDeclTypeIdentNode MethodDeclTypeIdentNode) {

        if (MethodDeclTypeIdentNode.getMethName().equals("main")){
            mainPc = Code.pc;
        }

        MethodDeclTypeIdentNode.obj.setAdr(Code.pc);

        SyntaxNode syntaxNode = MethodDeclTypeIdentNode.getParent().getParent();

        CounterVisitor counterVisitor = new CounterVisitor();
        syntaxNode.traverseBottomUp(counterVisitor);

        Code.put(Code.enter);
        Code.put(counterVisitor.getFormParsCnt());
        Code.put(counterVisitor.getFormParsCnt() + counterVisitor.getVarCnt());

        //System.out.println(counterVisitor.getFormParsCnt() + " " + counterVisitor.getVarCnt());

    }

    @Override
    public void visit(MethodDeclNode MethodDeclNode) {

        if (MethodDeclNode.getMethodDeclPrototype().obj.getType() == Tab.noType){
            Code.put(Code.exit);
            Code.put(Code.return_);
        }
        else{
            Code.put(Code.trap);
            Code.put(0);
        }
    }

    @Override
    public void visit(StatementReturn StatementReturn) {

        Code.put(Code.exit);
        Code.put(Code.return_);

    }

    @Override
    public void visit(DesignatorStatementFunc DesignatorStatementFunc) {

        Obj meth = DesignatorStatementFunc.getDesignatorStatementFuncDesignator().getDesignator().obj;

        if (meth.getName().equals("len")){

            Code.put(Code.arraylength);

        }
        else if (!meth.getName().equals("chr") && !meth.getName().equals("ord")){

            int off = meth.getAdr() - Code.pc;
            Code.put(Code.call);
            Code.put2(off);

        }

        // if function has return value pop it from stack because this is statement and it will not be used
        if (meth.getType() != Tab.noType){
            Code.put(Code.pop);
        }

    }

    @Override
    public void visit(FactorFuncCall FactorFuncCall) {

        Obj meth = FactorFuncCall.getFactorFuncCallDesignator().getDesignator().obj;

        if (meth.getName().equals("len")){

            Code.put(Code.arraylength);

        }
        else if (!meth.getName().equals("chr") && !meth.getName().equals("ord")){

            int off = meth.getAdr() - Code.pc;
            Code.put(Code.call);
            Code.put2(off);

        }

    }

    // DESIGNATOR

    @Override
    public void visit(DesignatorIdent DesignatorIdent) {

        if (DesignatorIdent.getParent() instanceof  StatementRead
            || DesignatorIdent.getParent() instanceof DesignatorStatementInc
            || DesignatorIdent.getParent() instanceof DesignatorStatementDec
            || DesignatorIdent.getParent() instanceof DesignatorAssignItemNode
            || DesignatorIdent.getParent() instanceof FactorFuncCallDesignator
            || DesignatorIdent.getParent() instanceof DesignatorStatementFuncDesignator
            ) return;

        Code.load(DesignatorIdent.obj);

    }

    @Override
    public void visit(DesignatorArray DesignatorArray) {

        if (DesignatorArray.getParent() instanceof  StatementRead
                || DesignatorArray.getParent() instanceof DesignatorAssignItemNode
                || DesignatorArray.getParent() instanceof DesignatorStatementInc
                || DesignatorArray.getParent() instanceof DesignatorStatementDec
                || DesignatorArray.getParent() instanceof FactorFuncCallDesignator
                || DesignatorArray.getParent() instanceof DesignatorStatementFuncDesignator) return;

        Code.load(DesignatorArray.obj);

    }

    // DESIGNATOR STATEMENT

    @Override
    public void visit(DesignatorAssignItemNode DesignatorAssignItemNode) {

        Code.store(DesignatorAssignItemNode.getDesignator().obj);

    }

    @Override
    public void visit(DesignatorStatementInc DesignatorStatementInc) {

        if (DesignatorStatementInc.getDesignator() instanceof DesignatorArray) Code.put(Code.dup2);

        Code.load(DesignatorStatementInc.getDesignator().obj);
        Code.loadConst(1);
        Code.put(Code.add);
        Code.store(DesignatorStatementInc.getDesignator().obj);

    }

    @Override
    public void visit(DesignatorStatementDec DesignatorStatementDec) {

        if (DesignatorStatementDec.getDesignator() instanceof DesignatorArray) Code.put(Code.dup2);

        Code.load(DesignatorStatementDec.getDesignator().obj);
        Code.loadConst(1);
        Code.put(Code.sub);
        Code.store(DesignatorStatementDec.getDesignator().obj);

    }

    // IF

    Stack<Integer> lastIfAddress = new Stack<>();
    Stack<Integer> lastElseAddress = new Stack<>();

    @Override
    public void visit(IfHeaderNode IfHeaderNode) {

        Code.loadConst(1);

        Code.putFalseJump(Code.eq, 0);

        lastIfAddress.push(Code.pc - 2);

    }

    @Override
    public void visit(ElseNode ElseNode) {

        Code.putJump(0);

        Code.fixup(lastIfAddress.pop());

        lastElseAddress.push(Code.pc - 2);

    }

    @Override
    public void visit(StatementIf StatementIf) {

        if (!(StatementIf.getElseStatementSingle() instanceof ElseStatementSingleNode)){

            // No else
            Code.fixup(lastIfAddress.pop());

        }
        else{
            Code.fixup(lastElseAddress.pop());
        }

    }

    // FOR

    Stack<Integer> conditionAdr = new Stack<>();
    Stack<Integer> stepAdr = new Stack<>();
    Stack<Integer> bodyAdr = new Stack<>();
    Stack<Integer> endAdr = new Stack<>();
    Stack<Boolean> fixEndAdr = new Stack<>();
    ArrayList<ArrayList<Integer>> breakAdrs = new ArrayList<>();

    @Override
    public void visit(ForInitNode ForInitNode) {
        conditionAdr.push(Code.pc);
        breakAdrs.add(new ArrayList<>());
    }

    @Override
    public void visit(ForConditionSingleNode ForConditionSingleNode) {

        if (ForConditionSingleNode.getConditionSingle() instanceof ConditionSingleNode){

            Code.loadConst(0);
            Code.putFalseJump(Code.ne, 0);
            endAdr.push(Code.pc - 2);
            fixEndAdr.push(true);

        }
        else {
            fixEndAdr.push(false);
        }

        Code.putJump(0);
        bodyAdr.push(Code.pc - 2);

        stepAdr.push(Code.pc);
    }

    @Override
    public void visit(ForStepNode ForStepNode) {

        Code.putJump(conditionAdr.peek());

    }

    @Override
    public void visit(ForLoopHeaderNode ForLoopHeaderNode) {

        Code.fixup(bodyAdr.peek());
    }

    @Override
    public void visit(StatementFor StatementFor) {

        Code.putJump(stepAdr.peek());

        if (fixEndAdr.peek())
            Code.fixup(endAdr.peek());

        // fix breaks addresses

        ArrayList<Integer> currForBreaks = breakAdrs.get(breakAdrs.size() - 1);

        for (int breakAdr : currForBreaks){
            Code.fixup(breakAdr);
        }

        breakAdrs.remove(breakAdrs.size() - 1);

        // remove current for from stack
        stepAdr.pop();
        conditionAdr.pop();
        bodyAdr.pop();
        if (fixEndAdr.peek())
            endAdr.pop();
        fixEndAdr.pop();

    }

    @Override
    public void visit(StatementBreak StatementBreak) {

        Code.putJump(0);

        breakAdrs.get(breakAdrs.size() - 1).add(Code.pc - 2);

    }

    @Override
    public void visit(StatementContinue StatementContinue) {
        Code.putJump(stepAdr.peek());
    }
}
