package lexemes;

import java.util.regex.Pattern;

public class Parenthesis extends Lexeme {
  private static final String TYPE = "Parenthesis";
  private static final String REGEX = "\\(|\\)";

  public Parenthesis(String word) {
    super(word);
  }

  @Override
  public String toString() {
    return word+" ---> "+TYPE;
  }

  public static boolean match(String word) {
    return Pattern.matches(REGEX, word);
  }

  public String getType() {
    return TYPE;
  }
}
