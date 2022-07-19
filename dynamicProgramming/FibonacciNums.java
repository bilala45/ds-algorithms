public class FibonacciNums {

  // naive approach
  public static int fibNaive(int num) {
    // base cases (num = 0, 1)
    if (num <= 1) {
      return num;
    }

    return fibNaive(num - 1) + fibNaive(num - 2);
  }


  // top-down (memoization)
  public static int fibMemo(int num) {
    return 0;
  }


  // bottom-up (tabulation)
  public static int fibTab(int num) {
    return 0;
  }


  public static void main(String[] args) {
    System.out.println(fibNaive(6)); // 8
    System.out.println(fibNaive(40)); // 102334155
  }
}
