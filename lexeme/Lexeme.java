/**
 *  @author Darío Vázquez | ITCG
 */

package lexeme;

/**
 *  An instance of this class represents a lexeme.
 */
public class Lexeme {
  private String word; // The String representation of a lexeme or token.
  private String type; // Lexeme´s type.

  /**
   *  Constructor.
   *  @param word The value that will be assigned to the token of the lexeme object.
   *  @param type The value that will be assigned to the type of the lexeme object.
   */
  public Lexeme(String word, String type) {
    this.word = word;
    this.type = type;
  }

  /**
   *  Overriding this method, a String value is defined to be returned everytime
   *  that a String representation of the instance is needed.
   */
  @Override
  public String toString() {
    return word+" ---> "+type;
  }

  /**
   *  This method get the token of the instance.
   *  @return Lexeme´s token.
   */
  public String getWord() {
    return word;
  }

  /**
   *  This method get the token of the instance.
   *  @return Lexeme´s type.
   */
  public String getType() {
    return type;
  }

  /**
   *  This method set the token of the instance.
   *  @param word Lexeme´s token.
   */
  public void setWord(String word) {
    this.word = word;
  }

  /**
   *  This method set the lexeme´s type.
   *  @param type Lexeme´s type.
   */
  public void setType(String type) {
    this.type = type;
  }
}
