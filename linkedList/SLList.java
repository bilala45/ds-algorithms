public class SLList {

  // SLList always keeps a pointer to the head node of the list
  public Node head;

  // Node class
  public class Node {
    // data stored in node
    public int data;
    // stores reference to next node in list
    public Node next;

    // constructor (no arguments)
    public Node(){};

    // constructor (data argument)
    public Node(int data) {
      this.data = data;
    }
  }

  // constructor to instantiate SLList
  // head node is set to null by default
  public SLList() {};

  // insert node at end of list
  public void insertEnd(SLList list, int data) {
    // reference to the head node in SLList
    Node traverse = list.head;

    // handles an empty list
    if (traverse == null) {
      list.head = new Node(data);
      return;
    }

    // traverses list to add node to end
    while (traverse.next != null) {
      traverse = traverse.next;
    }
    traverse.next = new Node(data);
  }

  // inserts node at start of list
  public void insertStart(SLList list, int data) {
    Node newHead = new Node(data);
    newHead.next = list.head;
    // reassign head field of list to the new node we created (newHead)
    list.head = newHead;
  }

  // remove node from start of list
  public void removeStart(SLList list) {
    list.head = list.head.next;
  }

  // remove node from end of list
  public void removeEnd(SLList list) {
    // reference node to traverse list
    Node traverse = list.head;

    // checks next field of next node so that we don't end up on the last node
    while (traverse.next.next != null) {
      traverse = traverse.next;
    }
    traverse.next = null;
  }

  // prints elements of list
  public void printList() {
    // Node traverse = list.head;
    //
    // // traverses list without checking ahead
    // /* this traversal method is useful when you only need to process the current node
    //    and the next node is not important */
    // while (traverse != null) {
    //   System.out.print(traverse.data + " -> ");
    //   traverse = traverse.next;
    // }
    // System.out.println("null");

    // since we call printList() on an object, we can reference the field's objects WITHOUT using the this keyword
    // We don't need the this keyword unless there is a naming conflict
    Node traverse = head;

    // traverses list without checking ahead
    /* this traversal method is useful when you only need to process the current node
       and the next node is not important */
    while (traverse != null) {
      System.out.print(traverse.data + " -> ");
      traverse = traverse.next;
    }
    System.out.println("null");


  }

  public static void main(String[] args) {
    // instantiate and build list
    SLList aList = new SLList();
    aList.insertEnd(aList, 1);
    aList.insertEnd(aList, 3);
    aList.insertEnd(aList, 5);
    aList.printList();

    // test calls on list
    System.out.println(aList.head.data); // 1
    System.out.println(aList.head.next.data); // 3

    // insert element at beginning of list
    aList.insertStart(aList, 0);
    System.out.println(aList.head.data); // 0
    System.out.println(aList.head.next.data); // 1

    // remove element from start of list
    aList.removeStart(aList);
    System.out.println(aList.head.data); // 1

    // remove element from end of list
    aList.removeEnd(aList);
    aList.removeEnd(aList);
  }
}
