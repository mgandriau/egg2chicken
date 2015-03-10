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
public class S_APP_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_APP_LACTION() {
	}
  S_APP_LACTION(LEX_LACTION scanner, boolean eval) {
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
  private void regle62() throws Exception {

	//declaration
	S_APP2_LACTION x_2 = new S_APP2_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_62(x_2);
	x_2.analyser() ;
	  addChild(x_2);
if  (att_eval)	  action_gen_62(x_2);
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle61() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_61();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_auto_inh_62(S_APP2_LACTION x_2) throws Exception {
try {
// instructions
x_2.att_table=this.att_table;
x_2.att_avis=this.att_avis;
x_2.att_act=this.att_act;
x_2.att_hentree=this.att_hentree;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","APP -> APP2 #gen ;"});
}
  }
private void action_gen_62(S_APP2_LACTION x_2) throws Exception {
try {
// instructions
this.att_code=x_2.att_code;
this.att_type=x_2.att_type;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","APP -> APP2 #gen ;"});
}
  }
private void action_gen_61() throws Exception {
try {
// instructions
this.att_code=(this.att_avis).var(this.att_hentree);
this.att_type=(this.att_hentree).getType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","APP -> #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_et : // 59
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_mult : // 53
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_div : // 54
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_d_mult : // 57
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_d_div : // 58
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_egal : // 70
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_different : // 71
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_append : // 62
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_plus : // 51
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_moins : // 52
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_d_plus : // 55
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_d_moins : // 56
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_ou : // 60
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_virgule : // 33
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_then : // 68
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_pointvirgule : // 34
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_parf : // 40
        regle61 () ;
      break ;
      case LEX_LACTION.token_t_point : // 31
        regle62 () ;
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
