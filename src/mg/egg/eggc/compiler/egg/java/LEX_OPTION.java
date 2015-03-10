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
public class LEX_OPTION extends LEXICAL4  {
 public static final int EOF = 0 ;
 public static final int token_separateur = 1 ;
 public static final int token_t_vv = 2 ;
 public static final int token_t_auto = 3 ;
 public static final int token_t_pv = 4 ;
 public static final int token_t_k = 5 ;
 public static final int token_t_version = 6 ;
 public static final int token_t_vk = 7 ;
 public static final int token_t_eg = 8 ;
 public static final int token_t_faux = 9 ;
 public static final int token_t_vrai = 10 ;
  static final int token_autre = 11 ;
  public static final String[][] tokenImages = {
	{"<EOF>"} ,    {"separateur"} ,
    {"t_vv"} ,
{"t_auto"},
{"t_pv"},
{"t_k"},
{"t_version"},
    {"t_vk"} ,
{"t_eg"},
{"t_faux"},
{"t_vrai"},
  } ;
  private int [] separateurs = { 
token_separateur
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
  public LEX_OPTION(IProblemReporter pr, LEX_CONTEXTE lc, int k) {
	super(pr , lc,k);
	dernier_accepte = 0 ;
	analyseur = new JLEX_OPTION();
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
	  _interrompre(IProblem.Syntax,getBeginLine(), IOPTIONMessages.id_OPTION_expected_token, OPTIONMessages.OPTION_expected_token,new Object[]{fenetre[0].getNom(), Arrays.asList(tokenImages[t])});
	}
  }
  public void accepter_fds() throws EGGException {
	lit ( 1 ) ;
	if ( fenetre[0].code != EOF ) {
	  _interrompre(IProblem.Syntax,getBeginLine(), IOPTIONMessages.id_OPTION_expected_token, OPTIONMessages.OPTION_expected_eof, new Object[]{fenetre[0].getNom()});
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
