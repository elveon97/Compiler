/**
 *  @author Darío Vázquez | ITCG
 */

package analyser;

import depurate.Line;
import lexeme.Lexeme;
import lexeme.LexemeTable;
import lexeme.LexemeFactory;
import lexeme.VariablesTable;
import lexeme.Matcher;
import automatons.Automaton;
import io.serialization.Deserializer;
import io.ErrorHandler;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  This class represents the analyser of the lexems, it contains a static method
 *  which job is to analyse the lexems containeds in a line.
 */
public class Analyser {

  /**
   *  This method receives a line object and analyses the lexemes in it. The
   *  lexemes are then added to the lexeme table.
   *  @param line Line onject to analyse
   */
  public static void Analyse(Line line) {
    String depuredLine = line.getDepuredLine();
    int row = line.getIndex();
    String arr[] = depuredLine.split(" ");

    System.out.print("\nANALYSING: ");
    for (String i: arr) {
      System.out.print(i+" ");
    }
    System.out.println();

    Stack.getInstance().analyseLine(depuredLine, row);
    for (String i: arr) {
      Lexeme lexeme = LexemeFactory.getLexeme(i);
      System.out.println(lexeme);
      LexemeTable.getInstance().addLexeme(row, lexeme);
    }

    String path;
    Automaton automaton;
    // DECLARATION
    if (Matcher.match(arr[0], "VARTYPES")) {
      switch (arr[0]) {
        case "INT":
          System.out.println("Checking Integer declaration...");
          path = "automatons/serialized/DeclarationInt.ser";
          if (checkDeclaration(path, arr, row)) {
            analizeInt(arr, row);
          }
          return;
        case "REAL":
          System.out.println("Checking Real declaration...");
          path = "automatons/serialized/DeclarationReal.ser";
          if (checkDeclaration(path, arr, row)) {
            analizeReal(arr, row);
          }
          return;
        case "BOOLEAN":
          System.out.println("Checking Boolean declaration...");
          path = "automatons/serialized/DeclarationBoolean.ser";
          checkDeclaration(path, arr, row);
          return;
        case "STRING":
          System.out.println("Checking String declaration...");
          path = "automatons/serialized/DeclarationString.ser";
          checkDeclaration(path, arr, row);
          return;
        case "CHAR":
          System.out.println("Checking String declaration...");
          path = "automatons/serialized/DeclarationChar.ser";
          checkDeclaration(path, arr, row);
          return;
      }
    }


    // RESERVED
    if (Matcher.match(arr[0], "RESERVED")) {
      switch(arr[0]) {
        case "READ":
          System.out.println("Checking READ...");
          path = "automatons/serialized/Read.ser";
          if (checkRead(path, arr, row)) {
            if (VariablesTable.getInstance().variableExists(arr[1])) {
              // AQUI SE LEE LA VARIABLE
            } else {
              ErrorHandler.addError(row, 6, arr[1]);
            }
          }
          return;
        case "PRINT":
          System.out.println("Checking PRINT...");
          path = "automatons/serialized/Print.ser";
          if (checkPrint(path, arr, row)) {
            // ANALIZAR EXPRESION DE PRINT
            analysePrint(arr, row);
          }
          return;
      }
    }

    // ASSIGNMENT
    if (lexeme.Matcher.match(arr[0], "VARIABLE")) {
      if(VariablesTable.getInstance().variableExists(arr[0])) {
        switch (VariablesTable.getInstance().getVariableType(arr[0])) {
          case "INT":
            path = "automatons/serialized/AssignationInt.ser";
            checkAssignation(path, arr, row);
            break;
          case "REAL":
            path = "automatons/serialized/AssignationReal.ser";
            checkAssignation(path, arr, row);
            break;
          case "BOOLEAN":
            path = "automatons/serialized/AssignationBoolean.ser";
            checkAssignation(path, arr, row);
            break;
          case "STRING":
            path = "automatons/serialized/AssignationString.ser";
            checkAssignation(path, arr, row);
            break;
          case "CHAR":
            path = "automatons/serialized/AssignationChar.ser";
            checkAssignation(path, arr, row);
            break;
        }
      } else {
        ErrorHandler.addError(row, 3, arr[0]);
      }
    }
  }

  private static boolean checkDeclaration(String path, String[] arr, int line) {
    Automaton automaton = (Automaton) Deserializer.deserializeObject(path);
    if (automaton.evaluate(arr)) {
      System.out.println("CORRECT DECLARATION");
      if (VariablesTable.getInstance().variableExists(arr[0])) {
        ErrorHandler.addError(line, 2, arr[0]);
        return true;
      }
      VariablesTable.getInstance().addVariables(arr, line);
      return true;
    }
    else  {
      System.out.println("INCORRECT DECLARATION");
      ErrorHandler.addError(line, 1, arr[0]);
      return false;
    }
  }

  private static void checkAssignation(String path, String[] arr, int line) {
    Automaton automaton = (Automaton) Deserializer.deserializeObject(path);
    if (automaton.evaluate(arr)) {
      if (VariablesTable.getInstance().getVariableType(arr[0]).equals("INT")) {
        if (Integer.parseInt(arr[2])<-32_768 || Integer.parseInt(arr[2])>32_767) {
          ErrorHandler.addError(line, 10, arr[0]);
          return;
        }
      }
      if (VariablesTable.getInstance().getVariableType(arr[0]).equals("REAL")) {
        if (Double.parseDouble(arr[2])<-32_768 || Double.parseDouble(arr[2])>32_767) {
          ErrorHandler.addError(line, 10, arr[0]);
          return;
        }
      }
      System.out.println("CORRECT ASSIGNMENT");
      VariablesTable.getInstance().setValue(arr[0], arr[2]);
    }
    else  {
      System.out.println("INCORRECT DECLARATION");
      ErrorHandler.addError(line, 4, arr[0]);
    }
  }

  private static boolean checkRead(String path, String[] arr, int line) {
    Automaton automaton = (Automaton) Deserializer.deserializeObject(path);
    if (automaton.evaluate(arr)) {
      System.out.println("CORRECT READ SYNTAX");
      return true;
    }
    else  {
      System.out.println("INCORRECT READ SYNTAX");
      ErrorHandler.addError(line, 5, "");
      return false;
    }
  }

  private static boolean checkPrint(String path, String[] arr, int line) {
    Automaton automaton = (Automaton) Deserializer.deserializeObject(path);
    if (automaton.evaluate(arr)) {
      System.out.println("CORRECT PRINT SYNTAX");
      return true;
    }
    else  {
      System.out.println("INCORRECT PRINT SYNTAX");
      ErrorHandler.addError(line, 7, "");
      return false;
    }
  }

  private static void analysePrint(String[] arr, int line) {
    if (arr.length == 4) { // PRINT (X)
      if (Matcher.match(arr[2], "STRING")) return;
      if (!VariablesTable.variableExists(arr[2])) {
        ErrorHandler.addError(line, 8, arr[2]);
      }
    } else { // PRINT ( $CAD$, Var1, var2, ... , varN)
      // PRINT ( CAD , VAR1 , var2 )
      int noVariables = arr.length/2-2;
      int variablesInString = arr[2].split("%v").length-1;
      if (noVariables != variablesInString) {
        ErrorHandler.addError(line, 9, "");
        return;
      }

      for (int i=4; i<arr.length; i+=2) {
        if (!VariablesTable.getInstance().variableExists(arr[i])) {
          ErrorHandler.addError(line, 8, arr[i]);
        }
      }
    }
  }

  private static void analizeInt(String[] arr, int line) {
    for (int i = 3; i<arr.length; i++) {
      if (!Matcher.match(arr[i], "INTEGER")) continue;
      int aux = Integer.parseInt(arr[i]);
      if (aux < -32_768 || aux > 32_767) {
        ErrorHandler.addError(line, 10, arr[i-2]);
        return;
      }
    }
  }

  private static void analizeReal(String[] arr, int line) {
    for (int i = 3; i<arr.length; i++) {
      if (!Matcher.match(arr[i], "REAL")) continue;
      double aux = Double.parseDouble(arr[i]);
      if (aux < -32_768.0 || aux > 32_767.0) {
        ErrorHandler.addError(line, 10, arr[i-2]);
        return;
      }
    }
  }
}
