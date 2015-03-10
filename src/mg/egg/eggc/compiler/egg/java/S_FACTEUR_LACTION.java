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
public class S_FACTEUR_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_FACTEUR_LACTION() {
	}
  S_FACTEUR_LACTION(LEX_LACTION scanner, boolean eval) {
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
  Resolveur glob_66_r;
  private void regle57() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_flottant);
	  addChild(x_2);
if  (att_eval)	  action_gen_57(x_2);
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle58() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_car);
	  addChild(x_2);
if  (att_eval)	  action_gen_58(x_2);
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle59() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_chaine);
	  addChild(x_2);
if  (att_eval)	  action_gen_59(x_2);
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle66() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_TYPE_LACTION x_4 = new S_TYPE_LACTION(scanner,att_eval) ;
	T_LACTION x_5 = new T_LACTION(scanner ) ;
	S_ARGS_LACTION x_6 = new S_ARGS_LACTION(scanner,att_eval) ;
	T_LACTION x_7 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_66(x_4, x_6);
	x_2.analyser(LEX_LACTION.token_t_new);
	  addChild(x_2);
if  (att_eval)	  action_trans_66(x_4, x_6);
	x_4.analyser() ;
	  addChild(x_4);
	x_5.analyser(LEX_LACTION.token_t_paro);
	  addChild(x_5);
	x_6.analyser() ;
	  addChild(x_6);
	x_7.analyser(LEX_LACTION.token_t_parf);
	  addChild(x_7);
if  (att_eval)	  action_gen_66(x_4, x_6);
	 offset =x_2.getOffset();
	 length =x_7.getOffset() + x_7.getLength() - offset;
  }
  private void regle53() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_true);
	  addChild(x_2);
if  (att_eval)	  action_gen_53();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle54() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_false);
	  addChild(x_2);
if  (att_eval)	  action_gen_54();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle64() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_FACTEUR_LACTION x_3 = new S_FACTEUR_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_64(x_3);
	x_2.analyser(LEX_LACTION.token_t_not);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
if  (att_eval)	  action_gen_64(x_3);
	 offset =x_2.getOffset();
	 length =x_3.getOffset() + x_3.getLength() - offset;
  }
  private void regle55() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_entier);
	  addChild(x_2);
if  (att_eval)	  action_gen_55(x_2);
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
  private void regle65() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_EXPR_LACTION x_3 = new S_EXPR_LACTION(scanner,att_eval) ;
	T_LACTION x_4 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_65(x_3);
	x_2.analyser(LEX_LACTION.token_t_paro);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser(LEX_LACTION.token_t_parf);
	  addChild(x_4);
if  (att_eval)	  action_gen_65(x_3);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle56() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_FACTEUR_LACTION x_3 = new S_FACTEUR_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_56(x_3);
	x_2.analyser(LEX_LACTION.token_t_moins);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
if  (att_eval)	  action_gen_56(x_3);
	 offset =x_2.getOffset();
	 length =x_3.getOffset() + x_3.getLength() - offset;
  }
  private void regle60() throws Exception {

	//declaration
	S_VAR_LACTION x_2 = new S_VAR_LACTION(scanner,att_eval) ;
	S_APP_LACTION x_4 = new S_APP_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_60(x_2, x_4);
	x_2.analyser() ;
	  addChild(x_2);
if  (att_eval)	  action_check_60(x_2, x_4);
	x_4.analyser() ;
	  addChild(x_4);
if  (att_eval)	  action_gen_60(x_2, x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle52() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_nil);
	  addChild(x_2);
if  (att_eval)	  action_gen_52();
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
private void action_auto_inh_65(S_EXPR_LACTION x_3) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_3.att_avis=this.att_avis;
x_3.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","FACTEUR -> t_paro EXPR t_parf #gen ;"});
}
  }
private void action_auto_inh_64(S_FACTEUR_LACTION x_3) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_3.att_avis=this.att_avis;
x_3.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","FACTEUR -> t_not FACTEUR1 #gen ;"});
}
  }
private void action_auto_inh_66(S_TYPE_LACTION x_4, S_ARGS_LACTION x_6) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_avis=this.att_avis;
x_6.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","FACTEUR -> t_new #trans TYPE t_paro ARGS t_parf #gen ;"});
}
  }
private void action_auto_inh_56(S_FACTEUR_LACTION x_3) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_3.att_avis=this.att_avis;
x_3.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","FACTEUR -> t_moins FACTEUR1 #gen ;"});
}
  }
private void action_check_60(S_VAR_LACTION x_2, S_APP_LACTION x_4) throws Exception {
try {
// instructions
if (!((x_2.att_entree).getEtat())){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_var_non_initialized, LACTIONMessages.LACTION_var_non_initialized,new Object[]{""+(x_2.att_entree).getNom()});

}
else if (!((x_2.att_entree).utilisable((this.att_act).getPos()))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_var_illegal_access, LACTIONMessages.LACTION_var_illegal_access,new Object[]{""+(x_2.att_entree).getNom()});

}
else {
x_4.att_hentree=x_2.att_entree;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#check","FACTEUR -> VAR #check APP #gen ;"});
}
  }
private void action_gen_66(S_TYPE_LACTION x_4, S_ARGS_LACTION x_6) throws Exception {
try {
// instructions
this.att_code=(this.att_avis).nouveau(x_4.att_type, x_6.att_args);
this.att_type=(glob_66_r).contConst(x_4.att_type, x_6.att_types);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_new #trans TYPE t_paro ARGS t_parf #gen ;"});
}
  }
private void action_gen_65(S_EXPR_LACTION x_3) throws Exception {
try {
// instructions
this.att_type=x_3.att_type;
this.att_code=(("("+x_3.att_code)+")");
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_paro EXPR t_parf #gen ;"});
}
  }
private void action_gen_64(S_FACTEUR_LACTION x_3) throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=(loc_r).contOpNon(x_3.att_type);
this.att_code=(this.att_avis).non(x_3.att_code);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_not FACTEUR1 #gen ;"});
}
  }
private void action_gen_59(T_LACTION x_2) throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=(loc_r).getType("STRING");
this.att_code=(this.att_avis).chaine(x_2.att_txt);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_chaine #gen ;"});
}
  }
private void action_gen_58(T_LACTION x_2) throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=(loc_r).getType("CHARACTER");
this.att_code=(this.att_avis).car(x_2.att_txt);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_car #gen ;"});
}
  }
private void action_gen_57(T_LACTION x_2) throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=(loc_r).getType("DOUBLE");
this.att_code=(this.att_avis).reel(x_2.att_txt);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_flottant #gen ;"});
}
  }
private void action_gen_60(S_VAR_LACTION x_2, S_APP_LACTION x_4) throws Exception {
try {
// instructions
this.att_code=x_4.att_code;
this.att_type=x_4.att_type;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> VAR #check APP #gen ;"});
}
  }
private void action_gen_56(S_FACTEUR_LACTION x_3) throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=(loc_r).getType("INTEGER");
this.att_code=(this.att_avis).moins(x_3.att_code);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_moins FACTEUR1 #gen ;"});
}
  }
private void action_auto_inh_60(S_VAR_LACTION x_2, S_APP_LACTION x_4) throws Exception {
try {
// instructions
x_2.att_table=this.att_table;
x_4.att_table=this.att_table;
x_4.att_avis=this.att_avis;
x_2.att_act=this.att_act;
x_4.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","FACTEUR -> VAR #check APP #gen ;"});
}
  }
private void action_gen_54() throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=(loc_r).getType("BOOLEAN");
this.att_code=(this.att_avis).faux();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_false #gen ;"});
}
  }
private void action_gen_55(T_LACTION x_2) throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=(loc_r).getType("INTEGER");
this.att_code=(this.att_avis).entier(x_2.att_txt);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_entier #gen ;"});
}
  }
private void action_gen_52() throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=(loc_r).getType("VOID");
this.att_code=(this.att_avis).vide();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_nil #gen ;"});
}
  }
private void action_gen_53() throws Exception {
try {
// instructions
Resolveur loc_r;
loc_r=(this.att_act).getResolveur();
this.att_type=(loc_r).getType("BOOLEAN");
this.att_code=(this.att_avis).vrai();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","FACTEUR -> t_true #gen ;"});
}
  }
private void action_trans_66(S_TYPE_LACTION x_4, S_ARGS_LACTION x_6) throws Exception {
try {
// instructions
Vector loc_a;
Vector loc_ts;
glob_66_r=(this.att_act).getResolveur();
x_4.att_res=glob_66_r;
loc_a= new Vector();
x_6.att_hargs=loc_a;
loc_ts= new Vector();
x_6.att_htypes=loc_ts;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","FACTEUR -> t_new #trans TYPE t_paro ARGS t_parf #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_nil : // 72
        regle52 () ;
      break ;
      case LEX_LACTION.token_t_true : // 73
        regle53 () ;
      break ;
      case LEX_LACTION.token_t_false : // 74
        regle54 () ;
      break ;
      case LEX_LACTION.token_t_entier : // 82
        regle55 () ;
      break ;
      case LEX_LACTION.token_t_moins : // 52
        regle56 () ;
      break ;
      case LEX_LACTION.token_t_flottant : // 83
        regle57 () ;
      break ;
      case LEX_LACTION.token_t_car : // 91
        regle58 () ;
      break ;
      case LEX_LACTION.token_t_chaine : // 89
        regle59 () ;
      break ;
      case LEX_LACTION.token_t_ident : // 92
        regle60 () ;
      break ;
      case LEX_LACTION.token_t_not : // 61
        regle64 () ;
      break ;
      case LEX_LACTION.token_t_paro : // 39
        regle65 () ;
      break ;
      case LEX_LACTION.token_t_new : // 50
        regle66 () ;
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
