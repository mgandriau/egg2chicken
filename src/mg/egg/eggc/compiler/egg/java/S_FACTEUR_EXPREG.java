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
public class S_FACTEUR_EXPREG implements IDstNode {
LEX_EXPREG scanner;
  S_FACTEUR_EXPREG() {
	}
  S_FACTEUR_EXPREG(LEX_EXPREG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  String att_code;
  TDS att_table;
  LEX_EXPREG att_scanner;
  IVisiteurEgg att_vis;
  private void regle10() throws Exception {

	//declaration
	T_EXPREG x_2 = new T_EXPREG(scanner ) ;
	//appel
	x_2.analyser(LEX_EXPREG.token_point);
	  addChild(x_2);
if  (att_eval)	  action_gen_10();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle12() throws Exception {

	//declaration
	T_EXPREG x_2 = new T_EXPREG(scanner ) ;
	S_ELT_EXPREG x_3 = new S_ELT_EXPREG(scanner,att_eval) ;
	S_ELTS_EXPREG x_4 = new S_ELTS_EXPREG(scanner,att_eval) ;
	T_EXPREG x_5 = new T_EXPREG(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_12(x_3, x_4);
	x_2.analyser(LEX_EXPREG.token_croco);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser() ;
	  addChild(x_4);
	x_5.analyser(LEX_EXPREG.token_crocf);
	  addChild(x_5);
if  (att_eval)	  action_gen_12(x_3, x_4);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle11() throws Exception {

	//declaration
	T_EXPREG x_2 = new T_EXPREG(scanner ) ;
	//appel
	x_2.analyser(LEX_EXPREG.token_car);
	  addChild(x_2);
if  (att_eval)	  action_gen_11(x_2);
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle14() throws Exception {

	//declaration
	T_EXPREG x_2 = new T_EXPREG(scanner ) ;
	S_REG_EXPREG x_3 = new S_REG_EXPREG(scanner,att_eval) ;
	T_EXPREG x_4 = new T_EXPREG(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_14(x_3);
	x_2.analyser(LEX_EXPREG.token_paro);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser(LEX_EXPREG.token_parf);
	  addChild(x_4);
if  (att_eval)	  action_gen_14(x_3);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle13() throws Exception {

	//declaration
	T_EXPREG x_2 = new T_EXPREG(scanner ) ;
	S_ELT_EXPREG x_3 = new S_ELT_EXPREG(scanner,att_eval) ;
	S_ELTS_EXPREG x_4 = new S_ELTS_EXPREG(scanner,att_eval) ;
	T_EXPREG x_5 = new T_EXPREG(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_13(x_3, x_4);
	x_2.analyser(LEX_EXPREG.token_neg);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser() ;
	  addChild(x_4);
	x_5.analyser(LEX_EXPREG.token_crocf);
	  addChild(x_5);
if  (att_eval)	  action_gen_13(x_3, x_4);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle15() throws Exception {

	//declaration
	T_EXPREG x_2 = new T_EXPREG(scanner ) ;
	//appel
	x_2.analyser(LEX_EXPREG.token_t_def);
	  addChild(x_2);
if  (att_eval)	  action_gen_15(x_2);
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
private void action_gen_14(S_REG_EXPREG x_3) throws Exception {
try {
// instructions
this.att_code=(("("+x_3.att_code)+")");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#gen","FACTEUR -> paro REG parf #gen ;"});
}
  }
private void action_gen_15(T_EXPREG x_2) throws Exception {
try {
// instructions
String loc_m;
String loc_er;
TDS loc_table;
SYMBOLE loc_s;
TERMINAL loc_t;
loc_er="";
loc_m=(x_2.att_txt).substring(1, ((x_2.att_txt).length()-1));
loc_table=this.att_table;
loc_s=(loc_table).chercher(loc_m);
if ((loc_s==null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEXPREGMessages.id_EXPREG_symbol_unknown, EXPREGMessages.EXPREG_symbol_unknown,new Object[]{""+loc_m});

}
else {
if (loc_s instanceof TERMINAL ){
loc_t=((TERMINAL)loc_s);
if (((((TERMINAL)loc_s)).get_type()==4)){
loc_er=(((TERMINAL)loc_s)).get_expreg();
}
else {
loc_er="";
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEXPREGMessages.id_EXPREG_not_a_macro, EXPREGMessages.EXPREG_not_a_macro,new Object[]{""+(((TERMINAL)loc_s)).getNom()});

}
}
else {
loc_er="";
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEXPREGMessages.id_EXPREG_not_a_macro, EXPREGMessages.EXPREG_not_a_macro,new Object[]{""+(loc_s).getNom()});


}
}
this.att_code=loc_er;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#gen","FACTEUR -> t_def #gen ;"});
}
  }
private void action_gen_12(S_ELT_EXPREG x_3, S_ELTS_EXPREG x_4) throws Exception {
try {
// instructions
this.att_code=((("["+x_3.att_code)+x_4.att_code)+"]");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#gen","FACTEUR -> croco ELT ELTS crocf #gen ;"});
}
  }
private void action_gen_13(S_ELT_EXPREG x_3, S_ELTS_EXPREG x_4) throws Exception {
try {
// instructions
this.att_code=((("[^"+x_3.att_code)+x_4.att_code)+"]");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#gen","FACTEUR -> neg ELT ELTS crocf #gen ;"});
}
  }
private void action_gen_11(T_EXPREG x_2) throws Exception {
try {
// instructions
this.att_code=(this.att_vis).car(x_2.att_txt);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#gen","FACTEUR -> car #gen ;"});
}
  }
private void action_gen_10() throws Exception {
try {
// instructions
this.att_code=".";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#gen","FACTEUR -> point #gen ;"});
}
  }
private void action_auto_inh_12(S_ELT_EXPREG x_3, S_ELTS_EXPREG x_4) throws Exception {
try {
// instructions
x_3.att_vis=this.att_vis;
x_4.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#auto_inh","FACTEUR -> croco ELT ELTS crocf #gen ;"});
}
  }
private void action_auto_inh_13(S_ELT_EXPREG x_3, S_ELTS_EXPREG x_4) throws Exception {
try {
// instructions
x_3.att_vis=this.att_vis;
x_4.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#auto_inh","FACTEUR -> neg ELT ELTS crocf #gen ;"});
}
  }
private void action_auto_inh_14(S_REG_EXPREG x_3) throws Exception {
try {
// instructions
x_3.att_vis=this.att_vis;
x_3.att_table=this.att_table;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EXPREG", "#auto_inh","FACTEUR -> paro REG parf #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EXPREG.token_point : // 28
        regle10 () ;
      break ;
      case LEX_EXPREG.token_car : // 33
        regle11 () ;
      break ;
      case LEX_EXPREG.token_croco : // 13
        regle12 () ;
      break ;
      case LEX_EXPREG.token_neg : // 22
        regle13 () ;
      break ;
      case LEX_EXPREG.token_paro : // 15
        regle14 () ;
      break ;
      case LEX_EXPREG.token_t_def : // 34
        regle15 () ;
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
