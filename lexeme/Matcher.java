package lexeme;

import java.util.regex.Pattern;

public class Matcher {
  public final static String RESERVED = "FROM|TO|IF|ELSE|PRINT|READ";
  public final static String INTEGER = "[0-9]+?";
  public final static String REAL = "([\\d]+?)|([\\d]+?\\.[\\d]+?)";
  public final static String VARIABLE = "[a-z|A-Z]{1}[a-z|A-Z|0-9|\\_|\\-]*";
  public final static String ARITHMETIC = "\\+|\\-|\\*|\\/";
  public final static String ASSIGNMENT = "\\=";
  public final static String PARENTHESIS = "\\(|\\)";
  public final static String BRACES = "\\{|\\}";
  public final static String LOGICAL = "\\<|\\>|\\<=\\>=\\!=\\&&|\\==|(\\|\\|)|,";
  public final static String STRING = "\\$[^\\\"]*\\$";
  public final static String VARTYPES = "INT|STRING|REAL|BOOLEAN|CHAR";
  public final static String BOOLEAN = "TRUE|FALSE";
  public final static String CHAR = "\\'[^\\\"]{1}\\'";

  public static boolean match(String word, String regex) {
    return Pattern.matches(getRegex(regex), word);
  }

  private static String getRegex(String cad) {
    switch (cad.toUpperCase()) {
      case "INTEGER": return INTEGER;
      case "REAL": return REAL;
      case "VARIABLE": return VARIABLE;
      case "ARITHMETIC": return ARITHMETIC;
      case "ASSIGNMENT": return ASSIGNMENT;
      case "PARENTHESIS": return PARENTHESIS;
      case "BRACES": return BRACES;
      case "LOGICAL": return LOGICAL;
      case "STRING": return STRING;
      case "VARTYPES": return VARTYPES;
      case "CHAR": return CHAR;
      case "BOOLEAN": return BOOLEAN;
      case "RESERVED": return RESERVED;
    }
    return null;
  }
}
