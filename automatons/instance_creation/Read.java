package automatons.instance_creation;

import automatons.*;

public class Read {
  public static void main(String[] args) {
    Node n1 = new Node(false, null);
    Node n2 = new Node(false, null);
    Node n3 = new Node(true, null);
    Node blackHole = new Node(false, null);

    Transition t1 = new Transition("READ", n2);
    Transition t2 = new Transition(lexeme.Matcher.VARIABLE, n3);
    Transition toTheHole = new Transition(lexeme.Matcher.VARTYPES, blackHole);
    Transition toTheHole2 = new Transition(lexeme.Matcher.RESERVED, blackHole);

    n1.setTransitions(new Transition[]{t1});
    n2.setTransitions(new Transition[]{toTheHole2, toTheHole, t2});

    Automaton automaton = new Automaton(n1);
    //System.out.println(automaton.evaluate(new String[]{"READ", "INT"}));
    io.serialization.Serializer.serialize(automaton, "automatons/serialized/Read.ser");
  }
}
