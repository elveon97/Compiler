package lexemes;

import java.util.regex.Pattern;

public class Real extends Lexeme {
  private static final String TYPE = "Real";
  private static final String REGEX = "([\\d]+?)|([\\d]+?\\.[\\d]+?)";

  public Real(String word) {
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
