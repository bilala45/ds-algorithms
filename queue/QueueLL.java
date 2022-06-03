public class QueueLL {

  // linked list field to store queue
  private LinkedList queue;
  // front and back node pointers
  private Node front;
  private Node back;

  // add element to back of queue
  public void enqueue(int val) {
    // initialize node with value to be enqueued
    Node enqNode = new Node(val);
    // insert node after back node
    back.next = enqNode;
    // update back to point to enqueued node
    back = back.next;
  }

  // remove element from front of queue
  public int dequeue() {
    // store value at front
    int deqVal = front.data;
    // update front to point to next node
    front = front.next;
    return deqVal;
  )

  // check if queue is empty
  public boolean isEmpty() {
    // no sentinel node used
    if (front == null && back == null) {
      return true;
    }
    return false;
  }

  // return value at front of queue
  public int front() {
    return front.data;
  }

  // return value at back of queue
  public int back() {
    return back.data;
  }

  // main method
  public static void main(String[] args) {

  }
}
