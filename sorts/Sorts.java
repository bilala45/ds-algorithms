import java.util.LinkedList;

public class Sorts {

  /********************* COMPARISON BASED SORTING *********************/

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

  // heap sort is located in heap directory

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

  // merge sort
  public static int[] mergeSort(int[] arr, int start, int end) {
    // base case: subarray of size 1
    if (end - start < 1) {
      return arr;
    }
    // calculate middle index of subarray
    int middle = start + (end-start)/2;
    // call mergeSort on both halves of array
    mergeSort(arr, start, middle);
    mergeSort(arr, middle + 1, end);
    // both of the lists we want to merge are in the same array
    // middle + 1 because the start of the second list is at middle + 1
    return merge(arr, start, middle + 1, end);
  }

  // merges two lists (for merge sort)
  private static int[] merge(int[] arr, int start, int middle, int end) {
    // start and end mark the beginning/end of the subarray
    // middle marks the beginning of the second list that will be merged

    // create array to hold values during sorting
    int[] sortArr = new int[end - start + 1];
    // pointer to track index in sortArr
    int sortPtr = 0;

    // pointer to first and second list
    int ptr1 = start;
    int ptr2 = middle;

    // iterate through arr and fill sortArr
    while (ptr1 < middle && ptr2 < end + 1) {
      if (arr[ptr1] < arr[ptr2]) {
        sortArr[sortPtr] = arr[ptr1];
        ptr1++;
      } else {
        sortArr[sortPtr] = arr[ptr2];
        ptr2++;
      }
      sortPtr++;
    }

    // iterate through remaining non-empty
    while (ptr1 < middle) {
      sortArr[sortPtr] = arr[ptr1];
      ptr1++;
      sortPtr++;
    }
    while (ptr2 < end + 1) {
      sortArr[sortPtr] = arr[ptr2];
      ptr2++;
      sortPtr++;
    }

    // copy sortArr back to corresponding part of arr
    for (int i = 0 ; i < sortArr.length ; i++) {
      arr[start + i] = sortArr[i];
    }

    return arr;
  }

  /********************* INDEX BASED SORTING *********************/

  // count sort
  // value must be a positive integer
  public static int[] countSort(int[] arr) {
    // initialize array to count occurrence of each value in arr
    // count size is max of arr + 1 (add 1 because indexing starts at 0 in arr and we want numbers to match up with their index)
    int[] count = new int[arrayMax(arr) + 1];

    // iterate through arr and tally occurrence of each value in arr
    for (int i = 0 ; i < arr.length ; i++) {
      // value at arr[i] is index in count
      int index = arr[i];
      // increment value at count
      count[index]++;
    }

    // pointer to track index in input arr
    int arrPtr = 0;

    // iterate through count and place index in original arr
    for (int i = 0 ; i < count.length ; i++) {
      // stop and iterate at indices with non-zero values
      while (count[i] > 0) {
        // store index in count as value in arr
        arr[arrPtr] = i;
        // decrement tally at i in count
        count[i]--;
        // update arrPtr
        arrPtr++;
      }
    }

    display(arr);
    return arr;
  }

  // bucket/bin sort
  public static int[] bucketSort(int[] arr) {
    // initialize array to store buckets for input array values
    // array of linked lists
    // add one to size of array so indices match up
    LinkedList<Integer>[] buckets = new LinkedList[arrayMax(arr) + 1];

    // iterate through input arr and place values in buckets linked list array
    for (int i = 0 ; i < arr.length ; i++) {
      // store value in arr as index
      int index = arr[i];

      // create new linked list if index at buckets is null
      if (buckets[index] == null) {
        buckets[index] = new LinkedList<Integer>();
      }
      // append index to list at buckets[index]
      buckets[index].add(index);
    }

    // pointer to track position in original input arr
    int arrPtr = 0;

    // iterate through buckets array and place data from list nodes back in arr
    for (int i = 0 ; i < buckets.length ; i++) {
      // iterate through linked list at each array index until end of list
      while (buckets[i] != null && buckets[i].peek() != null) {
        // remove value at head of list and update arrPtr
        arr[arrPtr] = buckets[i].remove();
        arrPtr++;
      }
    }

    display(arr);
    return arr;
  }

  // radix sort
  public static int[] radixSort(int[] arr) {
    // find max value in arr and count the number of digits
    int maxDigits = countDigits(arrayMax(arr));
    System.out.println(maxDigits);
    int digitTracker = 0;

    while (digitTracker < maxDigits) {
      // initialize array of size 10 -> each index corresponds to digit
      LinkedList<Integer>[] digitArr = new LinkedList[10];

      // iterate through list and calculate mod 10
      for (int i = 0 ; i < arr.length ; i++) {
        // extract one's digit of element
        // use Math.pow function instead of ^ (^ is bitwise XOR operator)
        // type cast to int since pow returns a double
        int elemMod = (arr[i] / ((int)Math.pow(10, digitTracker))) % 10;
        // sort element at index i in digitArr according to ones digit
        // initialize new linked list if index is null
        if (digitArr[elemMod] == null) {
          digitArr[elemMod] = new LinkedList<Integer>();
          digitArr[elemMod].add(arr[i]);
        // append to list if linked list is already initialized
        } else {
          digitArr[elemMod].add(arr[i]);
        }
      }

      // update digits
      digitTracker++;

      // pointer to track position in input arr
      int arrPtr = 0;

      // iterate through digitArr and place elements back in input arr
      for (int i = 0 ; i < digitArr.length ; i++) {
        // stop at non-null indices (indices with linked list nodes)
        while (digitArr[i] != null && digitArr[i].peek() != null) {
          // remove from head of linked list at each index and insert in arr
          arr[arrPtr] = digitArr[i].remove();
          // update arrPtr
          arrPtr++;
        }
      }
    }



    display(arr);
    return arr;
  }

  /********************* HELPER METHODS *********************/

  // find max element in array
  private static int arrayMax(int[] arr) {
    // set initial value of max as minimum possible value
    int max = Integer.MIN_VALUE;

    // iterate through arr
    for (int i = 0 ; i < arr.length ; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    return max;
  }

  // count digits of an integer
  private static int countDigits(int val) {
    // handles input of 0
    if (val / 10 == 0) {
      return 1;
    }
    return countDigits(val/10) + 1;
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
    int[] unsorted = {15, 52, 16, 1514, 26, 22, 32, 2423452};
    radixSort(unsorted);
  }
}
