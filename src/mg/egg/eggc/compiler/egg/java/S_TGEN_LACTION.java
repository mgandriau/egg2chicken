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
public class S_TGEN_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_TGEN_LACTION() {
	}
  S_TGEN_LACTION(LEX_LACTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  Resolveur att_res;
  boolean att_eval;
  Vector att_pars;
  LEX_LACTION att_scanner;
  private void regle8() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_TYPE_LACTION x_3 = new S_TYPE_LACTION(scanner,att_eval) ;
	S_XTYPE_LACTION x_4 = new S_XTYPE_LACTION(scanner,att_eval) ;
	T_LACTION x_5 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_8(x_3, x_4);
	x_2.analyser(LEX_LACTION.token_t_inf);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser() ;
	  addChild(x_4);
	x_5.analyser(LEX_LACTION.token_t_sup);
	  addChild(x_5);
if  (att_eval)	  action_gen_8(x_3, x_4);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle7() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_7();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_auto_inh_8(S_TYPE_LACTION x_3, S_XTYPE_LACTION x_4) throws Exception {
try {
// instructions
x_3.att_res=this.att_res;
x_4.att_res=this.att_res;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","TGEN -> t_inf TYPE XTYPE t_sup #gen ;"});
}
  }
private void action_gen_7() throws Exception {
try {
// instructions
this.att_pars=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","TGEN -> #gen ;"});
}
  }
private void action_gen_8(S_TYPE_LACTION x_3, S_XTYPE_LACTION x_4) throws Exception {
try {
// instructions
(x_4.att_pars).insertElementAt(x_3.att_type, 0);
this.att_pars=x_4.att_pars;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","TGEN -> t_inf TYPE XTYPE t_sup #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_virgule : // 33
        regle7 () ;
      break ;
      case LEX_LACTION.token_t_sup : // 38
        regle7 () ;
      break ;
      case LEX_LACTION.token_t_paro : // 39
        regle7 () ;
      break ;
      case LEX_LACTION.token_t_then : // 68
        regle7 () ;
      break ;
      case LEX_LACTION.token_t_pointvirgule : // 34
        regle7 () ;
      break ;
      case LEX_LACTION.token_t_inf : // 37
        regle8 () ;
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
