public class Merge {

  // merge two lists
  public static int[] mergeTwoLists(int[] arr1, int[] arr2) {
    // pointers for arr1 and arr2 at start of list
    int ptr1 = 0;
    int ptr2 = 0;

    // initialize array to hold merged list
    int[] mergeArr = new int[arr1.length + arr2.length];
    // pointer to track current position in mergeArr
    int ptrMerge = 0;

    // iterate until one of the pointers exceeds its array length
    // this avoids an index out of bounds exception
    while (ptr1 < arr1.length && ptr2 < arr2.length) {
      // compare pointer values in arr1 and arr2
      if (arr1[ptr1] <= arr2[ptr2]) {
        // set value in mergeArr as value from arr1
        mergeArr[ptrMerge] = arr1[ptr1];
        // update ptr1
        ptr1++;
      } else {
        mergeArr[ptrMerge] = arr2[ptr2];
        ptr2++;
      }
      // update merge pointer
      ptrMerge++;
    }

    // fill out rest of mergeArr with the arr that we haven't reached the end of
    while (ptr1 < arr1.length) {
      mergeArr[ptrMerge] = arr1[ptr1];
      ptr1++;
      ptrMerge++;
    }
    while (ptr2 < arr2.length) {
      mergeArr[ptrMerge] = arr2[ptr2];
      ptr2++;
      ptrMerge++;
    }

    display(mergeArr);
    return mergeArr;
  }

  // merge list in place
  public static int[] mergeInPlace(int[] arr, int partition) {
    // partition gives the index at which the second list starts
    // create an array with the same size as arr
    int[] sortArr = new int[arr.length];
    // pointer to track position in sortArr
    int sortPtr = 0;

    // add pointers at start of each sorted list
    int ptr1 = 0;
    int ptr2 = partition;

    // iterate through both lists until one list is completed
    while (ptr1 < partition && ptr2 < arr.length) {
      if (arr[ptr1] < arr[ptr2]) {
        sortArr[sortPtr] = arr[ptr1];
        ptr1++;
      } else {
        sortArr[sortPtr] = arr[ptr2];
        ptr2++;
      }
      sortPtr++;
    }

    // copy remaining elements from non-empty list
    while (ptr1 < partition) {
      sortArr[sortPtr] = arr[ptr1];
      ptr1++;
      sortPtr++;
    }
    while (ptr2 < arr.length) {
      sortArr[sortPtr] = arr[ptr2];
      ptr2++;
      sortPtr++;
    }

    // copy elements from sortArr back to input arr
    for (int i = 0 ; i < sortArr.length ; i++) {
      arr[i] = sortArr[i];
    }

    display(arr);
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
    int[] test = {1, 4, 6, 3, 7, 9};
    mergeInPlace(test, 3);
  }
}
