package lexemes;

import java.util.regex.Pattern;

public class Arithmetic extends Lexeme {
  private static final String TYPE = "Arithmetic";
  private static final String REGEX = "\\+|\\-|\\*|\\/";

  public Arithmetic(String word) {
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
