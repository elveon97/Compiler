package lexemes;

public class LexemeError extends Lexeme {
  private static final String type = "ERROR";

  public LexemeError(String word) {
    super(word);
  }

  @Override
  public String toString() {
    return word+" ---> "+type;
  }

  public String getType() {
    return type;
  }
}
