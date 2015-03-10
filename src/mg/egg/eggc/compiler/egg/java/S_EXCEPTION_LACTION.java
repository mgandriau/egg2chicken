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
public class S_EXCEPTION_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_EXCEPTION_LACTION() {
	}
  S_EXCEPTION_LACTION(LEX_LACTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  IVisiteurAction att_avis;
  String att_code;
  TDS att_table;
  LACT att_act;
  LEX_LACTION att_scanner;
  VAR glob_18_v;
  private void regle18() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	T_LACTION x_3 = new T_LACTION(scanner ) ;
	S_INSTS_LACTION x_5 = new S_INSTS_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_18(x_3, x_5);
	x_2.analyser(LEX_LACTION.token_t_exception);
	  addChild(x_2);
	x_3.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_3);
if  (att_eval)	  action_add_18(x_3, x_5);
	x_5.analyser() ;
	  addChild(x_5);
if  (att_eval)	  action_gen_18(x_3, x_5);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle17() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_17();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_gen_18(T_LACTION x_3, S_INSTS_LACTION x_5) throws Exception {
try {
// instructions
this.att_code=(this.att_avis).exc(x_3.att_txt, x_5.att_code);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","EXCEPTION -> t_exception t_ident #add INSTS #gen ;"});
}
  }
private void action_auto_inh_18(T_LACTION x_3, S_INSTS_LACTION x_5) throws Exception {
try {
// instructions
x_5.att_table=this.att_table;
x_5.att_avis=this.att_avis;
x_5.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","EXCEPTION -> t_exception t_ident #add INSTS #gen ;"});
}
  }
private void action_gen_17() throws Exception {
try {
// instructions
this.att_code="";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","EXCEPTION -> #gen ;"});
}
  }
private void action_add_18(T_LACTION x_3, S_INSTS_LACTION x_5) throws Exception {
try {
// instructions
TDS_ACTION loc_l;
ENTREE loc_e;
BLOC loc_b;
loc_b=(this.att_act).getBloc();
loc_l=(loc_b).getLocs();
loc_e=(loc_l).chercher(x_3.att_txt);
if ((loc_e!=null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_local_yet_declared, LACTIONMessages.LACTION_local_yet_declared,new Object[]{""+x_3.att_txt});

}
else {
glob_18_v= new VAR(x_3.att_txt, null);
(loc_l).ajouter_locale(glob_18_v);
(glob_18_v).setEtat(true);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#add","EXCEPTION -> t_exception t_ident #add INSTS #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_end : // 44
        regle17 () ;
      break ;
      case LEX_LACTION.token_t_exception : // 81
        regle18 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ILACTIONMessages.id_LACTION_unexpected_token,LACTIONMessages.LACTION_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
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
