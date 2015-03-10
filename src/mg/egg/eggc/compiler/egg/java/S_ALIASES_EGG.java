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
public class S_ALIASES_EGG implements IDstNode {
LEX_EGG scanner;
  S_ALIASES_EGG() {
	}
  S_ALIASES_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  TERMINAL att_lex;
  boolean att_eval;
  LEX_EGG att_scanner;
  private void regle21() throws Exception {

	//declaration
	//appel
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
  private void regle22() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	T_EGG x_3 = new T_EGG(scanner ) ;
	S_ALIASESX_EGG x_5 = new S_ALIASESX_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_22(x_3, x_5);
	x_2.analyser(LEX_EGG.token_t_aka);
	  addChild(x_2);
	x_3.analyser(LEX_EGG.token_t_alias);
	  addChild(x_3);
if  (att_eval)	  action_alias_22(x_3, x_5);
	x_5.analyser() ;
	  addChild(x_5);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
private void action_alias_22(T_EGG x_3, S_ALIASESX_EGG x_5) throws Exception {
try {
// instructions
(this.att_lex).addName(x_3.att_txt);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#alias","ALIASES -> t_aka t_alias #alias ALIASESX ;"});
}
  }
private void action_auto_inh_22(T_EGG x_3, S_ALIASESX_EGG x_5) throws Exception {
try {
// instructions
x_5.att_lex=this.att_lex;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","ALIASES -> t_aka t_alias #alias ALIASESX ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_pointvirgule : // 40
        regle21 () ;
      break ;
      case LEX_EGG.token_t_aka : // 32
        regle22 () ;
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
