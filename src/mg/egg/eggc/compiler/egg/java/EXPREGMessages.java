package mg.egg.eggc.compiler.egg.java;
import java.util.ResourceBundle;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class EXPREGMessages extends NLS {
  private static final long serialVersionUID = 1L;
  private static final String BUNDLE_NAME = "mg.egg.eggc.compiler.egg.EXPREG";
  private EXPREGMessages() {
  // Do not instantiate
  }
  static {
  NLS.initializeMessages(BUNDLE_NAME, mg.egg.eggc.compiler.egg.java.EXPREGMessages.class);
  }
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  public static ResourceBundle getResourceBundle() {
  return RESOURCE_BUNDLE;
  }		

  public static  String EXPREG_expected_eof;
  public static  String EXPREG_unexpected_token;
  public static  String EXPREG_not_a_macro;
  public static  String EXPREG_symbol_unknown;
  public static  String EXPREG_expected_token;
  }
