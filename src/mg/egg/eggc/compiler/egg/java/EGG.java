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
public class EGG {
  LEX_EGG scanner;
  protected IProblemReporter problemReporter;
	private S_S_EGG axiome ;
	public  S_S_EGG getAxiom(){return axiome;}
  public EGG(IProblemReporter pr){
	   this.problemReporter = pr;
  }
  public void compile(ISourceUnit cu) throws Exception {
	try{
	  System.err.println("EGG Version 5.4.0");
	  LEX_CONTEXTE contexte;
	  contexte = new LEX_CONTEXTE(cu);
	  scanner = new LEX_EGG(problemReporter, contexte, 1);
	  scanner.analyseur.fromContext(contexte);
	  att_scanner = scanner;
	  axiome = new S_S_EGG(scanner,att_eval);
	  axiome.att_scanner = this.att_scanner ;
	  axiome.att_eval = this.att_eval ;
	  axiome.att_source = this.att_source ;
	  axiome.analyser() ;
	  scanner.accepter_fds() ;
	}catch (EGGException e){
	  problemReporter.handle(e.getCategory(), e.getCode(),0, NLS.bind(e.getId(),e.getArgs()),ProblemSeverities.Error,0,0,e.getArgs());
	}
	}
  IEGGCompilationUnit att_source;
  public void set_source(IEGGCompilationUnit a_source){
	att_source = a_source;
  }
  public IEGGCompilationUnit get_source(){
	return att_source;
  }
  boolean att_eval;
  public void set_eval(boolean a_eval){
	att_eval = a_eval;
  }
  public boolean get_eval(){
	return att_eval;
  }
  LEX_EGG att_scanner;
  public void set_scanner(LEX_EGG a_scanner){
	att_scanner = a_scanner;
  }
  public LEX_EGG get_scanner(){
	return att_scanner;
  }
  }
