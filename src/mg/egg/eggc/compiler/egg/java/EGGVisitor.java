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
import mg.egg.eggc.runtime.libjava.*;
public class EGGVisitor implements IDstVisitor {
protected boolean visitNode(IDstNode node){
  return true;}
public boolean visit(IDstNode node){
  if (node instanceof S_S_EGG)
	return visit((S_S_EGG) node);
  if (node instanceof S_VTYPE_EGG)
	return visit((S_VTYPE_EGG) node);
  if (node instanceof S_TYPE_EGG)
	return visit((S_TYPE_EGG) node);
  if (node instanceof S_TGEN_EGG)
	return visit((S_TGEN_EGG) node);
  if (node instanceof S_XTYPE_EGG)
	return visit((S_XTYPE_EGG) node);
  if (node instanceof S_IDENT_EGG)
	return visit((S_IDENT_EGG) node);
  if (node.getClass() ==  cEXPREG){
	node.accept(fEXPREGVisitor);
  }
  if (node.getClass() ==  cLACTION){
	node.accept(fLACTIONVisitor);
  }
  if (node instanceof S_OPTIONS_EGG)
	return visit((S_OPTIONS_EGG) node);
  if (node.getClass() ==  cOPTION){
	node.accept(fOPTIONVisitor);
  }
  if (node instanceof S_ATTRIBUTS_EGG)
	return visit((S_ATTRIBUTS_EGG) node);
  if (node instanceof S_ATTRIBUT_EGG)
	return visit((S_ATTRIBUT_EGG) node);
  if (node instanceof S_LEXICAUX_EGG)
	return visit((S_LEXICAUX_EGG) node);
  if (node instanceof S_LEXICAL_EGG)
	return visit((S_LEXICAL_EGG) node);
  if (node instanceof S_AXIOME_EGG)
	return visit((S_AXIOME_EGG) node);
  if (node instanceof S_EXTS_EGG)
	return visit((S_EXTS_EGG) node);
  if (node instanceof S_IDENTS_EGG)
	return visit((S_IDENTS_EGG) node);
  if (node instanceof S_PRODUCTIONS_EGG)
	return visit((S_PRODUCTIONS_EGG) node);
  if (node instanceof S_PRODUCTION_EGG)
	return visit((S_PRODUCTION_EGG) node);
  if (node instanceof S_PDROITE_EGG)
	return visit((S_PDROITE_EGG) node);
  if (node instanceof S_GLOBALES_EGG)
	return visit((S_GLOBALES_EGG) node);
  if (node instanceof S_GLOBS_EGG)
	return visit((S_GLOBS_EGG) node);
  if (node instanceof S_ACTS_EGG)
	return visit((S_ACTS_EGG) node);
  if (node instanceof S_SATT_EGG)
	return visit((S_SATT_EGG) node);
  if (node instanceof S_ALIASES_EGG)
	return visit((S_ALIASES_EGG) node);
  if (node instanceof S_ALIASESX_EGG)
	return visit((S_ALIASESX_EGG) node);
  if (node instanceof T_EGG)
	return visit((T_EGG) node);
  return false;
}
public void endVisit(IDstNode node){
  if (node instanceof S_S_EGG)
	endVisit((S_S_EGG) node);
  if (node instanceof S_VTYPE_EGG)
	endVisit((S_VTYPE_EGG) node);
  if (node instanceof S_TYPE_EGG)
	endVisit((S_TYPE_EGG) node);
  if (node instanceof S_TGEN_EGG)
	endVisit((S_TGEN_EGG) node);
  if (node instanceof S_XTYPE_EGG)
	endVisit((S_XTYPE_EGG) node);
  if (node instanceof S_IDENT_EGG)
	endVisit((S_IDENT_EGG) node);
  if (node instanceof S_OPTIONS_EGG)
	endVisit((S_OPTIONS_EGG) node);
  if (node instanceof S_ATTRIBUTS_EGG)
	endVisit((S_ATTRIBUTS_EGG) node);
  if (node instanceof S_ATTRIBUT_EGG)
	endVisit((S_ATTRIBUT_EGG) node);
  if (node instanceof S_LEXICAUX_EGG)
	endVisit((S_LEXICAUX_EGG) node);
  if (node instanceof S_LEXICAL_EGG)
	endVisit((S_LEXICAL_EGG) node);
  if (node instanceof S_AXIOME_EGG)
	endVisit((S_AXIOME_EGG) node);
  if (node instanceof S_EXTS_EGG)
	endVisit((S_EXTS_EGG) node);
  if (node instanceof S_IDENTS_EGG)
	endVisit((S_IDENTS_EGG) node);
  if (node instanceof S_PRODUCTIONS_EGG)
	endVisit((S_PRODUCTIONS_EGG) node);
  if (node instanceof S_PRODUCTION_EGG)
	endVisit((S_PRODUCTION_EGG) node);
  if (node instanceof S_PDROITE_EGG)
	endVisit((S_PDROITE_EGG) node);
  if (node instanceof S_GLOBALES_EGG)
	endVisit((S_GLOBALES_EGG) node);
  if (node instanceof S_GLOBS_EGG)
	endVisit((S_GLOBS_EGG) node);
  if (node instanceof S_ACTS_EGG)
	endVisit((S_ACTS_EGG) node);
  if (node instanceof S_SATT_EGG)
	endVisit((S_SATT_EGG) node);
  if (node instanceof S_ALIASES_EGG)
	endVisit((S_ALIASES_EGG) node);
  if (node instanceof S_ALIASESX_EGG)
	endVisit((S_ALIASESX_EGG) node);
  }
private Class cEXPREG= new EXPREG().getAxiom().getClass();
public EXPREGVisitor fEXPREGVisitor;
private Class cLACTION= new LACTION().getAxiom().getClass();
public LACTIONVisitor fLACTIONVisitor;
private Class cOPTION= new OPTION().getAxiom().getClass();
public OPTIONVisitor fOPTIONVisitor;
public EGGVisitor(EXPREGVisitor v1,LACTIONVisitor v2,OPTIONVisitor v3){
  fEXPREGVisitor = v1;
  fLACTIONVisitor = v2;
  fOPTIONVisitor = v3;
  }
public EGGVisitor(){
  fEXPREGVisitor = new EXPREGVisitor();
  fLACTIONVisitor = new LACTIONVisitor();
  fOPTIONVisitor = new OPTIONVisitor();
  }
public boolean visit(S_S_EGG node ){
  return visitNode(node);
}
public void endVisit(S_S_EGG node){
}
public boolean visit(S_VTYPE_EGG node ){
  return visitNode(node);
}
public void endVisit(S_VTYPE_EGG node){
}
public boolean visit(S_TYPE_EGG node ){
  return visitNode(node);
}
public void endVisit(S_TYPE_EGG node){
}
public boolean visit(S_TGEN_EGG node ){
  return visitNode(node);
}
public void endVisit(S_TGEN_EGG node){
}
public boolean visit(S_XTYPE_EGG node ){
  return visitNode(node);
}
public void endVisit(S_XTYPE_EGG node){
}
public boolean visit(S_IDENT_EGG node ){
  return visitNode(node);
}
public void endVisit(S_IDENT_EGG node){
}
public boolean visit(S_OPTIONS_EGG node ){
  return visitNode(node);
}
public void endVisit(S_OPTIONS_EGG node){
}
public boolean visit(S_ATTRIBUTS_EGG node ){
  return visitNode(node);
}
public void endVisit(S_ATTRIBUTS_EGG node){
}
public boolean visit(S_ATTRIBUT_EGG node ){
  return visitNode(node);
}
public void endVisit(S_ATTRIBUT_EGG node){
}
public boolean visit(S_LEXICAUX_EGG node ){
  return visitNode(node);
}
public void endVisit(S_LEXICAUX_EGG node){
}
public boolean visit(S_LEXICAL_EGG node ){
  return visitNode(node);
}
public void endVisit(S_LEXICAL_EGG node){
}
public boolean visit(S_AXIOME_EGG node ){
  return visitNode(node);
}
public void endVisit(S_AXIOME_EGG node){
}
public boolean visit(S_EXTS_EGG node ){
  return visitNode(node);
}
public void endVisit(S_EXTS_EGG node){
}
public boolean visit(S_IDENTS_EGG node ){
  return visitNode(node);
}
public void endVisit(S_IDENTS_EGG node){
}
public boolean visit(S_PRODUCTIONS_EGG node ){
  return visitNode(node);
}
public void endVisit(S_PRODUCTIONS_EGG node){
}
public boolean visit(S_PRODUCTION_EGG node ){
  return visitNode(node);
}
public void endVisit(S_PRODUCTION_EGG node){
}
public boolean visit(S_PDROITE_EGG node ){
  return visitNode(node);
}
public void endVisit(S_PDROITE_EGG node){
}
public boolean visit(S_GLOBALES_EGG node ){
  return visitNode(node);
}
public void endVisit(S_GLOBALES_EGG node){
}
public boolean visit(S_GLOBS_EGG node ){
  return visitNode(node);
}
public void endVisit(S_GLOBS_EGG node){
}
public boolean visit(S_ACTS_EGG node ){
  return visitNode(node);
}
public void endVisit(S_ACTS_EGG node){
}
public boolean visit(S_SATT_EGG node ){
  return visitNode(node);
}
public void endVisit(S_SATT_EGG node){
}
public boolean visit(S_ALIASES_EGG node ){
  return visitNode(node);
}
public void endVisit(S_ALIASES_EGG node){
}
public boolean visit(S_ALIASESX_EGG node ){
  return visitNode(node);
}
public void endVisit(S_ALIASESX_EGG node){
}
public boolean visit(T_EGG node){
  return false;}
public void endVisit(T_EGG node){
}
}
