public class BinarySearch {

  // iterative implementation of binary search algorithm
  public static int binSearch(int[] searchArr, int value) {

    // set initial start and end pointers
    int start = 0;
    int end = searchArr.length - 1;

    // search concludes when start passes end pointer
    while (start <= end) {
      // mid is calculated this way to prevent overflow
      int mid = start + (end - start)/2;
      if (searchArr[mid] == value) {
        return mid;
      // restrict search field to first half
      } else if (value < searchArr[mid]) {
        end = mid - 1;
      // restrict search field to second half
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  // recursive implementation of binary search algorithm
  public static int rBinSearch(int[] searchArr, int value, int start, int end) {
    if (start <= end) {
      int mid = start + (end - start)/2;
      if (searchArr[mid] == value) {
        return mid;
      } else if (value < searchArr[mid]) {
        // recursive call with new end pointer (restricted to first half)
        return rBinSearch(searchArr, value, start, mid - 1);
      } else {
        // recursive call with new start pointer (restricted to second half)
        return rBinSearch(searchArr, value, mid + 1, end);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] test = {0,2,4,5,6,7,9,10};
    System.out.println(binSearch(test, 7)); // 5
    System.out.println(binSearch(test, 15)); // -1
    int start = 0;
    int end = test.length - 1;
    System.out.println(rBinSearch(test, 7, start, end)); // 5
    System.out.println(rBinSearch(test, 15, start, end)); // -1
  }
}
