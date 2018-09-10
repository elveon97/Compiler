package automatons.instance_creation;

import automatons.*;

public class DeclarationReal {
  public static void main(String[] args) {
    Node n1 = new Node(false, null);
    Node n2 = new Node(false, null);
    Node n3 = new Node(true, null);
    Node n4 = new Node(false, null);

    Transition t1 = new Transition("REAL", n2);
    Transition t2 = new Transition(lexeme.Matcher.VARIABLE, n3);
    Transition t3 = new Transition(",", n2);
    Transition t4 = new Transition("=", n4);
    Transition t5 = new Transition(lexeme.Matcher.REAL, n3);

    n1.setTransitions(new Transition[]{t1});
    n2.setTransitions(new Transition[]{t2});
    n3.setTransitions(new Transition[]{t3, t4});
    n4.setTransitions(new Transition[]{t5});

    Automaton automaton = new Automaton(n1);
    io.serialization.Serializer.serialize(automaton, "automatons/serialized/DeclarationReal.ser");
  }
}
