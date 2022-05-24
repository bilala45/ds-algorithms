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
    Node curr = head;
    System.out.print("null <- ");

    while (curr.next != null) {
      System.out.print(curr.data + " <-> ");
      curr = curr.next;
    }

    System.out.println(curr.data + " -> null");
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
      Node curr = head;

      // traverse up to index at which you want to insert
      for (int trackIndex = 0; trackIndex < index - 1 && curr != null; trackIndex++) {
        curr = curr.next;
      }

      if (curr == null) {
        System.out.println("Index is greater than length of list");
      } else {
        // initialize node with insertVal data
        Node insertNode = new Node(insertVal);
        // point insertNode at next node
        insertNode.next = curr.next;
        // point next node back at insertNode if it's not null
        // if next node is null, then you're at the end of the list
        if (curr.next != null) {
          curr.next.prev = insertNode;
        }

        // point current node at insertNode and insertNode back at current node
        curr.next = insertNode;
        insertNode.prev = curr;
      }
    }
  }

  // delete node from list (data in deleted node is returned)
  public Integer delete(int index) {
    // delete node at start of list
    if (index == 0) {
      int headData = head.data;
      // set head at next node
      head = head.next;

      // handles list with >1 node
      if (head != null) {
        head.prev = null;
      }

      return headData;
    // handle delete at all other indices
    } else {
      // traversal node
      Node curr = head;

      // traverse list to node that will be deleted
      // add condition to check that we haven't reached the end of the list
      for (int trackIndex = 0 ; trackIndex < index && curr != null ; trackIndex++) {
        curr = curr.next;
      }

      // condition for if traversal pointer has exceeded list indices
      if (curr == null) {
        return null;
      } else {
        // save data in current node (we will return this value)
        int nodeData = curr.data;

        // check that current node is not the last node in the list
        if (curr.next != null) {
          // link current node to node ahead of node to be deleted
          curr.prev.next = curr.next;
          // link node ahead of deleteNode to current node
          curr.next.prev = curr.prev;
        // condition if node being deleted is the last node in list
        } else {
          curr.prev.next = null;
        }
        return nodeData;
      }
    }
  }

  // reverse doubly linked list
  public void reverse() {
    // pointer to traverse list
    Node curr = head;

    while (curr != null) {
      // set head upon reaching the last node
      if (curr.next == null) {
        head = curr;
      }

      // on each node, save the address to the next node
      Node ahead = curr.next;
      // point next back at prev
      curr.next = curr.prev;
      // point prev at ahead
      curr.prev = ahead;
      // move trav up to ahead
      curr = ahead;
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
    test.display();
    test.reverse();
    test.display();
  }
}
