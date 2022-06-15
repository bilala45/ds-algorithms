public class BinSearchTree {

  // root node
  private Node root;

  // node class
  private class Node {

    // data field
    private int data;
    // child nodes
    private Node left;
    private Node right;

    // empty constructor
    private BinSearchTree() {}

    // constructor with data passed in
    private BinSearchTree(int data) {
      this.data = data;
    }
  }

  // constructor
  public BinSearchTree() {}

  // insert node in BST
  public void insertNode(int nodeData) {

  }

  // iterative search in BST
  public static boolean iterSearchBST(BinSearchTree tree, int key) {
    // check that tree contains values
    if (tree.root != null) {
      // initialize curr pointer at tree root
      Node curr = tree.root;

      // traverse tree levels until leaf node is reached
      while (curr != null) {
        // break loop if key matches data at current node
        if (curr.data == key) {
          return true;
        // move to right subtree if key is greater than data at current node
        } else if (key > curr.data) {
          curr = curr.right;
        // move to left subtree if key is less than data at current node
        } else {
          curr = curr.left;
        }
      }
    }
    return false;
  }

  // recursive search in BST
  public static boolean recurSearchBST(Node currNode, int key) {
    // check for null node
    if (currNode == null) {
      return false;
    }
    // compare key to data in currNode
    if (currNode.data == key) {
      return true;
    } else if (key > currNode.data) {
      recurSearchBST(currNode.right, key);
    } else {
      recurSearchBST(currNode.left, key);
    }
  }

  // main method
  public static void main(String[] args) {

  }
}
