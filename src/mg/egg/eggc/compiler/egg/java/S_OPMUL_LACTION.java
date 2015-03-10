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
public class S_OPMUL_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_OPMUL_LACTION() {
	}
  S_OPMUL_LACTION(LEX_LACTION scanner, boolean eval) {
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
  private void regle69() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_mult);
	  addChild(x_2);
if  (att_eval)	  action_gen_69();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle68() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_et);
	  addChild(x_2);
if  (att_eval)	  action_gen_68();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle72() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_d_div);
	  addChild(x_2);
if  (att_eval)	  action_gen_72();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle71() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_d_mult);
	  addChild(x_2);
if  (att_eval)	  action_gen_71();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle70() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_div);
	  addChild(x_2);
if  (att_eval)	  action_gen_70();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
private void action_gen_69() throws Exception {
try {
// instructions
this.att_nom="*";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPMUL -> t_mult #gen ;"});
}
  }
private void action_gen_68() throws Exception {
try {
// instructions
this.att_nom="and";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPMUL -> t_et #gen ;"});
}
  }
private void action_gen_71() throws Exception {
try {
// instructions
this.att_nom="*.";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPMUL -> t_d_mult #gen ;"});
}
  }
private void action_gen_70() throws Exception {
try {
// instructions
this.att_nom="/";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPMUL -> t_div #gen ;"});
}
  }
private void action_gen_72() throws Exception {
try {
// instructions
this.att_nom="/.";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","OPMUL -> t_d_div #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_et : // 59
        regle68 () ;
      break ;
      case LEX_LACTION.token_t_mult : // 53
        regle69 () ;
      break ;
      case LEX_LACTION.token_t_div : // 54
        regle70 () ;
      break ;
      case LEX_LACTION.token_t_d_mult : // 57
        regle71 () ;
      break ;
      case LEX_LACTION.token_t_d_div : // 58
        regle72 () ;
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
