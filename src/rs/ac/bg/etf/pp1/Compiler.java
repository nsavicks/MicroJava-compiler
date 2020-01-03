package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;
import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.Program;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

class Compiler {
    public static void main(String args[]) throws Exception {

        Logger log = Logger.getLogger(Compiler.class);

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

        Tab.dump();

        if (!p.errorDetected && !semanticAnalyzer.errorDetected){

            File objFile = new File(args[1]);

            if (objFile.exists()) objFile.delete();

            CodeGenerator codeGenerator = new CodeGenerator();
            prog.traverseBottomUp(codeGenerator);

            Code.dataSize = semanticAnalyzer.getnVars();
            Code.mainPc = codeGenerator.getMainPc();

            Code.write(new FileOutputStream(objFile));

            log.info("Parsiranje uspesno izvrseno.");
        }
        else{
            log.error("Parsiranje nije uspesno izvrseno.");
        }
    }
}

