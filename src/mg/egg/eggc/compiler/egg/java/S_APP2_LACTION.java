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
public class S_APP2_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_APP2_LACTION() {
	}
  S_APP2_LACTION(LEX_LACTION scanner, boolean eval) {
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
  LEX_LACTION att_scanner;
  private void regle63() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	T_LACTION x_3 = new T_LACTION(scanner ) ;
	T_LACTION x_5 = new T_LACTION(scanner ) ;
	S_ARGS_LACTION x_6 = new S_ARGS_LACTION(scanner,att_eval) ;
	T_LACTION x_7 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_63(x_3, x_6);
	x_2.analyser(LEX_LACTION.token_t_point);
	  addChild(x_2);
	x_3.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_3);
if  (att_eval)	  action_trans_63(x_3, x_6);
	x_5.analyser(LEX_LACTION.token_t_paro);
	  addChild(x_5);
	x_6.analyser() ;
	  addChild(x_6);
	x_7.analyser(LEX_LACTION.token_t_parf);
	  addChild(x_7);
if  (att_eval)	  action_gen_63(x_3, x_6);
	 offset =x_2.getOffset();
	 length =x_7.getOffset() + x_7.getLength() - offset;
  }
private void action_auto_inh_63(T_LACTION x_3, S_ARGS_LACTION x_6) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_avis=this.att_avis;
x_6.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","APP2 -> t_point t_ident #trans t_paro ARGS t_parf #gen ;"});
}
  }
private void action_trans_63(T_LACTION x_3, S_ARGS_LACTION x_6) throws Exception {
try {
// instructions
Vector loc_a;
Vector loc_ts;
loc_a= new Vector();
x_6.att_hargs=loc_a;
loc_ts= new Vector();
x_6.att_htypes=loc_ts;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","APP2 -> t_point t_ident #trans t_paro ARGS t_parf #gen ;"});
}
  }
private void action_gen_63(T_LACTION x_3, S_ARGS_LACTION x_6) throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=null;
this.att_code=(this.att_avis).fct(this.att_hentree, x_3.att_txt, x_6.att_args);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","APP2 -> t_point t_ident #trans t_paro ARGS t_parf #gen ;"});
}
  }
  public void analyser () throws Exception {
    regle63 () ;
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
