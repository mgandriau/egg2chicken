package mg.egg.eggc.compiler.egg.java;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.compiler.libegg.base.*;
import mg.egg.eggc.compiler.libegg.java.*;
import mg.egg.eggc.compiler.libegg.egg.*;
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
public class S_ELTS_EXPREG implements IDstNode {
LEX_EXPREG scanner;
  S_ELTS_EXPREG() {
	}
  S_ELTS_EXPREG(LEX_EXPREG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  String att_code;
  LEX_EXPREG att_scanner;
  IVisiteurEgg att_vis;
  private void regle24() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_24();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
  private void regle23() throws Exception {

	//declaration
	S_ELT_EXPREG x_2 = new S_ELT_EXPREG(scanner,att_eval) ;
	S_ELTS_EXPREG x_3 = new S_ELTS_EXPREG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_23(x_2, x_3);
	x_2.analyser() ;
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
if  (att_eval)	  action_gen_23(x_2, x_3);
	 offset =x_2.getOffset();
	 length =x_3.getOffset() + x_3.getLength() - offset;
  }
private void action_gen_24() throws Exception {
try {
// instructions
this.att_code="";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#gen","ELTS -> #gen ;"});
}
  }
private void action_gen_23(S_ELT_EXPREG x_2, S_ELTS_EXPREG x_3) throws Exception {
try {
// instructions
this.att_code=(x_2.att_code+x_3.att_code);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#gen","ELTS -> ELT ELTS1 #gen ;"});
}
  }
private void action_auto_inh_23(S_ELT_EXPREG x_2, S_ELTS_EXPREG x_3) throws Exception {
try {
// instructions
x_2.att_vis=this.att_vis;
x_3.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#auto_inh","ELTS -> ELT ELTS1 #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EXPREG.token_car : // 33
        regle23 () ;
      break ;
      case LEX_EXPREG.token_crocf : // 14
        regle24 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IEXPREGMessages.id_EXPREG_unexpected_token,EXPREGMessages.EXPREG_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
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
