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
import mg.egg.eggc.compiler.libegg.latex.*;
import mg.egg.eggc.compiler.libegg.type.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import java.util.*;
public class LEX_EXPREG extends LEXICAL4  {
 public static final int EOF = 0 ;
 public static final int token_neg = 1 ;
 public static final int token_etoile = 2 ;
 public static final int token_acf = 3 ;
 public static final int token_t_def = 4 ;
 public static final int token_guillemet = 5 ;
 public static final int token_ou = 6 ;
 public static final int token_car = 7 ;
 public static final int token_interro = 8 ;
 public static final int token_ser = 9 ;
 public static final int token_point = 10 ;
 public static final int token_paro = 11 ;
 public static final int token_plus = 12 ;
 public static final int token_croco = 13 ;
 public static final int token_eer = 14 ;
 public static final int token_moins = 15 ;
 public static final int token_parf = 16 ;
 public static final int token_aco = 17 ;
 public static final int token_crocf = 18 ;
  static final int token_autre = 19 ;
  public static final String[][] tokenImages = {
	{"<EOF>"} ,{"neg"},
{"etoile"},
{"acf"},
    {"t_def"} ,
{"guillemet"},
{"ou"},
    {"car"} ,
{"interro"},
{"ser"},
{"point"},
{"paro"},
{"plus"},
{"croco"},
{"eer"},
{"moins"},
{"parf"},
{"aco"},
{"crocf"},
  } ;
  private int [] separateurs = { 
	} ;
  public int[] getSeparateurs(){
	return separateurs;
    }
  private int [] comments = { 
	} ;
  public int[] getComments(){
	return comments;
    }
  private int le_comment = -1;
  public int getComment(){
	return le_comment;
    }
  public LEX_EXPREG(IProblemReporter pr, LEX_CONTEXTE lc, int k) {
	super(pr , lc,k);
	dernier_accepte = 0 ;
	analyseur = new JLEX_EXPREG();
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
	  _interrompre(IProblem.Syntax,getBeginLine(), IEXPREGMessages.id_EXPREG_expected_token, EXPREGMessages.EXPREG_expected_token,new Object[]{fenetre[0].getNom(), Arrays.asList(tokenImages[t])});
	}
  }
  public void accepter_fds() throws EGGException {
	lit ( 1 ) ;
	if ( fenetre[0].code != EOF ) {
	  _interrompre(IProblem.Syntax,getBeginLine(), IEXPREGMessages.id_EXPREG_expected_token, EXPREGMessages.EXPREG_expected_eof, new Object[]{fenetre[0].getNom()});
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
