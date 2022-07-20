import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class BestSum {

  // naive approachs
  public static ArrayList<Integer> bestSumNaive(int target, int[] nums) {
    // base cases
    // target == 0, return empty array
    if (target == 0) {
      return new ArrayList<Integer>(0);
    }
    if (target < 0) {
      return null;
    }

    ArrayList<Integer> shortestResult = null;

    // iterate through nums
    // Create branches from target by subtracting num from target
    for (int num : nums) {
      int remainder = target - num;
      ArrayList<Integer> result = bestSumNaive(remainder, nums);
      // set shortestResult to current result if no value is stored yet
      if (result != null) {
        // update result list with current element in nums array
        result.add(num);
        // replace shortestResult with result if no value has been initialized for shortestResult
        // or if result is shorter than current stored value
        if (shortestResult == null || result.size() < shortestResult.size()) {
          shortestResult = result;
        }
      }
    }
    // we can only return AFTER the for loop has completed because every combination must be checked
    // if no combination works, shortestResult will remain null and be returned
    return shortestResult;
  }

  public static ArrayList<Integer> bestSumMemo(int target, int[] nums) {
    Map<Integer, ArrayList<Integer>> memo = new HashMap<>();
    ArrayList<Integer> result = bestSumMemoHelper(target, nums, memo);
    return result;
  }

  // top-down (memoization)
  private static ArrayList<Integer> bestSumMemoHelper(int target, int[] nums, Map<Integer, ArrayList<Integer>> memo) {
    // check if target is cached
    if (memo.containsKey(target)) {
      return memo.get(target);
    }
    // base cases
    // target == 0, return empty array
    if (target == 0) {
      return new ArrayList<Integer>(0);
    }
    if (target < 0) {
      return null;
    }

    ArrayList<Integer> shortestResult = null;

    // iterate through nums
    // Create branches from target by subtracting num from target
    for (int num : nums) {
      int remainder = target - num;
      // pass remainder recursively to method
      ArrayList<Integer> result = bestSumMemoHelper(remainder, nums, memo);
      // set shortestResult to current result if no value is stored yet
      if (result != null) {
        // update result list with current element in nums array
        result.add(num);
        // replace shortestResult with result if no value has been initialized for shortestResult
        // or if result is shorter than current stored value
        if (shortestResult == null || result.size() < shortestResult.size()) {
          shortestResult = result;
        }
      }
    }
    // we can only return AFTER the for-loop has completed because every combination must be checked
    // if no combination works, shortestResult will remain null and be returned
    memo.put(target, new ArrayList<Integer>(shortestResult));
    return shortestResult;
  }

  // bottom-up (tabulation)
  public static int bestSumTab(int target, int[] nums) {
    return 0;
  }

  public static void main(String[] args) {
    //System.out.println(bestSumNaive(7, new int[] {5, 3, 4, 7}));
    //System.out.println(bestSumNaive(8, new int[] {2, 3, 5}));
    //System.out.println(bestSumNaive(8, new int[] {1, 4, 5}));
    //System.out.println(bestSumNaive(8, new int[] {2, 4}));
    //System.out.println(bestSumNaive(100, new int[] {1, 2, 5, 25}));
    System.out.println(bestSumMemo(8, new int[] {2, 4}));
  }
}
