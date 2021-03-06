package automatons.instance_creation;

import automatons.*;

public class AssignationBoolean {
  public static void main(String[] args) {
    Node n1 = new Node(false, null);
    Node n2 = new Node(false, null);
    Node n3 = new Node(false, null);
    Node n4 = new Node(true, null);

    Transition t1 = new Transition(lexeme.Matcher.VARIABLE, n2);
    Transition t2 = new Transition("=", n3);
    Transition t3 = new Transition(lexeme.Matcher.BOOLEAN, n4);

    n1.setTransitions(new Transition[]{t1});
    n2.setTransitions(new Transition[]{t2});
    n3.setTransitions(new Transition[]{t3});

    Automaton automaton = new Automaton(n1);
    io.serialization.Serializer.serialize(automaton, "automatons/serialized/AssignationBoolean.ser");
  }
}
