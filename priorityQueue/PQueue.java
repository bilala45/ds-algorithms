/* No need to import MinHeap class since it's in the same directory.
   Just call the class's methods using an instance of the class
   We only need to import if class is in a different package */

// PQ that implements a min heap
public class PQueue {

  public MinHeap pqueue;

  // constructor
  public PQueue() {
    pqueue = new MinHeap();
  }

  // returns min value in PQ without removing it
  public Integer peek() {
    return pqueue.find_min();
  }

  // removes min value from PQ
  public int remove() {
    return pqueue.get_min();
  }

  // inserts given value into PQ
  public void insert(int val) {
    pqueue.insert(val);
  }

  public static void main (String[] args) {
    PQueue aQueue = new PQueue();
    System.out.println(aQueue.peek()); //
    aQueue.insert(10);
    aQueue.insert(4);
    aQueue.insert(15);
    System.out.println(aQueue.peek()); // 4
    System.out.println(aQueue.pqueue.arr); // [4, 10, 15]
    System.out.println(aQueue.remove()); // 4
    System.out.println(aQueue.peek()); // 10
    aQueue.insert(20);
    aQueue.insert(0);
    aQueue.insert(30);
    System.out.println(aQueue.remove()); // 0
  }
}
