import java.util.Queue;
import java.util.LinkedList;

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

  // recursive preorder traversal of binary tree
  // static method because we're not changing the state of an object
  public static void recurPreOrder(Node curr) {
    // function returns if curr is null
    if (curr != null) {
      // print data in current node
      System.out.println(curr.data);
      // recursive call on left and right node
      recurPreOrder(curr.left);
      recurPreOrder(curr.right);
    }
  }

  // recursive inorder traversal of binary tree
  public static void recurInOrder(Node curr) {
    if (curr != null) {
      // recursive call on left node first
      recurInOrder(curr.left);
      // print data in current node
      System.out.println(curr.data);
      // recursive call on right node
      recurInOrder(curr.right);
    }
  }

  // recursive postorder traversal of binary tree
  public static void recurPostOrder(Node curr) {
    if (curr != null) {
      // recursive call on left and right node
      recurPostOrder(curr.left);
      recurPostOrder(curr.right);
      // print data in current node
      System.out.println(curr.data);
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
    test.addNode(7);
    System.out.println("preorder:");
    recurPreOrder(test.root);
    System.out.println("inorder:");
    recurInOrder(test.root);
    System.out.println("postorder:");
    recurPostOrder(test.root);
  }
}
