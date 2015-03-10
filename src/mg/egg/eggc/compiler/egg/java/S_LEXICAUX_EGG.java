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
public class S_LEXICAUX_EGG implements IDstNode {
LEX_EGG scanner;
  S_LEXICAUX_EGG() {
	}
  S_LEXICAUX_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  TDS att_table;
  LEX_EGG att_scanner;
  IVisiteurEgg att_vis;
  private void regle26() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_gen_26();
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
  private void regle25() throws Exception {

	//declaration
	S_LEXICAL_EGG x_2 = new S_LEXICAL_EGG(scanner,att_eval) ;
	S_LEXICAUX_EGG x_4 = new S_LEXICAUX_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_25(x_2, x_4);
	x_2.analyser() ;
	  addChild(x_2);
if  (att_eval)	  action_add_25(x_2, x_4);
	x_4.analyser() ;
	  addChild(x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
private void action_add_25(S_LEXICAL_EGG x_2, S_LEXICAUX_EGG x_4) throws Exception {
try {
// instructions
if (!((this.att_table).inserer_lexical(x_2.att_ter))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_terminal_yet_declared, EGGMessages.EGG_terminal_yet_declared,new Object[]{""+(x_2.att_ter).getNom()});

}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#add","LEXICAUX -> LEXICAL #add LEXICAUX1 ;"});
}
  }
private void action_gen_26() throws Exception {
try {
// instructions
(this.att_vis).lexical();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","LEXICAUX -> #gen ;"});
}
  }
private void action_auto_inh_25(S_LEXICAL_EGG x_2, S_LEXICAUX_EGG x_4) throws Exception {
try {
// instructions
x_2.att_table=this.att_table;
x_4.att_table=this.att_table;
x_2.att_vis=this.att_vis;
x_4.att_vis=this.att_vis;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","LEXICAUX -> LEXICAL #add LEXICAUX1 ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_space : // 45
        regle25 () ;
      break ;
      case LEX_EGG.token_t_sugar : // 47
        regle25 () ;
      break ;
      case LEX_EGG.token_t_term : // 48
        regle25 () ;
      break ;
      case LEX_EGG.token_t_macro : // 50
        regle25 () ;
      break ;
      case LEX_EGG.token_t_comm : // 46
        regle25 () ;
      break ;
      case LEX_EGG.token_t_external : // 49
        regle26 () ;
      break ;
      case LEX_EGG.token_t_ident : // 61
        regle26 () ;
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
