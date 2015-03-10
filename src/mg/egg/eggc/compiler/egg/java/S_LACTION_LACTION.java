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
public class S_LACTION_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_LACTION_LACTION() {
	}
  S_LACTION_LACTION(LEX_LACTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  REGLE att_reg;
  boolean att_eval;
  int att_length;
  IVisiteurAction att_avis;
  String att_code;
  TDS att_table;
  int att_offset;
  LACT att_act;
  LEX_LACTION att_scanner;
  int glob_0_length;
  int glob_0_offset;
  private void regle0() throws Exception {

	//declaration
	S_LOCALES_LACTION x_3 = new S_LOCALES_LACTION(scanner,att_eval) ;
	T_LACTION x_4 = new T_LACTION(scanner ) ;
	S_INSTS_LACTION x_6 = new S_INSTS_LACTION(scanner,att_eval) ;
	S_EXCEPTION_LACTION x_7 = new S_EXCEPTION_LACTION(scanner,att_eval) ;
	T_LACTION x_8 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_0(x_3, x_6, x_7);
if  (att_eval)	  action_res_0(x_3, x_6, x_7);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser(LEX_LACTION.token_t_do);
	  addChild(x_4);
if  (att_eval)	  action_inc_0(x_3, x_6, x_7);
	x_6.analyser() ;
	  addChild(x_6);
	x_7.analyser() ;
	  addChild(x_7);
	x_8.analyser(LEX_LACTION.token_t_end);
	  addChild(x_8);
if  (att_eval)	  action_gen_0(x_3, x_6, x_7);
	 offset =x_3.getOffset();
	 length =x_8.getOffset() + x_8.getLength() - offset;
  }
private void action_res_0(S_LOCALES_LACTION x_3, S_INSTS_LACTION x_6, S_EXCEPTION_LACTION x_7) throws Exception {
try {
// instructions
glob_0_offset=(this.att_scanner).getOffset();
(this.att_avis).resetIndent();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#res","LACTION -> #res LOCALES t_do #inc INSTS EXCEPTION t_end #gen ;"});
}
  }
private void action_gen_0(S_LOCALES_LACTION x_3, S_INSTS_LACTION x_6, S_EXCEPTION_LACTION x_7) throws Exception {
try {
// instructions
String loc_c;
this.att_code=(((x_3.att_code+(this.att_avis).insts())+x_6.att_code)+x_7.att_code);
(this.att_avis).decIndent();
glob_0_length=(((this.att_scanner).getOffset()+(this.att_scanner).getLength())-glob_0_offset);
this.att_offset=glob_0_offset;
this.att_length=glob_0_length;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","LACTION -> #res LOCALES t_do #inc INSTS EXCEPTION t_end #gen ;"});
}
  }
private void action_inc_0(S_LOCALES_LACTION x_3, S_INSTS_LACTION x_6, S_EXCEPTION_LACTION x_7) throws Exception {
try {
// instructions
(this.att_avis).incIndent();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#inc","LACTION -> #res LOCALES t_do #inc INSTS EXCEPTION t_end #gen ;"});
}
  }
private void action_auto_inh_0(S_LOCALES_LACTION x_3, S_INSTS_LACTION x_6, S_EXCEPTION_LACTION x_7) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_7.att_table=this.att_table;
x_3.att_avis=this.att_avis;
x_6.att_avis=this.att_avis;
x_7.att_avis=this.att_avis;
x_3.att_act=this.att_act;
x_6.att_act=this.att_act;
x_7.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","LACTION -> #res LOCALES t_do #inc INSTS EXCEPTION t_end #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_local : // 43
        regle0 () ;
      break ;
      case LEX_LACTION.token_t_do : // 42
        regle0 () ;
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
