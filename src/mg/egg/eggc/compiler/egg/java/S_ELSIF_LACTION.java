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
public class S_ELSIF_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_ELSIF_LACTION() {
	}
  S_ELSIF_LACTION(LEX_LACTION scanner, boolean eval) {
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
  LACT att_act;
  LEX_LACTION att_scanner;
  private void regle31() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_INSTS_LACTION x_4 = new S_INSTS_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_31(x_4);
	x_2.analyser(LEX_LACTION.token_t_else);
	  addChild(x_2);
if  (att_eval)	  action_inc_31(x_4);
	x_4.analyser() ;
	  addChild(x_4);
if  (att_eval)	  action_gen_31(x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle30() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_EXPR_LACTION x_3 = new S_EXPR_LACTION(scanner,att_eval) ;
	T_LACTION x_4 = new T_LACTION(scanner ) ;
	S_INSTS_LACTION x_6 = new S_INSTS_LACTION(scanner,att_eval) ;
	S_ELSIF_LACTION x_8 = new S_ELSIF_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_30(x_3, x_6, x_8);
	x_2.analyser(LEX_LACTION.token_t_elseif);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser(LEX_LACTION.token_t_then);
	  addChild(x_4);
if  (att_eval)	  action_inc_30(x_3, x_6, x_8);
	x_6.analyser() ;
	  addChild(x_6);
if  (att_eval)	  action_dec_30(x_3, x_6, x_8);
	x_8.analyser() ;
	  addChild(x_8);
if  (att_eval)	  action_gen_30(x_3, x_6, x_8);
	 offset =x_2.getOffset();
	 length =x_8.getOffset() + x_8.getLength() - offset;
  }
  private void regle32() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_32();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
private void action_gen_32() throws Exception {
try {
// instructions
this.att_code=((this.att_avis).indent()+(this.att_avis).ifFin());
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","ELSIF -> #gen ;"});
}
  }
private void action_dec_30(S_EXPR_LACTION x_3, S_INSTS_LACTION x_6, S_ELSIF_LACTION x_8) throws Exception {
try {
// instructions
(this.att_avis).decIndent();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#dec","ELSIF -> t_elseif EXPR t_then #inc INSTS #dec ELSIF1 #gen ;"});
}
  }
private void action_gen_30(S_EXPR_LACTION x_3, S_INSTS_LACTION x_6, S_ELSIF_LACTION x_8) throws Exception {
try {
// instructions
String loc_a;
String loc_b;
loc_a=x_6.att_code;
loc_b=x_8.att_code;
this.att_code=((this.att_avis).indent()+(this.att_avis).ifSinonSi(x_3.att_code, loc_a, loc_b));
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","ELSIF -> t_elseif EXPR t_then #inc INSTS #dec ELSIF1 #gen ;"});
}
  }
private void action_gen_31(S_INSTS_LACTION x_4) throws Exception {
try {
// instructions
String loc_a;
loc_a=x_4.att_code;
(this.att_avis).decIndent();
this.att_code=((((this.att_avis).indent()+(this.att_avis).ifSinon(loc_a))+(this.att_avis).indent())+(this.att_avis).ifFin());
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","ELSIF -> t_else #inc INSTS #gen ;"});
}
  }
private void action_auto_inh_30(S_EXPR_LACTION x_3, S_INSTS_LACTION x_6, S_ELSIF_LACTION x_8) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_6.att_table=this.att_table;
x_8.att_table=this.att_table;
x_3.att_avis=this.att_avis;
x_6.att_avis=this.att_avis;
x_8.att_avis=this.att_avis;
x_3.att_act=this.att_act;
x_6.att_act=this.att_act;
x_8.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","ELSIF -> t_elseif EXPR t_then #inc INSTS #dec ELSIF1 #gen ;"});
}
  }
private void action_auto_inh_31(S_INSTS_LACTION x_4) throws Exception {
try {
// instructions
x_4.att_table=this.att_table;
x_4.att_avis=this.att_avis;
x_4.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","ELSIF -> t_else #inc INSTS #gen ;"});
}
  }
private void action_inc_30(S_EXPR_LACTION x_3, S_INSTS_LACTION x_6, S_ELSIF_LACTION x_8) throws Exception {
try {
// instructions
(this.att_avis).incIndent();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#inc","ELSIF -> t_elseif EXPR t_then #inc INSTS #dec ELSIF1 #gen ;"});
}
  }
private void action_inc_31(S_INSTS_LACTION x_4) throws Exception {
try {
// instructions
(this.att_avis).incIndent();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#inc","ELSIF -> t_else #inc INSTS #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_elseif : // 64
        regle30 () ;
      break ;
      case LEX_LACTION.token_t_else : // 65
        regle31 () ;
      break ;
      case LEX_LACTION.token_t_end : // 44
        regle32 () ;
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
