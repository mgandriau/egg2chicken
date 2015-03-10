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
public class LACTIONVisitor implements IDstVisitor {
protected boolean visitNode(IDstNode node){
  return true;}
public boolean visit(IDstNode node){
  if (node instanceof S_LACTION_LACTION)
	return visit((S_LACTION_LACTION) node);
  if (node instanceof S_INSTS_LACTION)
	return visit((S_INSTS_LACTION) node);
  if (node instanceof S_INST_LACTION)
	return visit((S_INST_LACTION) node);
  if (node instanceof S_INST2_LACTION)
	return visit((S_INST2_LACTION) node);
  if (node instanceof S_ELSIF_LACTION)
	return visit((S_ELSIF_LACTION) node);
  if (node instanceof S_WITH_LACTION)
	return visit((S_WITH_LACTION) node);
  if (node instanceof S_WITHS_LACTION)
	return visit((S_WITHS_LACTION) node);
  if (node instanceof S_VAR_LACTION)
	return visit((S_VAR_LACTION) node);
  if (node instanceof S_EXPR_LACTION)
	return visit((S_EXPR_LACTION) node);
  if (node instanceof S_EXPRTERME_LACTION)
	return visit((S_EXPRTERME_LACTION) node);
  if (node instanceof S_TERME_LACTION)
	return visit((S_TERME_LACTION) node);
  if (node instanceof S_EXPRFACTEUR_LACTION)
	return visit((S_EXPRFACTEUR_LACTION) node);
  if (node instanceof S_FACTEUR_LACTION)
	return visit((S_FACTEUR_LACTION) node);
  if (node instanceof S_APP_LACTION)
	return visit((S_APP_LACTION) node);
  if (node instanceof S_APP2_LACTION)
	return visit((S_APP2_LACTION) node);
  if (node instanceof S_ARGS_LACTION)
	return visit((S_ARGS_LACTION) node);
  if (node instanceof S_ARGSX_LACTION)
	return visit((S_ARGSX_LACTION) node);
  if (node instanceof S_EARGS_LACTION)
	return visit((S_EARGS_LACTION) node);
  if (node instanceof S_EXCEPTION_LACTION)
	return visit((S_EXCEPTION_LACTION) node);
  if (node instanceof S_LOCALES_LACTION)
	return visit((S_LOCALES_LACTION) node);
  if (node instanceof S_LOCS_LACTION)
	return visit((S_LOCS_LACTION) node);
  if (node instanceof S_OPADD_LACTION)
	return visit((S_OPADD_LACTION) node);
  if (node instanceof S_OPMUL_LACTION)
	return visit((S_OPMUL_LACTION) node);
  if (node instanceof S_VTYPE_LACTION)
	return visit((S_VTYPE_LACTION) node);
  if (node instanceof S_TYPE_LACTION)
	return visit((S_TYPE_LACTION) node);
  if (node instanceof S_TGEN_LACTION)
	return visit((S_TGEN_LACTION) node);
  if (node instanceof S_XTYPE_LACTION)
	return visit((S_XTYPE_LACTION) node);
  if (node instanceof T_LACTION)
	return visit((T_LACTION) node);
  return false;
}
public void endVisit(IDstNode node){
  if (node instanceof S_LACTION_LACTION)
	endVisit((S_LACTION_LACTION) node);
  if (node instanceof S_INSTS_LACTION)
	endVisit((S_INSTS_LACTION) node);
  if (node instanceof S_INST_LACTION)
	endVisit((S_INST_LACTION) node);
  if (node instanceof S_INST2_LACTION)
	endVisit((S_INST2_LACTION) node);
  if (node instanceof S_ELSIF_LACTION)
	endVisit((S_ELSIF_LACTION) node);
  if (node instanceof S_WITH_LACTION)
	endVisit((S_WITH_LACTION) node);
  if (node instanceof S_WITHS_LACTION)
	endVisit((S_WITHS_LACTION) node);
  if (node instanceof S_VAR_LACTION)
	endVisit((S_VAR_LACTION) node);
  if (node instanceof S_EXPR_LACTION)
	endVisit((S_EXPR_LACTION) node);
  if (node instanceof S_EXPRTERME_LACTION)
	endVisit((S_EXPRTERME_LACTION) node);
  if (node instanceof S_TERME_LACTION)
	endVisit((S_TERME_LACTION) node);
  if (node instanceof S_EXPRFACTEUR_LACTION)
	endVisit((S_EXPRFACTEUR_LACTION) node);
  if (node instanceof S_FACTEUR_LACTION)
	endVisit((S_FACTEUR_LACTION) node);
  if (node instanceof S_APP_LACTION)
	endVisit((S_APP_LACTION) node);
  if (node instanceof S_APP2_LACTION)
	endVisit((S_APP2_LACTION) node);
  if (node instanceof S_ARGS_LACTION)
	endVisit((S_ARGS_LACTION) node);
  if (node instanceof S_ARGSX_LACTION)
	endVisit((S_ARGSX_LACTION) node);
  if (node instanceof S_EARGS_LACTION)
	endVisit((S_EARGS_LACTION) node);
  if (node instanceof S_EXCEPTION_LACTION)
	endVisit((S_EXCEPTION_LACTION) node);
  if (node instanceof S_LOCALES_LACTION)
	endVisit((S_LOCALES_LACTION) node);
  if (node instanceof S_LOCS_LACTION)
	endVisit((S_LOCS_LACTION) node);
  if (node instanceof S_OPADD_LACTION)
	endVisit((S_OPADD_LACTION) node);
  if (node instanceof S_OPMUL_LACTION)
	endVisit((S_OPMUL_LACTION) node);
  if (node instanceof S_VTYPE_LACTION)
	endVisit((S_VTYPE_LACTION) node);
  if (node instanceof S_TYPE_LACTION)
	endVisit((S_TYPE_LACTION) node);
  if (node instanceof S_TGEN_LACTION)
	endVisit((S_TGEN_LACTION) node);
  if (node instanceof S_XTYPE_LACTION)
	endVisit((S_XTYPE_LACTION) node);
  }
public LACTIONVisitor(){
  }
public boolean visit(S_LACTION_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_LACTION_LACTION node){
}
public boolean visit(S_INSTS_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_INSTS_LACTION node){
}
public boolean visit(S_INST_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_INST_LACTION node){
}
public boolean visit(S_INST2_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_INST2_LACTION node){
}
public boolean visit(S_ELSIF_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_ELSIF_LACTION node){
}
public boolean visit(S_WITH_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_WITH_LACTION node){
}
public boolean visit(S_WITHS_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_WITHS_LACTION node){
}
public boolean visit(S_VAR_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_VAR_LACTION node){
}
public boolean visit(S_EXPR_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_EXPR_LACTION node){
}
public boolean visit(S_EXPRTERME_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_EXPRTERME_LACTION node){
}
public boolean visit(S_TERME_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_TERME_LACTION node){
}
public boolean visit(S_EXPRFACTEUR_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_EXPRFACTEUR_LACTION node){
}
public boolean visit(S_FACTEUR_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_FACTEUR_LACTION node){
}
public boolean visit(S_APP_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_APP_LACTION node){
}
public boolean visit(S_APP2_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_APP2_LACTION node){
}
public boolean visit(S_ARGS_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_ARGS_LACTION node){
}
public boolean visit(S_ARGSX_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_ARGSX_LACTION node){
}
public boolean visit(S_EARGS_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_EARGS_LACTION node){
}
public boolean visit(S_EXCEPTION_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_EXCEPTION_LACTION node){
}
public boolean visit(S_LOCALES_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_LOCALES_LACTION node){
}
public boolean visit(S_LOCS_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_LOCS_LACTION node){
}
public boolean visit(S_OPADD_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_OPADD_LACTION node){
}
public boolean visit(S_OPMUL_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_OPMUL_LACTION node){
}
public boolean visit(S_VTYPE_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_VTYPE_LACTION node){
}
public boolean visit(S_TYPE_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_TYPE_LACTION node){
}
public boolean visit(S_TGEN_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_TGEN_LACTION node){
}
public boolean visit(S_XTYPE_LACTION node ){
  return visitNode(node);
}
public void endVisit(S_XTYPE_LACTION node){
}
public boolean visit(T_LACTION node){
  return false;}
public void endVisit(T_LACTION node){
}
}
