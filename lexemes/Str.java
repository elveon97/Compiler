package lexemes;

import java.util.regex.Pattern;

public class Str extends Lexeme {
  private static final String TYPE = "String";
  private static final String REGEX = "\\\"[^\\\"]*\\\"";

  public Str(String word) {
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
