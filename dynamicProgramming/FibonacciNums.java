import java.util.Map;
import java.util.HashMap;

public class FibonacciNums {

  // naive approach
  public static int fibNaive(int num) {
    // base cases (num = 0, 1)
    if (num <= 1) return num;

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
    if (memo.get(num) != null) return memo.get(num);
    // base cases (num = 0, 1)
    if (num <= 1) return num;

    // cache result
    memo.put(num, fibMemoHelper(num - 1, memo) + fibMemoHelper(num - 2, memo));
    return memo.get(num);
  }

  // bottom-up (tabulation)
  public static int fibTab(int num) {
    // array indexing begins at 0
    int[] tab = new int[num + 1];

    // base cases
    tab[0] = 0;
    tab[1] = 1;

    // iterate through tab array
    for (int i = 0 ; i < tab.length ; i++) {
      // update next two positions with value at current index
      if (i + 1 < tab.length) {
        tab[i+1] += tab[i];
      }
      if (i + 2 < tab.length) {
        tab[i+2] += tab[i];
      }
    }

    return tab[num];
  }

  public static void main(String[] args) {
    System.out.println(fibTab(3)); // 2
    System.out.println(fibTab(20)); // 6765
    System.out.println(fibTab(40)); // 102334155
  }
}
