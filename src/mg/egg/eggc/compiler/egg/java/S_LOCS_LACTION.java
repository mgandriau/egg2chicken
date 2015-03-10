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
public class S_LOCS_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_LOCS_LACTION() {
	}
  S_LOCS_LACTION(LEX_LACTION scanner, boolean eval) {
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
  LACT att_act;
  LEX_LACTION att_scanner;
  Resolveur glob_4_r;
  private void regle5() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_5();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
  private void regle4() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	S_VTYPE_LACTION x_4 = new S_VTYPE_LACTION(scanner,att_eval) ;
	T_LACTION x_5 = new T_LACTION(scanner ) ;
	S_LOCS_LACTION x_7 = new S_LOCS_LACTION(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_4(x_2, x_4, x_7);
	x_2.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_2);
if  (att_eval)	  action_trans_4(x_2, x_4, x_7);
	x_4.analyser() ;
	  addChild(x_4);
	x_5.analyser(LEX_LACTION.token_t_pointvirgule);
	  addChild(x_5);
if  (att_eval)	  action_add_4(x_2, x_4, x_7);
	x_7.analyser() ;
	  addChild(x_7);
if  (att_eval)	  action_gen_4(x_2, x_4, x_7);
	 offset =x_2.getOffset();
	 length =x_7.getOffset() + x_7.getLength() - offset;
  }
private void action_gen_5() throws Exception {
try {
// instructions
this.att_code="";
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","LOCS -> #gen ;"});
}
  }
private void action_add_4(T_LACTION x_2, S_VTYPE_LACTION x_4, S_LOCS_LACTION x_7) throws Exception {
try {
// instructions
VAR loc_v;
TDS_ACTION loc_l;
ENTREE loc_e;
BLOC loc_b;
loc_b=(this.att_act).getBloc();
loc_l=(loc_b).getLocs();
loc_e=(loc_l).chercher(x_2.att_txt);
if ((loc_e!=null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_local_yet_declared, LACTIONMessages.LACTION_local_yet_declared,new Object[]{""+x_2.att_txt});

}
else {
loc_v= new VAR(x_2.att_txt, x_4.att_type);
(loc_l).ajouter_locale(loc_v);
(glob_4_r).contDecl(loc_v);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#add","LOCS -> t_ident #trans VTYPE t_pointvirgule #add LOCS1 #gen ;"});
}
  }
private void action_auto_inh_4(T_LACTION x_2, S_VTYPE_LACTION x_4, S_LOCS_LACTION x_7) throws Exception {
try {
// instructions
x_7.att_avis=this.att_avis;
x_7.att_act=this.att_act;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#auto_inh","LOCS -> t_ident #trans VTYPE t_pointvirgule #add LOCS1 #gen ;"});
}
  }
private void action_gen_4(T_LACTION x_2, S_VTYPE_LACTION x_4, S_LOCS_LACTION x_7) throws Exception {
try {
// instructions
TDS_ACTION loc_l;
ENTREE loc_e;
BLOC loc_b;
loc_b=(this.att_act).getBloc();
loc_l=(loc_b).getLocs();
loc_e=(loc_l).chercher(x_2.att_txt);
this.att_code=((((this.att_avis).indent()+(this.att_avis).decl(loc_e))+"\n")+x_7.att_code);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","LOCS -> t_ident #trans VTYPE t_pointvirgule #add LOCS1 #gen ;"});
}
  }
private void action_trans_4(T_LACTION x_2, S_VTYPE_LACTION x_4, S_LOCS_LACTION x_7) throws Exception {
try {
// instructions
glob_4_r=(this.att_act).getResolveur();
x_4.att_res=glob_4_r;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#trans","LOCS -> t_ident #trans VTYPE t_pointvirgule #add LOCS1 #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_ident : // 92
        regle4 () ;
      break ;
      case LEX_LACTION.token_t_do : // 42
        regle5 () ;
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
