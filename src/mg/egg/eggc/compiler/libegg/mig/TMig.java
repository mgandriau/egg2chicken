package mg.egg.eggc.compiler.libegg.mig;

import mg.egg.eggc.compiler.libegg.base.TERMINAL;
import mg.egg.eggc.runtime.libjava.EGGException;

public class TMig {
	private TERMINAL terminal;

	public String getNom() {
		return terminal.getNom();
	}

	private StringBuffer entete;

	public StringBuffer getEntete() {
		return entete;
	}

	public void setEntete() {
		entete = new StringBuffer();
		String comm = terminal.getComm();

		if (comm != null)
			entete.append(terminal.getComm() + '\n');

		switch (terminal.getType()) {
		case TERMINAL.SPACE:
			entete.append("space " + terminal.getNom() + " is \""
					+ terminal.get_expreg() + "\"");
			break;
		case TERMINAL.SUGAR:
			entete.append("sugar " + terminal.getNom() + " is \""
					+ terminal.get_expreg() + "\"");
			break;
		case TERMINAL.TERM:
			entete.append("term " + terminal.getNom() + " is \""
					+ terminal.get_expreg() + "\"");
			break;
		case TERMINAL.MACRO:
			entete.append("macro " + terminal.getNom() + " is \""
					+ terminal.get_expreg() + "\"");
			break;
		case TERMINAL.COMM:
			entete.append("comment " + terminal.getNom() + " is \""
					+ terminal.get_expreg() + "\"");
			break;
		}
		if (terminal.getNames().size() != 0) {
			boolean premier = true;
			entete.append("\taka\t");
			for (String a : terminal.getNames()) {
				if (premier) {
					premier = false;
				} else {
					entete.append(", ");
				}
				entete.append("$" + a + "$");
			}
		}
		entete.append(";\n");
	}

	public TMig(TERMINAL t) {
		terminal = t;
	}

	public String finaliser() throws EGGException {
		return entete.toString();
	}
}
