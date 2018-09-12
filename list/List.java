package list;

public class List {
  private Node initialNode = null;
  private int numberNodes = 0;

  public List() {}

  public void clear() {
    initialNode = null;
    numberNodes = 0;
  }

  public boolean add(Object element) {
    Node n;
    if (initialNode == null) {
      n = new Node(element);
      n.setIndex(numberNodes++);
      initialNode = n;
      return true;
    }

    n = getNode(numberNodes-1); // Get last node
    Node n2 = new Node(element);
    n2.setIndex(numberNodes++);
    n.setNextNode(n2);
    return true;
  }

  public Node getNode(int index) {
    Node n = initialNode;
    while (n.getIndex()!=index&&index<numberNodes) n = n.getNextNode();
    return n;
  }

  public Object getElement(int index) {
    return getNode(index).getElement();
  }

  public Object[] toArray() {
    Object obj[] = new Object[getNumberNodes()];
    for (int i=0; i<obj.length; i++) {
      obj[i] = getElement(i);
    }
    return obj;
  }

  public int getNumberNodes() {
    return numberNodes;
  }
}
