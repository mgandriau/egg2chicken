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
public class S_S_EGG implements IDstNode {
LEX_EGG scanner;
  S_S_EGG() {
	}
  S_S_EGG(LEX_EGG scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	offset = 0;
	length = 0;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  IEGGCompilationUnit att_source;
  boolean att_eval;
  LEX_EGG att_scanner;
  IVisiteurEgg glob_0_v;
  TDS glob_0_table;
  private void regle0() throws Exception {

	//declaration
	S_OPTIONS_EGG x_3 = new S_OPTIONS_EGG(scanner,att_eval) ;
	S_ATTRIBUTS_EGG x_4 = new S_ATTRIBUTS_EGG(scanner,att_eval) ;
	S_LEXICAUX_EGG x_5 = new S_LEXICAUX_EGG(scanner,att_eval) ;
	S_EXTS_EGG x_6 = new S_EXTS_EGG(scanner,att_eval) ;
	S_AXIOME_EGG x_7 = new S_AXIOME_EGG(scanner,att_eval) ;
	S_PRODUCTIONS_EGG x_8 = new S_PRODUCTIONS_EGG(scanner,att_eval) ;
	T_EGG x_9 = new T_EGG(scanner ) ;
	//appel
if  (att_eval)	  action_init_0(x_3, x_4, x_5, x_6, x_7, x_8);
	x_3.analyser() ;
	  addChild(x_3);
	x_4.analyser() ;
	  addChild(x_4);
	x_5.analyser() ;
	  addChild(x_5);
	x_6.analyser() ;
	  addChild(x_6);
	x_7.analyser() ;
	  addChild(x_7);
	x_8.analyser() ;
	  addChild(x_8);
	x_9.analyser(LEX_EGG.token_t_end);
	  addChild(x_9);
if  (att_eval)	  action_gen_0(x_3, x_4, x_5, x_6, x_7, x_8);
	 offset =x_3.getOffset();
	 length =x_9.getOffset() + x_9.getLength() - offset;
  }
private void action_gen_0(S_OPTIONS_EGG x_3, S_ATTRIBUTS_EGG x_4, S_LEXICAUX_EGG x_5, S_EXTS_EGG x_6, S_AXIOME_EGG x_7, S_PRODUCTIONS_EGG x_8) throws Exception {
try {
// instructions
int loc_ce;
SYMBOLE loc_s;
Resolveur loc_r;
boolean loc_rx;
(glob_0_table).analyser_syntaxe();
loc_r=(glob_0_table).getResolveur();
loc_rx=(loc_r).resoudre();
(loc_r).generer();
(glob_0_v).finaliser();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#gen","S -> #init OPTIONS ATTRIBUTS LEXICAUX EXTS AXIOME PRODUCTIONS t_end #gen ;"});
}
  }
private void action_init_0(S_OPTIONS_EGG x_3, S_ATTRIBUTS_EGG x_4, S_LEXICAUX_EGG x_5, S_EXTS_EGG x_6, S_AXIOME_EGG x_7, S_PRODUCTIONS_EGG x_8) throws Exception {
try {
// instructions
ATTRIBUT loc_attribut;
EGGOptions loc_options;
int loc_ce;
Resolveur loc_r;
String loc_lang;
glob_0_table= new TDS(this.att_source);
loc_options=(glob_0_table).getOptions();
if (!((glob_0_table).verifierOptions())){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IEGGMessages.id_EGG_option_error, EGGMessages.EGG_option_error,new Object[]{""+(loc_options).toString()});

}

x_3.att_table=glob_0_table;
x_4.att_table=glob_0_table;
x_6.att_table=glob_0_table;
x_5.att_table=glob_0_table;
x_7.att_table=glob_0_table;
x_8.att_table=glob_0_table;
loc_lang=(loc_options).getLang();
if ((loc_lang).equals("java")){
glob_0_v= new VisiteurEggJava(glob_0_table);
loc_r= new LactionResolveur();
}
else if ((loc_lang).equals("egg")){
glob_0_v= new VisiteurEggEgg(glob_0_table);
loc_r= new LactionResolveur();
}
else if ((loc_lang).equals("mig")){
glob_0_v= new VisiteurEggMig(glob_0_table);
loc_r= new LactionResolveur();
}
else if ((loc_lang).equals("latex")){
glob_0_v= new VisiteurEggLatex(glob_0_table);
loc_r= new LactionResolveur();
}
else if ((loc_lang).equals("no")){
glob_0_v= new VisiteurEggNull(glob_0_table);
loc_r= new LactionResolveur();
}
else {
loc_r= new LactionResolveur();
}
(glob_0_table).setResolveur(loc_r);
loc_attribut= new ATTRIBUT(1, "txt", (loc_r).getType("STRING"), (this.att_scanner).getCommentaire());
(loc_attribut).set_builtin();
(glob_0_table).ajouter_att(loc_attribut);
loc_attribut= new ATTRIBUT(0, "scanner", (loc_r).getType(("LEX_"+(glob_0_table).getNom())), "--scanner");
(loc_attribut).set_builtin();
(glob_0_table).ajouter_att(loc_attribut);
loc_attribut= new ATTRIBUT(0, "eval", (loc_r).getType("BOOLEAN"), "-- eval semantic actions");
(loc_attribut).set_builtin();
(glob_0_table).ajouter_att(loc_attribut);
x_5.att_vis=glob_0_v;
x_4.att_vis=glob_0_v;
x_6.att_vis=glob_0_v;
x_7.att_vis=glob_0_v;
x_8.att_vis=glob_0_v;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "EGG", "#init","S -> #init OPTIONS ATTRIBUTS LEXICAUX EXTS AXIOME PRODUCTIONS t_end #gen ;"});
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_EGG.token_t_option : // 44
        regle0 () ;
      break ;
      case LEX_EGG.token_t_inh : // 30
        regle0 () ;
      break ;
      case LEX_EGG.token_t_syn : // 31
        regle0 () ;
      break ;
      case LEX_EGG.token_t_space : // 45
        regle0 () ;
      break ;
      case LEX_EGG.token_t_sugar : // 47
        regle0 () ;
      break ;
      case LEX_EGG.token_t_term : // 48
        regle0 () ;
      break ;
      case LEX_EGG.token_t_macro : // 50
        regle0 () ;
      break ;
      case LEX_EGG.token_t_comm : // 46
        regle0 () ;
      break ;
      case LEX_EGG.token_t_external : // 49
        regle0 () ;
      break ;
      case LEX_EGG.token_t_ident : // 61
        regle0 () ;
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
