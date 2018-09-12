/**
 *  @author Darío Vázquez | ITCG
 */

package lexeme;

/**
 *  This class is used to match the lexeme´s token and create a correct instance
 *  of the Lexeme class according to it.
 */
public class LexemeFactory {

  /**
   *  This method tests the lexeme´s token and returns a Lexeme object when the
   *  token matches with a lexeme´s type Regex (See Matcher class).
   *  @param word Token to be tested
   *  @return Lexeme instance
   */
  public static Lexeme getLexeme(String word) {
    if (Matcher.match(word, "VARTYPES")) return new Lexeme(word, "VARTYPE");
    if (Matcher.match(word, "RESERVED")) return new Lexeme(word, "RESERVED");
    if (Matcher.match(word, "INTEGER")) return new Lexeme(word, "INTEGER");
    if (Matcher.match(word, "REAL")) return new Lexeme(word, "REAL");
    if (Matcher.match(word, "STRING")) return new Lexeme(word, "STRING");
    if (Matcher.match(word, "ARITHMETIC")) return new Lexeme(word, "ARITHMETIC");
    if (Matcher.match(word, "ASSIGNMENT")) return new Lexeme(word, "ASSIGNMENT");
    if (Matcher.match(word, "PARENTHESIS")) return new Lexeme(word, "PARENTHESIS");
    if (Matcher.match(word, "BRACES")) return new Lexeme(word, "BRACES");
    if (Matcher.match(word, "LOGICAL")) return new Lexeme(word, "LOGICAL");
    if (Matcher.match(word, "CHAR")) return new Lexeme(word, "CHAR");
    if (Matcher.match(word, "BOOLEAN")) return new Lexeme(word, "BOOLEAN");
    if (Matcher.match(word, "VARIABLE")) return new Lexeme(word, "VARIABLE");
    return new Lexeme(word, "ERROR");
  }
}
