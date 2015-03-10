package mg.egg.eggc.compiler.libegg.mig;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import mg.egg.eggc.compiler.libegg.base.ActREGLE;
import mg.egg.eggc.compiler.libegg.base.EltREGLE;
import mg.egg.eggc.compiler.libegg.base.GLOB;
import mg.egg.eggc.compiler.libegg.base.REGLE;
import mg.egg.eggc.compiler.libegg.base.SYMBOLE;
import mg.egg.eggc.compiler.libegg.base.SymbREGLE;
import mg.egg.eggc.runtime.libjava.EGGException;

public class RMig {
	private REGLE regle;

	private StringBuffer entete;

	public StringBuffer getEntete() {
		return entete;
	}

	// génère le code de la règle
	public void setEntete() {
		entete = new StringBuffer();
		String comm = regle.getComm();

		if (comm != null)
			entete.append(regle.getComm() + '\n');

		entete.append(regle.getGauche().getNom() + "->");
		for (Enumeration d = regle.getDroite().elements(); d.hasMoreElements();) {
			EltREGLE er = (EltREGLE) d.nextElement();

			if (er instanceof SymbREGLE) {
				SYMBOLE s = ((SymbREGLE) er).getSymbole();
				entete.append(" " + s.getNom());
			} else {
				ActREGLE ar = (ActREGLE) er;
				if (ar.getNom().endsWith("auto_inh")) {
					continue;
				}

				if (ar.getCode() != null) {
					entete.append(" " + er.getNom());
				}
			}
		}
		entete.append(";\n");
	}

	private LinkedHashMap<String, String> acts;

	public String getAct(String act) {
		return acts.get(act);
	}

	public void addAct(String act, String c) {
		acts.put(act, c);
	}

	public void delAct(String act) {
		acts.remove(act);
	}

	public void setAct(ActREGLE act) {
		// ne pas traduire les auto
		if (act.getNom().endsWith("auto_inh")) {
			return;
		}
		StringBuffer asb = new StringBuffer();

		// l'entete d'une action
		asb.append(act.getNom() + "{\n");

		// le code
		asb.append(act.getCode());
		asb.append("}\n");

		// ajout dans la liste
		addAct(act.getNom(), asb.toString());
	}

	private LinkedHashMap<String, String> globs;

	public String getGlob(String g) {
		return globs.get(g);
	}

	public void addGlob(String g, String c) {
		globs.put(g, c);
	}

	public void delGlob(String g) {
		globs.remove(g);
	}

	public void setGlob(GLOB g) {
		StringBuffer asb = new StringBuffer();

		// visible dans le package
		// asb.append(g.getNom() + " : "
		// + VisiteurEggEgg.getTypeEgg(g.getType().getNom()) + ";\n");
		asb.append(VisiteurEggMig.getTypeEgg(g.getType().getNom()) + " "
				+ g.getNom() + ";\n");

		// ajout dans la liste
		addGlob(g.getNom(), asb.toString());
	}

	public RMig(REGLE r) {
		regle = r;
		acts = new LinkedHashMap<String, String>();
		globs = new LinkedHashMap<String, String>();
	}

	// appelé si changement dans le nt
	public String finaliser() throws EGGException {
		// les globales
		if (globs.values().size() != 0) {
			entete.append("global\n");

			for (Iterator e = globs.values().iterator(); e.hasNext();) {
				entete.append(e.next() + "\n");
			}
		}

		// les actions sémantiques
		for (Iterator e = acts.values().iterator(); e.hasNext();) {
			entete.append(e.next() + "\n");
		}

		return entete.toString();
	}
}
