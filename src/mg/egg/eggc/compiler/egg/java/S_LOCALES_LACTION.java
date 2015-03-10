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
public class S_LOCALES_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_LOCALES_LACTION() {
	}
  S_LOCALES_LACTION(LEX_LACTION scanner, boolean eval) {
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
  LACT att_act;
  LEX_LACTION att_scanner;
  private void regle1() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_LOCS_LACTION x_4 = new S_LOCS_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_1(x_4);
	x_2.analyser(LEX_LACTION.token_t_local);
	  addChild(x_2);
if  (att_eval)	  action_inc_1(x_4);
	x_4.analyser() ;
	  addChild(x_4);
if  (att_eval)	  action_gen_1(x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle2() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_2();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_gen_1(S_LOCS_LACTION x_4) throws Exception {
try {
// instructions
this.att_code=((this.att_avis).locales()+x_4.att_code);
(this.att_avis).decIndent();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","LOCALES -> t_local #inc LOCS #gen ;"});
}
  }
private void action_gen_2() throws Exception {
try {
// instructions
this.att_code="";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","LOCALES -> #gen ;"});
}
  }
private void action_inc_1(S_LOCS_LACTION x_4) throws Exception {
try {
// instructions
(this.att_avis).incIndent();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#inc","LOCALES -> t_local #inc LOCS #gen ;"});
}
  }
private void action_auto_inh_1(S_LOCS_LACTION x_4) throws Exception {
try {
// instructions
x_4.att_avis=this.att_avis;
x_4.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","LOCALES -> t_local #inc LOCS #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_local : // 43
        regle1 () ;
      break ;
      case LEX_LACTION.token_t_do : // 42
        regle2 () ;
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
