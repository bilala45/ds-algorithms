import java.util.Stack;

public class StackProvided {

  // parenthesis matching
  public static boolean parenthesisMatch(String input) {
    // initialize stack to hold parentheses
    Stack<Character> parStack = new Stack<>();

    // iterate over input string
    for (int i = 0 ; i < input.length() ; i++) {
      // ignore characters except opening/closing brackets
      if (input.charAt(i) == '(') {
        parStack.push('(');
      } else if (input.charAt(i) == ')') {
        // return false is stack is empty
        if (parStack.isEmpty()) {
          return false;
        }
        parStack.pop();
      }
    }

    // return true if stack is empty
    if (parStack.isEmpty()) {
      return true;
    }
    // return false for non-empty stack
    return false;
  }

  public static void main (String[] args) {
    String test = "((2 + 3) * (7 * 6))";
    System.out.println(parenthesisMatch(test));
  }
}
