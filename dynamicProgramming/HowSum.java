import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class HowSum {

  // naive approach
  public static ArrayList<Integer> howSumNaive(int target, int[] nums) {
    // base cases
    // target == 0, return empty array (sum of elements in empty array is 0)
    if (target == 0) {
      return new ArrayList<Integer>(0);
    }
    // negative target, return null
    if (target < 0) {
      return null;
    }

    // iterate through nums array
    // recursively call each element subtracted from target
    for (int num : nums) {
      int remainder = target - num;
      // store result of recursive call in ArrayList
      ArrayList<Integer> result = howSumNaive(remainder, nums);
      if (result != null) {
        // insert current target value in ArrayList
        result.add(num);
        return result;
      }
    }
    // no return value
    return null;
  }

  // top-down (memoization)
  public static ArrayList<Integer> howSumMemo(int target, int[] nums) {
    Map<Integer, ArrayList<Integer>> memo = new HashMap<>();
    return howSumMemoHelper(target, nums, memo);
  }

  // top-down (memoization) helper
  private static ArrayList<Integer> howSumMemoHelper(int target, int[] nums, Map<Integer, ArrayList<Integer>> memo) {
    // check if target is cached in memo
    // since some keys are associated with null, we use containsKey instead of checking with get()
    // should use containsKey in general rather than checking against null
    if (memo.containsKey(target)) {
      return memo.get(target);
    }
    // base cases
    // target == 0, return empty array (sum of elements in empty array is 0)
    if (target == 0) return new ArrayList<Integer>(0);
    // negative target, return null
    if (target < 0) return null;

    // iterate through nums array
    // recursively call each element subtracted from target
    for (int num : nums) {
      int remainder = target - num;
      // store result of recursive call in ArrayList
      ArrayList<Integer> result = howSumMemoHelper(remainder, nums, memo);
      if (result != null) {
        // insert current target value in ArrayList
        result.add(num);
        // hash target with result ArrayList
        memo.put(target, result);
        return memo.get(target);
      }
    }
    // no return value
    memo.put(target, null);
    return null;
  }

  // bottom-up (tabulation)
  public static int howSumTab(int target, int[] nums) {
    return 0;
  }

  public static void main(String[] args) {
    // System.out.println(howSumNaive(7, new int[] {2, 3}));
    // System.out.println(howSumNaive(7, new int[] {5, 3, 4, 7}));
    // System.out.println(howSumNaive(7, new int[] {2, 4}));
    // System.out.println(howSumNaive(8, new int[] {2, 3, 5}));
    // System.out.println(howSumNaive(300, new int[] {7, 14}));
    //
    // System.out.println(howSumMemo(7, new int[] {5, 3, 4, 7}));
    // System.out.println(howSumMemo(7, new int[] {2, 4}));
    System.out.println(howSumMemo(300, new int[] {7, 30}));
  }
}
