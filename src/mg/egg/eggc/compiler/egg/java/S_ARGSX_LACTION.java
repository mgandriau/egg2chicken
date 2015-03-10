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
public class S_ARGSX_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_ARGSX_LACTION() {
	}
  S_ARGSX_LACTION(LEX_LACTION scanner, boolean eval) {
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
  private void regle77() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_EXPR_LACTION x_3 = new S_EXPR_LACTION(scanner,att_eval) ;
	S_ARGSX_LACTION x_5 = new S_ARGSX_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_77(x_3, x_5);
	x_2.analyser(LEX_LACTION.token_t_virgule);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
if  (att_eval)	  action_expr_77(x_3, x_5);
	x_5.analyser() ;
	  addChild(x_5);
if  (att_eval)	  action_gen_77(x_3, x_5);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle76() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_76();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_auto_inh_77(S_EXPR_LACTION x_3, S_ARGSX_LACTION x_5) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_5.att_table=this.att_table;
x_3.att_avis=this.att_avis;
x_5.att_avis=this.att_avis;
x_3.att_act=this.att_act;
x_5.att_act=this.att_act;
x_5.att_hargs=this.att_hargs;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","ARGSX -> t_virgule EXPR #expr ARGSX1 #gen ;"});
}
  }
private void action_expr_77(S_EXPR_LACTION x_3, S_ARGSX_LACTION x_5) throws Exception {
try {
// instructions
(this.att_hargs).add(x_3.att_code);
(this.att_htypes).add(x_3.att_type);
x_5.att_htypes=this.att_htypes;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#expr","ARGSX -> t_virgule EXPR #expr ARGSX1 #gen ;"});
}
  }
private void action_gen_77(S_EXPR_LACTION x_3, S_ARGSX_LACTION x_5) throws Exception {
try {
// instructions
this.att_args=x_5.att_args;
this.att_types=x_5.att_types;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","ARGSX -> t_virgule EXPR #expr ARGSX1 #gen ;"});
}
  }
private void action_gen_76() throws Exception {
try {
// instructions
this.att_args=this.att_hargs;
this.att_types=this.att_htypes;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","ARGSX -> #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_parf : // 40
        regle76 () ;
      break ;
      case LEX_LACTION.token_t_virgule : // 33
        regle77 () ;
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
