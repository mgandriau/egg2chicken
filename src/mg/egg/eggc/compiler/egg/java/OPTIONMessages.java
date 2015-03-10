package mg.egg.eggc.compiler.egg.java;
import java.util.ResourceBundle;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class OPTIONMessages extends NLS {
  private static final long serialVersionUID = 1L;
  private static final String BUNDLE_NAME = "mg.egg.eggc.compiler.egg.OPTION";
  private OPTIONMessages() {
  // Do not instantiate
  }
  static {
  NLS.initializeMessages(BUNDLE_NAME, mg.egg.eggc.compiler.egg.java.OPTIONMessages.class);
  }
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  public static ResourceBundle getResourceBundle() {
  return RESOURCE_BUNDLE;
  }		

  public static  String OPTION_unexpected_token;
  public static  String OPTION_expected_token;
  public static  String OPTION_expected_eof;
  }
