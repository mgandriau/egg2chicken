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
public class S_ARGS_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_ARGS_LACTION() {
	}
  S_ARGS_LACTION(LEX_LACTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  Vector att_args;
  boolean att_eval;
  Vector att_htypes;
  IVisiteurAction att_avis;
  TDS att_table;
  Vector att_types;
  LACT att_act;
  Vector att_hargs;
  LEX_LACTION att_scanner;
  private void regle75() throws Exception {

	//declaration
	S_EXPR_LACTION x_2 = new S_EXPR_LACTION(scanner,att_eval) ;
	S_ARGSX_LACTION x_4 = new S_ARGSX_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_75(x_2, x_4);
	x_2.analyser() ;
	  addChild(x_2);
if  (att_eval)	  action_expr_75(x_2, x_4);
	x_4.analyser() ;
	  addChild(x_4);
if  (att_eval)	  action_gen_75(x_2, x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle74() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_74();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_auto_inh_75(S_EXPR_LACTION x_2, S_ARGSX_LACTION x_4) throws Exception {
try {
// instructions
x_2.att_table=this.att_table;
x_4.att_table=this.att_table;
x_2.att_avis=this.att_avis;
x_4.att_avis=this.att_avis;
x_2.att_act=this.att_act;
x_4.att_act=this.att_act;
x_4.att_hargs=this.att_hargs;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","ARGS -> EXPR #expr ARGSX #gen ;"});
}
  }
private void action_expr_75(S_EXPR_LACTION x_2, S_ARGSX_LACTION x_4) throws Exception {
try {
// instructions
(this.att_hargs).add(x_2.att_code);
(this.att_htypes).add(x_2.att_type);
x_4.att_htypes=this.att_htypes;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#expr","ARGS -> EXPR #expr ARGSX #gen ;"});
}
  }
private void action_gen_75(S_EXPR_LACTION x_2, S_ARGSX_LACTION x_4) throws Exception {
try {
// instructions
this.att_args=x_4.att_args;
this.att_types=x_4.att_types;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","ARGS -> EXPR #expr ARGSX #gen ;"});
}
  }
private void action_gen_74() throws Exception {
try {
// instructions
this.att_args=this.att_hargs;
this.att_types=this.att_htypes;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","ARGS -> #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_parf : // 40
        regle74 () ;
      break ;
      case LEX_LACTION.token_t_nil : // 72
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_true : // 73
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_false : // 74
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_entier : // 82
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_moins : // 52
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_flottant : // 83
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_car : // 91
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_chaine : // 89
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_ident : // 92
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_not : // 61
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_paro : // 39
        regle75 () ;
      break ;
      case LEX_LACTION.token_t_new : // 50
        regle75 () ;
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
