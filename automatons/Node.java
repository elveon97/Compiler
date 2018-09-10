package automatons;

public class Node implements java.io.Serializable {
  private boolean state;
  private Transition transitions[];

  public Node(boolean state, Transition[] transitions) {
    this.state = state;
    this.transitions = transitions;
  }

  public boolean getState() {
    return state;
  }

  public void setTransitions(Transition[] transitions) {
    this.transitions = transitions;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public Transition[] getTransitions() {
    return transitions;
  }

  public Node nextNode(String token) {
    if (this.transitions == null) return null;
    for (Transition i: transitions) {
      System.out.println("TOKEN: "+token);
      System.out.println("NEXT: "+i.getNext());
      if(i.containsToken(token)) return i.getNext();
    }
    return null;
  }
}
