public class Sorts {

  // bubble sort
  public static int[] bubbleSort(int[] sortArr) {
    // on each iteration, the largest element in the array is moved to the end
    // decrement the size of the array (from the right size) on each iteration
    for (int i = sortArr.length - 1 ; i > 0 ; i--) {
      // iterate up to i
      for (int j = 0 ; j < i ; j++) {
        if (sortArr[j] > sortArr[j+1]) {
          int temp = sortArr[j];
          sortArr[j] = sortArr[j+1];
          sortArr[j+1] = temp;
        }
      }
    }
    return sortArr;
  }

  // main method
  public static void main(String[] args) {
    int[] unsorted = {3,6,2,1,7,4};
    int[] bubble = bubbleSort(unsorted);
    for (int i = 0 ; i < bubble.length ; i++) {
      System.out.println(bubble[i]);
    } 
  }
}
