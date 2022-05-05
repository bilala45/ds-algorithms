public class Recursion {

  public static void tree(int x) {
    if (x > -1) {
      System.out.println(x);
      tree(x-1);
      tree(x-1);
    }
  }

  public static void main (String[] args) {
    tree(2);
  }
}
