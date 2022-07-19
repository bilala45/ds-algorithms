import java.util.ArrayList;

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
  public static int howSumMemo(int target, int[] nums) {
    return 0;
  }

  // bottom-up (tabulation)
  public static int howSumTab(int target, int[] nums) {
    return 0;
  }

  // display elements of ArrayList
  private static void display(ArrayList<Integer> result) {
    System.out.print("[ ");
    for (int elem : result) {
      System.out.print(elem + " ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    System.out.println(howSumNaive(7, new int[] {2, 3}));
    System.out.println(howSumNaive(7, new int[] {5, 3, 4, 7}));
    System.out.println(howSumNaive(7, new int[] {2, 4}));
    System.out.println(howSumNaive(8, new int[] {2, 3, 5}));
    System.out.println(howSumNaive(100, new int[] {5, 7}));

    // System.out.println(howSumMemo(7, new int[] {5, 3, 4, 7}));
    // System.out.println(howSumMemo(7, new int[] {2, 4}));
    // System.out.println(howSumMemo(300, new int[] {7, 14}));
  }
}
