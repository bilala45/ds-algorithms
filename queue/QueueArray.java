public class QueueArray {

  // implement queue with array
  private int[] queue;
  // front and back pointer
  private int front;
  private int back;

  // constructor
  public QueueArray() {
    queue = new int[3];
    // front and back of queue initialized to -1
    front = -1;
    back = -1;
  }

  // helper method to print front and back index
  private void getFrontBack() {
    System.out.println("Front: " + front);
    System.out.println("Back: " + back);
  }

  // enqueue element at back of queue
  public void enqueue(int enqVal) {
    // enqueue at tail of array
    // if back is at -1 (no elements in queue yet), update front pointer to 1 too
    // we can just check if the queue is empty because an empty queue resets both pointers to -1
    if (this.isEmpty()) {
      // update back pointer
      back += 1;
      // update front pointer
      front += 1;
      // insert element into queue at back
      queue[back] = enqVal;
    }

    else if (!this.isFull()) {
      // update back pointer
      back += 1;
      // insert element into queue at back
      queue[back] = enqVal;
    } else {
      System.out.println("Queue is full.");
    }
  }

  // dequeue element at front of queue
  public Integer dequeue() {
    // check if queue is empty before dequeuing
    if (!this.isEmpty()) {
      // store value at front of queue and update front pointer
      int frontVal = queue[front];
      front += 1;
      return frontVal;
    } else {
      System.out.println("Queue is empty.");
      return null;
    }
  }

  // check if queue is empty
  public boolean isEmpty() {
    // front pointer surpasses back pointer
    // front and back are at original position
    if (front > back || (front == -1 && back == -1)) {
      // reset front and back pointers to reuse spaces in array
      front = -1;
      back = -1;
      return true;
    }
    return false;
  }

  // check if queue is full
  public boolean isFull() {
    // check if back pointer is at the last index in the array
    if (back == queue.length - 1) {
      return true;
    }
    return false;
  }

  public static void main (String[] args) {
    QueueArray test = new QueueArray();
    test.getFrontBack(); // f-1, b-1

    test.enqueue(10);
    test.getFrontBack(); // f0, b0

    test.enqueue(20);
    test.getFrontBack(); // f0, b1

    test.enqueue(30);
    test.getFrontBack(); // f0, b2

    test.dequeue();
    test.getFrontBack(); // f1, b2

    test.dequeue();
    test.getFrontBack(); // f2, b2

    test.dequeue();
    test.getFrontBack(); // f3, b2

    test.dequeue();
    test.getFrontBack(); // f

  }
}
