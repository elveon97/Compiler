package lexemes;

import java.util.regex.Pattern;

public class Assignment extends Lexeme {
  private static final String type = "Assignment";
  private static final String REGEX = "\\=";

  public Assignment(String word) {
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