package lexemes;

import java.util.regex.Pattern;

public class Braces extends Lexeme {
  private static final String type = "Braces";
  private static final String REGEX = "\\{|\\}";

  public Braces(String word) {
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
