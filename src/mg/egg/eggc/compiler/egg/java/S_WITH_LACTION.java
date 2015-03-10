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
public class S_WITH_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_WITH_LACTION() {
	}
  S_WITH_LACTION(LEX_LACTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  ENTREE att_hentree;
  boolean att_eval;
  IVisiteurAction att_avis;
  String att_code;
  TDS att_table;
  IType att_type;
  LACT att_act;
  String att_nom;
  LEX_LACTION att_scanner;
  private void regle36() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_TYPE_LACTION x_4 = new S_TYPE_LACTION(scanner,att_eval) ;
	T_LACTION x_6 = new T_LACTION(scanner ) ;
	S_INSTS_LACTION x_7 = new S_INSTS_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_36(x_4, x_7);
	x_2.analyser(LEX_LACTION.token_t_with);
	  addChild(x_2);
if  (att_eval)	  action_res_36(x_4, x_7);
	x_4.analyser() ;
	  addChild(x_4);
if  (att_eval)	  action_trans_36(x_4, x_7);
	x_6.analyser(LEX_LACTION.token_t_then);
	  addChild(x_6);
	x_7.analyser() ;
	  addChild(x_7);
if  (att_eval)	  action_gen_36(x_4, x_7);
	 offset =x_2.getOffset();
	 length =x_7.getOffset() + x_7.getLength() - offset;
  }
private void action_gen_36(S_TYPE_LACTION x_4, S_INSTS_LACTION x_7) throws Exception {
try {
// instructions
this.att_type=x_4.att_type;
this.att_nom=(x_4.att_type).getNom();
this.att_code=x_7.att_code;
(this.att_avis).decIndent();
(this.att_avis).detranstyper(this.att_hentree);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","WITH -> t_with #res TYPE #trans t_then INSTS #gen ;"});
}
  }
private void action_trans_36(S_TYPE_LACTION x_4, S_INSTS_LACTION x_7) throws Exception {
try {
// instructions
(this.att_avis).incIndent();
(this.att_avis).transtyper(this.att_hentree, x_4.att_type);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","WITH -> t_with #res TYPE #trans t_then INSTS #gen ;"});
}
  }
private void action_auto_inh_36(S_TYPE_LACTION x_4, S_INSTS_LACTION x_7) throws Exception {
try {
// instructions
x_7.att_table=this.att_table;
x_7.att_avis=this.att_avis;
x_7.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","WITH -> t_with #res TYPE #trans t_then INSTS #gen ;"});
}
  }
private void action_res_36(S_TYPE_LACTION x_4, S_INSTS_LACTION x_7) throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
x_4.att_res=loc_r;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#res","WITH -> t_with #res TYPE #trans t_then INSTS #gen ;"});
}
  }
  public void analyser () throws Exception {
    regle36 () ;
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
