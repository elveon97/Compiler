import java.util.TreeMap;
import java.util.Map;
import lexemes.*;

class lol {
  public static void main(String[] args) {
    LexemeTable table = LexemeTable.getInstance();
    System.out.println(new Reserved("l").getType());
    table.addLexeme(1, new Reserved("lola"));
    table.addLexeme(1, new Real("loasdadla"));
    table.addLexeme(3, new Real("lola"));
    //table.addLexeme(2, new Logical("486547879787"));
    //table.addLexeme(1, new Logical("48654787"));
    table.printTable();
  }
}
