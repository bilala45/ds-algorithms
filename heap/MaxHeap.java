public class MaxHeap {

  // array to track heap elements
  private int[] heap;
  // pointer to track last element in heap
  private int end;

  // constructor for heap class
  public MaxHeap() {
    // initialize array of size 10 to store heap
    heap = new int[10];
    // intialize end to -1 (no elements in heap)
    end = -1;
  }

  /* for index i:
   * children at 2i+1 and 2i+2
   * parent at floor((i-1)/2)
   */

  // insert element in heap
  public void insert(int val) {
    // increment end and insert val at end
    end++;
    heap[end] = val;

    // store index of child and calculate index of parent
    int childInd = end;
    int parentInd = (int)Math.floor((end - 1)/2);

    // iterate while the value we want to insert is greater than its parent
    // we also check to ensure we aren't out of array bounds
    while (parentInd >= 0 && val > heap[parentInd]) {
      // swap child with parent element
      swap(heap, parentInd, childInd);

      // store child and recalculate parentInd
      childInd = parentInd;
      parentInd = (int)Math.floor((parentInd - 1)/2);
    }

    display(heap);
  }

  // helper method to swap elements in array
  private static void swap(int[] arr, int ind1, int ind2) {
    int temp = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = temp;
  }

  // helper method to display elements in array
  private static void display(int[] heap) {
    System.out.print("[");
    for (int i = 0 ; i < heap.length - 1 ; i++) {
      System.out.print(heap[i] + ", ");
    }
    System.out.print(heap[heap.length - 1]);
    System.out.println("]");
  }

  // delete element in heap
  public void delete(int val) {

  }

  // main method
  public static void main(String[] args) {
    MaxHeap test = new MaxHeap();
    test.insert(5);
    test.insert(3);
    test.insert(1);
    test.insert(10);
  }
}
