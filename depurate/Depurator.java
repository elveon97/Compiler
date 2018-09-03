/**
 *  @author Darío Vázquez | ITCG
 */

package depurate;

import java.util.ArrayList;


/**
 *  This class has the methods necessaries to depurate a plain text file and
 *  convert to a depurated .vz file.
 */
public class Depurator {

  /**
   *  This method receives the name of the text file to depurate and returns a
   *  boolean value depending on the succes or failure of the depuration process.
   *  @param name The name of the txt file to depurate.
   *  @return True = depuration succesfull. False = depuration failed.
   */
  public static boolean depurate(String name) {
    System.out.println("Initializing depuration process...");

    ArrayList<String> input = io.Reader.getLines(name);
    ArrayList<String> output = new ArrayList<String>();
    Line line;

    if (input == null) return false;

    for (String aux: input) {
      line = new Line(aux);
      output.add(line.getDepuredLine());
    }

    name = name.substring(0, name.length()-4);
    io.Writer.writeFile(output, name+".vz");

    System.out.println("Depuration process ended succesfully");
    return true;
  }
}
