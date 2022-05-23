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

  // reverse list (recursive)
  public void recurReverse(Node prev, Node curr) {
    // check if at end of list
    if (curr == null) {
      // update head to point to last node in list
      head = prev;
    } else {
      // slide pointers
      // update prev with curr pointer
      // update curr with curr.next pointer
      recurReverse(curr, curr.next);
      // point curr at prev on the way back
      curr.next = prev;
    }
  }

  // concatenate two lists
  public void concat(SLList addList) {
    Node trav = head;

    while (trav.next != null) {
      trav = trav.next;
    }
    // point last node of list at head node of addList
    trav.next = addList.head;
  }

  // merge two lists
  // make static so method isn't called on a list (we pass both lists in as arguments instead)
  public static SLList merge(SLList first, SLList second) {
    // check that both lists are sorted
    if (first.isSorted() && second.isSorted()) {
      // list traversal vars
      Node travFirst = first.head;
      Node travSecond = second.head;
      // head of merged list
      Node merge = null;
      // trailing var to build merge list
      Node trail = null;

      // set head of merged list and initialize trail pointer
      if (travFirst.data <= travSecond.data) {
        merge = travFirst;
        trail = travFirst;
        travFirst = travFirst.next;
      } else {
        merge = travSecond;
        trail = travSecond;
        travSecond = travSecond.next;
      }

      // traverse as long as we haven't reached the end of either list
      while (travFirst != null && travSecond != null) {
        // compare data at current pointers
        if (travFirst.data <= travSecond.data) {
          // point trail at travFirst
          trail.next = travFirst;
          // update trail to node that it's pointing at
          trail = travFirst;
          // update travFirst to next node on list
          travFirst = travFirst.next;
        } else {
          trail.next = travSecond;
          trail = travSecond;
          travSecond = travSecond.next;
        }
      }

      // point tail of merge list at remaining list
      if (travFirst != null) {
        trail.next = travFirst;
      } else {
        trail.next = travSecond;
      }

      // return head of merged list
      SLList mergedList = new SLList();
      mergedList.head = merge;
      return mergedList;
    }

    // returns null if either list is not sorted
    return null;
  }

  public static void main(String[] args) {
    SLList methodTest = new SLList();
    methodTest.insertEnd(1);
    methodTest.insertEnd(2);
    methodTest.insertEnd(7);

    SLList methodTest2 = new SLList();
    methodTest2.insertEnd(3);
    methodTest2.insertEnd(11);
    methodTest2.insertEnd(11);

    methodTest.display();
    methodTest2.display();

    SLList mergedList = merge(methodTest, methodTest2);
    mergedList.display();

  }
}
