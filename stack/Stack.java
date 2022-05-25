public class Stack {

  public int[] stack = new int[16];
  public int end = -1;

  // constructor
  public Stack() {};

  // add an integer to end of stack
  // end points to the last item on the stack
  public void push(int val) {
    end += 1;
    stack[end] = val;
  }

  // remove integer from end of stack
  public int pop() {
    int popVal = stack[end];
    end -= 1;
    return popVal;
  }

  public static void main (String[] args) {
    Stack aStack = new Stack();
    aStack.push(0);
    aStack.push(2);
    aStack.push(4);
    System.out.println(aStack.end); // 2
    System.out.println(aStack.pop()); // 4
  }

}
