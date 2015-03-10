package mg.egg.eggc.compiler.egg.java;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.compiler.libegg.base.*;
import mg.egg.eggc.compiler.libegg.java.*;
import mg.egg.eggc.compiler.libegg.egg.*;
import mg.egg.eggc.compiler.libegg.latex.*;
import mg.egg.eggc.compiler.libegg.type.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import java.util.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import java.util.List;
public class T_OPTION implements IDstNode {
  private int sorte;
  LEX_OPTION att_scanner;
  String att_txt;
  LEX_OPTION scanner;
  private String txt;
  public String getTxt(){return txt;}
  public T_OPTION(LEX_OPTION scanner ) {
	this.scanner = scanner ;
	this.att_scanner = scanner ;
	}
  public void analyser(int t) throws EGGException {
	scanner.lit ( 1 ) ;
	txt = scanner.fenetre[0].getNom() ;
	att_txt = txt ;
	sorte=t;
	offset= scanner.getOffset(0);
	length= scanner.getLength(0);
	scanner.accepter_sucre ( t ) ;
	}
  public int getSorte(){return sorte;}
	private IDstNode parent;
	public void setParent( IDstNode p){parent = p;}
	public IDstNode getParent(){return parent;}
  public void addChild(IDstNode node){}
  public List<IDstNode> getChildren(){return null;}
  public boolean isLeaf(){return true;}
  public void accept(IDstVisitor visitor){visitor.visit(this);}
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
