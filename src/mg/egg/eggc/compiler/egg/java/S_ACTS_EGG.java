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
public class S_ACTS_EGG implements IDstNode {
LEX_EGG scanner;
  S_ACTS_EGG() {
	}
  S_ACTS_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  REGLE att_reg;
  boolean att_eval;
  TDS att_table;
  LEX_EGG att_scanner;
  IVisiteurEgg att_vis;
  ActREGLE glob_45_a;
  private void regle46() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_regle_46();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
  private void regle45() throws Exception {

	//declaration
	S_GLOBALES_EGG x_2 = new S_GLOBALES_EGG(scanner,att_eval) ;
	T_EGG x_3 = new T_EGG(scanner ) ;
	T_EGG x_4 = new T_EGG(scanner ) ;
	LACTION x_6 = new LACTION(scanner.getReporter(), scanner.contexte);
	T_EGG x_7 = new T_EGG(scanner ) ;
	S_ACTS_EGG x_9 = new S_ACTS_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_45(x_2, x_3, x_6, x_9);
	x_2.analyser() ;
	  addChild(x_2);
	x_3.analyser(LEX_EGG.token_t_action);
	  addChild(x_3);
	x_4.analyser(LEX_EGG.token_t_aco);
	  addChild(x_4);
if  (att_eval)	  action_trans_45(x_2, x_3, x_6, x_9);
	x_6.scanner.setSource(scanner) ;
	x_6.set_eval(true) ;
	x_6.compile() ;
	  scanner.setSource(x_6.scanner) ;
	  addChild(x_6.getAxiom());
	x_7.analyser(LEX_EGG.token_t_acf);
	  addChild(x_7);
if  (att_eval)	  action_add_45(x_2, x_3, x_6, x_9);
	x_9.analyser() ;
	  addChild(x_9);
	 offset =x_2.getOffset();
	 length =x_9.getOffset() + x_9.getLength() - offset;
  }
private void action_regle_46() throws Exception {
try {
// instructions
TDS_ACTION loc_t;
String loc_atts;
LACT loc_lact;
ActREGLE loc_a;
LACTION loc_l;
LEX_CONTEXTE loc_lc;
LEX_LACTION loc_s;
String loc_acts;
if (((this.att_table).getAutoAtt()==true)){
loc_a=(this.att_reg).action("#auto_inh");
if ((loc_a!=null)){
loc_lact= new LACT((this.att_reg).getTable(), (loc_a).getPos());
(this.att_reg).autos(loc_lact);
if (((loc_a).getCodeSrc()!=null)){
loc_lc= new LEX_CONTEXTE((loc_a).getCodeSrc());
loc_l= new LACTION((this.att_scanner).getReporter(), loc_lc);
(loc_l).set_act(loc_lact);
(loc_l).set_table(this.att_table);
(loc_l).set_avis((this.att_vis).getVisAction());
loc_s=(loc_l).get_scanner();
(loc_s).setReader(loc_s);
(loc_l).set_eval(true);
(loc_l).compile();
(loc_a).setCode((loc_l).get_code());
(this.att_vis).nt_action(loc_a);
}

}

}

(this.att_vis).nt_regle(this.att_reg);
if (((this.att_table).syntaxOnly()!=true)){
loc_t=(this.att_reg).getTable();
loc_atts=(loc_t).verifier_initialisations();
if ((loc_atts!=null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_attributes_non_initialized, EGGMessages.EGG_attributes_non_initialized,new Object[]{""+loc_atts, ""+(this.att_reg).toStringSyntaxAction()});

}

loc_acts=(this.att_reg).verifierActions();
if ((loc_acts!=null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_undefined_actions, EGGMessages.EGG_undefined_actions,new Object[]{""+loc_acts, ""+(this.att_reg).toStringSyntaxAction()});

}

}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#regle","ACTS -> #regle ;"});
}
  }
private void action_add_45(S_GLOBALES_EGG x_2, T_EGG x_3, LACTION x_6, S_ACTS_EGG x_9) throws Exception {
try {
// instructions
if ((glob_45_a!=null)){
(glob_45_a).setCodeSrc(this.att_table, x_6.att_offset, x_6.att_length);
(glob_45_a).setCode(x_6.att_code);
(this.att_vis).nt_action(glob_45_a);
}
else {
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#add","ACTS -> GLOBALES t_action t_aco #trans LACTION t_acf #add ACTS1 ;"});
}
  }
private void action_trans_45(S_GLOBALES_EGG x_2, T_EGG x_3, LACTION x_6, S_ACTS_EGG x_9) throws Exception {
try {
// instructions
String loc_c;
LACT loc_lact;
glob_45_a=(this.att_reg).action(x_3.att_txt);
if ((glob_45_a!=null)){
loc_c=(glob_45_a).getCode();
if ((loc_c!=null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_action_yet_declared, EGGMessages.EGG_action_yet_declared,new Object[]{""+x_3.att_txt});

}
else {
loc_lact= new LACT((this.att_reg).getTable(), (glob_45_a).getPos());
x_6.att_act=loc_lact;
x_6.att_table=this.att_table;
x_6.att_avis=(this.att_vis).getVisAction();
}
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_action_useless, EGGMessages.EGG_action_useless,new Object[]{""+x_3.att_txt, ""+(this.att_reg).toStringSyntaxAction()});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#trans","ACTS -> GLOBALES t_action t_aco #trans LACTION t_acf #add ACTS1 ;"});
}
  }
private void action_auto_inh_45(S_GLOBALES_EGG x_2, T_EGG x_3, LACTION x_6, S_ACTS_EGG x_9) throws Exception {
try {
// instructions
x_2.att_table=this.att_table;
x_9.att_table=this.att_table;
x_2.att_reg=this.att_reg;
x_6.att_reg=this.att_reg;
x_9.att_reg=this.att_reg;
x_2.att_vis=this.att_vis;
x_9.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","ACTS -> GLOBALES t_action t_aco #trans LACTION t_acf #add ACTS1 ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_global : // 54
        regle45 () ;
      break ;
      case LEX_EGG.token_t_action : // 60
        regle45 () ;
      break ;
      case LEX_EGG.token_t_ident : // 61
        regle46 () ;
      break ;
      case LEX_EGG.token_t_end : // 53
        regle46 () ;
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
