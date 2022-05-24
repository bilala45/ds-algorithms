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

  // display list
  public void display() {
    Node trav = head;
    System.out.print("null <- ");

    while (trav.next != null) {
      System.out.print(trav.data + " <-> ");
      trav = trav.next;
    }

    System.out.println(trav.data + " -> null");
  }

  // insert node at start
  public void insertStart(int insertVal) {
    // initialize node to store data passed in
    Node insertNode = new Node(insertVal);
    // point prev field of insertNode at null
    insertNode.prev = null;

    // condition if list is empty
    if (head == null) {
      insertNode.next = null;
      // set head at insertNode
      head = insertNode;
    } else {
      // point next field of insertNode at head
      insertNode.next = head;
      // point prev field of head at insertNode
      head.prev = insertNode;
      // set head at insertNode
      head = insertNode;
    }
  }

  // insert node at specified index
  public void insert(int insertVal, int index) {
    if (index == 0) {
      this.insertStart(insertVal);
    } else {
      // node to traverse list
      Node trav = head;

      // traverse up to index at which you want to insert
      for (int trackIndex = 0; trackIndex < index - 1 && trav != null; trackIndex++) {
        trav = trav.next;
      }

      if (trav != null) {
        // initialize node with insertVal data
        Node insertNode = new Node(insertVal);
        // point insertNode at next node
        insertNode.next = trav.next;
        // point next node back at insertNode if it's not null
        // if next node is null, then you're at the end of the list
        if (trav.next != null) {
          trav.next.prev = insertNode;
        }

        // point current node at insertNode and insertNode back at current node
        trav.next = insertNode;
        insertNode.prev = trav;
      }
    }
  }

  // main method
  public static void main (String[] args) {
    DLList test = new DLList();
    test.insert(1,0);
    test.insert(3,1);
    test.insert(5,2);
    test.insert(7,3);
    test.insert(9,4);
    test.insert(11,10);
    test.display();
  }
}
