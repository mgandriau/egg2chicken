package mg.egg.eggc.compiler.egg.java;
import java.util.ResourceBundle;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class LACTIONMessages extends NLS {
  private static final long serialVersionUID = 1L;
  private static final String BUNDLE_NAME = "mg.egg.eggc.compiler.egg.LACTION";
  private LACTIONMessages() {
  // Do not instantiate
  }
  static {
  NLS.initializeMessages(BUNDLE_NAME, mg.egg.eggc.compiler.egg.java.LACTIONMessages.class);
  }
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  public static ResourceBundle getResourceBundle() {
  return RESOURCE_BUNDLE;
  }		

  public static  String LACTION_local_yet_declared;
  public static  String LACTION_var_non_initialized;
  public static  String LACTION_not_a_var;
  public static  String LACTION_expected_eof;
  public static  String LACTION_var_illegal_access;
  public static  String LACTION_expected_token;
  public static  String LACTION_not_an_attribute;
  public static  String LACTION_unexpected_token;
  }
