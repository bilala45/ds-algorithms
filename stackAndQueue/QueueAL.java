import java.util.ArrayList;

public class QueueAL {

  // if you import and use a class as a field, you still have to specify the generic's type
  public ArrayList<Integer> queue;
  public int head;
  public int tail;

  // constructor
  public QueueAL() {
    queue = new ArrayList<Integer>();
    head = -1;
    tail = -1;
  }

  // enqueue occurs at the tail
  public void enqueue(int val) {
    // updates head value if our queue is empty so that head doesn't remain stuck at -1
    if (tail == -1) {
      head += 1;
    }
    tail += 1;
    // retrieiving value at index in ArrayList occurs through get method
    queue.add(tail, val);
  }

  // dequeue occurs at the head
  // value at head is returned
  public int dequeue() {
    if (head != -1) {
      int deqVal = queue.get(head);
      head += 1;
      return deqVal;
    }
    return -1;
  }

  public static void main (String[] args) {
    QueueAL aQueue = new QueueAL();
    aQueue.enqueue(2);
    aQueue.enqueue(4);
    aQueue.enqueue(6);
    System.out.println(aQueue.dequeue()); // 2
  }
}
