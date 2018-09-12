package list;

class Test {
  public static void main(String[] args) {
    List list = new List();

    for (int i=0; i<10; i++) {
      list.add(i);
    }

    Object arr[] = list.toArray();

    for (Object obj: arr) {
      System.out.println((int)obj);
    }
  }
}
