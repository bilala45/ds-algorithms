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

      if (trav == null) {
        System.out.println("Index is greater than length of list");
      } else {
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
      Node trav = head;

      // traverse list to node that will be deleted
      // add condition to check that we haven't reached the end of the list
      for (int trackIndex = 0 ; trackIndex < index && trav != null ; trackIndex++) {
        trav = trav.next;
      }

      // condition for if traversal pointer has exceeded list indices
      if (trav == null) {
        return null;
      } else {
        // save data in current node (we will return this value)
        int nodeData = trav.data;

        // check that current node is not the last node in the list
        if (trav.next != null) {
          // link current node to node ahead of node to be deleted
          trav.prev.next = trav.next;
          // link node ahead of deleteNode to current node
          trav.next.prev = trav.prev;
        // condition if node being deleted is the last node in list
        } else {
          trav.prev.next = null;
        }
        return nodeData;
      }
    }
  }

  // reverse doubly linked list
  public void reverse() {

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
    System.out.println(test.delete(3));
    test.display();
  }
}
