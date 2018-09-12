package lexeme;

import java.util.ArrayList;
import io.ErrorHandler;

public class VariablesTable {
  private ArrayList<Register> variables;
  private static VariablesTable table;
  private static int count = 0;

  private VariablesTable() {
    variables = new ArrayList<Register>();
  }

  public static VariablesTable getInstance() {
    if (table == null) table = new VariablesTable();
    return table;
  }

  public static boolean variableExists(String name) {
    for (Register r: getInstance().variables) {
      if (r.getName().equals(name)) return true;
    }
    return false;
  }

  public static void setValue(String name, String value) {
    for (Register r: getInstance().variables) {
      if (r.getName().equals(name)) r.setValue(value);
    }
  }

  public static String getVariableType(String name) {
    for (Register r: getInstance().variables) {
      if (r.getName().equals(name)) return r.getType();
    }
    return null;
  }

  public void addVariables(String arr[], int index) {
    String type = arr[0];
    System.out.println(type);

    String aux = "";
    for (int i=1; i<arr.length; i++) {
      aux += arr[i]+" ";
    }
    aux = aux.trim();
    System.out.println(aux);

    String vars[] = aux.split(",");
    for (String i: vars) {
      i = i.trim();
      System.out.println(i);
      String arrAux[] = i.split("=");
      if (variableExists(arrAux[0])) {
        ErrorHandler.addError(index, 2, arrAux[0]);
        continue;
      }
      if (arrAux.length == 1) variables.add(new Register(++count, type, arrAux[0].trim(), "", true));
      else variables.add(new Register(++count, type, arrAux[0].trim(), arrAux[1].trim(), false));
    }
  }

  public void printTable() {
    System.out.println(" ____________________________________________________________________________________________________________________");
    System.out.println("| ID  | TYPE         | NAME         | VALUE                                                          | READABLE     |");
    System.out.println("|-----|--------------|--------------|----------------------------------------------------------------|--------------|");
    for (Register r: variables) {
      System.out.println(r);
    }
    System.out.println("|_____|______________|______________|________________________________________________________________|______________|");
  }

  class Register {
    private int id;
    private String type, name, value;
    private boolean readable;

    @Override
    public String toString() {
      String aux = "| "+id;
      while (aux.length()<5) aux += " ";
      aux += " | "+type;
      while (aux.length()<20) aux+= " ";
      aux += " | "+name;
      while (aux.length()<35) aux+= " ";
      aux += " | "+value;
      while (aux.length()<100) aux+= " ";
      aux += " | "+readable;
      while (aux.length()<115) aux+= " ";
      return aux+=" |";
    }

    public Register(int id, String type, String name, String value, Boolean readable) {
      this.id = id;
      this.type = type;
      this.name = name;
      this.value = value;
      this.readable = readable;
    }

    public int getId() {
      return this.id;
    }

    public String getType() {
      return this.type;
    }

    public String getName() {
      return this.name;
    }

    public String getValue() {
      return this.value;
    }

    public Boolean getReadable() {
      return this.readable;
    }

    public void setValue(String value) {
      this.value = value.trim();
      this.readable = false;
    }
  }
}
