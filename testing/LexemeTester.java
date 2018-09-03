package testing;

class LexemeTester {
  public static void main(String[] args) {
    System.out.println(new lexemes.Integer(args[0]));
    System.out.println(lexemes.Integer.match(args[0]));
  }
}
