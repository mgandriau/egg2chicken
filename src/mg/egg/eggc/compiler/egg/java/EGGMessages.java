package mg.egg.eggc.compiler.egg.java;
import java.util.ResourceBundle;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class EGGMessages extends NLS {
  private static final long serialVersionUID = 1L;
  private static final String BUNDLE_NAME = "mg.egg.eggc.compiler.egg.EGG";
  private EGGMessages() {
  // Do not instantiate
  }
  static {
  NLS.initializeMessages(BUNDLE_NAME, mg.egg.eggc.compiler.egg.java.EGGMessages.class);
  }
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  public static ResourceBundle getResourceBundle() {
  return RESOURCE_BUNDLE;
  }		

  public static  String EGG_global_var_yet_declared;
  public static  String EGG_expected_token;
  public static  String EGG_not_a_non_terminal;
  public static  String EGG_attribute_yet_declared;
  public static  String EGG_no_terminal_attribute;
  public static  String EGG_expected_eof;
  public static  String EGG_space_illegal_here;
  public static  String EGG_axiom_illegal_here;
  public static  String EGG_undefined_actions;
  public static  String EGG_terminal_yet_declared;
  public static  String EGG_attributes_non_initialized;
  public static  String EGG_action_useless;
  public static  String EGG_action_yet_declared;
  public static  String EGG_option_error;
  public static  String EGG_unexpected_token;
  }
