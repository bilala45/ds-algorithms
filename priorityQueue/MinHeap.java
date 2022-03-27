import java.util.ArrayList;

public class MinHeap {

  // ArrayList to store contents of binary heap
  public ArrayList<Integer> arr;

  // constructor
  public MinHeap() {
    arr = new ArrayList<Integer>();
  }

  // returns the minimum item in the heap without removing it
  public Integer find_min() {
    //
    if (arr.isEmpty()) {
      return null;
    } else {
      return arr.get(0);
    }
  }

  // returns and removes minimum item in the heap
  public int get_min() {
    // store value at top of heap
    int minVal = arr.get(0);
    // set top of heap with last value in heap
    arr.set(0, arr.get(arr.size() - 1));
    // remove last value in heap
    arr.remove(arr.size() - 1);
    // heapify down until last value (now at root) is properly sorted in heap
    heapifyDown(0);
    return minVal;
  }

  // inserts val into heap
  public void insert(int val) {
    // add value as last element in arr (maintains complete binary tree)
    arr.add(val);
    // val is inserted as the last element in the array
    heapifyUp(arr.size() - 1);
  }

  // helper method to restore heap after deletion, accepts index of current node
  private void heapifyDown(int currInd) {
    // checks for presence of left child by comparing against size of array
    // no need to check for right child yet since right child can't exist without left in a complete binary tree
    /* we don't want to compare left child against parent yet in the case that the left child is greater than the
       parent but the right child is less than the parent */
    if (childInd(currInd, 1) < arr.size()) {
      // we only care about the right child if it exists AND its value is less than the left child
      if (childInd(currInd, 2) < arr.size() && arr.get(childInd(currInd, 2)) < arr.get(childInd(currInd, 1))) {
        // compare right child against parent
        if (arr.get(childInd(currInd, 2)) < arr.get(currInd)) {
          // swap current index with index of smaller child
          swap(childInd(currInd, 2), currInd);
          // recursive call with new index of current value
          heapifyDown(childInd(currInd, 2));
        }
      // condition executes if right child doesn't exist or right child is not less than left child
      // negation of A && B is ~A || ~ B (De Morgan's Laws)
      } else {
        // check left child against parent
        if (arr.get(childInd(currInd, 1)) < arr.get(currInd)) {
          swap(childInd(currInd, 1), currInd);
          heapifyDown(childInd(currInd, 1));
        }
      }
    }
  }

  // helper method to restore heap after insertion, accepts index of current node
  private void heapifyUp(int currInd) {
    // checks that child value is not root and compares child value against parent value
    // first condition handles case where we're at the root of the heap
    while (currInd != 0 && arr.get(currInd) < arr.get(parentInd(currInd))) {
        // swap child with parent
        // swap is a method of the minHeap class (implicitly called on minHeap object). To call explicitly, write this.swap()
        swap(currInd, parentInd(currInd));
        currInd = parentInd(currInd);
    }
  }

  // helper method to calculate value of left child, accepts index of parent and position of child
  // left child is 1, right child is 2
  private static int childInd(int parent, int childNum) {
    return 2*parent + childNum;
  }

  // helper method to swap values at index1 and index2
  private void swap(int index1, int index2) {
    // temporarily store value at index1
    int temp = arr.get(index1);
    arr.set(index1, arr.get(index2));
    arr.set(index2, temp);
  }

  // helper method to calculate index of parent, accepts index of child
  private static int parentInd(int child) {
    // cast to int because Math.floor() returns a double
    return (int) Math.floor((child - 1)/2);
  }

  // main method
  public static void main (String[] args) {
    MinHeap aHeap = new MinHeap();
    System.out.println(aHeap.find_min()); //
    aHeap.insert(10);
    aHeap.insert(4);
    aHeap.insert(15);
    System.out.println(aHeap.find_min()); // 4
    System.out.println(aHeap.arr); // [4, 10, 15]
    System.out.println(aHeap.get_min()); // 4
    System.out.println(aHeap.find_min()); // 10
    aHeap.insert(20);
    aHeap.insert(0);
    aHeap.insert(30);
    System.out.println(aHeap.get_min()); // 0
  }

}
