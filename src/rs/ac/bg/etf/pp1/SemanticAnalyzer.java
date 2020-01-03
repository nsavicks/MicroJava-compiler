package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.Iterator;

public class SemanticAnalyzer extends VisitorAdaptor {

    boolean errorDetected = false;
    Type currentType = null;
    Obj curretClass = null;

    // Functions
    boolean isVoid = false;
    boolean foundReturn = false;
    Obj currentFunction = null;
    Struct funcRetType = null;
    boolean mainFound = false;
    int cntFormPars = 0;
    
    // Calling functions
    int currentActPar = 1;
    Obj calledFunction = null;

    // For loop
    int cntInFor = 0;

    int nVars;

    public int getnVars() {
        return nVars;
    }

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

        nVars = Tab.currentScope().getnVars();
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
        DesignatorArray.obj = Tab.noObj;

        if (leftSide.obj.getType().getKind() == Struct.Array){

            if (DesignatorArray.getExpr().struct != Tab.intType){
                report_error("Error on line " + DesignatorArray.getLine() + ": Expression betwen [] must be int type.", null);
            }

            report_info("Info on line " + DesignatorArray.getLine() + ": Detected usage of array element.", null);

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
        DesignatorIdent.obj = Tab.noObj;

        if (obj != Tab.noObj && obj != null){

            DesignatorIdent.obj = obj;

            if (obj.getKind() == Obj.Con){
                report_info("Info on line: " + DesignatorIdent.getLine() + ": Detected usage of symbolic constant " + obj.getName() +".", null);
            }

            if (obj.getKind() == Obj.Var && obj.getLevel() == 0){
                report_info("Info on line: " + DesignatorIdent.getLine() + ": Detected usage of global variable " + obj.getName() +".", null);
            }

            if (currentFunction != null && obj.getKind() == Obj.Var && obj.getFpPos() != 0){
                report_info("Info on line: " + DesignatorIdent.getLine() + ": Detected usage of function formal parameter " + obj.getName() +".", null);
            }

        }
        else{
            report_error("Error on line " + DesignatorIdent.getLine() + ": Name " + DesignatorIdent.getName() + " has not been declared.", null);
        }

    }

    @Override
    public void visit(FactorVariable FactorVariable) {

        if (FactorVariable.getDesignator().obj.getKind() == Obj.Meth){
            report_error("Error on line " + FactorVariable.getLine() + ": Cannot use function names as variables.", null );
            FactorVariable.struct = Tab.noType;
        }
        else
            FactorVariable.struct = FactorVariable.getDesignator().obj.getType();
    }

    @Override
    public void visit(FactorFuncCall FactorFuncCall) {

        if (calledFunction.getLevel() >= currentActPar){
            report_error("Error on line " + FactorFuncCall.getLine() + ": Not enough actual parameters.", null);
        }

        FactorFuncCall.struct = calledFunction.getType();

        report_info("Info on line " + FactorFuncCall.getLine() + ": Detected function call for function " + calledFunction.getName() + ".", null);

        calledFunction = null;
        currentActPar = 1;

    }

    @Override
    public void visit(FactorConstant FactorConstant) {
        FactorConstant.struct = FactorConstant.getConstLiteral().struct;

    }

    @Override
    public void visit(FactorNewClass FactorNewClass) {

        FactorNewClass.struct = FactorNewClass.getType().struct;

        if (FactorNewClass.getType().struct.getKind() != Struct.Class){
            report_error("Error on line " + FactorNewClass.getLine() + ": Type " + FactorNewClass.getType().getTypeName() + " is not a class.", null);
        }

    }

    @Override
    public void visit(FactorNewArray FactorNewArray) {

        FactorNewArray.struct = new Struct(Struct.Array, FactorNewArray.getType().struct);

        if (FactorNewArray.getExpr().struct != Tab.intType){
            report_error("Error on line " + FactorNewArray.getLine() + ": Expression between [] must be of type int.", null);
        }
    }

    @Override
    public void visit(FactorExpr FactorExpr) {
        FactorExpr.struct = FactorExpr.getExpr().struct;
    }

    @Override
    public void visit(TermMul TermMul) {

        Term leftSide = TermMul.getTerm();
        Factor rightSide = TermMul.getFactor();

        if (leftSide.struct != Tab.intType || rightSide.struct != Tab.intType){
            report_error("Error on line " + TermMul.getLine() + ": Both operands of * must be int type.", null);
            TermMul.struct = Tab.noType;
        }
        else
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
            report_error("Error on line " + ExprAdd.getAddop().getLine() + ": When using + operands must be int type.", null);
            ExprAdd.struct = Tab.noType;
        }
        else
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

                if (!expr.struct.assignableTo(designator.obj.getType())){
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

    @Override
    public void visit(CondFactRelop CondFactRelop) {

        Expr leftExpr = CondFactRelop.getExpr();
        Expr rightExpr = CondFactRelop.getExpr1();
        Relop relop = CondFactRelop.getRelop();

        if (!leftExpr.struct.compatibleWith(rightExpr.struct)){
            report_error("Error on line " + CondFactRelop.getLine() + ": Expression types are not compatible.", null);
        }
        else{

            if (
                (leftExpr.struct.isRefType() || rightExpr.struct.isRefType())
                && (!(relop instanceof Equalop) && !(relop instanceof NotEqualop))
            )
            {
                report_error("Error on line " + CondFactRelop.getLine() + ": Only == and != operators are allowed on reference types.", null);
            }

        }

        CondFactRelop.struct = TableExtensions.boolType;

    }

    @Override
    public void visit(CondFactExpr CondFactExpr) {

        if (CondFactExpr.getExpr().struct != TableExtensions.boolType){
            report_error("Error on line " + CondFactExpr.getLine() + ": Expression must be bool type.", null);
        }

        CondFactExpr.struct = CondFactExpr.getExpr().struct;
    }

    @Override
    public void visit(MethodDeclTypeIdentNode MethodDeclTypeIdentNode) {

        foundReturn = false;
        cntFormPars = 0;

        RetType retType = MethodDeclTypeIdentNode.getRetType();

        if (retType instanceof RetTypeNode){
            isVoid = false;
            funcRetType = ((RetTypeNode) retType).getType().struct;
        }
        else{
            isVoid = true;
            funcRetType = Tab.noType;
        }

        Obj obj = Tab.currentScope.findSymbol(MethodDeclTypeIdentNode.getMethName());

        if (obj == null || obj == Tab.noObj){

            if (MethodDeclTypeIdentNode.getMethName().equals("main")){

                if (isVoid){
                    mainFound = true;
                }
                else{
                    report_error("Error on line " + MethodDeclTypeIdentNode.getLine() + ": Main method cannot have return type.", null);
                }

            }

            currentFunction = Tab.insert(Obj.Meth, MethodDeclTypeIdentNode.getMethName(), funcRetType);
            MethodDeclTypeIdentNode.obj = currentFunction;
            Tab.openScope();

        }
        else{
            MethodDeclTypeIdentNode.obj = Tab.noObj;
            currentFunction = Tab.noObj;
            report_error("Error on line " + MethodDeclTypeIdentNode.getLine() + ": Name " + MethodDeclTypeIdentNode.getMethName() + " has already been declared.", null);
        }

    }

    @Override
    public void visit(MethodDeclPrototype MethodDeclPrototype) {

        MethodDeclPrototype.obj = MethodDeclPrototype.getMethodDeclTypeIdent().obj;
        currentFunction.setLevel(cntFormPars);

    }

    @Override
    public void visit(MethodDeclNode MethodDeclNode) {

        if (!foundReturn && !isVoid){
            report_error("Error on line " + MethodDeclNode.getLine() + ": Missing return statement.", null);
        }

        MethodDeclNode.obj = MethodDeclNode.getMethodDeclPrototype().obj;
        Tab.chainLocalSymbols(currentFunction);
        currentFunction = null;
        funcRetType = null;
        Tab.closeScope();

    }

    @Override
    public void visit(TypeIdentSingleNode TypeIdentSingleNode) {

        Obj obj = Tab.currentScope().findSymbol(TypeIdentSingleNode.getParamName());

        if (obj == null || obj == Tab.noObj){

            if (TypeIdentSingleNode.getSquareSingle() instanceof SquareSingleNode){
                obj = Tab.insert(Obj.Var, TypeIdentSingleNode.getParamName(), new Struct(Struct.Array, TypeIdentSingleNode.getType().struct));
            }
            else{
                obj = Tab.insert(Obj.Var, TypeIdentSingleNode.getParamName(), TypeIdentSingleNode.getType().struct);
            }

            obj.setFpPos(++cntFormPars);

            if (currentFunction.getName().equals("main")){
                report_error("Error on line " + TypeIdentSingleNode.getLine() + ": Main method cannot have parameters.", null);
            }

        }
        else{
            TypeIdentSingleNode.obj = Tab.noObj;
            report_error("Error on line " + TypeIdentSingleNode.getLine() + ": Name " + TypeIdentSingleNode.getParamName() +" has already been declared.", null);
        }

    }

    @Override
    public void visit(StatementReturn StatementReturn) {

        if (currentFunction != null){

            foundReturn = true;

            if (isVoid){

                if (StatementReturn.getExprSingle() instanceof ExprSingleNode){
                    report_error("Error on line " + StatementReturn.getLine() + ": Return expression is not allowed on void function.", null);
                }

            }
            else{

                if (StatementReturn.getExprSingle() instanceof NoExprSingle){
                    report_error("Error on line " + StatementReturn.getLine() + ": Return on non void function must have expression.", null);
                }
                else{

                    Expr expr = ((ExprSingleNode) StatementReturn.getExprSingle()).getExpr();

                    if (!expr.struct.assignableTo(funcRetType)){
                        report_error("Error on line " + StatementReturn.getLine() + ": Return type not compatible with function return type.", null);
                    }
                }

            }
        }
        else{
            report_error("Error on line " + StatementReturn.getLine() + ": Return statement is only allowed inside functions and methods.", null);
        }

    }

    @Override
    public void visit(ForLoopHeaderNode ForLoopHeaderNode) {

        report_info("Info on line " + ForLoopHeaderNode.getLine() + ": Detected for loop.", null);
        cntInFor++;

    }

    @Override
    public void visit(StatementFor StatementFor) {

        cntInFor--;

    }

    @Override
    public void visit(StatementContinue StatementContinue) {

        if (cntInFor <= 0){
            report_error("Error on line " + StatementContinue.getLine() + ": Continue can only be called inside for loop.", null);
        }

    }

    @Override
    public void visit(StatementBreak StatementBreak) {

        if (cntInFor <= 0){
            report_error("Error on line " + StatementBreak.getLine() + ": Break can only be called inside for loop.", null);
        }

    }

    @Override
    public void visit(DesignatorStatementFuncDesignator DesignatorStatementFuncDesignator) {

        currentActPar = 1;
        calledFunction = DesignatorStatementFuncDesignator.getDesignator().obj;

        if (DesignatorStatementFuncDesignator.getDesignator().obj.getKind() != Obj.Meth){
            report_error("Error on line " + DesignatorStatementFuncDesignator.getLine() + ": Designator must be function or method type.", null);
        }

    }

    @Override
    public void visit(ActParsExprNode ActParsExprNode) {

        Obj formPar = null;

        if (calledFunction.getName().equals("ord")
            || calledFunction.getName().equals("chr")
            || calledFunction.getName().equals("len")){

            formPar = calledFunction.getLocalSymbols().iterator().next();

        }
        else{

            for (Obj obj : calledFunction.getLocalSymbols()){

                formPar = obj;

                if (obj.getFpPos() == currentActPar) break;

            }

            if (formPar.getFpPos() != currentActPar) formPar = null;

        }

        if (formPar != null){

            if (!ActParsExprNode.getExpr().struct.assignableTo(formPar.getType())){
                report_error("Error on line " + ActParsExprNode.getLine() + ": Type mismatch in function call for parameter " + formPar.getName() + ".", null);
            }

        }
        else{
            report_error("Error on line " + ActParsExprNode.getLine() + ": Too much parameters passed to function.", null);
        }

        currentActPar++;

    }

    @Override
    public void visit(DesignatorStatementFunc DesignatorStatementFunc) {

        if (calledFunction.getLevel() >= currentActPar){
            report_error("Error on line " + DesignatorStatementFunc.getLine() + ": Not enough actual parameters.", null);
        }

        report_info("Info on line " + DesignatorStatementFunc.getLine() + ": Detected function call for function " + calledFunction.getName() + ".", null);

        calledFunction = null;
        currentActPar = 1;
    }

    @Override
    public void visit(FactorFuncCallDesignator FactorFuncCallDesignator) {

        currentActPar = 1;
        calledFunction = FactorFuncCallDesignator.getDesignator().obj;

        if (FactorFuncCallDesignator.getDesignator().obj.getKind() != Obj.Meth){
            report_error("Error on line " + FactorFuncCallDesignator.getLine() + ": Designator must be function or method type.", null);
        }

    }


}
