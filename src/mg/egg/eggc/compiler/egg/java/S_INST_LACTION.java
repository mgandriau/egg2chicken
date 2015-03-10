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
public class S_INST_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_INST_LACTION() {
	}
  S_INST_LACTION(LEX_LACTION scanner, boolean eval) {
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
  private void regle35() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_VAR_LACTION x_3 = new S_VAR_LACTION(scanner,att_eval) ;
	S_WITH_LACTION x_5 = new S_WITH_LACTION(scanner,att_eval) ;
	S_WITHS_LACTION x_6 = new S_WITHS_LACTION(scanner,att_eval) ;
	T_LACTION x_7 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_35(x_3, x_5, x_6);
	x_2.analyser(LEX_LACTION.token_t_match);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
if  (att_eval)	  action_check_35(x_3, x_5, x_6);
	x_5.analyser() ;
	  addChild(x_5);
	x_6.analyser() ;
	  addChild(x_6);
	x_7.analyser(LEX_LACTION.token_t_end);
	  addChild(x_7);
if  (att_eval)	  action_gen_35(x_3, x_5, x_6);
	 offset =x_2.getOffset();
	 length =x_7.getOffset() + x_7.getLength() - offset;
  }
  private void regle26() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	T_LACTION x_3 = new T_LACTION(scanner ) ;
	T_LACTION x_4 = new T_LACTION(scanner ) ;
	S_EARGS_LACTION x_6 = new S_EARGS_LACTION(scanner,att_eval) ;
	T_LACTION x_7 = new T_LACTION(scanner ) ;
	T_LACTION x_8 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_26(x_4, x_6);
	x_2.analyser(LEX_LACTION.token_t_attention);
	  addChild(x_2);
	x_3.analyser(LEX_LACTION.token_t_paro);
	  addChild(x_3);
	x_4.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_4);
if  (att_eval)	  action_trans_26(x_4, x_6);
	x_6.analyser() ;
	  addChild(x_6);
	x_7.analyser(LEX_LACTION.token_t_parf);
	  addChild(x_7);
	x_8.analyser(LEX_LACTION.token_t_pointvirgule);
	  addChild(x_8);
if  (att_eval)	  action_gen_26(x_4, x_6);
	 offset =x_2.getOffset();
	 length =x_8.getOffset() + x_8.getLength() - offset;
  }
  private void regle24() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_EXPR_LACTION x_3 = new S_EXPR_LACTION(scanner,att_eval) ;
	T_LACTION x_4 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_24(x_3);
	x_2.analyser(LEX_LACTION.token_t_write);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser(LEX_LACTION.token_t_pointvirgule);
	  addChild(x_4);
if  (att_eval)	  action_gen_24(x_3);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle25() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	T_LACTION x_3 = new T_LACTION(scanner ) ;
	T_LACTION x_4 = new T_LACTION(scanner ) ;
	S_EARGS_LACTION x_6 = new S_EARGS_LACTION(scanner,att_eval) ;
	T_LACTION x_7 = new T_LACTION(scanner ) ;
	T_LACTION x_8 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_25(x_4, x_6);
	x_2.analyser(LEX_LACTION.token_t_error);
	  addChild(x_2);
	x_3.analyser(LEX_LACTION.token_t_paro);
	  addChild(x_3);
	x_4.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_4);
if  (att_eval)	  action_trans_25(x_4, x_6);
	x_6.analyser() ;
	  addChild(x_6);
	x_7.analyser(LEX_LACTION.token_t_parf);
	  addChild(x_7);
	x_8.analyser(LEX_LACTION.token_t_pointvirgule);
	  addChild(x_8);
if  (att_eval)	  action_gen_25(x_4, x_6);
	 offset =x_2.getOffset();
	 length =x_8.getOffset() + x_8.getLength() - offset;
  }
  private void regle29() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_EXPR_LACTION x_3 = new S_EXPR_LACTION(scanner,att_eval) ;
	T_LACTION x_4 = new T_LACTION(scanner ) ;
	S_INSTS_LACTION x_6 = new S_INSTS_LACTION(scanner,att_eval) ;
	S_ELSIF_LACTION x_8 = new S_ELSIF_LACTION(scanner,att_eval) ;
	T_LACTION x_9 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_29(x_3, x_6, x_8);
	x_2.analyser(LEX_LACTION.token_t_if);
	  addChild(x_2);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser(LEX_LACTION.token_t_then);
	  addChild(x_4);
if  (att_eval)	  action_inc_29(x_3, x_6, x_8);
	x_6.analyser() ;
	  addChild(x_6);
if  (att_eval)	  action_dec_29(x_3, x_6, x_8);
	x_8.analyser() ;
	  addChild(x_8);
	x_9.analyser(LEX_LACTION.token_t_end);
	  addChild(x_9);
if  (att_eval)	  action_gen_29(x_3, x_6, x_8);
	 offset =x_2.getOffset();
	 length =x_9.getOffset() + x_9.getLength() - offset;
  }
  private void regle19() throws Exception {

	//declaration
	S_VAR_LACTION x_2 = new S_VAR_LACTION(scanner,att_eval) ;
	S_INST2_LACTION x_4 = new S_INST2_LACTION(scanner,att_eval) ;
	T_LACTION x_5 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_19(x_2, x_4);
	x_2.analyser() ;
	  addChild(x_2);
if  (att_eval)	  action_trans_19(x_2, x_4);
	x_4.analyser() ;
	  addChild(x_4);
	x_5.analyser(LEX_LACTION.token_t_pointvirgule);
	  addChild(x_5);
if  (att_eval)	  action_gen_19(x_2, x_4);
	 offset =x_2.getOffset();
	 length =x_5.getOffset() + x_5.getLength() - offset;
  }
  private void regle22() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_VAR_LACTION x_4 = new S_VAR_LACTION(scanner,att_eval) ;
	T_LACTION x_6 = new T_LACTION(scanner ) ;
	T_LACTION x_7 = new T_LACTION(scanner ) ;
	T_LACTION x_8 = new T_LACTION(scanner ) ;
	S_ARGS_LACTION x_9 = new S_ARGS_LACTION(scanner,att_eval) ;
	T_LACTION x_10 = new T_LACTION(scanner ) ;
	T_LACTION x_11 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_22(x_4, x_7, x_9);
	x_2.analyser(LEX_LACTION.token_t_call);
	  addChild(x_2);
if  (att_eval)	  action_trans_22(x_4, x_7, x_9);
	x_4.analyser() ;
	  addChild(x_4);
if  (att_eval)	  action_check_22(x_4, x_7, x_9);
	x_6.analyser(LEX_LACTION.token_t_point);
	  addChild(x_6);
	x_7.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_7);
	x_8.analyser(LEX_LACTION.token_t_paro);
	  addChild(x_8);
	x_9.analyser() ;
	  addChild(x_9);
	x_10.analyser(LEX_LACTION.token_t_parf);
	  addChild(x_10);
	x_11.analyser(LEX_LACTION.token_t_pointvirgule);
	  addChild(x_11);
if  (att_eval)	  action_gen_22(x_4, x_7, x_9);
	 offset =x_2.getOffset();
	 length =x_11.getOffset() + x_11.getLength() - offset;
  }
  private void regle23() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_VAR_LACTION x_4 = new S_VAR_LACTION(scanner,att_eval) ;
	T_LACTION x_5 = new T_LACTION(scanner ) ;
	T_LACTION x_6 = new T_LACTION(scanner ) ;
	T_LACTION x_7 = new T_LACTION(scanner ) ;
	S_ARGS_LACTION x_8 = new S_ARGS_LACTION(scanner,att_eval) ;
	T_LACTION x_9 = new T_LACTION(scanner ) ;
	T_LACTION x_10 = new T_LACTION(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_23(x_4, x_6, x_8);
	x_2.analyser(LEX_LACTION.token_t_new);
	  addChild(x_2);
if  (att_eval)	  action_trans_23(x_4, x_6, x_8);
	x_4.analyser() ;
	  addChild(x_4);
	x_5.analyser(LEX_LACTION.token_t_point);
	  addChild(x_5);
	x_6.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_6);
	x_7.analyser(LEX_LACTION.token_t_paro);
	  addChild(x_7);
	x_8.analyser() ;
	  addChild(x_8);
	x_9.analyser(LEX_LACTION.token_t_parf);
	  addChild(x_9);
	x_10.analyser(LEX_LACTION.token_t_pointvirgule);
	  addChild(x_10);
if  (att_eval)	  action_gen_23(x_4, x_6, x_8);
	 offset =x_2.getOffset();
	 length =x_10.getOffset() + x_10.getLength() - offset;
  }
private void action_auto_inh_29(S_EXPR_LACTION x_3, S_INSTS_LACTION x_6, S_ELSIF_LACTION x_8) throws Exception {
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
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST -> t_if EXPR t_then #inc INSTS #dec ELSIF t_end #gen ;"});
}
  }
private void action_gen_19(S_VAR_LACTION x_2, S_INST2_LACTION x_4) throws Exception {
try {
// instructions
this.att_code=x_4.att_code;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST -> VAR #trans INST2 t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_26(T_LACTION x_4, S_EARGS_LACTION x_6) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_avis=this.att_avis;
x_6.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST -> t_attention t_paro t_ident #trans EARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_gen_35(S_VAR_LACTION x_3, S_WITH_LACTION x_5, S_WITHS_LACTION x_6) throws Exception {
try {
// instructions
this.att_code=(((this.att_avis).matchVarAvec(x_3.att_entree, x_5.att_type, x_5.att_code, x_6.att_code)+(this.att_avis).indent())+(this.att_avis).matchSi(x_3.att_entree, x_5.att_type, x_5.att_code, x_6.att_code));
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST -> t_match VAR #check WITH WITHS t_end #gen ;"});
}
  }
private void action_check_35(S_VAR_LACTION x_3, S_WITH_LACTION x_5, S_WITHS_LACTION x_6) throws Exception {
try {
// instructions
if (!((x_3.att_entree).getEtat())){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_var_non_initialized, LACTIONMessages.LACTION_var_non_initialized,new Object[]{""+(x_3.att_entree).getNom()});

}
else if (!((x_3.att_entree).utilisable((this.att_act).getPos()))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_var_illegal_access, LACTIONMessages.LACTION_var_illegal_access,new Object[]{""+(x_3.att_entree).getNom()});

}

x_5.att_hentree=x_3.att_entree;
x_6.att_hentree=x_3.att_entree;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#check","INST -> t_match VAR #check WITH WITHS t_end #gen ;"});
}
  }
private void action_trans_19(S_VAR_LACTION x_2, S_INST2_LACTION x_4) throws Exception {
try {
// instructions
x_4.att_hentree=x_2.att_entree;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","INST -> VAR #trans INST2 t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_24(S_EXPR_LACTION x_3) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_3.att_avis=this.att_avis;
x_3.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST -> t_write EXPR t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_25(T_LACTION x_4, S_EARGS_LACTION x_6) throws Exception {
try {
// instructions
x_6.att_table=this.att_table;
x_6.att_avis=this.att_avis;
x_6.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST -> t_error t_paro t_ident #trans EARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_22(S_VAR_LACTION x_4, T_LACTION x_7, S_ARGS_LACTION x_9) throws Exception {
try {
// instructions
x_4.att_table=this.att_table;
x_9.att_table=this.att_table;
x_9.att_avis=this.att_avis;
x_4.att_act=this.att_act;
x_9.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST -> t_call #trans VAR #check t_point t_ident t_paro ARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_23(S_VAR_LACTION x_4, T_LACTION x_6, S_ARGS_LACTION x_8) throws Exception {
try {
// instructions
x_4.att_table=this.att_table;
x_8.att_table=this.att_table;
x_8.att_avis=this.att_avis;
x_4.att_act=this.att_act;
x_8.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST -> t_new #trans VAR t_point t_ident t_paro ARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_19(S_VAR_LACTION x_2, S_INST2_LACTION x_4) throws Exception {
try {
// instructions
x_2.att_table=this.att_table;
x_4.att_table=this.att_table;
x_4.att_avis=this.att_avis;
x_2.att_act=this.att_act;
x_4.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST -> VAR #trans INST2 t_pointvirgule #gen ;"});
}
  }
private void action_gen_24(S_EXPR_LACTION x_3) throws Exception {
try {
// instructions
this.att_code=(this.att_avis).ecrire(x_3.att_code);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST -> t_write EXPR t_pointvirgule #gen ;"});
}
  }
private void action_gen_23(S_VAR_LACTION x_4, T_LACTION x_6, S_ARGS_LACTION x_8) throws Exception {
try {
// instructions
Resolveur loc_r;
if (!((x_4.att_entree).affectable((this.att_act).getPos()))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_var_illegal_access, LACTIONMessages.LACTION_var_illegal_access,new Object[]{""+(x_4.att_entree).getNom()});

}
else {
(x_4.att_entree).setEtat(true);
this.att_code=(this.att_avis).nouveau(x_4.att_entree, x_8.att_args);
loc_r=(this.att_act).getResolveur();
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST -> t_new #trans VAR t_point t_ident t_paro ARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_gen_26(T_LACTION x_4, S_EARGS_LACTION x_6) throws Exception {
try {
// instructions
Resolveur loc_r;
(this.att_table).addProperty(x_4.att_txt, (x_6.att_args).size());
this.att_code=(this.att_avis).signaler(x_4.att_txt, x_6.att_args);
loc_r=(this.att_act).getResolveur();
(loc_r).contErr(x_6.att_types);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST -> t_attention t_paro t_ident #trans EARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_gen_25(T_LACTION x_4, S_EARGS_LACTION x_6) throws Exception {
try {
// instructions
Resolveur loc_r;
(this.att_table).addProperty(x_4.att_txt, (x_6.att_args).size());
this.att_code=(this.att_avis).fatal(x_4.att_txt, x_6.att_args);
loc_r=(this.att_act).getResolveur();
(loc_r).contErr(x_6.att_types);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST -> t_error t_paro t_ident #trans EARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_dec_29(S_EXPR_LACTION x_3, S_INSTS_LACTION x_6, S_ELSIF_LACTION x_8) throws Exception {
try {
// instructions
(this.att_avis).decIndent();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#dec","INST -> t_if EXPR t_then #inc INSTS #dec ELSIF t_end #gen ;"});
}
  }
private void action_gen_29(S_EXPR_LACTION x_3, S_INSTS_LACTION x_6, S_ELSIF_LACTION x_8) throws Exception {
try {
// instructions
String loc_a;
String loc_b;
loc_a=x_6.att_code;
loc_b=x_8.att_code;
this.att_code=(this.att_avis).ifExpr(x_3.att_code, loc_a, loc_b);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST -> t_if EXPR t_then #inc INSTS #dec ELSIF t_end #gen ;"});
}
  }
private void action_trans_22(S_VAR_LACTION x_4, T_LACTION x_7, S_ARGS_LACTION x_9) throws Exception {
try {
// instructions
Vector loc_a;
Vector loc_ts;
loc_a= new Vector();
x_9.att_hargs=loc_a;
loc_ts= new Vector();
x_9.att_htypes=loc_ts;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","INST -> t_call #trans VAR #check t_point t_ident t_paro ARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_gen_22(S_VAR_LACTION x_4, T_LACTION x_7, S_ARGS_LACTION x_9) throws Exception {
try {
// instructions
Resolveur loc_r;
(x_4.att_entree).setEtat(true);
loc_r=(this.att_act).getResolveur();
this.att_code=(this.att_avis).appel(x_4.att_entree, x_7.att_txt, x_9.att_args);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","INST -> t_call #trans VAR #check t_point t_ident t_paro ARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_inc_29(S_EXPR_LACTION x_3, S_INSTS_LACTION x_6, S_ELSIF_LACTION x_8) throws Exception {
try {
// instructions
(this.att_avis).incIndent();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#inc","INST -> t_if EXPR t_then #inc INSTS #dec ELSIF t_end #gen ;"});
}
  }
private void action_check_22(S_VAR_LACTION x_4, T_LACTION x_7, S_ARGS_LACTION x_9) throws Exception {
try {
// instructions
if (!((x_4.att_entree).getEtat())){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_var_non_initialized, LACTIONMessages.LACTION_var_non_initialized,new Object[]{""+(x_4.att_entree).getNom()});

}
else if (!((x_4.att_entree).utilisable((this.att_act).getPos()))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_var_illegal_access, LACTIONMessages.LACTION_var_illegal_access,new Object[]{""+(x_4.att_entree).getNom()});

}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#check","INST -> t_call #trans VAR #check t_point t_ident t_paro ARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_auto_inh_35(S_VAR_LACTION x_3, S_WITH_LACTION x_5, S_WITHS_LACTION x_6) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_5.att_table=this.att_table;
x_6.att_table=this.att_table;
x_5.att_avis=this.att_avis;
x_6.att_avis=this.att_avis;
x_3.att_act=this.att_act;
x_5.att_act=this.att_act;
x_6.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","INST -> t_match VAR #check WITH WITHS t_end #gen ;"});
}
  }
private void action_trans_26(T_LACTION x_4, S_EARGS_LACTION x_6) throws Exception {
try {
// instructions
Vector loc_a;
Vector loc_ts;
loc_a= new Vector();
x_6.att_hargs=loc_a;
loc_ts= new Vector();
x_6.att_htypes=loc_ts;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","INST -> t_attention t_paro t_ident #trans EARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_trans_25(T_LACTION x_4, S_EARGS_LACTION x_6) throws Exception {
try {
// instructions
Vector loc_a;
Vector loc_ts;
loc_a= new Vector();
x_6.att_hargs=loc_a;
loc_ts= new Vector();
x_6.att_htypes=loc_ts;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","INST -> t_error t_paro t_ident #trans EARGS t_parf t_pointvirgule #gen ;"});
}
  }
private void action_trans_23(S_VAR_LACTION x_4, T_LACTION x_6, S_ARGS_LACTION x_8) throws Exception {
try {
// instructions
Vector loc_a;
Vector loc_ts;
loc_a= new Vector();
x_8.att_hargs=loc_a;
loc_ts= new Vector();
x_8.att_htypes=loc_ts;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","INST -> t_new #trans VAR t_point t_ident t_paro ARGS t_parf t_pointvirgule #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_ident : // 92
        regle19 () ;
      break ;
      case LEX_LACTION.token_t_call : // 45
        regle22 () ;
      break ;
      case LEX_LACTION.token_t_new : // 50
        regle23 () ;
      break ;
      case LEX_LACTION.token_t_write : // 49
        regle24 () ;
      break ;
      case LEX_LACTION.token_t_error : // 47
        regle25 () ;
      break ;
      case LEX_LACTION.token_t_attention : // 48
        regle26 () ;
      break ;
      case LEX_LACTION.token_t_if : // 63
        regle29 () ;
      break ;
      case LEX_LACTION.token_t_match : // 66
        regle35 () ;
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
