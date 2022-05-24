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

  // insert node at specified index
  // separate condition for inserting at start is not necessary with sentinel
  public void insert(int insertVal, int index) {
    Node curr = head;

    // traverse to node right before where the new node will be inserted
    for (int trackIndex = 0 ; trackIndex < index && curr != null ; trackIndex++) {
      curr = curr.next;
    }

    if (curr != null) {
      // insert node
      Node insertNode = new Node(insertVal);
      insertNode.next = curr.next;
      curr.next = insertNode;
    } else {
      System.out.println("Index is out of range of list");
    }
  }

  public static void main (String[] args) {
    SLListSentinel test = new SLListSentinel();
    test.display();
    test.insert(2,0);
    test.insert(4,1);
    test.insert(6,2);
    test.insert(8,3);
    test.insert(10,4);
    test.insert(3,5245);
    test.display();
  }
}
