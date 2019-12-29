package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import javax.lang.model.element.VariableElement;

public class SemanticAnalyzer extends VisitorAdaptor {

    boolean errorDetected = false;
    Type currentType = null;
    Obj curretClass = null;


    Logger log = Logger.getLogger(getClass());

    public void report_error(String message, SyntaxNode info) {
        errorDetected = true;
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();
        if (line != 0)
            msg.append (" na liniji ").append(line);
        log.error(msg.toString());
    }

    public void report_info(String message, SyntaxNode info) {
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();
        if (line != 0)
            msg.append (" na liniji ").append(line);
        log.info(msg.toString());
    }

    @Override
    public void visit(ProgName ProgName) {

        ProgName.obj = Tab.insert(Obj.Prog, ProgName.getProgName(), Tab.noType);
        Tab.openScope();
    }

    @Override
    public void visit(Program Program) {

        Tab.chainLocalSymbols(Program.getProgName().obj);

    }

    @Override
    public void visit(Type Type) {

        Obj obj = Tab.find(Type.getTypeName());

        if (obj != Tab.noObj){

            if (obj.getKind() == Obj.Type){

                Type.struct = obj.getType();

            }
            else{
                report_error("Error on line " + Type.getLine() + ": " + "Name " + Type.getTypeName() + " does not represent a type.", null);
                Type.struct = Tab.noType;
            }

        }
        else{

            report_error("Error on line " + Type.getLine() + ": " + "Type " + Type.getTypeName() + " not found.", null);
            Type.struct = Tab.noType;

        }

    }

    @Override
    public void visit(ConstLiteralBool ConstLiteralBool) {
        ConstLiteralBool.struct = TableExtensions.boolType;
    }

    @Override
    public void visit(ConstLiteralChar ConstLiteralChar) {
        ConstLiteralChar.struct = Tab.charType;
    }

    @Override
    public void visit(ConstLiteralNum ConstLiteralNum) {
        ConstLiteralNum.struct = Tab.intType;
    }

    @Override
    public void visit(ConstType ConstType) {
        currentType = ConstType.getType();
    }

    @Override
    public void visit(ConstDeclListItem ConstDeclListItem) {

        String constName = ConstDeclListItem.getConstName();
        ConstLiteral constLiteral = ConstDeclListItem.getConstLiteral();

        Obj obj = Tab.currentScope().findSymbol(constName);

        if (obj == Tab.noObj || obj == null){

            if (constLiteral.struct == currentType.struct){

                Obj inserted = Tab.insert(Obj.Con, constName, currentType.struct);
                inserted.setAdr(TableExtensions.GetConstValue(constLiteral));

            }
            else {
                report_error("Error on line " + ConstDeclListItem.getLine() + ": " + "Type " + currentType.getTypeName() + " does not match constant literal type.", null);
            }

        }
        else{
            report_error("Error on line " + ConstDeclListItem.getLine() + ": " + "Name " + constName + " has already been declared.", null);
        }

    }

    @Override
    public void visit(VarType VarType) {
        currentType = VarType.getType();
    }

    @Override
    public void visit(VarIdentSingleNode VarIdentSingleNode) {

        Obj obj = Tab.currentScope().findSymbol(VarIdentSingleNode.getVarName());

        if (obj == Tab.noObj || obj == null){

            if (VarIdentSingleNode.getSquareSingle() instanceof SquareSingleNode){

                Tab.insert(Obj.Var, VarIdentSingleNode.getVarName(), new Struct(Struct.Array, currentType.struct));

            }
            else{

                Tab.insert(Obj.Var, VarIdentSingleNode.getVarName(), currentType.struct);

            }

        }
        else{
            report_error("Error on line " + VarIdentSingleNode.getLine() + ": " + "Name " + VarIdentSingleNode.getVarName() + " has already been declared.", null);
        }
    }

    @Override
    public void visit(DesignatorArray DesignatorArray) {

        Designator leftSide = DesignatorArray.getDesignator();

        if (leftSide.obj.getType().getKind() == Struct.Array){

            if (DesignatorArray.getExpr().struct != Tab.intType){
                report_error("Error on line " + DesignatorArray.getLine() + ": Expression betwen [] must be int type.", null);
            }

            DesignatorArray.obj = new Obj(Obj.Elem, "#", leftSide.obj.getType().getElemType());

        }
        else{
            report_error("Error on line " + DesignatorArray.getLine() + ": Cannot use indexing on non array type.", null);
        }

    }

    @Override
    public void visit(DesignatorDot DesignatorDot) {

        // TODO Class members

    }

    @Override
    public void visit(DesignatorIdent DesignatorIdent) {

        Obj obj = Tab.find(DesignatorIdent.getName());

        if (obj != Tab.noObj && obj != null){

            DesignatorIdent.obj = obj;

        }
        else{
            report_error("Error on line " + DesignatorIdent.getLine() + ": Name " + DesignatorIdent.getName() + " has not been declared.", null);
        }

    }

    @Override
    public void visit(FactorVariable FactorVariable) {
        FactorVariable.struct = FactorVariable.getDesignator().obj.getType();
    }

    @Override
    public void visit(FactorFuncCall FactorFuncCall) {
        if (FactorFuncCall.getDesignator().obj.getKind() == Obj.Meth){
            FactorFuncCall.struct = FactorFuncCall.getDesignator().obj.getType();
        }
        else{
            report_error("Error on line: " + FactorFuncCall.getLine() + ": Designator must be function or method.", null);
        }
    }

    @Override
    public void visit(FactorConstant FactorConstant) {
        FactorConstant.struct = FactorConstant.getConstLiteral().struct;
    }

    @Override
    public void visit(FactorNewClass FactorNewClass) {

        if (FactorNewClass.getType().struct.getKind() == Struct.Class){
            FactorNewClass.struct = FactorNewClass.getType().struct;
        }
        else{
            report_error("Error on line " + FactorNewClass.getLine() + ": Type " + FactorNewClass.getType().getTypeName() + " is not a class.", null);
        }
    }

    @Override
    public void visit(FactorNewArray FactorNewArray) {
        if (FactorNewArray.getExpr().struct == Tab.intType){
            FactorNewArray.struct = new Struct(Struct.Array, FactorNewArray.getType().struct);
        }
        else{
            report_error("Error on line " + FactorNewArray.getLine() + ": Expression between [] must be of type int.", null);
        }
    }

    @Override
    public void visit(FactorExpr FactorExpr) {
        super.visit(FactorExpr);
    }

    @Override
    public void visit(TermMul TermMul) {

        Term leftSide = TermMul.getTerm();
        Factor rightSide = TermMul.getFactor();

        if (leftSide.struct != Tab.intType || rightSide.struct != Tab.intType){
            report_error("Error on line " + TermMul.getLine() + ": Both operands of * must be int type.", null);
        }

        TermMul.struct = Tab.intType;
    }

    @Override
    public void visit(TermFactor TermFactor) {
        TermFactor.struct = TermFactor.getFactor().struct;
    }

    @Override
    public void visit(ExprAdd ExprAdd) {

        Expr leftSide = ExprAdd.getExpr();
        Term rightSide = ExprAdd.getTerm();

        if (leftSide.struct != Tab.intType || rightSide.struct != Tab.intType){
            report_error("Error on line " + ExprAdd.getLine() + ": When using + operands must be int type.", null);
        }

        ExprAdd.struct = Tab.intType;
    }

    @Override
    public void visit(ExprTerm ExprTerm) {

        if (ExprTerm.getSubSingle() instanceof SubSingleNode){
            if (ExprTerm.getTerm().struct != Tab.intType){
                report_error("Error on line " + ExprTerm.getLine() + ": When using unary operator - operand must be of int type.", null);
            }
        }

        ExprTerm.struct = ExprTerm.getTerm().struct;
    }

    @Override
    public void visit(StatementPrint StatementPrint) {

        if (StatementPrint.getExpr().struct != Tab.intType
            && StatementPrint.getExpr().struct != Tab.charType
            && StatementPrint.getExpr().struct != TableExtensions.boolType
        )
        {
            report_error("Error on line " + StatementPrint.getLine() + ": Print expression must be int, char or bool type.", null);
        }

    }

    @Override
    public void visit(StatementRead StatementRead) {

        Designator designator = StatementRead.getDesignator();

        if (designator.obj.getKind() != Obj.Var
            && designator.obj.getKind() != Obj.Elem
            && designator.obj.getKind() != Obj.Fld
        )
        {
            report_error("Error on line " + StatementRead.getLine() + ": Read designator must be variable, array element or class field.",null);
        }
        else{

            if (designator.obj.getType() != Tab.intType
                && designator.obj.getType() != Tab.charType
                && designator.obj.getType() != TableExtensions.boolType
            )
            {
                report_error("Error on line " + StatementRead.getLine() + ": Read designator type must be int, char or bool.",null);
            }

        }
    }

    @Override
    public void visit(DesignatorStatementAssignNode DesignatorStatementAssignNode) {

        if (DesignatorStatementAssignNode.getDesignatorAssignItem() instanceof DesignatorAssignItemNode){

            Designator designator = ((DesignatorAssignItemNode) DesignatorStatementAssignNode.getDesignatorAssignItem()).getDesignator();
            Expr expr = ((DesignatorAssignItemNode) DesignatorStatementAssignNode.getDesignatorAssignItem()).getExpr();

            if (designator.obj.getKind() != Obj.Var
                && designator.obj.getKind() != Obj.Elem
                && designator.obj.getKind() != Obj.Fld
            )
            {
                report_error("Error on line " + DesignatorStatementAssignNode.getLine() + ": Value can be assigned to variable, array element or class field.",null);
            }
            else{

                // Provera kompatibilnosti

                if (!TableExtensions.CheckTypeCompatibility(designator.obj.getType(), expr.struct)){
                    report_error("Error on line " + DesignatorStatementAssignNode.getLine() + ": Types are not compatible.", null);
                }

            }

        }

    }

    @Override
    public void visit(DesignatorStatementDec DesignatorStatementDec) {

        Designator designator = DesignatorStatementDec.getDesignator();

        if (designator.obj.getKind() != Obj.Var
            && designator.obj.getKind() != Obj.Elem
            && designator.obj.getKind() != Obj.Fld
        )
        {
            report_error("Error on line " + DesignatorStatementDec.getLine() + ": Designator must be variable, array element or class field.", null);
        }
        else{

            if (designator.obj.getType() != Tab.intType){
                report_error("Error on line " + DesignatorStatementDec.getLine() + ": Operator -- must be used on int type designator.", null);
            }

        }

    }

    @Override
    public void visit(DesignatorStatementInc DesignatorStatementInc) {

        Designator designator = DesignatorStatementInc.getDesignator();

        if (designator.obj.getKind() != Obj.Var
            && designator.obj.getKind() != Obj.Elem
            && designator.obj.getKind() != Obj.Fld
        )
        {
            report_error("Error on line " + DesignatorStatementInc.getLine() + ": Designator must be variable, array element or class field.", null);
        }
        else{

            if (designator.obj.getType() != Tab.intType){
                report_error("Error on line " + DesignatorStatementInc.getLine() + ": Operator ++ must be used on int type designator.", null);
            }

        }

    }
}
