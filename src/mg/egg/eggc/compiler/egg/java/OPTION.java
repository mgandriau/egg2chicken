package mg.egg.eggc.compiler.egg.java;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.compiler.libegg.base.*;
import mg.egg.eggc.compiler.libegg.java.*;
import mg.egg.eggc.compiler.libegg.egg.*;
import mg.egg.eggc.compiler.libegg.latex.*;
import mg.egg.eggc.compiler.libegg.type.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import java.util.*;
import mg.egg.eggc.runtime.libjava.EGGException;
import mg.egg.eggc.runtime.libjava.ISourceUnit;
import mg.egg.eggc.runtime.libjava.lex.LEX_CONTEXTE;
import mg.egg.eggc.runtime.libjava.problem.IProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemSeverities;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class OPTION {
  LEX_OPTION scanner;
  protected IProblemReporter problemReporter;
	private S_O_OPTION axiome ;
	public  S_O_OPTION getAxiom(){return axiome;}
  public OPTION() {
	axiome = new S_O_OPTION();
	}
  public OPTION(IProblemReporter pr, LEX_CONTEXTE lc){
	  scanner = new LEX_OPTION (pr, lc, 1);
	  att_scanner = scanner;
	}
  public void compile() throws Exception {
	axiome = new S_O_OPTION(scanner,att_eval);
	att_scanner = scanner;
	axiome.att_scanner = this.att_scanner ;
	axiome.att_eval = this.att_eval ;
	axiome.att_table = this.att_table ;
	axiome.analyser() ;
	}
  boolean att_eval;
  public void set_eval(boolean a_eval){
	att_eval = a_eval;
  }
  public boolean get_eval(){
	return att_eval;
  }
  TDS att_table;
  public void set_table(TDS a_table){
	att_table = a_table;
  }
  public TDS get_table(){
	return att_table;
  }
  LEX_OPTION att_scanner;
  public void set_scanner(LEX_OPTION a_scanner){
	att_scanner = a_scanner;
  }
  public LEX_OPTION get_scanner(){
	return att_scanner;
  }
  }
