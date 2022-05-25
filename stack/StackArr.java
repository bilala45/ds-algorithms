public class StackArr {

  // array field to form stack
  private int[] stack;
  // index of top of stack
  private int top;

  // constructor with predefined array size
  public StackArr() {
    // predefine size of stack to 10
    stack = new int[10];
    top = -1;
  }

  // constructor with size of array specified
  public StackArr(int size) {
    stack = new int[size];
    top = -1;
  }

  // push elements onto the stack
  public void push(int newElem) {
    if (!this.isFull()) {
      // update top
      top++;
      // place newElem at top
      stack[top] = newElem;
    } else {
      System.out.println("Stack overflow");
    }
  }

  // pop elements off the stack
  public Integer pop() {
    if (!this.isEmpty()) {
      // save item at top of stack
      int popElem = stack[top];
      // decrement top to reflect popped item
      top--;
      return popElem;
    }
    System.out.println("stack is empty")
    return null;
  }

  // peek at top element of stack
  public int peek() {
    // return element at top
    return stack[top];
  }

  // check if stack is empty
  public boolean isEmpty() {
    if (top == -1) {
      return true;
    }
    return false;
  }

  // check if stack is full
  public boolean isFull() {
    // compare top against length of data structure containing stack
    if (top == stack.length - 1) {
      return true;
    }
    return false;
  }

  // main method
  public static void main (String[] args) {
    StackArr testStack = new StackArr();
    System.out.println(testStack.isEmpty());
    System.out.println(testStack.isFull());
    testStack.push(2);
    testStack.push(4);
    testStack.push(6);
    testStack.push(8);
    testStack.push(10);
    testStack.push(12);
    System.out.println(testStack.peek());
    System.out.println(testStack.isEmpty());
    System.out.println(testStack.isFull());
  }
}
