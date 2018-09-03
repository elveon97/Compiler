/**
 *  @author Darío Vázquez | ITCG
 */

package analyser;

import depurate.Line;
import lexeme.Lexeme;
import lexeme.LexemeTable;
import lexeme.LexemeFactory;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  This class represents the analyser of the lexems, it contains a static method
 *  which job is to analyse the lexems containeds in a line.
 */
public class Analyser {

  /**
   *  This method receives a line object and analyses the lexemes in it. The
   *  lexemes are then added to the lexeme table.
   *  @param line Line onject to analyse
   */
  public static void Analyse(Line line) {
    String arr[] = line.getDepuredLine().split(" ");

    for (String i: arr) {
      Lexeme lexeme = LexemeFactory.getLexeme(i);
      LexemeTable.getInstance().addLexeme(line.getIndex(), lexeme);
    }
  }
}
