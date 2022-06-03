public class Deque {

  // int array to store deque
  private int[] deque;
  // front and back index pointers
  private int front;
  private int back;

  // constructor
  public Deque() {
    // initialize array to hold deque
    deque = new int[10];
    // initialize front and back at -1 to indicate empty deque
    front = -1;
    back = -1;
  }

  public static void main(String[] args) {

  }
}
