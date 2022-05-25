import java.util.Stack;

public class QueueWStack {

  // this approach works so well because only ever worries about the first value (the value to be dequeued)
  // As long as the enqueue order is MAINTAINED, it doesn't matter if our queue is separated across two stacks
  /* Process:
     store enqueued values in order on enqueue stack
     if a dequeue is requested, pop and push all values onto the dequeue stack (now all values are available in dequeue order)
     enqueued values can continue to be placed on the enqueue stack
     Crucially, we never disrupt our queue order becuase we don't need to pop off the enqueue stack UNTIL our dequeue stack is empty */

  // stack that stores values in order of enqueue
  Stack<Integer> enqStack;
  // stack that stores the value to be dequeued at the top
  Stack<Integer> deqStack;

  // constructor name must be same as class
  public QueueWStack() {
    // initialize enqStack and deqStack
    // If we don't initialize the fields, we have to initialize in our constructors or our objects will be null
    enqStack = new Stack<Integer>();
    deqStack = new Stack<Integer>();
  }

  // inserts value at tail of queue
  public void enqueue(int val) {
      enqStack.push(val);
  }

  // removes value from head of queue
  public int dequeue() {
    // throw exception to handle dequeueing off empty queue
    if (deqStack.empty() && enqStack.empty()) {
      return -1;
    }

    // if our deqStack is empty, we pop everything off the enqueue stack to put our first value at the top of the deqStack
    if (deqStack.empty()) {
      while (!enqStack.empty()) {
        deqStack.push(enqStack.pop());
      }
    }
    // a non-empty deqStack will just return the first value on the deqStack
    return deqStack.pop();
  }

  public static void main (String[] args) {
    QueueWStack aQueue = new QueueWStack();
    System.out.println(aQueue.dequeue()); // -1
    aQueue.enqueue(1);
    aQueue.enqueue(3);
    aQueue.enqueue(5);
    aQueue.enqueue(7);
    System.out.println(aQueue.dequeue()); // 1
    System.out.println(aQueue.dequeue()); // 3
  }

}
