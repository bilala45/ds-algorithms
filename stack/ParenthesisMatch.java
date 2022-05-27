import java.util.Stack;

public class ParenthesisMatch {

  // parenthesis matching
  public static boolean isParenthesisBalanced(String input) {
    // initialize stack to hold parentheses
    Stack<Character> parStack = new Stack<>();

    // iterate over input string
    for (int i = 0 ; i < input.length() ; i++) {
      // ignore characters except opening/closing brackets
      if (input.charAt(i) == '(') {
        parStack.push('(');
      } else if (input.charAt(i) == ')') {
        // return false is stack is empty (extra closing bracket)
        if (parStack.empty()) {
          return false;
        }
        parStack.pop();
      }
    }
    // ternary operator with return statement
    // returns true if stack is empty, false otherwise
    // a non-empty stack indicates an unmatched opening bracket
    return (parStack.empty()) ? true : false;
  }

  // checks bracket matching for all types of brackets
  public static boolean isBracketBalanced(String input) {
    // initialize stack to hold brackets
    Stack<Character> brStack = new Stack<>();

    // iterate through characters in input string
    for (int i = 0 ; i < input.length() ; i++) {
      char currChar = input.charAt(i);

      // check current position in string against all opening brackets
      if (currChar == '{' | currChar == '[' | currChar == '(') {
        // push opening bracket to stack
        brStack.push(currChar);
      } else if (currChar == '}' | currChar == ']' | currChar == ')') {
        // return false if stack is empty (unmatched closing bracket in string)
        if (brStack.empty()) {
          return false;
        }
        // peek top value of stack
        char topChar = brStack.peek();
        // compare top value and check that opening bracket matches closing bracket
        if (topChar == '{' && currChar == '}') {
          brStack.pop();
        } else if (topChar == '[' && currChar == ']') {
          brStack.pop();
        } else if (topChar == '(' && currChar == ')'){
          brStack.pop();
        }
      }
    }

    // return true if stack is empty, false otherwise
    return (brStack.empty()) ? true : false;
  }

  public static void main (String[] args) {
    String test = "[(2 + 3] * {7 * 6})";
    System.out.println(isBracketBalanced(test));
  }
}
