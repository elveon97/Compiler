package automatons;

import java.util.regex.Pattern;

public class Transition implements java.io.Serializable {
  private String regex;
  private Node next;

  public Transition(String regex, Node next) {
    this.regex = regex;
    this.next = next;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public String getRegex() {
    return regex;
  }

  public Node getNext() {
    return next;
  }

  public boolean containsToken(String token) {
    return Pattern.matches(regex, token);
  }
}
