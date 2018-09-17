package io;

import java.util.ArrayList;

public class ErrorHandler {
  private static ArrayList<String> errors;
  private static String[] errorsArr = {"ERROR #1: Incorrect variable declaration",
      "ERROR #2: Variable (VARNAME) is already declared",
      "ERROR #3: Token (VARNAME) is not defined",
      "ERROR #4: Incorrect assignment for (VARNAME)",
      "ERROR #5: Incorrect READ intruction syntax",
      "ERROR #6: Unable to READ variable (VARNAME): its not defined",
      "ERROR #5: Incorrect READ intruction syntax",
      "ERROR #7: Unable to PRINT variable (VARNAME): its not defined",
      "ERROR #8: Unable to PRINT: Number of variables to print does not match "+
      "with String expresion (there must be the same number of %v as variables to print)"};

  private ErrorHandler() {}

  public static void addError(int line, int error, String aux) {
    if (errors == null) errors = new ArrayList<String>();
    String linestr = "(Line "+line+") ";
    switch (error) {
      case 1:
        errors.add(linestr+errorsArr[0]);
        return;
      case 2:
        errors.add(linestr+errorsArr[1].replace("VARNAME", aux));
        return;
      case 3:
        errors.add(linestr+errorsArr[2].replace("VARNAME", aux));
        return;
      case 4:
        errors.add(linestr+errorsArr[3].replace("VARNAME", aux));
        return;
      case 5:
        errors.add(linestr+errorsArr[4]);
        return;
      case 6:
        errors.add(linestr+errorsArr[5].replace("VARNAME", aux));
        return;
      case 7:
        errors.add(linestr+errorsArr[6]);
        return;
      case 8:
        errors.add(linestr+errorsArr[7].replace("VARNAME", aux));
        return;
      case 9:
        errors.add(linestr+errorsArr[8]);
        return;
    }
  }

  public static void printErrors() {
    System.out.println();
    if (errors == null) return;
    for (String i: errors) {
      System.out.println(i);
    }
  }
}
