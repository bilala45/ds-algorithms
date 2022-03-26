import java.util.ArrayList;
import java.util.Collections;

// PQ that implements a min heap
public class PQueue {

  // initialize ArrayList to store values inserted into PQ
  public ArrayList<Integer> bHeap;

  // constructor
  public PQueue() {
    bHeap = new ArrayList<Integer>();
  }

  // returns min value in PQ without removing it
  public static int find_min(PQueue pq) {
    return pq.bHeap.get(0);
  }

  // // removes the lowest value from the PQ
  // public static int get_min(PriorityQueue heap) {
  //
  // }

  // inserts given value into PQ
  public static void insert_val(PQueue pq, int value) {

    // add value at right-most open position to maintain a complete binary tree
    pq.bHeap.add(value);

    // retrieve index of inserted value
    int currVal = pq.bHeap.size() - 1;

    // initialize parentVal to be 0 (handles edge case where heap has one element)
    int parentVal = 0;
    // calculates parentVal if heap is non-zero
    if (currVal != 0) {
      parentVal = (int) Math.floor((currVal - 1)/2);
    };

    // compare inserted value with parent node
    while (pq.bHeap.get(currVal) < pq.bHeap.get(parentVal)) {
      // swap parent value with inserted value
      Collections.swap(pq.bHeap, currVal, parentVal);

      // update index of inserted value with parent's index
      currVal = parentVal;

      // calculate parentVal's location for next iteration
      if (currVal != 0) {
        parentVal = (int) Math.floor((currVal - 1)/2);
      }
    }
  }

  public static void main (String[] args) {
    PQueue aHeap = new PQueue();
    insert_val(aHeap, 10);
    insert_val(aHeap, 5);
    insert_val(aHeap, 3);
    insert_val(aHeap, 17);
    System.out.println(find_min(aHeap));
    System.out.println(aHeap.bHeap);
  }
}
