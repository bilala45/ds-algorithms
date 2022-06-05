import java.util.Stack;

public class Queue2Stack {

  // stack fields for enqueue and dequeue
  private Stack<Integer> enq;
  private Stack<Integer> deq;

  public Queue2Stack() {
    // initialize enq and deq stacks
    enq = new Stack<Integer>();
    deq = new Stack<Integer>();
  }

  // insert value in queue
  public void enqueue(int val) {
    // push value to enq stack
    enq.push(val);
  }

  // dequeue value from queue
  public Integer dequeue() {
    // pop from enq stack and push into deq stack until enq stack is empty
    if (deq.empty()) {
      // handles empty queue by checking if enq stack is empty
      if (enq.empty()) {
        System.out.println("Queue is empty");
        return null;
      }
      // iterate through enq stack until empty
      while (!enq.empty()) {
        // pop from enq stack and push into deq stack
        deq.push(enq.pop());
      }
    }
    // pop and return top value of deq stack
    return deq.pop();
  }

  // main method
  public static void main(String[] args) {
    Queue2Stack test = new Queue2Stack();
    test.enqueue(6);
    test.enqueue(4);
    test.enqueue(2);
    System.out.println(test.dequeue());
    System.out.println(test.dequeue());
    test.enqueue(10);
    System.out.println(test.dequeue());
    System.out.println(test.dequeue());
  }
}
