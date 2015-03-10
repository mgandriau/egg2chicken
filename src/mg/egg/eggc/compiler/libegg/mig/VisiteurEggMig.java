/*
 * version prévue pour gérer un compilateur incremental
 * pour eclipse mais pour l'instant tout est regénéré
 * à chaque fois.
 *
 * MG 04-05
 * Pour engendrer un .m avec juste la syntaxe
 */
package mg.egg.eggc.compiler.libegg.mig;

import java.util.Enumeration;
import java.util.Vector;

import mg.egg.eggc.compiler.libegg.base.ATTRIBUT;
import mg.egg.eggc.compiler.libegg.base.ActREGLE;
import mg.egg.eggc.compiler.libegg.base.GLOB;
import mg.egg.eggc.compiler.libegg.base.IVisiteurAction;
import mg.egg.eggc.compiler.libegg.base.IVisiteurEgg;
import mg.egg.eggc.compiler.libegg.base.NON_TERMINAL;
import mg.egg.eggc.compiler.libegg.base.REGLE;
import mg.egg.eggc.compiler.libegg.base.TDS;
import mg.egg.eggc.compiler.libegg.base.TERMINAL;
import mg.egg.eggc.runtime.libjava.EGGException;
import mg.egg.eggc.runtime.libjava.EGGOptions;
import mg.egg.eggc.runtime.libjava.IEGGCompilationUnit;

public class VisiteurEggMig implements IVisiteurEgg {
	// un seul visiteur d'action par visiteurEgg
	private IVisiteurAction vact;

	public IVisiteurAction getVisAction() {
	    return vact;
	}

	// les attributs deja engendrés
	private Vector<AttMig> atts;

	// les terminaux deja engendrés
	private Vector<TMig> terms;

	public TMig getTerm(String n) {
	    for (Enumeration e = terms.elements(); e.hasMoreElements();) {
	        TMig tj = (TMig) e.nextElement();

	        if (tj.getNom().equals(n))
	            return tj;
	    }
	    return null;
	}

	// les règles déjà engendrées
	private Vector<RMig> regles;

	public RMig getRegle(int n) {
	    // rajouter le test de débordement
	    if (n < regles.size())
	        return (RMig) regles.elementAt(n);
	    else
	        return null;
	}

	// la grammaire
	private TDS table;

	public VisiteurEggMig(TDS t) {
	    vact = new VisiteurActionMig();
	    table = t;
	    atts = new Vector<AttMig>();
	    terms = new Vector<TMig>();
	    regles = new Vector<RMig>();
	}

	// génère main() du compilo
	public void racinec() {
	}

	// génère module
	public void racine() {
	}

	// génère l'analyseur lexical
	public void lexical() {
	}

	// génère l'entête d'un non terminal
	// appelé à la création du non terminal
	public void nt_entete(NON_TERMINAL nt) {
	}

	// appelé à chaque création de règle
	public void regle(REGLE r) {
	    RMig c = new RMig(r);
	    regles.add(c);
	}

	// appele à la déclaration du non terminal externe
	public void ex_entete(NON_TERMINAL nt) {
	}

	// appele à chaque création de règle
	public void nt_regle(REGLE r) {
	    RMig c = getRegle(r.getNumero());
	    c.setEntete();
	}

	// génère l'analyse syntaxique d'un terminal ( = accepter)
	// appelé à la création du terminal
	public void t_entete(TERMINAL t) {
	    TMig c = new TMig(t);
	    terms.addElement(c);
	    c.setEntete();
	}

	// génère le code d'un attribut semantique
	// non appelé
	public void nt_attribut(NON_TERMINAL nt, ATTRIBUT a) {
	}

	// génère le code d'un attribut sémantique
	public void nt_attribut(ATTRIBUT a) {
	    AttMig c = new AttMig(a);
	    atts.addElement(c);
	    c.setEntete();
	}

	public void globale(REGLE r, GLOB g) {
	    RMig c = getRegle(r.getNumero());

	    if (c == null)
	        c = new RMig(r);

	    c.setGlob(g);
	}

	// génère le code d'une var globale attribut sémantique
	public void nt_globale(NON_TERMINAL nt, GLOB g) {
	    // NtEgg c = getNterm(nt.getNom());
	    // c.setGlob(g);
	}

	public void t_attribut(TERMINAL t, ATTRIBUT a) {
	}

	// génère le code d'une action sémantique
	// appelé à la création de l'action
	// nom (n), regle(r), code (c)
	public void nt_action(ActREGLE a) {
	    REGLE r = a.getRegle();
	    RMig c = getRegle(r.getNumero());

	    if (c == null)
	        c = new RMig(r);

	    c.setAct(a);
	}

	public String car(String s) {
	    return s;
	}

	public void finaliser() throws EGGException {
	    StringBuffer sb = new StringBuffer();
	    sb.append("------------------ ***** -----------------------------\n");
	    sb.append("-- Migration de la grammaire de "
	            + table.getNom());
	    sb.append("-- vers la nouvelle syntaxe\n");
	    sb.append("------------------ ***** -----------------------------\n");
	    sb.append("--OPTIONS\n");
	    EGGOptions options = table.getOptions();
        sb.append("option k =" + options.getK() + ";\n");
        sb.append("option auto =" + options.getAutoAtt() + ";\n");
        sb.append("option version =" + options.getVersion() + ";\n");
	    // les attributs
	    sb.append("--ATTRIBUTS\n");
	//    sb.append("\\section{Attributs}\n\n");
	    for (AttMig a : atts) {
	        sb.append(a.finaliser());
	    }
	    sb.append("\n");

	    sb.append("--TERMINAUX\n");
	    // les terminaux
//	    sb.append("\\section{Terminaux}\n\n");
	    for (TMig a : terms) {
	        sb.append(a.finaliser());
	    }
	    sb.append("\n");

	    sb.append("--REGLES\n");
	    // les règles
//	    sb.append("\\section{Règles de production}\n");
	    for (RMig a : regles) {
	        sb.append(a.finaliser());
	    }
//	    sb.append("\\end{document}\n");

	    // écriture
	    IEGGCompilationUnit cu = table.getCompilationUnit();
	    cu.createFile(table.getNom() + ".egg", sb.toString());
	}

	protected static String getOpEgg(String op) {
	    return op;
	}

	protected static String getTypeEgg(String type) {
	    return type;
	}

	public void m_entete(String m) {
	}
}
