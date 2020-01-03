package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.FormParsSingle;
import rs.ac.bg.etf.pp1.ast.TypeIdentSingleNode;
import rs.ac.bg.etf.pp1.ast.VarIdentSingleNode;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {
	
	private int varCnt = 0;
	private int formParsCnt = 0;

	public int getVarCnt() {
		return varCnt;
	}

	public int getFormParsCnt() {
		return formParsCnt;
	}

	@Override
	public void visit(TypeIdentSingleNode TypeIdentSingleNode) {
		formParsCnt++;
	}

	@Override
	public void visit(VarIdentSingleNode VarIdentSingleNode) {
		varCnt++;
	}


}
