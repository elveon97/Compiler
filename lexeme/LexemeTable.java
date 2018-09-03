package lexeme;

import java.util.ArrayList;

public class LexemeTable {
  private ArrayList<Register> lexemes;
  private static LexemeTable table;

  private LexemeTable() {
    lexemes = new ArrayList<Register>();
  }

  public static LexemeTable getInstance() {
    if (table == null) table = new LexemeTable();
    return table;
  }

  public void addLexeme(int row, Lexeme lexeme) {
    lexemes.add(new Register(row, lexeme));
  }

  public ArrayList<Register> getLexemes() {
    return lexemes;
  }

  public void printLexemes() {
    for (Register lexeme: lexemes) System.out.println(lexeme);
  }

  public void printTable() {
    System.out.println("     ____________________________________________________________");
    System.out.println("    |       TYPE      |                  LEXEME                  |");
    System.out.println("[R ]|-----------------|------------------------------------------|");
    for (Register reg: lexemes ) System.out.println(reg);
    System.out.println("    |_________________|__________________________________________|");
  }

  class Register {
    private int row;
    private Lexeme lexeme;

    @Override
    public String toString() {
      String aux = "["+(row<10?row+" ":row)+"]|"+lexeme.getType();
      while (aux.length()<22) aux += " ";
      aux += "|"+lexeme.getWord();
      while (aux.length()<65) aux += " ";
      aux += "|";
      return aux;
    }

    public Register(int row, Lexeme lexeme) {
      this.row = row;
      this.lexeme = lexeme;
    }

    public Lexeme getLexeme() {
      return this.lexeme;
    }

    public int getRow() {
      return this.row;
    }
  }

}
