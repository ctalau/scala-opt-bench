package test;

public class Test0sp0X {
  public byte tag_1;

  public Test0sp0X(byte tag_1) {
    this.tag_1 = tag_1;
  }

  public void print() {
    switch(tag_1) {
    case 0 : 
      System.out.println(tag_1 + " - 0");
      break;
    case 1 : 
      System.out.println(tag_1 + " - 1");
      break;
    case 2 : 
      System.out.println(tag_1 + " - 2");
      break;
    default :
      System.out.println(tag_1 + " - *");
    }
  }

}
