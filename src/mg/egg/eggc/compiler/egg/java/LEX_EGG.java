package mg.egg.eggc.compiler.egg.java;
import java.util.Arrays;
import mg.egg.eggc.runtime.libjava.EGGException;
import mg.egg.eggc.runtime.libjava.messages.NLS;
import mg.egg.eggc.runtime.libjava.lex.LEXICAL4;
import mg.egg.eggc.runtime.libjava.lex.LEX_CONTEXTE;
import mg.egg.eggc.runtime.libjava.problem.IProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemSeverities;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.compiler.libegg.base.*;
import mg.egg.eggc.compiler.libegg.java.*;
import mg.egg.eggc.compiler.libegg.egg.*;
import mg.egg.eggc.compiler.libegg.mig.*;
import mg.egg.eggc.compiler.libegg.latex.*;
import mg.egg.eggc.compiler.libegg.type.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import java.util.*;
public class LEX_EGG extends LEXICAL4  {
 public static final int EOF = 0 ;
 public static final int token_t_option = 1 ;
 public static final int token_t_for = 2 ;
 public static final int token_t_aka = 3 ;
 public static final int token_t_alias = 4 ;
 public static final int token_t_sugar = 5 ;
 public static final int token_t_inh = 6 ;
 public static final int token_t_inf = 7 ;
 public static final int token_commentaires = 8 ;
 public static final int token_t_is = 9 ;
 public static final int token_t_space = 10 ;
 public static final int token_t_external = 11 ;
 public static final int token_t_syn = 12 ;
 public static final int token_big = 13 ;
 public static final int token_t_global = 14 ;
 public static final int token_t_action = 15 ;
 public static final int token_t_fleche = 16 ;
 public static final int token_t_cro = 17 ;
 public static final int token_t_term = 18 ;
 public static final int token_t_pointvirgule = 19 ;
 public static final int token_t_macro = 20 ;
 public static final int token_t_crf = 21 ;
 public static final int token_t_integer = 22 ;
 public static final int token_t_guillemet = 23 ;
 public static final int token_t_aco = 24 ;
 public static final int token_t_string = 25 ;
 public static final int token_t_virgule = 26 ;
 public static final int token_t_sup = 27 ;
 public static final int token_t_char = 28 ;
 public static final int token_t_end = 29 ;
 public static final int token_separateurs = 30 ;
 public static final int token_t_acf = 31 ;
 public static final int token_t_ident = 32 ;
 public static final int token_t_double = 33 ;
 public static final int token_t_comm = 34 ;
 public static final int token_t_deuxpoints = 35 ;
  static final int token_autre = 36 ;
  public static final String[][] tokenImages = {
	{"<EOF>"} ,   {"option", },
   {"for", },
   {"aka", },
    {"t_alias"} ,
   {"sugar", },
   {"inh", },
   {"<", },
    {"commentaires"} ,
   {"is", },
   {"space", },
   {"compil", },
   {"syn", },
    {"big"} ,
   {"global", },
    {"t_action"} ,
   {"->", },
   {"[", },
   {"term", },
   {";", },
   {"macro", },
   {"]", },
   {"INTEGER", },
   {"\"", },
   {"{", },
   {"STRING", },
   {",", },
   {">", },
   {"CHARACTER", },
   {"end", },
    {"separateurs"} ,
   {"}", },
    {"t_ident"} ,
   {"DOUBLE", },
   {"comment", },
   {":", },
  } ;
  private int [] separateurs = { 
token_separateurs
	} ;
  public int[] getSeparateurs(){
	return separateurs;
    }
  private int [] comments = { 
token_commentaires
, token_big
	} ;
  public int[] getComments(){
	return comments;
    }
  private int le_comment = token_commentaires;
  public int getComment(){
	return le_comment;
    }
  public LEX_EGG(IProblemReporter pr, LEX_CONTEXTE lc, int k) {
	super(pr, lc,k);
	dernier_accepte = 0 ;
	analyseur = new JLEX_EGG();
  }
  public void setSource ( LEXICAL4 scanner) throws EGGException{
	scanner.analyseur.toContext(scanner.contexte);
	analyseur.fromContext(scanner.contexte);
  }
  public void setReader ( LEXICAL4 scanner) {
	scanner.analyseur.setReader(scanner.contexte.source);
  }
  public void accepter_sucre ( int t ) throws EGGException {
	if ( fenetre[0].code == t ) {
	  dernier_accepte = fenetre[0].ligne ;
	  recovery = false;
	  decaler () ;
	}else {
	  _interrompre(IProblem.Syntax,getBeginLine(), IEGGMessages.id_EGG_expected_token, EGGMessages.EGG_expected_token,new Object[]{fenetre[0].getNom(), Arrays.asList(tokenImages[t])});
	}
  }
  public void accepter_fds() throws EGGException {
	lit ( 1 ) ;
	if ( fenetre[0].code != EOF ) {
	  _interrompre(IProblem.Syntax,getBeginLine(), IEGGMessages.id_EGG_expected_token, EGGMessages.EGG_expected_eof, new Object[]{fenetre[0].getNom()});
	  }
     else {
	  dernier_accepte = fenetre[0].ligne ;
	  }
	}
  public int ligneDepart () {
	return getBeginLine() + getEndLine() ;
	}
  public void _interrompre (int cat,  int line, int id,  String c , Object [] m )  {
	  //recovery = true;
	  recovery = false;
	  contexte.errors++;
	    problemReporter.handle(cat, id,line  , NLS.bind(c,m), getOffset(), getOffset() + getLength() - 1,ProblemSeverities.Error,m);
	}
	public void _signaler ( int cat, int line, int id, String c , Object [] m )  {
	    problemReporter.handle(cat , id, line  , NLS.bind(c,m),getOffset(), getOffset() + getLength() - 1,ProblemSeverities.Warning,m);
	}
  }
