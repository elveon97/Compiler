package testing;

class LineTester {
  public static void main(String[] args) {
    String input = "";
    for (String word: args) {
      input += word+" ";
    }
    input.trim();

    Line line = new Line(input);
    System.out.println(line.getDepuredLine());
  }
}
