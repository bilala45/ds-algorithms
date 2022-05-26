import java.util.LinkedList;

public class StackLL {

  // create stack in linked list
  private LinkedList<Integer> stack;

  // constructor
  public StackLL() {
    stack = new LinkedList<>();
    // add a sentinel node containing null at the end of the list
    // push and pop all elements ahead of the sentinel node
    stack.add(null);
  }

  // push element onto stack
  public void push(int pushElem) {
    // append pushElem to head of list
    stack.addFirst(pushElem);
  }

  // pop element off stack
  public int pop() {
    return stack.remove();
  }

  // peek at top of stack
  public int peek() {
    // retrieves head element of list
    return stack.getFirst();
  }

  // check if stack is empty

  // check if stack is full


  // main method
  public static void main (String[] args) {
    StackLL test = new StackLL();
    test.push(3);
    test.push(5);
    test.push(7);
    System.out.println(test.pop()); // 7
    System.out.println(test.peek()); // 5
  }
}
