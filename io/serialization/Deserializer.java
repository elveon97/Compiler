package io.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Deserializer {
  public final static Object deserializeObject(String path) {
    System.out.println("Deserializing object...");
    Object o = null;
    try {
       FileInputStream fileIn = new FileInputStream(path);
       ObjectInputStream in = new ObjectInputStream(fileIn);
       o = in.readObject();
       in.close();
       fileIn.close();
       System.out.println("Object deserialized successfully");
    } catch (IOException i) {
       System.out.println("Deserializing process failed");
       i.printStackTrace();
    } catch (ClassNotFoundException c) {
       System.out.println("Class not found");
       c.printStackTrace();
    }
    return o;
  }
}
