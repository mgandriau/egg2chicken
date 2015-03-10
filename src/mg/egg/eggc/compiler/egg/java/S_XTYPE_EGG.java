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
public class S_XTYPE_EGG implements IDstNode {
LEX_EGG scanner;
  S_XTYPE_EGG() {
	}
  S_XTYPE_EGG(LEX_EGG scanner, boolean eval) {
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
  LEX_EGG att_scanner;
  IVisiteurEgg att_vis;
  private void regle13() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_13();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
  private void regle12() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	S_TYPE_EGG x_3 = new S_TYPE_EGG(scanner,att_eval) ;
	S_XTYPE_EGG x_4 = new S_XTYPE_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_12(x_3, x_4);
	x_2.analyser(LEX_EGG.token_t_virgule);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser() ;
	  addChild(x_4);
if  (att_eval)	  action_add_12(x_3, x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
private void action_add_12(S_TYPE_EGG x_3, S_XTYPE_EGG x_4) throws Exception {
try {
// instructions
(x_4.att_pars).insertElementAt(x_3.att_type, 0);
this.att_pars=x_4.att_pars;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#add","XTYPE -> t_virgule TYPE XTYPE1 #add ;"});
}
  }
private void action_gen_13() throws Exception {
try {
// instructions
this.att_pars= new Vector();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","XTYPE -> #gen ;"});
}
  }
private void action_auto_inh_12(S_TYPE_EGG x_3, S_XTYPE_EGG x_4) throws Exception {
try {
// instructions
x_3.att_res=this.att_res;
x_4.att_res=this.att_res;
x_3.att_vis=this.att_vis;
x_4.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","XTYPE -> t_virgule TYPE XTYPE1 #add ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_virgule : // 39
        regle12 () ;
      break ;
      case LEX_EGG.token_t_sup : // 42
        regle13 () ;
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
