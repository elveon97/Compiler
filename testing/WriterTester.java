package testing;

import java.util.ArrayList;

class WriterTester {
  public static void main(String[] args) {
    ArrayList<String> lines = new ArrayList<String>();
    String aux[] = {"Primera linea", " ", "1346578", "Linea final"};
    for (String line: aux) lines.add(line);

    io.Writer.writeFile(lines, "testing/writerTests/"+args[0]);
  }
}
