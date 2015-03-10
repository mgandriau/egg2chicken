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
public class EXPREG {
  LEX_EXPREG scanner;
  protected IProblemReporter problemReporter;
	private S_EXPREG_EXPREG axiome ;
	public  S_EXPREG_EXPREG getAxiom(){return axiome;}
  public EXPREG() {
	axiome = new S_EXPREG_EXPREG();
	}
  public EXPREG(IProblemReporter pr, LEX_CONTEXTE lc){
	  scanner = new LEX_EXPREG (pr, lc, 2);
	  att_scanner = scanner;
	}
  public void compile() throws Exception {
	axiome = new S_EXPREG_EXPREG(scanner,att_eval);
	att_scanner = scanner;
	axiome.att_scanner = this.att_scanner ;
	axiome.att_eval = this.att_eval ;
	axiome.att_vis = this.att_vis ;
	axiome.att_table = this.att_table ;
	axiome.analyser() ;
	this.att_code = axiome.att_code ;
	}
  boolean att_eval;
  public void set_eval(boolean a_eval){
	att_eval = a_eval;
  }
  public boolean get_eval(){
	return att_eval;
  }
  String att_code;
  public void set_code(String a_code){
	att_code = a_code;
  }
  public String get_code(){
	return att_code;
  }
  TDS att_table;
  public void set_table(TDS a_table){
	att_table = a_table;
  }
  public TDS get_table(){
	return att_table;
  }
  LEX_EXPREG att_scanner;
  public void set_scanner(LEX_EXPREG a_scanner){
	att_scanner = a_scanner;
  }
  public LEX_EXPREG get_scanner(){
	return att_scanner;
  }
  IVisiteurEgg att_vis;
  public void set_vis(IVisiteurEgg a_vis){
	att_vis = a_vis;
  }
  public IVisiteurEgg get_vis(){
	return att_vis;
  }
  }
