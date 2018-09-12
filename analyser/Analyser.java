/**
 *  @author Darío Vázquez | ITCG
 */

package analyser;

import depurate.Line;
import lexeme.Lexeme;
import lexeme.LexemeTable;
import lexeme.LexemeFactory;
import lexeme.VariablesTable;
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
    String arr[] = line.getDepuredLine().split(" ");

    for (String i: arr) {
      Lexeme lexeme = LexemeFactory.getLexeme(i);
      System.out.println(lexeme);
      LexemeTable.getInstance().addLexeme(line.getIndex(), lexeme);
    }

    String path;
    Automaton automaton;
    // DECLARATION
    switch (arr[0]) {
      case "INT":
        System.out.println("Checking Integer declaration...");
        path = "automatons/serialized/DeclarationInt.ser";
        checkDeclaration(path, arr, line.getIndex());
        return;
      case "REAL":
        System.out.println("Checking Real declaration...");
        path = "automatons/serialized/DeclarationReal.ser";
        checkDeclaration(path, arr, line.getIndex());
        return;
      case "BOOLEAN":
        System.out.println("Checking Boolean declaration...");
        path = "automatons/serialized/DeclarationBoolean.ser";
        checkDeclaration(path, arr, line.getIndex());
        return;
      case "STRING":
        System.out.println("Checking String declaration...");
        path = "automatons/serialized/DeclarationString.ser";
        checkDeclaration(path, arr, line.getIndex());
        return;
      case "CHAR":
        System.out.println("Checking String declaration...");
        path = "automatons/serialized/DeclarationChar.ser";
        checkDeclaration(path, arr, line.getIndex());
        return;
    }

    // ASSIGNMENT
    if (lexeme.Matcher.match(arr[0], "VARIABLE")) {
      if(VariablesTable.variableExists(arr[0])) {
        switch (VariablesTable.getVariableType(arr[0])) {
          case "INT":
            path = "automatons/serialized/AssignationInt.ser";
            checkAssignation(path, arr, line.getIndex());
            break;
          case "REAL":
            path = "automatons/serialized/AssignationReal.ser";
            checkAssignation(path, arr, line.getIndex());
            break;
          case "BOOLEAN":
            path = "automatons/serialized/AssignationBoolean.ser";
            checkAssignation(path, arr, line.getIndex());
            break;
          case "STRING":
            path = "automatons/serialized/AssignationString.ser";
            checkAssignation(path, arr, line.getIndex());
            break;
          case "CHAR":
            path = "automatons/serialized/AssignationChar.ser";
            checkAssignation(path, arr, line.getIndex());
            break;
        }
      } else {
        ErrorHandler.addError(line.getIndex(), 3, arr[0]);
      }
    }
  }

  private static void checkDeclaration(String path, String[] arr, int line) {
    Automaton automaton = (Automaton) Deserializer.deserializeObject(path);
    if (automaton.evaluate(arr)) {
      System.out.println("CORRECT DECLARATION");
      if (VariablesTable.variableExists(arr[0])) {
        ErrorHandler.addError(line, 2, arr[0]);
        return;
      }
      VariablesTable.getInstance().addVariables(arr, line);
    }
    else  {
      System.out.println("INCORRECT DECLARATION");
      ErrorHandler.addError(line, 1, arr[0]);
    }
  }

  private static void checkAssignation(String path, String[] arr, int line) {
    Automaton automaton = (Automaton) Deserializer.deserializeObject(path);
    if (automaton.evaluate(arr)) {
      System.out.println("CORRECT ASSIGNMENT");
      VariablesTable.setValue(arr[0], arr[2]);
    }
    else  {
      System.out.println("INCORRECT DECLARATION");
      ErrorHandler.addError(line, 4, arr[0]);
    }
  }
}
