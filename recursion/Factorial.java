public class Factorial {

  public static int factorial(int n) {
    // base case
    if (n > 0) {
      // n placed before recursive call (tail recursion)
      return n * factorial(n-1);
    }
    // 0! = 1
    return 1;
  }

  public static void main (String[] args) {
    System.out.println(factorial(5));
    System.out.println(factorial(0));
    System.out.println(factorial(1));
  }
}
