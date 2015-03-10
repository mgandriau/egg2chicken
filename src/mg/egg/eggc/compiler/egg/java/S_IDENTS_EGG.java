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
public class S_IDENTS_EGG implements IDstNode {
LEX_EGG scanner;
  S_IDENTS_EGG() {
	}
  S_IDENTS_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  ATTRIBUT att_att;
  TDS att_table;
  LEX_EGG att_scanner;
  IVisiteurEgg att_vis;
  private void regle18() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	S_IDENT_EGG x_3 = new S_IDENT_EGG(scanner,att_eval) ;
	S_IDENTS_EGG x_5 = new S_IDENTS_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_18(x_3, x_5);
	x_2.analyser(LEX_EGG.token_t_virgule);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
if  (att_eval)	  action_add_18(x_3, x_5);
	x_5.analyser() ;
	  addChild(x_5);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle19() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_fin_19();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_auto_inh_18(S_IDENT_EGG x_3, S_IDENTS_EGG x_5) throws Exception {
try {
// instructions
x_5.att_table=this.att_table;
x_5.att_att=this.att_att;
x_3.att_vis=this.att_vis;
x_5.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","IDENTS -> t_virgule IDENT #add IDENTS1 ;"});
}
  }
private void action_fin_19() throws Exception {
try {
// instructions
(this.att_vis).nt_attribut(this.att_att);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#fin","IDENTS -> #fin ;"});
}
  }
private void action_add_18(S_IDENT_EGG x_3, S_IDENTS_EGG x_5) throws Exception {
try {
// instructions
SYMBOLE loc_symbole;
NON_TERMINAL loc_nt;
ATTRIBUT loc_attribut;
ATTRIBUT loc_atteval;
ATTRIBUT loc_a;
loc_nt=null;
loc_symbole=(this.att_table).chercher(x_3.att_code);
if ((loc_symbole!=null)){
if (loc_symbole instanceof NON_TERMINAL ){
loc_nt=((NON_TERMINAL)loc_symbole);
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_no_terminal_attribute, EGGMessages.EGG_no_terminal_attribute,new Object[]{""+x_3.att_code});


}
}
else {
loc_nt= new NON_TERMINAL(x_3.att_code);
(this.att_table).inserer(loc_nt);
(this.att_vis).nt_entete(loc_nt);
loc_attribut=(this.att_table).attribut("scanner");
(loc_nt).add_attribut(loc_attribut);
(this.att_vis).nt_attribut(loc_nt, loc_attribut);
loc_atteval=(this.att_table).attribut("eval");
(loc_nt).add_attribut(loc_atteval);
(this.att_vis).nt_attribut(loc_nt, loc_atteval);
}
loc_a=(loc_nt).attribut((this.att_att).getNom());
if ((loc_a==null)){
(loc_nt).add_attribut(this.att_att);
(this.att_vis).nt_attribut(loc_nt, this.att_att);
}
else {
{ String as[]={
(this.att_att).getNom(), x_3.att_code}
;att_scanner._signaler(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_attribute_yet_declared, EGGMessages.EGG_attribute_yet_declared,as);
}

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#add","IDENTS -> t_virgule IDENT #add IDENTS1 ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_virgule : // 39
        regle18 () ;
      break ;
      case LEX_EGG.token_t_pointvirgule : // 40
        regle19 () ;
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
