import java.util.ArrayList;

public class MinHeap {

  // ArrayList to store contents of binary heap
  public ArrayList<Integer> arr;

  // constructor
  public MinHeap() {
    arr = new ArrayList<Integer>();
  }

  // TODO - add method to heapify passed in array of values

  // returns the minimum item in the heap without removing it
  public int find_min() {
    return arr.get(0);
  }

  // // returns and removes minimum item in the heap
  // public int get_min() {
  // 
  // }

  // inserts val into heap
  public void insert(int val) {
    // add value as last element in arr (maintains complete binary tree)
    arr.add(val);

    // get index of inserted value
    int valIndex = arr.size() - 1;

    // iterate through levels of heap
    // solves edge case if inserted value is only element in heap
    while (valIndex != 0) {
      // compare last element with value at parent node
      if (val < arr.get(parent(valIndex))) {
        // swap child with parent
        // swap is a method of the minHeap class (implicitly called on minHeap object)
        swap(valIndex, parent(valIndex));
      }

      // update valIndex to be parent's index
      valIndex = parent(valIndex);
    }
  }

  // helper method to swap values at index1 and index2
  private void swap(int index1, int index2) {
    // temporarily store value at index1
    int temp = arr.get(index1);
    arr.set(index1, arr.get(index2));
    arr.set(index2, temp);
  }

  // helper method to calculate index of parent given index of child
  private static int parent(int child) {
    // cast to int because Math.floor() returns a double
    return (int) Math.floor((child - 1)/2);
  }
}
