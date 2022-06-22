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
          swap(arr, j, j+1);
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
      // track end of sorted group
      int sortedElem = i - 1;

      // shift while sortedElem (element from sorted group) is greater than curr
      while (sortedElem > -1 && arr[sortedElem] > curr) {
        // shift sortedElem over by 1
        arr[sortedElem+1] = arr[sortedElem];
        // decrement j on each iteration
        sortedElem--;
      }
      // set index to the right of sortedElem as curr
      arr[sortedElem+1] = curr;
      display(arr);
    }
    return arr;
  }

  // selection sort
  public static int[] selectionSort(int[] arr) {
    for (int i = 0 ; i < arr.length ; i++) {
      // initialize min and iterator at i
      // min stops at the smallest value in the array
      int min = i;

      // iterate through the array and compares with value stored in min
      for (int j = i ; j < arr.length ; j++) {
        if (arr[j] < arr[min]) {
          // move min to j pointer
          min = j;
        }
      }

      // swap value at i with value at min
      swap(arr, i, min);

      display(arr);
    }
    return arr;
  }

  // quick sort
  public static int[] quickSort(int[] arr, int start, int end) {
    // return empty input arrays or arrays of size 1
    if (end - start < 1) {
      display(arr);
      return arr;
    }
    // partition input array with start and end arguments
    int partitionIndex = partition(arr, start, end);
    // call quicksort on left and right partition with new partition index
    quickSort(arr, start, partitionIndex - 1);
    quickSort(arr, partitionIndex + 1, end);
    display(arr);
    return arr;
  }

  // partition helper for quick sort
  private static int partition(int[] arr, int start, int end) {
    // set pivot at start
    int pivot = start;

    // iterate through array using two pointers
    while (start < end) {
      // check that start < end on each
      // update start pointer until start points to value greater than pivot
      while (arr[start] <= arr[pivot] && start < end) {
        start++;
      }
      // decrement end until end points at value less than pivot
      // don't need to check start < end here because end never surpasses pivot, so its index never goes out of bounds
      // end never surpasses pivot because we check that arr[end] is >, not >=
      while (arr[end] > arr[pivot]) {
        end--;
      }
      // swap elements at start and end
      // we only do this while start < end because this swap is not the final swap we perform to place our pivot at the correct index
      if ((arr[start] > arr[pivot] && arr[end] < arr[pivot]) && start < end) {
        swap(arr, start, end);
      }
    }

    // swap element that end is pointing to with pivot to place pivot in its sorted location in the array
    // pivot is now sorted in the correct place -> return this index to serve as a partition
    swap(arr, pivot, end);

    // return index of pivot to serve as partition for array
    return end;
  }

  // display elements of array
  private static void display(int[] arr) {
    System.out.print("[");
    for (int i = 0 ; i < arr.length - 1 ; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println(arr[arr.length - 1] + "]");
  }

  // swap elements of array
  private static void swap(int[] swapArr, int first, int second) {
    int temp = swapArr[first];
    swapArr[first] = swapArr[second];
    swapArr[second] = temp;
  }

  // main method
  public static void main(String[] args) {
    int[] unsorted = {13, 5};
    // bubbleSort(unsorted);
    // insertionSort(unsorted);
    // selectionSort(unsorted);
    quickSort(unsorted, 0, unsorted.length - 1);

  }
}
