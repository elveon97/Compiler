/**
 *  @author Darío Vázquez | ITCG
 */

package depurate;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *  This class represents a Line object. It is designed to represent every line
 *  of the file. It has methods to depure the line, and stores every line readed
 *  in a static ArrayList.
 */
public class Line {
  public String line;
  private static ArrayList<Line> lines = new ArrayList<Line>();
  private int index;
  char operators[] = {'+', '-', '/', '*', '>', '<', '=', '{', '}',
                      '(', ')', ','};
  static int globalIndex = 0;

  /**
   *  Constructor.
   *  @param input Line in String form.
   */
  public Line(String input) {
    line = input;
    index = ++globalIndex;
    lines.add(this);
  }

  /**
   *  This method depures the line object, and then returns it.
   *  @return Depured line object.
   */
  public String getDepuredLine() {
    depureLine();
    return line;
  }

  /**
   *  This private method depurates separates the tokens of the line, adding a
   *  blank space before and after every operator (see operators array above).
   *  It also makes sure every token is separated by only one blank space.
   *  After the line fulfills these requirements, the line is considered to be
   *  depured.
   */
  private void depureLine() {
    System.out.println("Depuring line #"+index+"...");

    String words[] = line.split(" ");
    for (int i=0; i<words.length; i++) {
      words[i] = words[i].trim();
    }

    String newLine = "";
    for (String word: words) {
      for (char op: operators) {
        word = word.replace(op+"", " "+op+" ");
      }
      newLine += word+" ";
    }
    newLine = newLine.replace("*  *", "**");
    newLine = newLine.replace("/  /", "//");
    newLine = newLine.replace("=  =", "==");
    newLine = newLine.replace("<  =", "<=");
    newLine = newLine.replace(">  =", ">=");
    newLine = newLine.split("//")[0];
    Scanner scanner = new Scanner(newLine);
    newLine = "";
    while(scanner.hasNext()) {
      newLine += scanner.next()+" ";
    }
    line = newLine.trim();    
  }

  /**
   *  This method returns the list of all the line objects.
   *  @return ArrayList of all line objects.
   */
  public static ArrayList<Line> getLines() {
    return lines;
  }

  /**
   *  This method returns the row of the line, as it was read in the txt file.
   *  @param index Row of the line, as it was read in the file.
   */
  public int getIndex() {
    return index;
  }
}
