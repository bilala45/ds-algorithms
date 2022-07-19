import java.util.Map;
import java.util.HashMap;

public class FibonacciNums {

  // naive approach
  public static int fibNaive(int num) {
    // base cases (num = 0, 1)
    if (num <= 1) {
      return num;
    }

    // sum previous two numbers
    return fibNaive(num - 1) + fibNaive(num - 2);
  }

  // top-down (memoization)
  public static int fibMemo(int num) {
    Map<Integer, Integer> memo = new HashMap<>();
    return fibMemoHelper(num, memo);
  }

  // top-down approach helper method
  private static int fibMemoHelper(int num, Map<Integer, Integer> memo) {
    // check if input has been cached
    if (memo.get(num) != null) {
      return memo.get(num);
    }
    // base cases (num = 0, 1)
    if (num <= 1) {
      return num;
    }

    // cache result
    memo.put(num, fibMemoHelper(num - 1, memo) + fibMemoHelper(num - 2, memo));
    return memo.get(num);
  }

  // bottom-up (tabulation)
  public static int fibTab(int num) {
    return 0;
  }


  public static void main(String[] args) {
    System.out.println(fibNaive(6)); // 8
    System.out.println(fibNaive(40)); // 102334155

    System.out.println(fibMemo(6)); // 8
    System.out.println(fibMemo(40)); // 102334155
  }
}
