import java.util.ArrayList;
import io.Reader;
import io.Writer;
import depurate.Depurator;
import depurate.Line;
import analyser.Analyser;
import lexeme.LexemeTable;

class Compile {
  public static void main(String[] args) {
    compile(args[0]);
  }

  public static void compile(String name) {
    Depurator.depurate(name);

    ArrayList<Line> lines = Line.getLines();
    for (Line line: lines) {
      Analyser.Analyse(line);
    }

    LexemeTable.getInstance().printTable();
  }
}
