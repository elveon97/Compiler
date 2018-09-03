package lexemes;

import java.util.regex.Pattern;

public class Variable extends Lexeme {
  private static final String TYPE = "Variable";
  private static final String REGEX = "[a-z|A-Z]{1}[a-z|A-Z|0-9|\\_|\\-]*";

  public Variable(String word) {
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
