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
public class S_TYPE_EGG implements IDstNode {
LEX_EGG scanner;
  S_TYPE_EGG() {
	}
  S_TYPE_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  Resolveur att_res;
  boolean att_eval;
  IType att_type;
  LEX_EGG att_scanner;
  IVisiteurEgg att_vis;
  private void regle9() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	S_TGEN_EGG x_3 = new S_TGEN_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_9(x_2, x_3);
	x_2.analyser(LEX_EGG.token_t_ident);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
if  (att_eval)	  action_gen_9(x_2, x_3);
	 offset =x_2.getOffset();
	 length =x_3.getOffset() + x_3.getLength() - offset;
  }
  private void regle17() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	//appel
	x_2.analyser(LEX_EGG.token_t_char);
	  addChild(x_2);
if  (att_eval)	  action_gen_17();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle14() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	//appel
	x_2.analyser(LEX_EGG.token_t_integer);
	  addChild(x_2);
if  (att_eval)	  action_gen_14();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle15() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	//appel
	x_2.analyser(LEX_EGG.token_t_double);
	  addChild(x_2);
if  (att_eval)	  action_gen_15();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle16() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	//appel
	x_2.analyser(LEX_EGG.token_t_string);
	  addChild(x_2);
if  (att_eval)	  action_gen_16();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
private void action_gen_16() throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType("STRING");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","TYPE -> t_string #gen ;"});
}
  }
private void action_gen_17() throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType("CHARACTER");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","TYPE -> t_char #gen ;"});
}
  }
private void action_gen_14() throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType("INTEGER");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","TYPE -> t_integer #gen ;"});
}
  }
private void action_gen_15() throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType("DOUBLE");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","TYPE -> t_double #gen ;"});
}
  }
private void action_auto_inh_9(T_EGG x_2, S_TGEN_EGG x_3) throws Exception {
try {
// instructions
x_3.att_res=this.att_res;
x_3.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","TYPE -> t_ident TGEN #gen ;"});
}
  }
private void action_gen_9(T_EGG x_2, S_TGEN_EGG x_3) throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType(x_2.att_txt, x_3.att_pars);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","TYPE -> t_ident TGEN #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_ident : // 61
        regle9 () ;
      break ;
      case LEX_EGG.token_t_integer : // 56
        regle14 () ;
      break ;
      case LEX_EGG.token_t_double : // 57
        regle15 () ;
      break ;
      case LEX_EGG.token_t_string : // 55
        regle16 () ;
      break ;
      case LEX_EGG.token_t_char : // 58
        regle17 () ;
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
