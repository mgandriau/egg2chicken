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
public class S_OPTIONS_EGG implements IDstNode {
LEX_EGG scanner;
  S_OPTIONS_EGG() {
	}
  S_OPTIONS_EGG(LEX_EGG scanner, boolean eval) {
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
  private void regle1() throws Exception {

	//declaration
	//appel
   length = 0; offset = scanner.getPreviousOffset()+ scanner.getPreviousLength();  }
  private void regle2() throws Exception {

	//declaration
	T_EGG x_2 = new T_EGG(scanner ) ;
	OPTION x_3 = new OPTION(scanner.getReporter(), scanner.contexte);
	S_OPTIONS_EGG x_4 = new S_OPTIONS_EGG(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_2(x_3, x_4);
	x_2.analyser(LEX_EGG.token_t_option);
	  addChild(x_2);
	x_3.scanner.setSource(scanner) ;
	x_3.set_eval(true) ;
	x_3.compile() ;
	  scanner.setSource(x_3.scanner) ;
	  addChild(x_3.getAxiom());
	x_4.analyser() ;
	  addChild(x_4);
	 offset =x_2.getOffset();
	 length =x_4.getOffset() + x_4.getLength() - offset;
  }
private void action_auto_inh_2(OPTION x_3, S_OPTIONS_EGG x_4) throws Exception {
try {
// instructions
x_3.att_table=this.att_table;
x_4.att_table=this.att_table;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#auto_inh","OPTIONS -> t_option OPTION OPTIONS1 ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_inh : // 30
        regle1 () ;
      break ;
      case LEX_EGG.token_t_syn : // 31
        regle1 () ;
      break ;
      case LEX_EGG.token_t_space : // 45
        regle1 () ;
      break ;
      case LEX_EGG.token_t_sugar : // 47
        regle1 () ;
      break ;
      case LEX_EGG.token_t_term : // 48
        regle1 () ;
      break ;
      case LEX_EGG.token_t_macro : // 50
        regle1 () ;
      break ;
      case LEX_EGG.token_t_comm : // 46
        regle1 () ;
      break ;
      case LEX_EGG.token_t_external : // 49
        regle1 () ;
      break ;
      case LEX_EGG.token_t_ident : // 61
        regle1 () ;
      break ;
      case LEX_EGG.token_t_option : // 44
        regle2 () ;
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
