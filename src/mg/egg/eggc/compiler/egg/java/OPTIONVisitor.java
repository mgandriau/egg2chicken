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
public class OPTIONVisitor implements IDstVisitor {
protected boolean visitNode(IDstNode node){
  return true;}
public boolean visit(IDstNode node){
  if (node instanceof S_O_OPTION)
	return visit((S_O_OPTION) node);
  if (node instanceof S_BOOL_OPTION)
	return visit((S_BOOL_OPTION) node);
  if (node instanceof T_OPTION)
	return visit((T_OPTION) node);
  return false;
}
public void endVisit(IDstNode node){
  if (node instanceof S_O_OPTION)
	endVisit((S_O_OPTION) node);
  if (node instanceof S_BOOL_OPTION)
	endVisit((S_BOOL_OPTION) node);
  }
public OPTIONVisitor(){
  }
public boolean visit(S_O_OPTION node ){
  return visitNode(node);
}
public void endVisit(S_O_OPTION node){
}
public boolean visit(S_BOOL_OPTION node ){
  return visitNode(node);
}
public void endVisit(S_BOOL_OPTION node){
}
public boolean visit(T_OPTION node){
  return false;}
public void endVisit(T_OPTION node){
}
}
