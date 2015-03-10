package mg.egg.eggc.compiler.egg.java;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.compiler.libegg.base.*;
import mg.egg.eggc.compiler.libegg.java.*;
import mg.egg.eggc.compiler.libegg.egg.*;
import mg.egg.eggc.compiler.libegg.mig.*;
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
public class LACTION {
  LEX_LACTION scanner;
  protected IProblemReporter problemReporter;
	private S_LACTION_LACTION axiome ;
	public  S_LACTION_LACTION getAxiom(){return axiome;}
  public LACTION() {
	axiome = new S_LACTION_LACTION();
	}
  public LACTION(IProblemReporter pr, LEX_CONTEXTE lc){
	  scanner = new LEX_LACTION (pr, lc, 2);
	  att_scanner = scanner;
	}
  public void compile() throws Exception {
	axiome = new S_LACTION_LACTION(scanner,att_eval);
	att_scanner = scanner;
	axiome.att_scanner = this.att_scanner ;
	axiome.att_eval = this.att_eval ;
	axiome.att_table = this.att_table ;
	axiome.att_reg = this.att_reg ;
	axiome.att_avis = this.att_avis ;
	axiome.att_act = this.att_act ;
	axiome.analyser() ;
	this.att_code = axiome.att_code ;
	this.att_offset = axiome.att_offset ;
	this.att_length = axiome.att_length ;
	}
  REGLE att_reg;
  public void set_reg(REGLE a_reg){
	att_reg = a_reg;
  }
  public REGLE get_reg(){
	return att_reg;
  }
  boolean att_eval;
  public void set_eval(boolean a_eval){
	att_eval = a_eval;
  }
  public boolean get_eval(){
	return att_eval;
  }
  int att_length;
  public void set_length(int a_length){
	att_length = a_length;
  }
  public int get_length(){
	return att_length;
  }
  IVisiteurAction att_avis;
  public void set_avis(IVisiteurAction a_avis){
	att_avis = a_avis;
  }
  public IVisiteurAction get_avis(){
	return att_avis;
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
  int att_offset;
  public void set_offset(int a_offset){
	att_offset = a_offset;
  }
  public int get_offset(){
	return att_offset;
  }
  LACT att_act;
  public void set_act(LACT a_act){
	att_act = a_act;
  }
  public LACT get_act(){
	return att_act;
  }
  LEX_LACTION att_scanner;
  public void set_scanner(LEX_LACTION a_scanner){
	att_scanner = a_scanner;
  }
  public LEX_LACTION get_scanner(){
	return att_scanner;
  }
  }
