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
public class S_PDROITE_EGG implements IDstNode {
LEX_EGG scanner;
  S_PDROITE_EGG() {
	}
  S_PDROITE_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  REGLE att_reg;
  boolean att_eval;
  TDS att_table;
  LEX_EGG att_scanner;
  IVisiteurEgg att_vis;
  private void regle40() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_init_40();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
  private void regle39() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	S_PDROITE_EGG x_4 = new S_PDROITE_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_39(x_2, x_4);
	x_2.analyser(LEX_EGG.token_t_action);
	  addChild(x_2);
if  (att_eval)	  action_add_39(x_2, x_4);
	x_4.analyser() ;
	  addChild(x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle38() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	S_PDROITE_EGG x_4 = new S_PDROITE_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_38(x_2, x_4);
	x_2.analyser(LEX_EGG.token_t_ident);
	  addChild(x_2);
if  (att_eval)	  action_add_38(x_2, x_4);
	x_4.analyser() ;
	  addChild(x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
private void action_add_39(T_EGG x_2, S_PDROITE_EGG x_4) throws Exception {
try {
// instructions
if (!((this.att_reg).add_action(x_2.att_txt))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_action_yet_declared, EGGMessages.EGG_action_yet_declared,new Object[]{""+x_2.att_txt});

}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#add","PDROITE -> t_action #add PDROITE1 ;"});
}
  }
private void action_auto_inh_38(T_EGG x_2, S_PDROITE_EGG x_4) throws Exception {
try {
// instructions
x_4.att_table=this.att_table;
x_4.att_reg=this.att_reg;
x_4.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","PDROITE -> t_ident #add PDROITE1 ;"});
}
  }
private void action_add_38(T_EGG x_2, S_PDROITE_EGG x_4) throws Exception {
try {
// instructions
ATTRIBUT loc_attribut;
SYMBOLE loc_symbole;
NON_TERMINAL loc_nt;
TERMINAL loc_t;
TDS loc_table;
loc_nt=null;
loc_symbole=(this.att_table).chercher(x_2.att_txt);
if ((loc_symbole==null)){
loc_nt= new NON_TERMINAL(x_2.att_txt, (this.att_scanner).getCommentaire());
(this.att_table).inserer(loc_nt);
loc_attribut=(this.att_table).attribut("scanner");
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
loc_attribut=(this.att_table).attribut("eval");
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
loc_symbole=loc_nt;
}
else {
if (loc_symbole instanceof TERMINAL ){
loc_t=((TERMINAL)loc_symbole);
if (((loc_t).get_type()==0)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_space_illegal_here, EGGMessages.EGG_space_illegal_here,new Object[]{""+x_2.att_txt});

}

}
else if (loc_symbole instanceof NON_TERMINAL ){
loc_nt=((NON_TERMINAL)loc_symbole);
if ((this.att_table).est_axiome(loc_nt)){
if (!((this.att_table).getModule())){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_axiom_illegal_here, EGGMessages.EGG_axiom_illegal_here,new Object[]{""+x_2.att_txt});

}

}

}
else {

}
}
(this.att_reg).add_droite(loc_symbole);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#add","PDROITE -> t_ident #add PDROITE1 ;"});
}
  }
private void action_auto_inh_39(T_EGG x_2, S_PDROITE_EGG x_4) throws Exception {
try {
// instructions
x_4.att_table=this.att_table;
x_4.att_reg=this.att_reg;
x_4.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","PDROITE -> t_action #add PDROITE1 ;"});
}
  }
private void action_init_40() throws Exception {
try {
// instructions
(this.att_reg).init();
(this.att_vis).regle(this.att_reg);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#init","PDROITE -> #init ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_ident : // 61
        regle38 () ;
      break ;
      case LEX_EGG.token_t_action : // 60
        regle39 () ;
      break ;
      case LEX_EGG.token_t_pointvirgule : // 40
        regle40 () ;
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
