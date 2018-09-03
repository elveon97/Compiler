package io.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Serializer {
  public final static boolean serialize(Object o, String path) {
    System.out.println("Serializing object...");
    try {
       FileOutputStream fileOut = new FileOutputStream(path);
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(o);
       out.close();
       fileOut.close();
       System.out.println("Serialization process ended sucessfully");
       System.out.println("Serialized data is saved in '"+path+"'");
       return true;
    } catch (IOException i) {
       System.out.println("Serialization process failed");
       i.printStackTrace();
       return false;
    }
  }
}
