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
public class S_SATT_EGG implements IDstNode {
LEX_EGG scanner;
  S_SATT_EGG() {
	}
  S_SATT_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  int att_sorte;
  LEX_EGG att_scanner;
  private void regle5() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	//appel
	x_2.analyser(LEX_EGG.token_t_inh);
	  addChild(x_2);
if  (att_eval)	  action_sorte_5();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle6() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	//appel
	x_2.analyser(LEX_EGG.token_t_syn);
	  addChild(x_2);
if  (att_eval)	  action_sorte_6();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
private void action_sorte_5() throws Exception {
try {
// instructions
this.att_sorte=0;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#sorte","SATT -> t_inh #sorte ;"});
}
  }
private void action_sorte_6() throws Exception {
try {
// instructions
this.att_sorte=1;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#sorte","SATT -> t_syn #sorte ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_inh : // 30
        regle5 () ;
      break ;
      case LEX_EGG.token_t_syn : // 31
        regle6 () ;
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
