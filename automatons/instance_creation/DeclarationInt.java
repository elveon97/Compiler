package automatons.instance_creation;

import automatons.*;

public class DeclarationInt {
  public static void main(String[] args) {
    Node n1 = new Node(false, null);
    Node n2 = new Node(false, null);
    Node n3 = new Node(true, null);
    Node n4 = new Node(false, null);

    Transition t1 = new Transition("INT", n2);
    Transition t2 = new Transition(lexeme.Matcher.VARIABLE, n3);
    Transition t3 = new Transition(",", n2);
    Transition t4 = new Transition("=", n4);
    Transition t5 = new Transition(lexeme.Matcher.INTEGER, n3);

    n1.setTransitions(new Transition[]{t1});
    n2.setTransitions(new Transition[]{t2});
    n3.setTransitions(new Transition[]{t3, t4});
    n4.setTransitions(new Transition[]{t5});

    Automaton automaton = new Automaton(n1);
    System.out.println(automaton.evaluate(new String[]{"INT", "var3", "=", "4.5", ",", "var5"}));
    io.serialization.Serializer.serialize(automaton, "automatons/serialized/DeclarationInt.ser");
  }
}
