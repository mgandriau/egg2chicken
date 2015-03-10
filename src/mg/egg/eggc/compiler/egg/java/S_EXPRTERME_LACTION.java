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
public class S_EXPRTERME_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_EXPRTERME_LACTION() {
	}
  S_EXPRTERME_LACTION(LEX_LACTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  String att_hcode;
  IType att_htype;
  IVisiteurAction att_avis;
  String att_code;
  TDS att_table;
  IType att_type;
  LACT att_act;
  LEX_LACTION att_scanner;
  private void regle41() throws Exception {

	//declaration
	S_OPADD_LACTION x_2 = new S_OPADD_LACTION(scanner,att_eval) ;
	S_TERME_LACTION x_3 = new S_TERME_LACTION(scanner,att_eval) ;
	S_EXPRTERME_LACTION x_5 = new S_EXPRTERME_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_41(x_2, x_3, x_5);
	x_2.analyser() ;
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
if  (att_eval)	  action_code_41(x_2, x_3, x_5);
	x_5.analyser() ;
	  addChild(x_5);
if  (att_eval)	  action_gen_41(x_2, x_3, x_5);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle50() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_50();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_gen_41(S_OPADD_LACTION x_2, S_TERME_LACTION x_3, S_EXPRTERME_LACTION x_5) throws Exception {
try {
// instructions
this.att_type=x_5.att_type;
this.att_code=x_5.att_code;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","EXPRTERME -> OPADD TERME #code EXPRTERME1 #gen ;"});
}
  }
private void action_gen_50() throws Exception {
try {
// instructions
this.att_type=this.att_htype;
this.att_code=this.att_hcode;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","EXPRTERME -> #gen ;"});
}
  }
private void action_code_41(S_OPADD_LACTION x_2, S_TERME_LACTION x_3, S_EXPRTERME_LACTION x_5) throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
x_5.att_htype=(loc_r).contOp(this.att_htype, x_2.att_nom, x_3.att_type);
x_5.att_hcode=(this.att_avis).opAdd(this.att_hcode, x_2.att_nom, x_3.att_code);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#code","EXPRTERME -> OPADD TERME #code EXPRTERME1 #gen ;"});
}
  }
private void action_auto_inh_41(S_OPADD_LACTION x_2, S_TERME_LACTION x_3, S_EXPRTERME_LACTION x_5) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_5.att_table=this.att_table;
x_3.att_avis=this.att_avis;
x_5.att_avis=this.att_avis;
x_3.att_act=this.att_act;
x_5.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","EXPRTERME -> OPADD TERME #code EXPRTERME1 #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_egal : // 70
        regle41 () ;
      break ;
      case LEX_LACTION.token_t_different : // 71
        regle41 () ;
      break ;
      case LEX_LACTION.token_t_append : // 62
        regle41 () ;
      break ;
      case LEX_LACTION.token_t_plus : // 51
        regle41 () ;
      break ;
      case LEX_LACTION.token_t_moins : // 52
        regle41 () ;
      break ;
      case LEX_LACTION.token_t_d_plus : // 55
        regle41 () ;
      break ;
      case LEX_LACTION.token_t_d_moins : // 56
        regle41 () ;
      break ;
      case LEX_LACTION.token_t_ou : // 60
        regle41 () ;
      break ;
      case LEX_LACTION.token_t_virgule : // 33
        regle50 () ;
      break ;
      case LEX_LACTION.token_t_then : // 68
        regle50 () ;
      break ;
      case LEX_LACTION.token_t_pointvirgule : // 34
        regle50 () ;
      break ;
      case LEX_LACTION.token_t_parf : // 40
        regle50 () ;
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
