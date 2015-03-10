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
public class S_PRODUCTION_EGG implements IDstNode {
LEX_EGG scanner;
  S_PRODUCTION_EGG() {
	}
  S_PRODUCTION_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  TDS att_table;
  LEX_EGG att_scanner;
  IVisiteurEgg att_vis;
  int glob_37_offset;
  private void regle37() throws Exception {

	//declaration
	T_EGG x_3 = new T_EGG(scanner ) ;
	T_EGG x_4 = new T_EGG(scanner ) ;
	S_PDROITE_EGG x_6 = new S_PDROITE_EGG(scanner,att_eval) ;
	T_EGG x_7 = new T_EGG(scanner ) ;
	S_ACTS_EGG x_8 = new S_ACTS_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_37(x_3, x_6, x_8);
if  (att_eval)	  action_init_code_37(x_3, x_6, x_8);
	x_3.analyser(LEX_EGG.token_t_ident);
	  addChild(x_3);
	x_4.analyser(LEX_EGG.token_t_fleche);
	  addChild(x_4);
if  (att_eval)	  action_trans_37(x_3, x_6, x_8);
	x_6.analyser() ;
	  addChild(x_6);
	x_7.analyser(LEX_EGG.token_t_pointvirgule);
	  addChild(x_7);
	x_8.analyser() ;
	  addChild(x_8);
if  (att_eval)	  action_fin_code_37(x_3, x_6, x_8);
	 offset =x_3.getOffset();
	 length =x_8.getOffset() + x_8.getLength() - offset;
  }
private void action_auto_inh_37(T_EGG x_3, S_PDROITE_EGG x_6, S_ACTS_EGG x_8) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_8.att_table=this.att_table;
x_6.att_vis=this.att_vis;
x_8.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","PRODUCTION -> #init_code t_ident t_fleche #trans PDROITE t_pointvirgule ACTS #fin_code ;"});
}
  }
private void action_trans_37(T_EGG x_3, S_PDROITE_EGG x_6, S_ACTS_EGG x_8) throws Exception {
try {
// instructions
ATTRIBUT loc_attribut;
SYMBOLE loc_symbole;
NON_TERMINAL loc_nt;
REGLE loc_regle;
loc_nt=null;
loc_symbole=(this.att_table).chercher(x_3.att_txt);
if ((loc_symbole==null)){
loc_nt= new NON_TERMINAL(x_3.att_txt);
(this.att_table).inserer(loc_nt);
loc_attribut=(this.att_table).attribut("scanner");
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
loc_attribut=(this.att_table).attribut("eval");
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
}
else {
if (loc_symbole instanceof NON_TERMINAL ){
loc_nt=((NON_TERMINAL)loc_symbole);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_not_a_non_terminal, EGGMessages.EGG_not_a_non_terminal,new Object[]{""+x_3.att_txt});


}
}
loc_regle= new REGLE(this.att_table, loc_nt, (this.att_table).getResolveur(), (this.att_scanner).getCommentaire());
(this.att_table).add_regle(loc_regle);
(loc_nt).add_regle(loc_regle);
x_6.att_reg=loc_regle;
x_8.att_reg=loc_regle;
(this.att_vis).nt_entete(loc_nt);
if ((this.att_table).getAutoAtt()){
if (!((loc_regle).add_action_inhs())){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_action_yet_declared, EGGMessages.EGG_action_yet_declared,new Object[]{""+"#auto"});

}

}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#trans","PRODUCTION -> #init_code t_ident t_fleche #trans PDROITE t_pointvirgule ACTS #fin_code ;"});
}
  }
private void action_init_code_37(T_EGG x_3, S_PDROITE_EGG x_6, S_ACTS_EGG x_8) throws Exception {
try {
// instructions
glob_37_offset=(this.att_scanner).getOffset();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#init_code","PRODUCTION -> #init_code t_ident t_fleche #trans PDROITE t_pointvirgule ACTS #fin_code ;"});
}
  }
private void action_fin_code_37(T_EGG x_3, S_PDROITE_EGG x_6, S_ACTS_EGG x_8) throws Exception {
try {
// instructions
int loc_length;
loc_length=((this.att_scanner).getOffset()-glob_37_offset);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#fin_code","PRODUCTION -> #init_code t_ident t_fleche #trans PDROITE t_pointvirgule ACTS #fin_code ;"});
}
  }
  public void analyser () throws Exception {
    regle37 () ;
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
