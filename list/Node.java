package list;

class Node {
  private Object element;
  private Node nextNode;
  private int index;

  public Node(Object element) {
    this.element = element;
    nextNode = null;
  }

  public Object getElement() {
    return element;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public int getIndex() {
    return index;
  }

  void setIndex(int index) {
    this.index = index;
  }

  public void setElement(Object element) {
    this.element = element;
  }

  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }
}
