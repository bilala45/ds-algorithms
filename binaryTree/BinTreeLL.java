import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinTreeLL {

  // root node
  private Node root;

  // node class
  private class Node {
    // node data
    private int data;
    // left and right child
    private Node left;
    private Node right;

    // left and right fields are automatically set to null if values aren't provided in constructor
    // Node constructor (null)
    public Node() {}

    // Node constructor (data)
    public Node(int data) {
      // assign data argument to Node's data field
      this.data = data;
    }
  }

  // binary tree constructor
  // initializes binary tree with root set to null
  public BinTreeLL() {}

  // add node to binary tree
  public void addNode(int nodeData) {
    // queue is an interface that is implemented with the linked list class
    // the queue interface controls what methods of the LinkedList class are exposed
    // by extension, this limits the methods available to us (we can't use all of the LinkedList methods)
    // create a LinkedList object to store node addresses as an implementation of the queue interface
    Queue<Node> nodeQueue = new LinkedList<Node>();

    if (root == null) {
      root = new Node(nodeData);
    } else {
      // enqueue root (allows while loop to run since queue is now non-empty)
      nodeQueue.offer(root);

      // iterate until nodeQueue is empty
      while (nodeQueue.peek() != null) {
        // initialize traversal pointer to point to dequeued node
        Node curr = nodeQueue.poll();

        // we assume that our binary tree can't have empty spaces (must be complete)
        // enqueue left child if present
        if (curr.left != null) {
          nodeQueue.offer(curr.left);
        // add new node as left child if null
        } else {
          curr.left = new Node(nodeData);
          // break condition to exit loop
          break;
        }

        // repeat for right child
        if (curr.right != null) {
          nodeQueue.offer(curr.right);
        } else {
          curr.right = new Node(nodeData);
          // break condition to exit loop
          break;
        }
      }
    }
  }

  // level order traversal of tree
  public static void levelOrder(BinTreeLL tree) {
    // track current node in tree while traversing
    // initialize curr as root
    Node curr = tree.root;

    // initialize queue to track children of nodes from left to right
    /* Queue is the interface, LinkedList is the class implementation
    The methods specified in queue are all that can be accessed by the LinkedList class */
    Queue<Node> nodeQ = new LinkedList<Node>();
    // enqueue root in nodeQ
    nodeQ.offer(curr);

    // iterate until queue is empty
    while (nodeQ.peek() != null) {
      // get current node for iteration by dequeuing from nodeQ
      curr = nodeQ.poll();

      // process data at current node
      System.out.println(curr.data);

      // enqueue left and right child of current node
      // check that each child is not null before enqueuing
      // don't want to enqueue null objects because we can't access fields of null object - throws null pointer exception
      if (curr.left != null) {
        nodeQ.offer(curr.left);
      }
      if (curr.right != null) {
        nodeQ.offer(curr.right);
      }
    }
  }

  // recursive preorder traversal of binary tree
  // static method because we're not changing the state of an object
  public static void recurPreOrder(Node curr) {
    // function returns if curr is null
    if (curr != null) {
      // print data in current node
      System.out.println(curr.data);
      // recursive call on left and right child
      recurPreOrder(curr.left);
      recurPreOrder(curr.right);
    }
  }

  // iterative preorder traversal of binary tree
  public static void iterPreOrder(BinTreeLL tree) {
    // pointer to track current node - initialize as tree root
    Node curr = tree.root;

    // stack to store parent node of current node
    // necessary because tree links only move from parent to child but we need a way to move from child to parent
    Stack<Node> parentStack = new Stack<Node>();

    // iterate as long as stack is non-empty and curr is not equal to null
    /* curr != null handles the start of our iteration (when our stack is empty)
       it also handles our empty stack when we've traversed the entire left side and only the right side remains */
    // we use the OR operator because our loop should only terminate when both the stack is empty and curr is null
    while (!(parentStack.empty() && curr == null)) {
      // process current node, push its address to stack and move to its left child
      // execute if node is NOT null (since a null node would not have a data or child field)
      if (curr != null) {
        // process data at current node
        System.out.println(curr.data);

        // store address of node to come back to right child after updating curr to left child
        parentStack.push(curr);
        // update current node to left child
        curr = curr.left;
      // if current node is null, return to parent node and try the right child
      } else {
        // reset curr to parent of null node by retrieving address from stack
        curr = parentStack.pop();

        // update current node to right child
        curr = curr.right;
      }
    }
  }

  // recursive inorder traversal of binary tree
  public static void recurInOrder(Node curr) {
    if (curr != null) {
      // recursive call on left child
      recurInOrder(curr.left);
      // print data in current node
      System.out.println(curr.data);
      // recursive call on right child
      recurInOrder(curr.right);
    }
  }

  // iterative inorder traversal of binary tree
  public static void iterInOrder(BinTreeLL tree) {
    // traversal pointer initialized to tree root
    Node curr = tree.root;

    // stack to store nodes in tree
    Stack<Node> parentStack = new Stack<Node>();

    // stop iterating when both curr is null and stack is empty
    while (!(parentStack.isEmpty() && curr == null)) {
      // if curr is not pointing to null, store curr in stack and then move to left child of curr
      if (curr != null) {
        // push curr to stack
        parentStack.push(curr);

        // move to left child of curr
        curr = curr.left;
      } else {
        // pop parent of curr pointer
        curr = parentStack.pop();

        // process parent (since we're returning from null left child)
        System.out.println(curr.data);

        // move to right child of curr
        curr = curr.right;
      }
    }
  }

  // recursive postorder traversal of binary tree
  public static void recurPostOrder(Node curr) {
    if (curr != null) {
      // recursive call on left then right child
      recurPostOrder(curr.left);
      recurPostOrder(curr.right);
      // print data in current node
      System.out.println(curr.data);
    }
  }

  // iterative postorder traversal of binary tree
  // come back to this
  public static void iterPostOrder(BinTreeLL tree) {
    // pointer to current node in tree (initialize to root)
    Node curr = tree.root;

    // initialize stack to hold parent nodes
    Stack<Node> parentStack = new Stack<>();

    // iterate through tree nodes
    // stop when stack is empty and curr points to null
    while (!(parentStack.isEmpty() && curr == null)) {
      if (curr != null) {
        // store current node in stack
        parentStack.push(curr);

        // move to left child
        curr = curr.left;
      } else {
        // pop parent node from stack
        curr = parentStack.pop();

        // push current node in stack again (to process current node)
        parentStack.push(curr);

        // move to right child
        curr = curr.right;
      }
    }
  }

  // sum node data
  public static int sumNodes(Node treeNode) {
    // base case: null node
    if (treeNode == null) {
      return 0;
    } else {
      // recurse to left and right subtree and sum nodes
      int leftSubtree = sumNodes(treeNode.left);
      int rightSubtree = sumNodes(treeNode.right);
      // sum subtree with data in current node
      return leftSubtree + rightSubtree + treeNode.data;
    }
  }

  // count nodes
  public static int count(Node treeNode) {
    // base case: null node
    if (treeNode == null) {
      return 0;
    } else {
      int leftSubtree = count(treeNode.left);
      int rightSubtree = count(treeNode.right);
      // add 1 to count the current node
      /* Think of an example tree with only a root node (tree with one node)
         Both the left and right subtree evaluate to 0
         We need a way to count the single root node, so we add 1 */
      return leftSubtree + rightSubtree + 1;
    }
  }

  // count nodes with degree 2
  public static int countDegreeTwo(Node treeNode) {
    // base case: null node
    if (treeNode == null) {
      return 0;
    } else {
      int leftSubtree = countDegreeTwo(treeNode.left);
      int rightSubtree = countDegreeTwo(treeNode.right);
      // add 1 if both children are present
      if (treeNode.left != null && treeNode.right != null) {
        return leftSubtree + rightSubtree + 1;
      // return sum from descendants if missing both children
      } else {
        return leftSubtree + rightSubtree;
      }
    }
  }

  // main method
  public static void main(String[] args) {
    BinTreeLL test = new BinTreeLL();
    test.addNode(1);
    test.addNode(2);
    test.addNode(3);
    test.addNode(4);
    test.addNode(5);
    test.addNode(6);
    System.out.println("sum: " + sumNodes(test.root));
    System.out.println("count: " + count(test.root));
    System.out.println("degree two: " + countDegreeTwo(test.root));
  }
}
