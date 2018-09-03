package lexemes;

public abstract class Lexeme {
  String word;

  protected Lexeme(String word) {
    this.word = word;
  }

  public abstract String getType();

  public String getWord() {
    return word;
  }
}
