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

  // insert node at start of list
  public void insertStart(int insertVal) {
    // create new node with insertVal as node's data
    Node insertNode = new Node(insertVal);

    // assign next field of new node to point to head node of list
    insertNode.next = head;
    // move head to point to insertNode
    head = insertNode;
  }

  // insert node at end of list
  public void insertEnd(int insertVal) {
    // list is empty
    // necessary because we traverse by checking ahead which would cause a null pointer exception in an empty list
    if (head == null) {
      head = new Node(insertVal);
    // list contains elements
    } else {
      Node trav = head;
      // check one node ahead to prevent losing access to last node
      while (trav.next != null) {
        trav = trav.next;
      }
      // point next field of last node to new node initialized with insertVal as data
      trav.next = new Node(insertVal);
    }
  }

  // insert at specified index of list
  public void insert(int insertVal, int index) {
    // node inserted at start
    if (index == 0) {
      this.insertStart(insertVal);
    } else {
      Node trav = head;

      // iterate so that i is one less than the index
      // we do this to maintain access to the node JUST BEFORE where we want to insert
      for (int i = 0 ; i < index - 1 && trav != null ; i++) {
        trav = trav.next;
      }

      // insert node if current node is not null
      if (trav != null) {
        // initialize node with insertVal as data
        Node insertNode = new Node(insertVal);
        // point insertNode to next node
        insertNode.next = trav.next;
        // point current node ot insertNode
        trav.next = insertNode;
      }
    }
  }

  // insert an element into a sorted list
  public void insertSorted(int insertVal) {
    // check that list is sorted
    if (this.isSorted()) {
      Node trav = head;
      Node insertNode = new Node(insertVal);

      if (insertVal < trav.data) {
        insertNode.next = head;
        head = insertNode;
      } else {
        // traverse as long as next node isn't null and the data in the next node is less than the value being inserted
        while (trav.next != null && trav.next.data < insertVal) {
          trav = trav.next;
        }

        // insert new node
        insertNode.next = trav.next;
        trav.next = insertNode;
      }
    }
  }

  // check if list is sorted
  public boolean isSorted() {
    Node trav = head;
    // stores data at current node
    int currData = head.data;

    while (trav != null) {
      // compares data at current node against previous node
      if (trav.data < currData) {
        return false;
      }
      // update currData with data at current node and then update traversal pointer
      currData = trav.data;
      trav = trav.next;
    }
    return true;
  }

  // remove duplicates from sorted list
  public void removeDuplicates() {
    Node trav = head;

    // traverse linked list by checking ahead
    while (trav.next != null) {
      // once a duplicate is found, iterate until all duplicates are found
      while (trav.data == trav.next.data) {
        trav.next = trav.next.next;
      }
      trav = trav.next;
    }
  }

  // delete node at specified index in list
  // returns data stored in deleted node
  public Integer delete(int index) {
    Node trav = head;

    if (index == 0) {
      int nodeData = trav.data;
      head = trav.next;
      return nodeData;
    } else {
      for (int i = 0 ; i < index - 1 && trav != null ; i++) {
        trav = trav.next;
      }

      // deletes node if trav is not null
      if (trav != null) {
        // store data in next node
        int nodeData = trav.next.data;
        // point current node two nodes ahead
        trav.next = trav.next.next;
        return nodeData;
      }
      return null;
    }
  }

  // display list
  public void display() {
    Node trav = head;

    while (trav != null) {
      System.out.print(trav.data + " -> ");
      trav = trav.next;
    }
    System.out.println("null");
  }

  // display list (recursive)
  public static void recurDisplay(Node trav) {
    if (trav == null) {
      System.out.println("null");
    } else {
      System.out.print(trav.data + " -> ");
      recurDisplay(trav.next);
    }
  }

  // count list nodes (length of linked list)
  public int count() {
    Node trav = head;
    int numNodes = 0;

    while (trav != null) {
      numNodes += 1;
      trav = trav.next;
    }

    return numNodes;
  }

  // count list nodes (recursive)
  public static int count(Node trav) {
    if (trav != null) {
      return 1 + count(trav.next);
    } else {
      return 0;
    }
  }

  // sum list nodes
  public int sumData() {
    Node trav = head;
    int sum = 0;

    while (trav != null) {
      sum += trav.data;
      trav = trav.next;
    }

    return sum;
  }

  // sum list nodes (recursive)
  public static int recurSumData(Node trav) {
    if (trav != null) {
      return trav.data + recurSumData(trav.next);
    } else {
      return 0;
    }
  }

  // find max in list
  public int findMax() {
    Node trav = head;
    // set to min value so that any value in list will update
    // we use this instead of 0 in case our list contains negative integers
    int max = Integer.MIN_VALUE;

    while (trav != null) {
      if (trav.data > max) {
        max = trav.data;
      }
      trav = trav.next;
    }
    return max;
  }

  // find min in list (recursive)
  public static int findMin(Node trav) {
    // leave variable uninitialized
    int min;

    if (trav == null) {
      return Integer.MAX_VALUE;
    } else {
      // make recursive call on next node of list and store in min
      min = findMin(trav.next);
      // compare returned value to data at current node
      // example: we have list 1 -> 5 -> 11 -> 8 -> null
      // if we're on node 5, we recursively call the function on 11 -> 8 -> null
      // compare the returned value from calling the function on 11 -> 8 -> null against value at current node (5)
      return Math.min(trav.data, min);
    }
  }

  // linear search for value in list (returns index in list)
  public int linSearch(int searchVal) {
    Node trav = head;
    int index = 0;

    while (trav != null) {
      if (trav.data == searchVal) {
        return index;
      }
      index += 1;
      trav = trav.next;
    }
    // return -1 if searchVal is not in list
    return -1;
  }

  // reverse list
  public void reverse() {
    Node prev = null;
    Node ahead = null;
    Node curr = head;

    // loop exits when you reach the last node on the list
    while (curr != null) {
      // place ahead at next node
      ahead = curr.next;
      // point current node to previous node
      curr.next = prev;
      // move previous pointer to current node
      prev = curr;
      // move current pointer to next node
      curr = ahead;
    }

    // set head as previous node in list
    head = prev;
  }

  public static void main(String[] args) {
    SLList methodTest = new SLList();
    methodTest.insertEnd(1);
    methodTest.insertEnd(2);
    methodTest.insertEnd(2);
    methodTest.insertEnd(2);
    methodTest.insertEnd(2);
    methodTest.insertEnd(3);
    methodTest.display();
    methodTest.removeDuplicates();
    methodTest.display();
  }
}
