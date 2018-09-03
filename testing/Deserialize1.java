package testing;

class Deserialize1 {
  public static void main(String[] args) {
    SerializedClass1 sc1 =
      (SerializedClass1)io.serialization.Deserializer
                        .deserializeObject("./testing/serializingTests/test1.ser");

    System.out.println(sc1.name);
    System.out.println(sc1.sex);
    System.out.println(sc1.age);
    for (String i: sc1.chores) System.out.println(i);
  }
}
