package lexeme;

import java.util.regex.Pattern;

class Matcher {
  final static String RESERVED[] = {"DE", "HASTA", "MIENTRAS", "SI",
                                    "CONTRARIO", "IMPRIMIR"};
  final static String INTEGER = "[0-9]+?";
  final static String REAL = "([\\d]+?)|([\\d]+?\\.[\\d]+?)";
  final static String VARIABLE = "[a-z|A-Z]{1}[a-z|A-Z|0-9|\\_|\\-]*";
  final static String ARITHMETIC = "\\+|\\-|\\*|\\/";
  final static String ASSIGNMENT = "\\=";
  final static String PARENTHESIS = "\\(|\\)";
  final static String BRACES = "\\{|\\}";
  final static String LOGICAL = "\\<|\\>|\\<=\\>=\\!=\\&&|\\==|(\\|\\|)";
  final static String STRING = "\\\"[^\\\"]*\\\"";  

  public static boolean match(String word, String regex) {
    if (regex.equalsIgnoreCase("RESERVED")) {
      for (String reserved : RESERVED) {
        if (word.equals(reserved)) return true;
      }
      return false;
    }
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
    }
    return null;
  }
}
