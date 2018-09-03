/**
 *  @author Darío Vázquez | ITCG
 */

package io;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;

/**
 *  This class has the methods necessaries to write a file. Its configured to
 *  to write a file with the extension .vz
 */
public class Writer {

  /**
   *  This method writes a .vz file with the lines of the ArrayList passed to it.
   *  @param lines ArrayList of the lines that the file will contain.
   *  @return True = File writing successful. False = File writing failed.
   */
  public static boolean writeFile(java.util.ArrayList<String> lines, String name) {
    System.out.println("Overwriting file...");
    try {
      if(Files.exists(Paths.get(name))) Files.delete(Paths.get(name));
    } catch(IOException e) {
      System.out.println("ERROR: Something went wrong while trying to "
                        + "overwrite '"+name+"'");
      return false;
    }

    try {
      System.out.println("Initializing writer...");
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(name, true)));
      for (String line: lines) {
        pw.println(line);
      }
      System.out.println("Closing writer...");
      pw.close();
      System.out.println("File writing succesful");
      return true;
    } catch(IOException e) {
      System.out.println("ERROR: Something went wrong while writing file '"+name+"'");
      return false;
    }
  }
}
