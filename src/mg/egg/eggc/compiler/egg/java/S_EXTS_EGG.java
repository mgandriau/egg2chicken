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
public class S_EXTS_EGG implements IDstNode {
LEX_EGG scanner;
  S_EXTS_EGG() {
	}
  S_EXTS_EGG(LEX_EGG scanner, boolean eval) {
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
  private void regle33() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	T_EGG x_3 = new T_EGG(scanner ) ;
	T_EGG x_4 = new T_EGG(scanner ) ;
	S_EXTS_EGG x_6 = new S_EXTS_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_33(x_3, x_6);
	x_2.analyser(LEX_EGG.token_t_external);
	  addChild(x_2);
	x_3.analyser(LEX_EGG.token_t_ident);
	  addChild(x_3);
	x_4.analyser(LEX_EGG.token_t_pointvirgule);
	  addChild(x_4);
if  (att_eval)	  action_gen_33(x_3, x_6);
	x_6.analyser() ;
	  addChild(x_6);
	 offset =x_2.getOffset();
	 length =x_6.getOffset() + x_6.getLength() - offset;
  }
  private void regle32() throws Exception {

	//declaration
	//appel
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_gen_33(T_EGG x_3, S_EXTS_EGG x_6) throws Exception {
try {
// instructions
SYMBOLE loc_symbole;
NON_TERMINAL loc_nt;
ATTRIBUT loc_attribut;
EGG loc_compiler;
loc_nt=null;
loc_symbole=(this.att_table).chercher(x_3.att_txt);
if ((loc_symbole!=null)){
if (loc_symbole instanceof NON_TERMINAL ){
loc_nt=((NON_TERMINAL)loc_symbole);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_not_a_non_terminal, EGGMessages.EGG_not_a_non_terminal,new Object[]{""+x_3.att_txt});


}
}
else {
loc_nt= new NON_TERMINAL(x_3.att_txt);
(this.att_table).inserer(loc_nt);
(this.att_vis).ex_entete(loc_nt);
loc_attribut=(this.att_table).attribut("scanner");
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
loc_attribut=(this.att_table).attribut("eval");
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
}
(loc_nt).setExterne();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","EXTS -> t_external t_ident t_pointvirgule #gen EXTS1 ;"});
}
  }
private void action_auto_inh_33(T_EGG x_3, S_EXTS_EGG x_6) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","EXTS -> t_external t_ident t_pointvirgule #gen EXTS1 ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_ident : // 61
        regle32 () ;
      break ;
      case LEX_EGG.token_t_external : // 49
        regle33 () ;
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
