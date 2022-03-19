import java.util.Stack;

public class StackImp {

  public static void main (String[] args) {
    // Generic var is the type of value stored in the stack
    Stack<Integer> store = new Stack<>();

    // adds item to top of stack
    store.push(1);
    store.push(3);
    store.push(5);

    // removes item from top of stack
    store.pop();
  }
}
