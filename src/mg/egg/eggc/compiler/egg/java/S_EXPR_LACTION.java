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
public class S_EXPR_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_EXPR_LACTION() {
	}
  S_EXPR_LACTION(LEX_LACTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  IVisiteurAction att_avis;
  String att_code;
  TDS att_table;
  IType att_type;
  LACT att_act;
  LEX_LACTION att_scanner;
  private void regle40() throws Exception {

	//declaration
	S_TERME_LACTION x_2 = new S_TERME_LACTION(scanner,att_eval) ;
	S_EXPRTERME_LACTION x_4 = new S_EXPRTERME_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_40(x_2, x_4);
	x_2.analyser() ;
	  addChild(x_2);
if  (att_eval)	  action_code_40(x_2, x_4);
	x_4.analyser() ;
	  addChild(x_4);
if  (att_eval)	  action_gen_40(x_2, x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
private void action_code_40(S_TERME_LACTION x_2, S_EXPRTERME_LACTION x_4) throws Exception {
try {
// instructions
x_4.att_hcode=x_2.att_code;
x_4.att_htype=x_2.att_type;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#code","EXPR -> TERME #code EXPRTERME #gen ;"});
}
  }
private void action_gen_40(S_TERME_LACTION x_2, S_EXPRTERME_LACTION x_4) throws Exception {
try {
// instructions
this.att_type=x_4.att_type;
this.att_code=x_4.att_code;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","EXPR -> TERME #code EXPRTERME #gen ;"});
}
  }
private void action_auto_inh_40(S_TERME_LACTION x_2, S_EXPRTERME_LACTION x_4) throws Exception {
try {
// instructions
x_2.att_table=this.att_table;
x_4.att_table=this.att_table;
x_2.att_avis=this.att_avis;
x_4.att_avis=this.att_avis;
x_2.att_act=this.att_act;
x_4.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","EXPR -> TERME #code EXPRTERME #gen ;"});
}
  }
  public void analyser () throws Exception {
    regle40 () ;
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
