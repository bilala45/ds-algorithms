/* If we set removeStart to be a static method, then we don't have to call removeStart on an object (we PASS IN an object instead)
   If we set removeStart to be non-static, it needs to be called on an object (even if we're not actually using that object in our method)
   However, it doesn't make much sense to call a method that "acts in a static manner" in a non-static way (by calling it on an object)
   In LeetCode problems, it's weird becuse our objects are passed in, but the methods are defined non-statically (doesn't seem like best practice)
   Note -> you can still access a static method from a non-static context (but not the other way around) */

public class SLList {

  // pointer to head node
  private Node head;

  // Node class
  public class Node {
    // node data
    private int data;
    // reference to next node
    private Node next;

    // constructor (no arguments)
    public Node(){};

    // constructor (data argument)
    public Node(int data) {
      this.data = data;
    }
  }

  // constructor to instantiate SLList
  // head field is null (since it's not instantiated with a value)
  public SLList() {};

  // display list
  public void display() {
    Node trav = head;

    while (trav != null) {
      System.out.print(trav.data + " -> ");
      trav = trav.next;
    }
    System.out.print("null");
  }

  // display list recursively
  public static void recurDisplay(Node trav) {
    if (trav == null) {
      System.out.print("null");
    } else {
      System.out.print(trav.data + " -> ")
      recurDisplay(trav.next);
    }
  }

  // count list nodes
  public int count() {
    Node trav = this;
    int numNodes = 0;

    while (trav != null) {
      numNodes += 1;
    }

    return numNodes;
  }

  // sum list nodes
  public int sum() {
    Node trav = this;
    int sum = 0;

    while (trav != null) {
      sum += trav.data;
    }

    return sum;
  }

  public static void main(String[] args) {
  }
}
