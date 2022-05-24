public class SLListSentinel {

  Node head;

  // node class
  public class Node {
    // field to store node's data
    private int data;
    // pointer to next node in list
    private Node next;

    // node constructor
    public Node() {}

    // node constructor (with data)
    public Node(int data) {
      this.data = data;
    }
  }

  // constructor for list with sentinel node
  public SLListSentinel() {
    // initialize head as empty node
    head = new Node();
    head.next = null;
  }

  // display list
  public void display() {
    Node curr = head;
    System.out.print("sentinel -> ");
    curr = curr.next;

    while (curr != null) {
      System.out.print(curr.data + " -> ");
      curr = curr.next;
    }
    System.out.println("null");
  }

  public static void main (String[] args) {
    SLListSentinel test = new SLListSentinel();
    test.display();
  }
}
