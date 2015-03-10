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
public class S_ATTRIBUT_EGG implements IDstNode {
LEX_EGG scanner;
  S_ATTRIBUT_EGG() {
	}
  S_ATTRIBUT_EGG(LEX_EGG scanner, boolean eval) {
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
  private void regle8() throws Exception {

	//declaration
	S_SATT_EGG x_2 = new S_SATT_EGG(scanner,att_eval) ;
	T_EGG x_4 = new T_EGG(scanner ) ;
	S_VTYPE_EGG x_5 = new S_VTYPE_EGG(scanner,att_eval) ;
	T_EGG x_6 = new T_EGG(scanner ) ;
	S_IDENT_EGG x_7 = new S_IDENT_EGG(scanner,att_eval) ;
	S_IDENTS_EGG x_9 = new S_IDENTS_EGG(scanner,att_eval) ;
	T_EGG x_10 = new T_EGG(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_8(x_2, x_4, x_5, x_7, x_9);
	x_2.analyser() ;
	  addChild(x_2);
if  (att_eval)	  action_trans_8(x_2, x_4, x_5, x_7, x_9);
	x_4.analyser(LEX_EGG.token_t_ident);
	  addChild(x_4);
	x_5.analyser() ;
	  addChild(x_5);
	x_6.analyser(LEX_EGG.token_t_for);
	  addChild(x_6);
	x_7.analyser() ;
	  addChild(x_7);
if  (att_eval)	  action_add_8(x_2, x_4, x_5, x_7, x_9);
	x_9.analyser() ;
	  addChild(x_9);
	x_10.analyser(LEX_EGG.token_t_pointvirgule);
	  addChild(x_10);
	 offset =x_2.getOffset();
	 length =x_10.getOffset() + x_10.getLength() - offset;
  }
private void action_auto_inh_8(S_SATT_EGG x_2, T_EGG x_4, S_VTYPE_EGG x_5, S_IDENT_EGG x_7, S_IDENTS_EGG x_9) throws Exception {
try {
// instructions
x_9.att_table=this.att_table;
x_5.att_vis=this.att_vis;
x_7.att_vis=this.att_vis;
x_9.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","ATTRIBUT -> SATT #trans t_ident VTYPE t_for IDENT #add IDENTS t_pointvirgule ;"});
}
  }
private void action_trans_8(S_SATT_EGG x_2, T_EGG x_4, S_VTYPE_EGG x_5, S_IDENT_EGG x_7, S_IDENTS_EGG x_9) throws Exception {
try {
// instructions
x_5.att_res=(this.att_table).getResolveur();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#trans","ATTRIBUT -> SATT #trans t_ident VTYPE t_for IDENT #add IDENTS t_pointvirgule ;"});
}
  }
private void action_add_8(S_SATT_EGG x_2, T_EGG x_4, S_VTYPE_EGG x_5, S_IDENT_EGG x_7, S_IDENTS_EGG x_9) throws Exception {
try {
// instructions
SYMBOLE loc_symbole;
ATTRIBUT loc_attribut;
ATTRIBUT loc_attscan;
ATTRIBUT loc_atteval;
NON_TERMINAL loc_nt;
loc_attribut= new ATTRIBUT(x_2.att_sorte, x_4.att_txt, x_5.att_type, (this.att_scanner).getCommentaire());
if (!((this.att_table).ajouter_att(loc_attribut))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_attribute_yet_declared, EGGMessages.EGG_attribute_yet_declared,new Object[]{""+x_4.att_txt});

}

loc_nt=null;
loc_symbole=(this.att_table).chercher(x_7.att_code);
if ((loc_symbole!=null)){
if (loc_symbole instanceof NON_TERMINAL ){
loc_nt=((NON_TERMINAL)loc_symbole);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_no_terminal_attribute, EGGMessages.EGG_no_terminal_attribute,new Object[]{""+x_7.att_code});


}
}
else {
loc_nt= new NON_TERMINAL(x_7.att_code);
(this.att_table).inserer(loc_nt);
(this.att_vis).nt_entete(loc_nt);
loc_attscan=(this.att_table).attribut("scanner");
(loc_nt).add_attribut(loc_attscan);
(this.att_vis).nt_attribut(loc_nt, loc_attscan);
loc_atteval=(this.att_table).attribut("eval");
(loc_nt).add_attribut(loc_atteval);
(this.att_vis).nt_attribut(loc_nt, loc_atteval);
}
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
x_9.att_att=loc_attribut;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#add","ATTRIBUT -> SATT #trans t_ident VTYPE t_for IDENT #add IDENTS t_pointvirgule ;"});
}
  }
  public void analyser () throws Exception {
    regle8 () ;
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
