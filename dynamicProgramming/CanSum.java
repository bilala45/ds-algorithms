import java.util.Map;
import java.util.HashMap;

public class CanSum {

  /* Complexity analysis
   * Assume length of nums is n, and target is m
   * Time complexity: O(n^m) (exponential)
   * Space complexity: O(m) (linear)
   */
  // naive approach
  public static boolean canSumNaive(int target, int[] nums) {
    // base cases
    // 0 num means valid solution
    if (target == 0) {up
      return true;
    }
    // negative value means invalid solution
    if (target < 0) {
      return false;
    }

    // apply each value in nums to target
    for (int num : nums) {
      // recursive call to target value with num subtracted
      // return true for early exit if valid solution found
      // don't return false if invalid solution is found because valid solution may be found later
      if (canSumNaive(target - num, nums)) {
        return true;
      }
    }
    // return false at the end (no valid solution found)
    return false;
  }

  public static boolean canSumMemo(int target, int[] nums) {
    Map<Integer, Boolean> memo = new HashMap<>();
    return canSumMemoHelper(target, nums, memo);
  }

  /* Complexity analysis
   * Assume length of nums is n, and target is m
   * Time complexity: O(m*n) (quadratic)
   * Tree will have depth up to m (if 1 is in the nums array, 1 will be subtracted from target on each recursive call)
   * Each recursive call will require iteration through the length of the nums array (n)
   * We multiply these together to get m*n
   *
   * Space complexity: O(m) (linear)
   * Tree will have depth up to m (if 1 is in the nums array, 1 will be subtracted from target on each recursive call)
   * Max number of stack frames on call stack is proportional to depth of recursive tree
   */
  // top-down (memoization)
  private static boolean canSumMemoHelper(int target, int[] nums, Map<Integer, Boolean> memo) {
    // check if target is cached
    if (memo.containsKey(target)) {
      return memo.get(target);
    }
    // base cases
    // 0 num means valid solution
    if (target == 0) {
      return true;
    }
    // negative value means invalid solution
    if (target < 0) {
      return false;
    }

    // apply each value in nums to target
    for (int num : nums) {
      // recursive call to target value with num subtracted
      // return true for early exit if valid solution found
      // don't return false if invalid solution is found because valid solution may be found later
      if (canSumMemoHelper(target - num, nums, memo)) {
        // cache true result for current target
        memo.put(target, true);
        return true;
      }
    }
    // cache false result for current target
    // return false at the end (no valid solution found)
    memo.put(target, false);
    return false;
  }

  // bottom-up (tabulation)
  public static boolean canSumTab(int num) {
    return false;
  }

  public static void main(String[] args) {
    System.out.println(canSumNaive(7, new int[] {2, 3})); // true
    System.out.println(canSumNaive(7, new int[] {5, 3, 4, 7})); // true
    System.out.println(canSumNaive(7, new int[] {2, 4})); // false
    System.out.println(canSumNaive(8, new int[] {2, 3, 5})); // true
    System.out.println(canSumNaive(300, new int[] {7, 14})); // false

    System.out.println(canSumMemo(7, new int[] {5, 3, 4, 7})); // true
    System.out.println(canSumMemo(7, new int[] {2, 4})); // false
    System.out.println(canSumMemo(300, new int[] {7, 14})); // false
  }
}
