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
public class LEX_LACTION extends LEXICAL4  {
 public static final int EOF = 0 ;
 public static final int token_t_parf = 1 ;
 public static final int token_t_et = 2 ;
 public static final int token_t_deuxpoints = 3 ;
 public static final int token_t_attention = 4 ;
 public static final int token_t_end = 5 ;
 public static final int token_t_when = 6 ;
 public static final int token_t_point = 7 ;
 public static final int token_t_true = 8 ;
 public static final int token_t_plus = 9 ;
 public static final int token_t_new = 10 ;
 public static final int token_t_flottant = 11 ;
 public static final int token_t_car = 12 ;
 public static final int token_t_char = 13 ;
 public static final int token_t_local = 14 ;
 public static final int token_t_affectation = 15 ;
 public static final int token_t_do = 16 ;
 public static final int token_t_mult = 17 ;
 public static final int token_t_d_moins = 18 ;
 public static final int token_t_else = 19 ;
 public static final int token_t_ident = 20 ;
 public static final int token_t_egal = 21 ;
 public static final int token_big = 22 ;
 public static final int token_t_is = 23 ;
 public static final int token_t_begin = 24 ;
 public static final int token_t_pointvirgule = 25 ;
 public static final int token_t_chapeau = 26 ;
 public static final int token_t_ou = 27 ;
 public static final int token_t_cro = 28 ;
 public static final int token_t_sup = 29 ;
 public static final int token_t_crf = 30 ;
 public static final int token_t_if = 31 ;
 public static final int token_t_virgule = 32 ;
 public static final int token_t_not = 33 ;
 public static final int token_t_exception = 34 ;
 public static final int token_t_nil = 35 ;
 public static final int token_t_string = 36 ;
 public static final int token_t_append = 37 ;
 public static final int token_t_with = 38 ;
 public static final int token_t_call = 39 ;
 public static final int token_t_integer = 40 ;
 public static final int token_t_moins = 41 ;
 public static final int token_commentaires = 42 ;
 public static final int token_t_false = 43 ;
 public static final int token_t_div = 44 ;
 public static final int token_t_double = 45 ;
 public static final int token_t_match = 46 ;
 public static final int token_separateur = 47 ;
 public static final int token_t_error = 48 ;
 public static final int token_t_d_plus = 49 ;
 public static final int token_t_elseif = 50 ;
 public static final int token_t_chaine = 51 ;
 public static final int token_t_d_div = 52 ;
 public static final int token_t_inf = 53 ;
 public static final int token_t_d_mult = 54 ;
 public static final int token_t_different = 55 ;
 public static final int token_t_entier = 56 ;
 public static final int token_t_write = 57 ;
 public static final int token_t_then = 58 ;
 public static final int token_t_paro = 59 ;
  static final int token_autre = 60 ;
  public static final String[][] tokenImages = {
	{"<EOF>"} ,   {")", },
   {"&", "&&", },
   {":", },
   {"warning", },
   {"end", },
   {"when", },
   {".", },
   {"true", },
   {"+", },
   {"new", },
    {"t_flottant"} ,
    {"t_car"} ,
   {"CHARACTER", },
   {"local", },
   {":=", },
   {"do", },
   {"*", },
   {"-.", },
   {"else", },
    {"t_ident"} ,
   {"=", },
    {"big"} ,
   {"is", },
   {"begin", },
   {";", },
   {"^", },
   {"|", "||", },
   {"[", },
   {">", },
   {"]", },
   {"if", },
   {",", },
   {"~", "!", },
   {"exception", },
   {"nil", "null", },
   {"STRING", },
   {"@", },
   {"with", },
   {"call", },
   {"INTEGER", },
   {"-", },
    {"commentaires"} ,
   {"false", },
   {"/", },
   {"DOUBLE", },
   {"match", },
    {"separateur"} ,
   {"error", },
   {"+.", },
   {"elseif", },
    {"t_chaine"} ,
   {"/.", },
   {"<", },
   {"*.", },
   {"/=", "!=", },
    {"t_entier"} ,
   {"write", },
   {"then", },
   {"(", },
  } ;
  private int [] separateurs = { 
token_separateur
	} ;
  public int[] getSeparateurs(){
	return separateurs;
    }
  private int [] comments = { 
token_big
, token_commentaires
	} ;
  public int[] getComments(){
	return comments;
    }
  private int le_comment = token_big;
  public int getComment(){
	return le_comment;
    }
  public LEX_LACTION(IProblemReporter pr, LEX_CONTEXTE lc, int k) {
	super(pr , lc,k);
	dernier_accepte = 0 ;
	analyseur = new JLEX_LACTION();
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
	  _interrompre(IProblem.Syntax,getBeginLine(), ILACTIONMessages.id_LACTION_expected_token, LACTIONMessages.LACTION_expected_token,new Object[]{fenetre[0].getNom(), Arrays.asList(tokenImages[t])});
	}
  }
  public void accepter_fds() throws EGGException {
	lit ( 1 ) ;
	if ( fenetre[0].code != EOF ) {
	  _interrompre(IProblem.Syntax,getBeginLine(), ILACTIONMessages.id_LACTION_expected_token, LACTIONMessages.LACTION_expected_eof, new Object[]{fenetre[0].getNom()});
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
