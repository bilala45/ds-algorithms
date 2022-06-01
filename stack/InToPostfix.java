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

  // evaluate a postfix expression
  public static int PostfixEval(String postfix) {
    // stack to store integer values from expression
    Stack<Integer> store = new Stack<>();

    // iterate through string
    for (int i = 0 ; i < postfix.length() ; i++) {
      // current element in string
      char curr = postfix.charAt(i);
      System.out.println("current value: " + curr + " int: " + (int)curr);

      // check if current element is an operator
      if (isOperator(curr)) {
        // pop two values from stack and apply operator
        // top of stack is second operand
        // stack stores characters
        // After popping, ascii value is subtracted from ascii value of 0 which provides the corresponding number
        int operand2 = store.pop();
        System.out.println("operand2: " + operand2);
        int operand1 = store.pop();
        System.out.println("operand1: " + operand1);
        int result = 0;

        // apply operator to operands using switch statements
        // switch statement compares value of "operator" against each case and executes if there's a match
        switch ((int)curr) {
          case 42: result = operand1 * operand2; // *
                   break;
          case 43: result = operand1 + operand2; // +
                   break;
          case 45: result = operand1 - operand2; // -
                   break;
          case 47: result = operand1 / operand2; // /
                   break;
        }
        System.out.println("push value: " + (char)(result+48));

        // push result of operation to stack
        // type cast result to char since stack stores chars
        store.push(result);
      } else {
        // push current element to stack
        store.push(curr - '0');
      }
    }
    System.out.println("final: " + store.peek());
    // return final remaining value in stack
    return store.pop();
  }

  // helper method to check if a value is an operator
  private static boolean isOperator(char input) {
    // use ASCII codes
    if ((int)input >= 48) {
      return false;
    }
    return true;
  }

  // main method
  public static void main (String[] args) {
    String infix = "3+4/2";
    System.out.println(InfixToPostfix(infix));
    String postfix = InfixToPostfix(infix);
    System.out.println(PostfixEval(postfix));
  }
}
