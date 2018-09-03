package testing;

import java.util.ArrayList;

class Serialize1 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<String>();
    list.add("Go to school");
    list.add("Clean his room");
    list.add("Go to gym");
    SerializedClass1 sc1 = new SerializedClass1("Dario", "Male", 21, list);

    io.serialization.Serializer.serialize(sc1, "./testing/serializingTests/test1.ser");
  }
}
