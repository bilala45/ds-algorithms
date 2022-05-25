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
    // update top
    top++;
    // place newElem at top
    stack[top] = newElem;
  }

  // pop elements off the stack
  public int pop() {
    // save item at top of stack
    int popElem = stack[top];
    // decrement top to reflect popped item
    top--;
    return popElem;
  }

  public static void main (String[] args) {
    StackArr testStack = new StackArr();

  }
}
