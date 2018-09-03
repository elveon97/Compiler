package testing;

import java.util.ArrayList;

class SerializedClass1 implements java.io.Serializable {
  String name, sex;
  int age;
  ArrayList<String> chores;

  public SerializedClass1(String name, String sex, int age, ArrayList<String> list) {
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.chores = list;
  }
}
