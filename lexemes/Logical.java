package lexemes;

import java.util.regex.Pattern;

public class Logical extends Lexeme {
  private static final String type = "Logical";
  private static final String REGEX = "\\<|\\>|\\<=\\>=\\!=\\&&|\\==|(\\|\\|)";

  public Logical(String word) {
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
