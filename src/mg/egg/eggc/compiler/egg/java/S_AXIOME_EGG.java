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
public class S_AXIOME_EGG implements IDstNode {
LEX_EGG scanner;
  S_AXIOME_EGG() {
	}
  S_AXIOME_EGG(LEX_EGG scanner, boolean eval) {
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
  private void regle34() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	T_EGG x_3 = new T_EGG(scanner ) ;
	S_PDROITE_EGG x_5 = new S_PDROITE_EGG(scanner,att_eval) ;
	T_EGG x_6 = new T_EGG(scanner ) ;
	S_ACTS_EGG x_8 = new S_ACTS_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_34(x_2, x_5, x_8);
	x_2.analyser(LEX_EGG.token_t_ident);
	  addChild(x_2);
	x_3.analyser(LEX_EGG.token_t_fleche);
	  addChild(x_3);
if  (att_eval)	  action_trans_34(x_2, x_5, x_8);
	x_5.analyser() ;
	  addChild(x_5);
	x_6.analyser(LEX_EGG.token_t_pointvirgule);
	  addChild(x_6);
if  (att_eval)	  action_axiome_34(x_2, x_5, x_8);
	x_8.analyser() ;
	  addChild(x_8);
	 offset =x_2.getOffset();
	 length =x_8.getOffset() + x_8.getLength() - offset;
  }
private void action_trans_34(T_EGG x_2, S_PDROITE_EGG x_5, S_ACTS_EGG x_8) throws Exception {
try {
// instructions
SYMBOLE loc_symbole;
NON_TERMINAL loc_nt;
REGLE loc_regle;
ATTRIBUT loc_attribut;
Resolveur loc_r;
loc_r=(this.att_table).getResolveur();
loc_nt=null;
loc_symbole=null;
loc_attribut=null;
loc_symbole=(this.att_table).chercher(x_2.att_txt);
if ((loc_symbole!=null)){
if (loc_symbole instanceof NON_TERMINAL ){
loc_nt=((NON_TERMINAL)loc_symbole);
(this.att_table).setAxiome(loc_nt);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_not_a_non_terminal, EGGMessages.EGG_not_a_non_terminal,new Object[]{""+x_2.att_txt});


}
}
else {
loc_nt= new NON_TERMINAL(x_2.att_txt);
(this.att_table).inserer(loc_nt);
(this.att_table).setAxiome(loc_nt);
(this.att_vis).nt_entete(loc_nt);
loc_attribut=(this.att_table).attribut("scanner");
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
loc_attribut=(this.att_table).attribut("eval");
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
}
(this.att_table).ajouter_axiome();
loc_regle= new REGLE(this.att_table, loc_nt, (this.att_table).getResolveur(), (this.att_scanner).getCommentaire());
(this.att_table).add_regle(loc_regle);
(loc_nt).add_regle(loc_regle);
x_5.att_reg=loc_regle;
x_8.att_reg=loc_regle;
if ((this.att_table).getAutoAtt()){
if (!((loc_regle).add_action_inhs())){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_action_yet_declared, EGGMessages.EGG_action_yet_declared,new Object[]{""+"#auto"});

}

}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#trans","AXIOME -> t_ident t_fleche #trans PDROITE t_pointvirgule #axiome ACTS ;"});
}
  }
private void action_auto_inh_34(T_EGG x_2, S_PDROITE_EGG x_5, S_ACTS_EGG x_8) throws Exception {
try {
// instructions
x_5.att_table=this.att_table;
x_8.att_table=this.att_table;
x_5.att_vis=this.att_vis;
x_8.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","AXIOME -> t_ident t_fleche #trans PDROITE t_pointvirgule #axiome ACTS ;"});
}
  }
private void action_axiome_34(T_EGG x_2, S_PDROITE_EGG x_5, S_ACTS_EGG x_8) throws Exception {
try {
// instructions
(this.att_vis).racine();
if ((!((this.att_table).getModule())&&(this.att_table).getMain())){
(this.att_vis).racinec();
}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#axiome","AXIOME -> t_ident t_fleche #trans PDROITE t_pointvirgule #axiome ACTS ;"});
}
  }
  public void analyser () throws Exception {
    regle34 () ;
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
