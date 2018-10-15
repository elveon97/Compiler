package analyser;

import java.util.Deque;
import java.util.ArrayDeque;
import io.ErrorHandler;

public class Stack {
  private static Stack stack;
  private static Deque<Tupla> deque;

  private Stack() {
    deque = new ArrayDeque<Tupla>();
  }

  public static Stack getInstance() {
    if (stack == null) stack = new Stack();
    return stack;
  }

  public void push(char e, int row) {
    deque.push(new Tupla(e, row));
  }

  public char peek() {
    return deque.peek().c;
  }

  public Tupla pop() {
    return deque.pop();
  }

  public static boolean isOpening(char c) {
    return c == '{' || c == '(';
  }

  public static boolean isClosing(char c) {
    return c == '}' || c == ')';
  }

  public void remainings() {
    while ( !deque.isEmpty() ) {
      Tupla t = deque.pop();
      ErrorHandler.addError(t.row, 11, ""+t.c);
    }
  }

  public void analyseLine(String line, int row) {
    for (int i=0; i<line.length();i++ ) {
      char c = line.charAt(i);
      if (isOpening(c)) {
        push(c, row);
      } else if (isClosing(c)) {
        checkClosing(c, row);
      }
    }
  }

  public void checkClosing(char c, int row) {
    if ( deque.isEmpty() ) {
      ErrorHandler.addError(row, 12, ""+c);
      return;
    }

    char aux = Character.UNASSIGNED;
    switch (c) {
      case '}':
        aux = '{';
        break;
      case ')':
        aux = '(';
        break;
    }

    Tupla t = deque.pop();
    if ( t.c != aux) {
      ErrorHandler.addError(t.row, 11, ""+(t.c));
    }
  }

  class Tupla {
    char c;
    int row;

    public Tupla(char c, int row) {
      this.c = c;
      this.row = row;
    }
  }
}
