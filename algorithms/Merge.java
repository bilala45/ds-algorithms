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

  }
}
