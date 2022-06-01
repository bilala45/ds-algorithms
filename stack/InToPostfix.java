import java.util.Stack;

public class InToPostfix {

  // convert infix expression to posfix
  public static String InfixToPostfix(String infix) {
    // stack to store elements
    Stack<Character> store = new Stack<>();
    // postfix expression
    String postfix = "";

    // iterate through characters in string
    for (int i = 0 ; i < infix.length() ; i++) {
      // current character in string
      char curr = infix.charAt(i);

      // repeat as long as stack is non-empty
      // break conditions are added after pushing current element to stack to exit loop
      while (!store.empty()) {
      // store top value of stack for comparison
        char top = store.peek();

        // ASCII codes -> * 42, + 43, - 45, / 47, numbers 48 - 57
        // number at top of stack
        if ((int)top >= 48) {
          // append to postfix
          postfix += store.pop();
        }
        // multiplication/division at the top
        else if ((int)top == 42 || (int)top == 47) {
          // if current element is number, push current element
          if ((int)curr >= 48) {
            store.push(curr);
            break;
          } else {
            postfix += store.pop();
          }
        }
        // addition/subtraction at the top
        else if ((int)top == 43 || (int)top == 45) {
          if ((int)curr >= 47 || (int)curr == 42) {
            store.push(curr);
            break;
          } else {
            postfix += store.pop();
          }
        }
      }
      // push curr element if all values are removed from stack
      if (store.empty()) {
        store.push(curr);
      }
    }
    // empty stack after iterating through string is complete
    while (!store.empty()) {
      // append to postfix
      postfix += store.pop();
    }
    return postfix;
  }

  // main method
  public static void main (String[] args) {
    String infix = "a+b*c-d/e";
    System.out.println(InfixToPostfix(infix));
  }
}
