package automatons;

public class Automaton implements java.io.Serializable {
  private Node initialNode;

  public Automaton(Node initialNode) {
    this.initialNode = initialNode;
  }

  public Node getInitial() {
    return initialNode;
  }

  public void setInitialNode(Node initialNode) {
    this.initialNode = initialNode;
  }

  public boolean evaluate(String tokens[]) {
    Node node = initialNode.nextNode(tokens[0]);
    if (node == null) return false;
    int i=1;
    while((node = node.nextNode(tokens[i++]))!=null&&i<tokens.length);
    return node==null?false:node.getState();
  }
}
