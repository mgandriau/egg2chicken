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
public class S_VAR_LACTION implements IDstNode {
LEX_LACTION scanner;
  S_VAR_LACTION() {
	}
  S_VAR_LACTION(LEX_LACTION scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  TDS att_table;
  ENTREE att_entree;
  LACT att_act;
  LEX_LACTION att_scanner;
  private void regle34() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	T_LACTION x_3 = new T_LACTION(scanner ) ;
	T_LACTION x_4 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_2);
	x_3.analyser(LEX_LACTION.token_t_chapeau);
	  addChild(x_3);
	x_4.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_4);
if  (att_eval)	  action_gen_34(x_2, x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
  private void regle33() throws Exception {

	//declaration
	T_LACTION x_2 = new T_LACTION(scanner ) ;
	//appel
	x_2.analyser(LEX_LACTION.token_t_ident);
	  addChild(x_2);
if  (att_eval)	  action_gen_33(x_2);
	 offset =x_2.getOffset();
	 length =x_2.getOffset() + x_2.getLength() - offset;
  }
private void action_gen_33(T_LACTION x_2) throws Exception {
try {
// instructions
TDS_ACTION loc_l;
ENTREE loc_e;
BLOC loc_b;
Resolveur loc_r;
loc_b=(this.att_act).getBloc();
loc_l=(loc_b).getLocs();
loc_e=(loc_l).chercher(x_2.att_txt);
if ((loc_e==null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_not_a_var, LACTIONMessages.LACTION_not_a_var,new Object[]{""+x_2.att_txt});

}
else {
this.att_entree=loc_e;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","VAR -> t_ident #gen ;"});
}
  }
private void action_gen_34(T_LACTION x_2, T_LACTION x_4) throws Exception {
try {
// instructions
TDS_ACTION loc_l;
ENTREE loc_e;
String loc_s;
BLOC loc_b;
SYMBOLE loc_symb;
Resolveur loc_r;
loc_b=(this.att_act).getBloc();
loc_l=(loc_b).getLocs();
loc_s=((x_2.att_txt+"^")+x_4.att_txt);
loc_e=(loc_l).chercher(loc_s);
if ((loc_e==null)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ILACTIONMessages.id_LACTION_not_an_attribute, LACTIONMessages.LACTION_not_an_attribute,new Object[]{""+x_4.att_txt, ""+x_2.att_txt});

}
else {
this.att_entree=loc_e;
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "LACTION", "#gen","VAR -> t_ident t_chapeau t_ident1 #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_LACTION.token_t_ident : // 92
        scanner.lit ( 2 ) ;
        switch ( scanner.fenetre[1].code ) {
          case LEX_LACTION.token_t_affectation : // 36
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_point : // 31
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_with : // 67
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_et : // 59
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_mult : // 53
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_div : // 54
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_d_mult : // 57
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_d_div : // 58
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_egal : // 70
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_different : // 71
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_append : // 62
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_plus : // 51
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_moins : // 52
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_d_plus : // 55
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_d_moins : // 56
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_ou : // 60
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_virgule : // 33
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_then : // 68
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_pointvirgule : // 34
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_parf : // 40
            regle33 () ;
          break ;
          case LEX_LACTION.token_t_chapeau : // 32
            regle34 () ;
          break ;
          default :
            	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ILACTIONMessages.id_LACTION_unexpected_token,LACTIONMessages.LACTION_unexpected_token,new String[]{scanner.fenetre[1].getNom()});
scanner.accepter_sucre(LEX_LACTION.token_t_ident);
        }
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
