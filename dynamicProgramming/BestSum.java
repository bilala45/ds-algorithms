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
    return bestSumMemoHelper(target, nums, memo);
  }

  // top-down (memoization)
  private static ArrayList<Integer> bestSumMemoHelper(int target, int[] nums, Map<Integer, ArrayList<Integer>> memo) {
    // check if target is cached
    if (memo.containsKey(target)) {
      return memo.get(target);
    }
    // base cases
    // target == 0, return empty array
    if (target == 0) return new ArrayList<Integer>(0);
    if (target < 0) return null;

    ArrayList<Integer> shortestResult = null;

    // iterate through nums
    // Create branches from target by subtracting num from target
    for (int num : nums) {
      int remainder = target - num;
      // pass remainder recursively to method
      // result variable REFERS to the object initialized and returned by bestSumMemoHelper
      // this object can be an empty ArrayList (target == 0), the shortestResult object, or an object that a hash key points to
      // we're NOT creating a new object here (because we don't use the new keyword, we're just creating a reference to our returned object
      // Why not just create a new object here using: new ArrayList<>(bestSumMemoHelper(remainder, nums, memo))? If our method returns null (possible for negative values), then we get a nullPointerException
      ArrayList<Integer> result = bestSumMemoHelper(remainder, nums, memo);
      // set shortestResult to current result if no value is stored yet
      if (result != null) {
        // once we know that our result is NOT null, initialize a new ArrayList that stores the contents of result (but not a reference to the original object where the contents came from)
        // This removes any reference to hashed values or our shortestResult object
        // since the return value stored in result is only used in the current iteration, we can safely reassign our new ArrayList to result
        // We can't do this step outside the loop in case our method returns null
        result = new ArrayList<>(result);
        // add num value to results ArrayList
        result.add(num);
        // replace shortestResult with result if no value has been initialized for shortestResult
        // or if tempResult is shorter than current stored value
        if (shortestResult == null || result.size() < shortestResult.size()) {
          // shortestResult stores a reference to the new object we created
          shortestResult = result;
        }
      }
    }
    // we can only return AFTER the for-loop has completed because every combination must be checked
    // if no combination works, shortestResult will remain null and be returned
    memo.put(target, shortestResult);
    return memo.get(target);
  }

  // bottom-up (tabulation)
  public static int bestSumTab(int target, int[] nums) {
    return 0;
  }

  public static void main(String[] args) {
    // System.out.println(bestSumNaive(7, new int[] {5, 3, 4, 7}));
    // System.out.println(bestSumNaive(8, new int[] {2, 3, 5}));
    // System.out.println(bestSumNaive(8, new int[] {1, 4, 5}));
    // System.out.println(bestSumNaive(8, new int[] {2, 4}));
    System.out.println(bestSumMemo(50, new int[] {2, 4, 10}));
    System.out.println(bestSumMemo(300, new int[] {7, 30}));
  }
}
