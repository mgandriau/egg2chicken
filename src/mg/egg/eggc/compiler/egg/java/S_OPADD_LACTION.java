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
public class S_OPADD_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_OPADD_LACTION() {
	}
  S_OPADD_LACTION(LEX_LACTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  String att_nom;
  LEX_LACTION att_scanner;
  private void regle48() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_d_moins);
	  addChild(x_2);
if  (att_eval)	  action_gen_48();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle49() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_ou);
	  addChild(x_2);
if  (att_eval)	  action_gen_49();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle46() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_moins);
	  addChild(x_2);
if  (att_eval)	  action_gen_46();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle47() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_d_plus);
	  addChild(x_2);
if  (att_eval)	  action_gen_47();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle44() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_append);
	  addChild(x_2);
if  (att_eval)	  action_gen_44();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle42() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_egal);
	  addChild(x_2);
if  (att_eval)	  action_gen_42();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle45() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_plus);
	  addChild(x_2);
if  (att_eval)	  action_gen_45();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle43() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_different);
	  addChild(x_2);
if  (att_eval)	  action_gen_43();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
private void action_gen_42() throws Exception {
try {
// instructions
this.att_nom="=";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPADD -> t_egal #gen ;"});
}
  }
private void action_gen_43() throws Exception {
try {
// instructions
this.att_nom="/=";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPADD -> t_different #gen ;"});
}
  }
private void action_gen_44() throws Exception {
try {
// instructions
this.att_nom="@";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPADD -> t_append #gen ;"});
}
  }
private void action_gen_49() throws Exception {
try {
// instructions
this.att_nom="or";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPADD -> t_ou #gen ;"});
}
  }
private void action_gen_46() throws Exception {
try {
// instructions
this.att_nom="-";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPADD -> t_moins #gen ;"});
}
  }
private void action_gen_45() throws Exception {
try {
// instructions
this.att_nom="+";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPADD -> t_plus #gen ;"});
}
  }
private void action_gen_48() throws Exception {
try {
// instructions
this.att_nom="-.";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPADD -> t_d_moins #gen ;"});
}
  }
private void action_gen_47() throws Exception {
try {
// instructions
this.att_nom="+.";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPADD -> t_d_plus #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_egal : // 70
        regle42 () ;
      break ;
      case LEX_LACTION.token_t_different : // 71
        regle43 () ;
      break ;
      case LEX_LACTION.token_t_append : // 62
        regle44 () ;
      break ;
      case LEX_LACTION.token_t_plus : // 51
        regle45 () ;
      break ;
      case LEX_LACTION.token_t_moins : // 52
        regle46 () ;
      break ;
      case LEX_LACTION.token_t_d_plus : // 55
        regle47 () ;
      break ;
      case LEX_LACTION.token_t_d_moins : // 56
        regle48 () ;
      break ;
      case LEX_LACTION.token_t_ou : // 60
        regle49 () ;
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
