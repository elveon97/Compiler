/**
 *  @author Darío Vázquez | ITCG
 */

package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  These class has the methods necessaries to read a file.
 */
public class Reader {

  /**
   *  This private method gets the buffer of the file we are reading.
   *  @param fileName The name of the file to read.
   *  @return BufferedReader instance with the file that is meant to be read.
   */
  private static BufferedReader getBuffer(String fileName) {
    System.out.println("Reading file...");
    try {
      return new BufferedReader(new FileReader(fileName));
    } catch (IOException e) {
      System.out.println("ERROR: unable to read file '"+fileName+"'");
      System.out.println(e);
      return null;
    }
  }


  /**
   *  This method returns an ArrayList with all the lines read from the file.
   *  @param fileName The name of the file meant to be read.
   *  @return ArrayList with the lines of the read file.
   */
  public static ArrayList<String> getLines(String fileName) {
    BufferedReader bf = getBuffer(fileName);
    if (bf == null) return null;

    System.out.println("File read succesfully");

    ArrayList<String> lines = new ArrayList<String>();
    String input;
    depurate.Line line;
    try {
      while ((input = bf.readLine()) != null) {
        input = input.trim();        
        lines.add(input);
      }
      return lines;
    }catch(IOException e) {
      System.out.println("ERROR: Unable to extract the lines from the buffer");
      return null;
    }
  }
}
