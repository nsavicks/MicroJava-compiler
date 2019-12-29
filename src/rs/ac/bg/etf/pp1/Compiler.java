package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.symboltable.Tab;

import java.io.FileReader;

class Compiler {
    public static void main(String args[]) throws Exception {

        FileReader r = new FileReader(args[0]);
        Yylex skener = new Yylex(r);
        MJParser p = new MJParser(skener);
        Symbol s = p.parse();
        Program prog = (Program) (s.value);

        // ispis sintaksnog stabla
        System.out.println(prog.toString(""));
        System.out.println("===================================");


        Tab.init();
        TableExtensions.init();

        // ispis prepoznatih programskih konstrukcija
        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
        prog.traverseBottomUp(semanticAnalyzer);

        System.out.println("===================================");

       // Tab.dump();
    }
}

