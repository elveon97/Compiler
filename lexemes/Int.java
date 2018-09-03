package lexemes;

import java.util.regex.Pattern;

public class Int extends Lexeme {
  private static final String type = "Integer";
  private static final String REGEX = "[0-9]+?";

  public Int(String word) {
    super(word);
  }

  @Override
  public String toString() {
    return word+" ---> "+type;
  }

  public static boolean match(String word) {
    return Pattern.matches(REGEX, word);
  }

  public String getType() {
    return type;
  }
}
