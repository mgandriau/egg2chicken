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
public class EXPREGVisitor implements IDstVisitor {
protected boolean visitNode(IDstNode node){
  return true;}
public boolean visit(IDstNode node){
  if (node instanceof S_EXPREG_EXPREG)
	return visit((S_EXPREG_EXPREG) node);
  if (node instanceof S_REG_EXPREG)
	return visit((S_REG_EXPREG) node);
  if (node instanceof S_TERME_EXPREG)
	return visit((S_TERME_EXPREG) node);
  if (node instanceof S_APRTERME_EXPREG)
	return visit((S_APRTERME_EXPREG) node);
  if (node instanceof S_FACTEUR_EXPREG)
	return visit((S_FACTEUR_EXPREG) node);
  if (node instanceof S_APRFACTEUR_EXPREG)
	return visit((S_APRFACTEUR_EXPREG) node);
  if (node instanceof S_ELT_EXPREG)
	return visit((S_ELT_EXPREG) node);
  if (node instanceof S_ELTS_EXPREG)
	return visit((S_ELTS_EXPREG) node);
  if (node instanceof S_APRCAR_EXPREG)
	return visit((S_APRCAR_EXPREG) node);
  if (node instanceof S_SER_EXPREG)
	return visit((S_SER_EXPREG) node);
  if (node instanceof S_EER_EXPREG)
	return visit((S_EER_EXPREG) node);
  if (node instanceof S_OP_EXPREG)
	return visit((S_OP_EXPREG) node);
  if (node instanceof T_EXPREG)
	return visit((T_EXPREG) node);
  return false;
}
public void endVisit(IDstNode node){
  if (node instanceof S_EXPREG_EXPREG)
	endVisit((S_EXPREG_EXPREG) node);
  if (node instanceof S_REG_EXPREG)
	endVisit((S_REG_EXPREG) node);
  if (node instanceof S_TERME_EXPREG)
	endVisit((S_TERME_EXPREG) node);
  if (node instanceof S_APRTERME_EXPREG)
	endVisit((S_APRTERME_EXPREG) node);
  if (node instanceof S_FACTEUR_EXPREG)
	endVisit((S_FACTEUR_EXPREG) node);
  if (node instanceof S_APRFACTEUR_EXPREG)
	endVisit((S_APRFACTEUR_EXPREG) node);
  if (node instanceof S_ELT_EXPREG)
	endVisit((S_ELT_EXPREG) node);
  if (node instanceof S_ELTS_EXPREG)
	endVisit((S_ELTS_EXPREG) node);
  if (node instanceof S_APRCAR_EXPREG)
	endVisit((S_APRCAR_EXPREG) node);
  if (node instanceof S_SER_EXPREG)
	endVisit((S_SER_EXPREG) node);
  if (node instanceof S_EER_EXPREG)
	endVisit((S_EER_EXPREG) node);
  if (node instanceof S_OP_EXPREG)
	endVisit((S_OP_EXPREG) node);
  }
public EXPREGVisitor(){
  }
public boolean visit(S_EXPREG_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_EXPREG_EXPREG node){
}
public boolean visit(S_REG_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_REG_EXPREG node){
}
public boolean visit(S_TERME_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_TERME_EXPREG node){
}
public boolean visit(S_APRTERME_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_APRTERME_EXPREG node){
}
public boolean visit(S_FACTEUR_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_FACTEUR_EXPREG node){
}
public boolean visit(S_APRFACTEUR_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_APRFACTEUR_EXPREG node){
}
public boolean visit(S_ELT_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_ELT_EXPREG node){
}
public boolean visit(S_ELTS_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_ELTS_EXPREG node){
}
public boolean visit(S_APRCAR_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_APRCAR_EXPREG node){
}
public boolean visit(S_SER_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_SER_EXPREG node){
}
public boolean visit(S_EER_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_EER_EXPREG node){
}
public boolean visit(S_OP_EXPREG node ){
  return visitNode(node);
}
public void endVisit(S_OP_EXPREG node){
}
public boolean visit(T_EXPREG node){
  return false;}
public void endVisit(T_EXPREG node){
}
}
