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
public class S_TYPE_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_TYPE_LACTION() {
	}
  S_TYPE_LACTION(LEX_LACTION scanner, boolean eval) {
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
  LEX_LACTION att_scanner;
  private void regle6() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_TGEN_LACTION x_4 = new S_TGEN_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_6(x_2, x_4);
	x_2.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_2);
if  (att_eval)	  action_trans_6(x_2, x_4);
	x_4.analyser() ;
	  addChild(x_4);
if  (att_eval)	  action_gen_6(x_2, x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle13() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_string);
	  addChild(x_2);
if  (att_eval)	  action_gen_13();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle14() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_char);
	  addChild(x_2);
if  (att_eval)	  action_gen_14();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle11() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_integer);
	  addChild(x_2);
if  (att_eval)	  action_gen_11();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle12() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_double);
	  addChild(x_2);
if  (att_eval)	  action_gen_12();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
private void action_auto_inh_6(T_LACTION x_2, S_TGEN_LACTION x_4) throws Exception {
try {
// instructions
x_4.att_res=this.att_res;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","TYPE -> t_ident #trans TGEN #gen ;"});
}
  }
private void action_gen_6(T_LACTION x_2, S_TGEN_LACTION x_4) throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType(x_2.att_txt, x_4.att_pars);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","TYPE -> t_ident #trans TGEN #gen ;"});
}
  }
private void action_gen_14() throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType("CHARACTER");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","TYPE -> t_char #gen ;"});
}
  }
private void action_gen_12() throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType("DOUBLE");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","TYPE -> t_double #gen ;"});
}
  }
private void action_gen_13() throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType("STRING");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","TYPE -> t_string #gen ;"});
}
  }
private void action_gen_11() throws Exception {
try {
// instructions
this.att_type=(this.att_res).getType("INTEGER");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","TYPE -> t_integer #gen ;"});
}
  }
private void action_trans_6(T_LACTION x_2, S_TGEN_LACTION x_4) throws Exception {
try {
// instructions
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","TYPE -> t_ident #trans TGEN #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_ident : // 92
        regle6 () ;
      break ;
      case LEX_LACTION.token_t_integer : // 78
        regle11 () ;
      break ;
      case LEX_LACTION.token_t_double : // 79
        regle12 () ;
      break ;
      case LEX_LACTION.token_t_string : // 77
        regle13 () ;
      break ;
      case LEX_LACTION.token_t_char : // 80
        regle14 () ;
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
