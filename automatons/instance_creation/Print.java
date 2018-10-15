package automatons.instance_creation;

import automatons.*;

public class Print {
  public static void main(String[] args) {
    Node n1 = new Node(false, null);
    Node n2 = new Node(false, null);
    Node n3 = new Node(false, null);
    Node n4 = new Node(false, null);
    Node n5 = new Node(false, null);
    Node n6 = new Node(true, null);
    Node n7 = new Node(false, null);
    Node n8 = new Node(true, null);
    Node blackHole = new Node(false, null);

    Transition t1 = new Transition("PRINT", n2);
    Transition t2 = new Transition("\\(", n3);
    Transition t3 = new Transition(lexeme.Matcher.STRING, n4);
    Transition t4 = new Transition(",", n5);
    Transition t5 = new Transition(lexeme.Matcher.VARIABLE, n6);
    Transition t6 = new Transition(",", n5);
    Transition t7 = new Transition("\\)", n8);
    Transition t8 = new Transition(lexeme.Matcher.VARIABLE, n7);
    Transition t9 = new Transition("\\)", n8);

    Transition toTheHole = new Transition(lexeme.Matcher.VARTYPES, blackHole);
    Transition toTheHole2 = new Transition(lexeme.Matcher.RESERVED, blackHole);

    n1.setTransitions(new Transition[]{t1});
    n2.setTransitions(new Transition[]{t2});
    n3.setTransitions(new Transition[]{toTheHole, toTheHole2, t3, t8});
    n4.setTransitions(new Transition[]{t4, t9});
    n5.setTransitions(new Transition[]{toTheHole, toTheHole2, t5});
    n6.setTransitions(new Transition[]{t6, t7});
    n7.setTransitions(new Transition[]{t9});

    Automaton automaton = new Automaton(n1);
    System.out.println(automaton.evaluate(new String[]{"PRINT", "(", "$lol$", ")"}));
    io.serialization.Serializer.serialize(automaton, "automatons/serialized/Print.ser");
  }
}
