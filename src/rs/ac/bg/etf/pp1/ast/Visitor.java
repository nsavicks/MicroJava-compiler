// generated with ast extension for cup
// version 0.8
// 21/11/2019 18:17:12


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(DeclarationList DeclarationList);
    public void visit(ClassDeclIdent ClassDeclIdent);
    public void visit(FormParsSingle FormParsSingle);
    public void visit(Relop Relop);
    public void visit(TermList TermList);
    public void visit(ConditionList ConditionList);
    public void visit(CondTermList CondTermList);
    public void visit(VarDeclPartial VarDeclPartial);
    public void visit(TypeIdentSingle TypeIdentSingle);
    public void visit(FactorActParsSingle FactorActParsSingle);
    public void visit(DesignatorStatementSingle DesignatorStatementSingle);
    public void visit(FactorExprSingle FactorExprSingle);
    public void visit(StatementList StatementList);
    public void visit(TermItem TermItem);
    public void visit(ForConditionSingle ForConditionSingle);
    public void visit(Factor Factor);
    public void visit(CommaNumConstSingle CommaNumConstSingle);
    public void visit(ElseStatementSingle ElseStatementSingle);
    public void visit(AbstractMethodDecl AbstractMethodDecl);
    public void visit(TypeIdentList TypeIdentList);
    public void visit(RetType RetType);
    public void visit(IdentList IdentList);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(ExprSingle ExprSingle);
    public void visit(ActParsList ActParsList);
    public void visit(ConditionSingle ConditionSingle);
    public void visit(ConstLiteral ConstLiteral);
    public void visit(IdentSingle IdentSingle);
    public void visit(ExprList ExprList);
    public void visit(ExtendsSingle ExtendsSingle);
    public void visit(IdentListItem IdentListItem);
    public void visit(VarDeclList VarDeclList);
    public void visit(DesignatorStatementItem DesignatorStatementItem);
    public void visit(AbstractMethodDeclList AbstractMethodDeclList);
    public void visit(DesignatorList DesignatorList);
    public void visit(ActParsSingle ActParsSingle);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(SubSingle SubSingle);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(AbstractMethodDeclItem AbstractMethodDeclItem);
    public void visit(DesignatorItem DesignatorItem);
    public void visit(SquareSingle SquareSingle);
    public void visit(CondFact CondFact);
    public void visit(Declaration Declaration);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(DesignatorAssignItem DesignatorAssignItem);
    public void visit(Modop Modop);
    public void visit(Divop Divop);
    public void visit(Mulop Mulop);
    public void visit(Subop Subop);
    public void visit(Addop Addop);
    public void visit(LesserEqualop LesserEqualop);
    public void visit(Lesserop Lesserop);
    public void visit(GreaterEqualop GreaterEqualop);
    public void visit(Greaterop Greaterop);
    public void visit(NotEqualop NotEqualop);
    public void visit(Equalop Equalop);
    public void visit(Assignop Assignop);
    public void visit(DesignatorArrayItem DesignatorArrayItem);
    public void visit(DesignatorDotItem DesignatorDotItem);
    public void visit(NoDesignatorList NoDesignatorList);
    public void visit(DesignatorListNode DesignatorListNode);
    public void visit(Designator Designator);
    public void visit(NoActParsSingle NoActParsSingle);
    public void visit(ActParsSingleNode ActParsSingleNode);
    public void visit(NoFactorActParsSingle NoFactorActParsSingle);
    public void visit(FactorActParsSingleNode FactorActParsSingleNode);
    public void visit(NoFactorExprSingle NoFactorExprSingle);
    public void visit(FactorExprSingleNode FactorExprSingleNode);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNew FactorNew);
    public void visit(FactorConstant FactorConstant);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(TermItemDerived1 TermItemDerived1);
    public void visit(NoTermList NoTermList);
    public void visit(TermListNode TermListNode);
    public void visit(Term Term);
    public void visit(ExprItem ExprItem);
    public void visit(NoExprList NoExprList);
    public void visit(ExprListNode ExprListNode);
    public void visit(NoSubSingle NoSubSingle);
    public void visit(SubSingleNode SubSingleNode);
    public void visit(Expr Expr);
    public void visit(CondFactRelop CondFactRelop);
    public void visit(CondFactExpr CondFactExpr);
    public void visit(CondTermItem CondTermItem);
    public void visit(NoCondTermList NoCondTermList);
    public void visit(CondTermListNode CondTermListNode);
    public void visit(CondTerm CondTerm);
    public void visit(NoConditionList NoConditionList);
    public void visit(ConditionListNode ConditionListNode);
    public void visit(Condition Condition);
    public void visit(NoActParsList NoActParsList);
    public void visit(ActParsListNode ActParsListNode);
    public void visit(ActPars ActPars);
    public void visit(ErrorDesignatorAssignItem ErrorDesignatorAssignItem);
    public void visit(DesignatorAssignItemNode DesignatorAssignItemNode);
    public void visit(DesignatorItemDec DesignatorItemDec);
    public void visit(DesignatorItemInc DesignatorItemInc);
    public void visit(DesignatorItemActPars DesignatorItemActPars);
    public void visit(DesignatorAssignStatementNode DesignatorAssignStatementNode);
    public void visit(DesignatorStatementNode DesignatorStatementNode);
    public void visit(NoDesignatorStatementSingle NoDesignatorStatementSingle);
    public void visit(DesignatorStatementSingleNode DesignatorStatementSingleNode);
    public void visit(NoElseStatementSingle NoElseStatementSingle);
    public void visit(ElseStatementSingleNode ElseStatementSingleNode);
    public void visit(NoExprSingle NoExprSingle);
    public void visit(ExprSingleNode ExprSingleNode);
    public void visit(NoCommaNumConstSingle NoCommaNumConstSingle);
    public void visit(CommaNumConstSingleNode CommaNumConstSingleNode);
    public void visit(NoStatementList NoStatementList);
    public void visit(StatementListNode StatementListNode);
    public void visit(NoConditionSingle NoConditionSingle);
    public void visit(ConditionSingleNode ConditionSingleNode);
    public void visit(ErrorForConditionSingleNode ErrorForConditionSingleNode);
    public void visit(ForConditionSingleNode ForConditionSingleNode);
    public void visit(StatementStatementList StatementStatementList);
    public void visit(StatementPrint StatementPrint);
    public void visit(StatementRead StatementRead);
    public void visit(StatementReturn StatementReturn);
    public void visit(StatementContinue StatementContinue);
    public void visit(StatementBreak StatementBreak);
    public void visit(StatementFor StatementFor);
    public void visit(StatementIf StatementIf);
    public void visit(StatementDesignator StatementDesignator);
    public void visit(Type Type);
    public void visit(NoSquareSingle NoSquareSingle);
    public void visit(SquareSingleNode SquareSingleNode);
    public void visit(ErrorTypeIdentSingle ErrorTypeIdentSingle);
    public void visit(TypeIdentSingleNode TypeIdentSingleNode);
    public void visit(SingleTypeIdentList SingleTypeIdentList);
    public void visit(TypeIdentListNode TypeIdentListNode);
    public void visit(FormPars FormPars);
    public void visit(RetTypeVoid RetTypeVoid);
    public void visit(RetTypeNode RetTypeNode);
    public void visit(NoFormParsSingle NoFormParsSingle);
    public void visit(FormParsSingleNode FormParsSingleNode);
    public void visit(ErrorAbstractMethodDecl ErrorAbstractMethodDecl);
    public void visit(AbstractMethodDeclNode AbstractMethodDeclNode);
    public void visit(NoVarDeclList NoVarDeclList);
    public void visit(VarDeclListNode VarDeclListNode);
    public void visit(MethodDecl MethodDecl);
    public void visit(ErrorExtendsSingle ErrorExtendsSingle);
    public void visit(NoExtendsSingle NoExtendsSingle);
    public void visit(ExtendsSingleNode ExtendsSingleNode);
    public void visit(ErrorClassDeclIdent ErrorClassDeclIdent);
    public void visit(ClassDeclIdentNode ClassDeclIdentNode);
    public void visit(AbstractMethodDeclItemNode AbstractMethodDeclItemNode);
    public void visit(MethodDeclItemNode MethodDeclItemNode);
    public void visit(NoAbstractMethodDeclList NoAbstractMethodDeclList);
    public void visit(AbstractMethodDeclListNode AbstractMethodDeclListNode);
    public void visit(AbstractClassMethodDeclSingle AbstractClassMethodDeclSingle);
    public void visit(AbstractClassDecl AbstractClassDecl);
    public void visit(NoMethodDeclList NoMethodDeclList);
    public void visit(MethodDeclListNode MethodDeclListNode);
    public void visit(ClassMethodDeclSingle ClassMethodDeclSingle);
    public void visit(ClassDecl ClassDecl);
    public void visit(ErrorIdentSingle ErrorIdentSingle);
    public void visit(IdentSingleNode IdentSingleNode);
    public void visit(IdentListSingle IdentListSingle);
    public void visit(IdentListNode IdentListNode);
    public void visit(ErrorVarDecl ErrorVarDecl);
    public void visit(VarDeclNode VarDeclNode);
    public void visit(ConstLiteralBool ConstLiteralBool);
    public void visit(ConstLiteralChar ConstLiteralChar);
    public void visit(ConstLiteralNum ConstLiteralNum);
    public void visit(ConstDeclListItem ConstDeclListItem);
    public void visit(NoConstDeclList NoConstDeclList);
    public void visit(ConstDeclListNode ConstDeclListNode);
    public void visit(ConstDecl ConstDecl);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(AbstractClassDeclaration AbstractClassDeclaration);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(NoDeclarationList NoDeclarationList);
    public void visit(DeclarationListNode DeclarationListNode);
    public void visit(Program Program);

}
