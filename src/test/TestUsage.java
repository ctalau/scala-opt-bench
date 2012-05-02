package test;

import java.lang.reflect.Modifier;



public class TestUsage {

  public static void main(String[] args) throws ClassNotFoundException {
    Printer t = new Test0sp0X((byte) 13);
    t.print();
    if (Modifier.isStatic(t.getClass().getFields()[0].getModifiers())){
      System.out.println("changed to static");
    }
    System.out.println("if the above is different from 13, it worked!");
  }

}
