import java.util.Stack;

public class InToPostfix {

  // convert infix expression to posfix
  public static String infixToPostfix(String infix) {
    // stack to store elements
    Stack<Character> store = new Stack<>();
    // postfix expression
    String postfix = "";

    // iterate through characters in string
    int i = 0;
    // use a while loop to prevent pointer from moving forward on every iteration
    // while loop is used similarly to for loop (except pointer is controlled with a conditional)
    while (i < infix.length()) {
      // current character in string
      char curr = infix.charAt(i);

      // store top value of stack for comparison (only runs if stack is not empty)
      if (!store.empty()) {
        char top = store.peek();

        // compare top of stack with curr element
        if (setPrecedence(top) <= setPrecedence(curr)) {
          // append to postfix
          // if we pop, then we remain on the same element and compare again
          postfix += store.pop();
        } else {
          // push value to stack if lower precedence
          store.push(curr);
          // pointer is only updated if value is pushed to stack
          i++;
        }
      // handles an empty stack
      } else {
        // push current value to stack if stack is empty and update iterator
        store.push(curr);
        i++;
      }
    }

    // empty stack after iterating through string
    while (!store.empty()) {
      // append to postfix
      postfix += store.pop();
    }
    return postfix;
  }

  // helper method to assign precedence to character
  // Precedence: operands 1, mult/div 2, add/sub 3
  // ASCII codes -> * 42, + 43, - 45, / 47, numbers 48 - 57
  private static int setPrecedence(char element) {
    // numbers
    // cast char element to int and compare with ascii code
    if ((int)element >= 48) {
      return 1;
    // mult/div
    } else if ((int)element == 42 || (int)element == 47) {
      return 2;
    // add/sub
    } else {
      return 3;
    }
  }

  // evaluate a postfix expression
  public static int postfixEval(String postfix) {
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
    System.out.println(infixToPostfix(infix));
    String postfix = infixToPostfix(infix);
    System.out.println(postfixEval(postfix));
  }
}
