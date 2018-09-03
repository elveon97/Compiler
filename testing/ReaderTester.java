package testing;

import java.util.ArrayList;

class ReaderTester {
  public static void main(String[] args) {
    ArrayList<String> lines = io.Reader.getLines(args[0]);
    for (String line: lines) {
      System.out.println(line);
    }
  }
}
