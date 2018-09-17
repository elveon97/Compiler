import java.util.ArrayList;
import io.Reader;
import io.Writer;
import io.ErrorHandler;
import depurate.Depurator;
import depurate.Line;
import analyser.Analyser;
import lexeme.LexemeTable;
import lexeme.VariablesTable;

class Compile {
  public static void main(String[] args) {
    compile(args[0]);
  }

  public static void compile(String name) {
    Depurator.depurate(name);

    ArrayList<Line> lines = Line.getLines();

    System.out.println("\nLINEAS A COMPILAR");
    for (Line ln: lines) {
      System.out.println(ln.getDepuredLine());
    }
    System.out.println();

    for (Line line: lines) {
      Analyser.Analyse(line);
      System.out.println();
    }

    LexemeTable.getInstance().printTable();
    VariablesTable.getInstance().printTable();
    ErrorHandler.printErrors();    
  }
}
