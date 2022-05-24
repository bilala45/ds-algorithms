public class DLList {

  // head node
  private Node head;

  // class for node in in DLList
  public class Node {
    // pointer to previous node
    private Node prev;
    // pointer to next node
    private Node next;
    // data field
    private int data;

    // constructor (no data)
    public Node() {}

    // constructor (data argument)
    public Node(int data) {
      this.data = data;
    }
  }

  // constructor
  public DLList() {}


  public static void main (String[] args) {
    DLList test = new DLList();
  }
}
