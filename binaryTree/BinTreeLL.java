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
        Node trav = nodeQueue.poll();

        // we assume that our binary tree can't have empty spaces (must be complete)
        // enqueue left child if present
        if (trav.left != null) {
          nodeQueue.offer(trav.left);
        // add new node as left child if null
        } else {
          trav.left = new Node(nodeData);
          // break condition to exit loop
          break;
        }

        // repeat for right child
        if (trav.right != null) {
          nodeQueue.offer(trav.right);
        } else {
          trav.right = new Node(nodeData);
          // break condition to exit loop
          break;
        }
      }
    }
  }

  // main method
  public static void main(String[] args) {
    BinTreeLL test = new BinTreeLL();
    test.addNode(1);
    test.addNode(2);
    test.addNode(3);
  }
}
