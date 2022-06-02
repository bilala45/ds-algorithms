public class QueueArray {

  private int[] queue;
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

  // enqueue element in queue
  public void enqueue(int enqVal) {
    // enqueue at tail of array
    // if tail is at -1 (no elements inserted in queue), update head pointer to 1 too
    if (back == -1) {
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

  public static void main (String[] args) {
    QueueArray test = new QueueArray();
    test.getFrontBack(); // f-1, b-1
    System.out.println(test.isEmpty());

    test.enqueue(10);
    test.getFrontBack(); // f0, b0
    System.out.println(test.isEmpty());

    test.enqueue(20);
    test.getFrontBack(); // f0, b1

    test.enqueue(30);
    test.getFrontBack(); // f0, b2

    test.enqueue(40); //
  }
}
