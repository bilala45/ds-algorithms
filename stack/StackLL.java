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
  public Integer pop() {
    // check if stack is empty
    if (!this.isEmpty()) {
      // removes head element of list and returns it
      return stack.remove();
    }
    // prints if stack is empty
    System.out.println("Stack is empty");
    return null;
  }

  // peek at top of stack
  public Integer peek() {
    if (!this.isEmpty()) {
      // retrieves head element of list without removing it
      return stack.getFirst();
    }
    System.out.println("Stack is empty");
    return null;
  }

  // check if stack is empty
  public boolean isEmpty() {
    // checks first element of stack
    // if stack is empty, only sentinel node (which has a value of null) should reamin
    if (stack.getFirst() == null) {
      return true;
    }
    return false;
  }

  // main method
  public static void main (String[] args) {
    StackLL test = new StackLL();
    System.out.println(test.isEmpty()); // true
    test.push(3);
    test.push(5);
    test.push(7);
    System.out.println(test.pop()); // 7
    System.out.println(test.pop()); // 5
    System.out.println(test.pop()); // 3
    test.peek();
    test.pop();
    System.out.println(test.isEmpty()); // false
  }
}
