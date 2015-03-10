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
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
public class S_LEXICAL_EGG implements IDstNode {
LEX_EGG scanner;
  S_LEXICAL_EGG() {
	}
  S_LEXICAL_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  TDS att_table;
  TERMINAL att_ter;
  LEX_EGG att_scanner;
  IVisiteurEgg att_vis;
  TERMINAL glob_28_terminal;
  TERMINAL glob_29_terminal;
  TERMINAL glob_27_terminal;
  private void regle29() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	T_EGG x_3 = new T_EGG(scanner ) ;
	T_EGG x_4 = new T_EGG(scanner ) ;
	T_EGG x_5 = new T_EGG(scanner ) ;
	EXPREG x_6 = new EXPREG(scanner.getReporter(), scanner.contexte);
	S_ALIASES_EGG x_8 = new S_ALIASES_EGG(scanner,att_eval) ;
	T_EGG x_9 = new T_EGG(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_29(x_3, x_6, x_8);
	x_2.analyser(LEX_EGG.token_t_term);
	  addChild(x_2);
	x_3.analyser(LEX_EGG.token_t_ident);
	  addChild(x_3);
	x_4.analyser(LEX_EGG.token_t_is);
	  addChild(x_4);
	x_5.analyser(LEX_EGG.token_t_guillemet);
	  addChild(x_5);
	x_6.scanner.setSource(scanner) ;
	x_6.set_eval(true) ;
	x_6.compile() ;
	  scanner.setSource(x_6.scanner) ;
	  addChild(x_6.getAxiom());
if  (att_eval)	  action_trans_29(x_3, x_6, x_8);
	x_8.analyser() ;
	  addChild(x_8);
	x_9.analyser(LEX_EGG.token_t_pointvirgule);
	  addChild(x_9);
if  (att_eval)	  action_gen_29(x_3, x_6, x_8);
	 offset =x_2.getOffset();
	 length =x_9.getOffset() + x_9.getLength() - offset;
  }
  private void regle28() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	T_EGG x_3 = new T_EGG(scanner ) ;
	T_EGG x_4 = new T_EGG(scanner ) ;
	T_EGG x_5 = new T_EGG(scanner ) ;
	EXPREG x_6 = new EXPREG(scanner.getReporter(), scanner.contexte);
	S_ALIASES_EGG x_8 = new S_ALIASES_EGG(scanner,att_eval) ;
	T_EGG x_9 = new T_EGG(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_28(x_3, x_6, x_8);
	x_2.analyser(LEX_EGG.token_t_sugar);
	  addChild(x_2);
	x_3.analyser(LEX_EGG.token_t_ident);
	  addChild(x_3);
	x_4.analyser(LEX_EGG.token_t_is);
	  addChild(x_4);
	x_5.analyser(LEX_EGG.token_t_guillemet);
	  addChild(x_5);
	x_6.scanner.setSource(scanner) ;
	x_6.set_eval(true) ;
	x_6.compile() ;
	  scanner.setSource(x_6.scanner) ;
	  addChild(x_6.getAxiom());
if  (att_eval)	  action_trans_28(x_3, x_6, x_8);
	x_8.analyser() ;
	  addChild(x_8);
	x_9.analyser(LEX_EGG.token_t_pointvirgule);
	  addChild(x_9);
if  (att_eval)	  action_gen_28(x_3, x_6, x_8);
	 offset =x_2.getOffset();
	 length =x_9.getOffset() + x_9.getLength() - offset;
  }
  private void regle27() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	T_EGG x_3 = new T_EGG(scanner ) ;
	T_EGG x_4 = new T_EGG(scanner ) ;
	T_EGG x_5 = new T_EGG(scanner ) ;
	EXPREG x_6 = new EXPREG(scanner.getReporter(), scanner.contexte);
	S_ALIASES_EGG x_8 = new S_ALIASES_EGG(scanner,att_eval) ;
	T_EGG x_9 = new T_EGG(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_27(x_3, x_6, x_8);
	x_2.analyser(LEX_EGG.token_t_space);
	  addChild(x_2);
	x_3.analyser(LEX_EGG.token_t_ident);
	  addChild(x_3);
	x_4.analyser(LEX_EGG.token_t_is);
	  addChild(x_4);
	x_5.analyser(LEX_EGG.token_t_guillemet);
	  addChild(x_5);
	x_6.scanner.setSource(scanner) ;
	x_6.set_eval(true) ;
	x_6.compile() ;
	  scanner.setSource(x_6.scanner) ;
	  addChild(x_6.getAxiom());
if  (att_eval)	  action_trans_27(x_3, x_6, x_8);
	x_8.analyser() ;
	  addChild(x_8);
	x_9.analyser(LEX_EGG.token_t_pointvirgule);
	  addChild(x_9);
if  (att_eval)	  action_gen_27(x_3, x_6, x_8);
	 offset =x_2.getOffset();
	 length =x_9.getOffset() + x_9.getLength() - offset;
  }
  private void regle30() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	T_EGG x_3 = new T_EGG(scanner ) ;
	T_EGG x_4 = new T_EGG(scanner ) ;
	T_EGG x_5 = new T_EGG(scanner ) ;
	EXPREG x_6 = new EXPREG(scanner.getReporter(), scanner.contexte);
	T_EGG x_7 = new T_EGG(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_30(x_3, x_6);
	x_2.analyser(LEX_EGG.token_t_macro);
	  addChild(x_2);
	x_3.analyser(LEX_EGG.token_t_ident);
	  addChild(x_3);
	x_4.analyser(LEX_EGG.token_t_is);
	  addChild(x_4);
	x_5.analyser(LEX_EGG.token_t_guillemet);
	  addChild(x_5);
	x_6.scanner.setSource(scanner) ;
	x_6.set_eval(true) ;
	x_6.compile() ;
	  scanner.setSource(x_6.scanner) ;
	  addChild(x_6.getAxiom());
	x_7.analyser(LEX_EGG.token_t_pointvirgule);
	  addChild(x_7);
if  (att_eval)	  action_gen_30(x_3, x_6);
	 offset =x_2.getOffset();
	 length =x_7.getOffset() + x_7.getLength() - offset;
  }
  private void regle31() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	T_EGG x_3 = new T_EGG(scanner ) ;
	T_EGG x_4 = new T_EGG(scanner ) ;
	T_EGG x_5 = new T_EGG(scanner ) ;
	EXPREG x_6 = new EXPREG(scanner.getReporter(), scanner.contexte);
	T_EGG x_7 = new T_EGG(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_31(x_3, x_6);
	x_2.analyser(LEX_EGG.token_t_comm);
	  addChild(x_2);
	x_3.analyser(LEX_EGG.token_t_ident);
	  addChild(x_3);
	x_4.analyser(LEX_EGG.token_t_is);
	  addChild(x_4);
	x_5.analyser(LEX_EGG.token_t_guillemet);
	  addChild(x_5);
	x_6.scanner.setSource(scanner) ;
	x_6.set_eval(true) ;
	x_6.compile() ;
	  scanner.setSource(x_6.scanner) ;
	  addChild(x_6.getAxiom());
	x_7.analyser(LEX_EGG.token_t_pointvirgule);
	  addChild(x_7);
if  (att_eval)	  action_gen_31(x_3, x_6);
	 offset =x_2.getOffset();
	 length =x_7.getOffset() + x_7.getLength() - offset;
  }
private void action_auto_inh_29(T_EGG x_3, EXPREG x_6, S_ALIASES_EGG x_8) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","LEXICAL -> t_term t_ident t_is t_guillemet EXPREG #trans ALIASES t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_28(T_EGG x_3, EXPREG x_6, S_ALIASES_EGG x_8) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","LEXICAL -> t_sugar t_ident t_is t_guillemet EXPREG #trans ALIASES t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_27(T_EGG x_3, EXPREG x_6, S_ALIASES_EGG x_8) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","LEXICAL -> t_space t_ident t_is t_guillemet EXPREG #trans ALIASES t_pointvirgule #gen ;"});
}
  }
private void action_gen_28(T_EGG x_3, EXPREG x_6, S_ALIASES_EGG x_8) throws Exception {
try {
// instructions
(this.att_vis).t_entete(glob_28_terminal);
this.att_ter=glob_28_terminal;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","LEXICAL -> t_sugar t_ident t_is t_guillemet EXPREG #trans ALIASES t_pointvirgule #gen ;"});
}
  }
private void action_gen_27(T_EGG x_3, EXPREG x_6, S_ALIASES_EGG x_8) throws Exception {
try {
// instructions
(this.att_vis).t_entete(glob_27_terminal);
this.att_ter=glob_27_terminal;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","LEXICAL -> t_space t_ident t_is t_guillemet EXPREG #trans ALIASES t_pointvirgule #gen ;"});
}
  }
private void action_gen_29(T_EGG x_3, EXPREG x_6, S_ALIASES_EGG x_8) throws Exception {
try {
// instructions
ATTRIBUT loc_attribut;
UN_ATTRIBUT loc_un_attribut;
ENTREE loc_entree;
REGLE loc_regle;
TDS_ACTION loc_table;
(this.att_vis).t_entete(glob_29_terminal);
loc_attribut=(this.att_table).attribut("txt");
(glob_29_terminal).add_attribut(loc_attribut);
loc_attribut=(this.att_table).attribut("scanner");
(glob_29_terminal).add_attribut(loc_attribut);
this.att_ter=glob_29_terminal;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","LEXICAL -> t_term t_ident t_is t_guillemet EXPREG #trans ALIASES t_pointvirgule #gen ;"});
}
  }
private void action_gen_30(T_EGG x_3, EXPREG x_6) throws Exception {
try {
// instructions
TERMINAL loc_terminal;
loc_terminal= new TERMINAL(4, x_3.att_txt, x_6.att_code, (this.att_scanner).getCommentaire());
(this.att_vis).t_entete(loc_terminal);
this.att_ter=loc_terminal;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","LEXICAL -> t_macro t_ident t_is t_guillemet EXPREG t_pointvirgule #gen ;"});
}
  }
private void action_gen_31(T_EGG x_3, EXPREG x_6) throws Exception {
try {
// instructions
TERMINAL loc_terminal;
loc_terminal= new TERMINAL(5, x_3.att_txt, x_6.att_code, (this.att_scanner).getCommentaire());
(this.att_vis).t_entete(loc_terminal);
this.att_ter=loc_terminal;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","LEXICAL -> t_comm t_ident t_is t_guillemet EXPREG t_pointvirgule #gen ;"});
}
  }
private void action_trans_29(T_EGG x_3, EXPREG x_6, S_ALIASES_EGG x_8) throws Exception {
try {
// instructions
glob_29_terminal= new TERMINAL(2, x_3.att_txt, x_6.att_code, (this.att_scanner).getCommentaire());
x_8.att_lex=glob_29_terminal;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#trans","LEXICAL -> t_term t_ident t_is t_guillemet EXPREG #trans ALIASES t_pointvirgule #gen ;"});
}
  }
private void action_trans_28(T_EGG x_3, EXPREG x_6, S_ALIASES_EGG x_8) throws Exception {
try {
// instructions
glob_28_terminal= new TERMINAL(1, x_3.att_txt, x_6.att_code, (this.att_scanner).getCommentaire());
x_8.att_lex=glob_28_terminal;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#trans","LEXICAL -> t_sugar t_ident t_is t_guillemet EXPREG #trans ALIASES t_pointvirgule #gen ;"});
}
  }
private void action_trans_27(T_EGG x_3, EXPREG x_6, S_ALIASES_EGG x_8) throws Exception {
try {
// instructions
IEGGCompilationUnit loc_cu;
String loc_code;
int loc_offset;
int loc_length;
glob_27_terminal= new TERMINAL(0, x_3.att_txt, x_6.att_code, (this.att_scanner).getCommentaire());
x_8.att_lex=glob_27_terminal;
loc_cu=(this.att_table).getCompilationUnit();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#trans","LEXICAL -> t_space t_ident t_is t_guillemet EXPREG #trans ALIASES t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_30(T_EGG x_3, EXPREG x_6) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","LEXICAL -> t_macro t_ident t_is t_guillemet EXPREG t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_31(T_EGG x_3, EXPREG x_6) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","LEXICAL -> t_comm t_ident t_is t_guillemet EXPREG t_pointvirgule #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_space : // 45
        regle27 () ;
      break ;
      case LEX_EGG.token_t_sugar : // 47
        regle28 () ;
      break ;
      case LEX_EGG.token_t_term : // 48
        regle29 () ;
      break ;
      case LEX_EGG.token_t_macro : // 50
        regle30 () ;
      break ;
      case LEX_EGG.token_t_comm : // 46
        regle31 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IEGGMessages.id_EGG_unexpected_token,EGGMessages.EGG_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
	private IDstNode parent;
	public void setParent( IDstNode p){parent = p;}
	public IDstNode getParent(){return parent;}
	private List<IDstNode> children = null ;
	public void addChild(IDstNode node){
	  if (children == null) {
	     children = new ArrayList<IDstNode>() ;}
	  children.add(node);
	  node.setParent(this);
	}
	public List<IDstNode> getChildren(){return children;}
	public boolean isLeaf(){return children == null;}
	public void accept(IDstVisitor visitor) {
	  boolean visitChildren = visitor.visit(this);
	  if (visitChildren && children != null){
	    for(IDstNode node : children){
	      node.accept(visitor);
	    }
	}
	visitor.endVisit(this);
  }
  private int offset;
  private int length;
  public int getOffset(){return offset;}
  public void setOffset(int o){offset = o;}
  public int getLength(){return length;}
  public void setLength(int l){length = l;}
  private boolean malformed = false;
  public void setMalformed(){malformed = true;}
  public boolean isMalformed(){return malformed;}
  }
