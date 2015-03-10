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
public class S_INST2_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_INST2_LACTION() {
	}
  S_INST2_LACTION(LEX_LACTION scanner, boolean eval) {
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
  LACT att_act;
  LEX_LACTION att_scanner;
  private void regle21() throws Exception {

	//declaration
	S_APP2_LACTION x_2 = new S_APP2_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_21(x_2);
	x_2.analyser() ;
	  addChild(x_2);
if  (att_eval)	  action_gen_21(x_2);
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle20() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_EXPR_LACTION x_3 = new S_EXPR_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_20(x_3);
	x_2.analyser(LEX_LACTION.token_t_affectation);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
if  (att_eval)	  action_gen_20(x_3);
	 offset =x_2.getOffset();
	 length =x_3.getOffset() + x_3.getLength() - offset;
  }
private void action_gen_20(S_EXPR_LACTION x_3) throws Exception {
try {
// instructions
Resolveur loc_r;
if (!((this.att_hentree).affectable((this.att_act).getPos()))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_var_illegal_access, LACTIONMessages.LACTION_var_illegal_access,new Object[]{""+(this.att_hentree).getNom()});

}
else {
(this.att_hentree).setEtat(true);
this.att_code=(this.att_avis).aff(this.att_hentree, x_3.att_code);
loc_r=(this.att_act).getResolveur();
(loc_r).contAff(this.att_hentree, x_3.att_type);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST2 -> t_affectation EXPR #gen ;"});
}
  }
private void action_gen_21(S_APP2_LACTION x_2) throws Exception {
try {
// instructions
this.att_code=(x_2.att_code+";");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST2 -> APP2 #gen ;"});
}
  }
private void action_auto_inh_20(S_EXPR_LACTION x_3) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_3.att_avis=this.att_avis;
x_3.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST2 -> t_affectation EXPR #gen ;"});
}
  }
private void action_auto_inh_21(S_APP2_LACTION x_2) throws Exception {
try {
// instructions
x_2.att_table=this.att_table;
x_2.att_avis=this.att_avis;
x_2.att_act=this.att_act;
x_2.att_hentree=this.att_hentree;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST2 -> APP2 #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_affectation : // 36
        regle20 () ;
      break ;
      case LEX_LACTION.token_t_point : // 31
        regle21 () ;
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
