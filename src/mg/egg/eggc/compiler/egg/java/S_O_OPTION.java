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
public class S_O_OPTION implements IDstNode {
LEX_OPTION scanner;
  S_O_OPTION() {
	}
  S_O_OPTION(LEX_OPTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  TDS att_table;
  LEX_OPTION att_scanner;
  private void regle2() throws Exception {

	//declaration
	T_OPTION x_2 = new T_OPTION(scanner ) ;
	T_OPTION x_3 = new T_OPTION(scanner ) ;
	S_BOOL_OPTION x_4 = new S_BOOL_OPTION(scanner,att_eval) ;
	T_OPTION x_5 = new T_OPTION(scanner ) ;
	//appel
	x_2.analyser(LEX_OPTION.token_t_auto);
	  addChild(x_2);
	x_3.analyser(LEX_OPTION.token_t_eg);
	  addChild(x_3);
	x_4.analyser() ;
	  addChild(x_4);
	x_5.analyser(LEX_OPTION.token_t_pv);
	  addChild(x_5);
if  (att_eval)	  action_gen_2(x_4);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle1() throws Exception {

	//declaration
	T_OPTION x_2 = new T_OPTION(scanner ) ;
	T_OPTION x_3 = new T_OPTION(scanner ) ;
	T_OPTION x_4 = new T_OPTION(scanner ) ;
	T_OPTION x_5 = new T_OPTION(scanner ) ;
	//appel
	x_2.analyser(LEX_OPTION.token_t_version);
	  addChild(x_2);
	x_3.analyser(LEX_OPTION.token_t_eg);
	  addChild(x_3);
	x_4.analyser(LEX_OPTION.token_t_vv);
	  addChild(x_4);
	x_5.analyser(LEX_OPTION.token_t_pv);
	  addChild(x_5);
if  (att_eval)	  action_gen_1(x_4);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle0() throws Exception {

	//declaration
	T_OPTION x_2 = new T_OPTION(scanner ) ;
	T_OPTION x_3 = new T_OPTION(scanner ) ;
	T_OPTION x_4 = new T_OPTION(scanner ) ;
	T_OPTION x_5 = new T_OPTION(scanner ) ;
	//appel
	x_2.analyser(LEX_OPTION.token_t_k);
	  addChild(x_2);
	x_3.analyser(LEX_OPTION.token_t_eg);
	  addChild(x_3);
	x_4.analyser(LEX_OPTION.token_t_vk);
	  addChild(x_4);
	x_5.analyser(LEX_OPTION.token_t_pv);
	  addChild(x_5);
if  (att_eval)	  action_gen_0(x_4);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
private void action_gen_1(T_OPTION x_4) throws Exception {
try {
// instructions
(this.att_table).setVersion(x_4.att_txt);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "OPTION", "#gen","O -> t_version t_eg t_vv t_pv #gen ;"});
}
  }
private void action_gen_2(S_BOOL_OPTION x_4) throws Exception {
try {
// instructions
(this.att_table).setAuto(x_4.att_val);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "OPTION", "#gen","O -> t_auto t_eg BOOL t_pv #gen ;"});
}
  }
private void action_gen_0(T_OPTION x_4) throws Exception {
try {
// instructions
(this.att_table).setK(x_4.att_txt);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "OPTION", "#gen","O -> t_k t_eg t_vk t_pv #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_OPTION.token_t_k : // 4
        regle0 () ;
      break ;
      case LEX_OPTION.token_t_version : // 10
        regle1 () ;
      break ;
      case LEX_OPTION.token_t_auto : // 9
        regle2 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IOPTIONMessages.id_OPTION_unexpected_token,OPTIONMessages.OPTION_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
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
