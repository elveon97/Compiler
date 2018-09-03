package lexemes;

public class Reserved extends Lexeme {
  private static final String TYPE = "Reserved";
  static final String[] REGEX = {"DE", "HASTA", "MIENTRAS", "SI", "CONTRARIO",
                                 "IMPRIMIR"};

  public Reserved(String word) {
    super(word);
  }

  public static boolean match(String word) {
    for (String aux: REGEX)
      if (aux.equals(word)) return true;
    return false;
  }

  @Override
  public String toString() {
    return word+" ---> "+TYPE;
  }

  public String getType() {
    return TYPE;
  }
}
