public class Sorts {

  // bubble sort
  public static int[] bubbleSort(int[] arr) {
    // on each iteration, the largest element in the array is moved to the end
    // decrement the size of the array (from the right size) on each iteration
    for (int i = arr.length - 1 ; i > 0 ; i--) {
      // iterate up to i (not including i because we don't need to compare the last value with anything)
      for (int j = 0 ; j < i ; j++) {
        // swap array elements if element at j is greater than element at j+1
        if (arr[j] > arr[j+1]) {
          // swap
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
      display(arr);
    }
    return arr;
  }

  // insertion sort
  public static int[] insertionSort(int[] arr) {
    // start at index 1 (beginning of unsorted group)
    // the first element (index 0) is already "sorted" since it's a single element
    for (int i = 1 ; i < arr.length ; i++) {
      // store element at start of unsorted group
      int curr = arr[i];
      int sortedElem = i - 1;

      // shift while element at j (from sorted group) is greater than curr
      while (sortedElem != -1 && arr[sortedElem] > curr) {
        arr[sortedElem+1] = arr[sortedElem];
        // decrement j on each iteration
        sortedElem--;
      }
      // update next element with curr
      arr[sortedElem+1] = curr;
      display(arr);
    }
    return arr;
  }

  // display elements of array
  private static void display(int[] arr) {
    System.out.print("[");
    for (int i = 0 ; i < arr.length - 1 ; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println(arr[arr.length - 1] + "]");
  }

  // main method
  public static void main(String[] args) {
    int[] unsorted = {3,6,4,2,1};
    //int[] bubble = bubbleSort(unsorted);
    int[] insertion = insertionSort(unsorted);
  }
}
