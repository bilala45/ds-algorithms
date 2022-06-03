public class Deque {

  // int array to store deque
  private int[] deque;
  // front and back index pointers
  private int front;
  private int back;

  // constructor
  public Deque() {
    // initialize array to hold deque
    deque = new int[10];
    // initialize front and back at -1 to indicate empty deque
    front = -1;
    back = -1;
  }

  // enqueue at front of deque
  public void enqueueFront(int val) {
    if (front == 0 || front == -1) {
      System.out.println("Front of deque is full");
    } else {
      front -= 1;
      deque[front] = val;
    }
  }

  // enqueue at back of deque
  public void enqueueBack(int val) {
    // empty deque condition
    if (front == -1) {
      // update front and back pointer to first index
      front = 0;
      back = 0;
      // insert value
      deque[front] = val;
    } else if (front == deque.length - 1) {
      System.out.println("Back of deque is full");
    } else {
      // update front pointer
      back += 1;
      // insert value
      deque[back] = val;
    }
  }

  // dequeue from front of deque
  public Integer dequeueFront() {
    if (front == deque.length) {
      System.out.println("Queue is empty");
      return null;
    } else {
      // store front val for return
      int frontVal = deque[front];
      // update front
      front += 1;
      return frontVal;
    }
  }

  // dequeue from back of deque
  public Integer dequeueBack() {
    // handle empty deque
    if (back == -1) {
      System.out.println("Queue is empty");
      return null;
    } else {
      // store value that back is pointing to
      int backVal = deque[back];
      // update back
      back -= 1;
      return backVal;
    }
  }

  public static void main(String[] args) {
    Deque test = new Deque();
    test.enqueueBack(1);
    test.enqueueBack(3);
    test.enqueueBack(5);
    test.enqueueBack(7);
    test.enqueueBack(9);
    System.out.println(test.dequeueFront());
    System.out.println(test.dequeueFront());
    test.enqueueFront(4);
    test.enqueueFront(2);
    test.enqueueFront(1);
    System.out.println(test.dequeueFront());
    test.enqueueFront(1);
    System.out.println(test.dequeueFront());
  }
}
