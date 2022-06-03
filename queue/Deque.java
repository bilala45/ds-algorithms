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
      front += 1;
      // insert value
      deque[front] = val;
    }
  }

  // dequeue from front of deque
  public int dequeueFront() {
<<<<<<< HEAD

=======
    if (front == deque.length) {
      System.out.println("Queue is empty");
    } else {
      // store front val for return
      int frontVal = deque[front];
      // update front
      front += 1;
      return frontVal;
    }
>>>>>>> d81599b (add methods to dequeue from front and back of deque)
  }

  // dequeue from back of deque
  public int dequeueBack() {
    // handle empty deque
    if (back == -1) {
      System.out.println("Queue is empty");
    } else {
<<<<<<< HEAD
      
=======
      // store value that back is pointing to
      int backVal = deque[back];
      // update back
      back -= 1;
      return backVal;
>>>>>>> d81599b (add methods to dequeue from front and back of deque)
    }
  }

  public static void main(String[] args) {

  }
}
