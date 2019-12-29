package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.ConstLiteral;
import rs.ac.bg.etf.pp1.ast.ConstLiteralBool;
import rs.ac.bg.etf.pp1.ast.ConstLiteralChar;
import rs.ac.bg.etf.pp1.ast.ConstLiteralNum;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;

public class TableExtensions {

    public static final Struct boolType = new Struct(5);

    public static void init(){
        Obj obj = Tab.insert(Obj.Type, "bool", boolType);
        Tab.currentScope().addToLocals(obj);
    }


    public static int GetConstValue(ConstLiteral constLiteral){

        if (constLiteral instanceof ConstLiteralNum){
            return ((ConstLiteralNum) constLiteral).getValue();
        }
        else if (constLiteral instanceof ConstLiteralChar){
            return ((ConstLiteralChar) constLiteral).getValue();
        }
        else if (constLiteral instanceof ConstLiteralBool){
            return (((ConstLiteralBool) constLiteral).getValue()) ? 1: 0;
        }
        else return 0;

    }

}
