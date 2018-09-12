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
  public String line, depuredLine;
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
    depureLine();
    lines.add(this);
  }

  /**
   *  This method depures the line object, and then returns it.
   *  @return Depured line object.
   */
  public String getDepuredLine() {
    return depuredLine;
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

    String aux = line;
    String stringLit[] = getStringLiterals(aux);
    if (stringLit != null) {
      for (String i: stringLit) {
        String token = i.replace(" ", "#SPC");
        aux = aux.replace(i, token);
      }
    }

    String words[] = aux.split(" ");
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
    depuredLine = newLine.trim();
  }

  private static String[] getStringLiterals(String cad) {
    boolean ban = false;
    String aux = "";

    ArrayList<String> list = new ArrayList<String>();
    for (int i=0; i<cad.length(); i++) {
      if (cad.charAt(i)=='$') {
        if (ban) {
          ban = false;
          list.add(aux);
          aux = "";
        } else {
          ban = true;
          continue;
        }
      }
      if (ban) aux += cad.charAt(i);
    }

    if (list.size() == 0) return null;

    String arr[] = new String[list.size()];
    for (int i=0; i<arr.length; i++) {
      arr[i] = list.get(i);
    }
    return arr;
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
