public class AVLTree {

  // root node
  private Node root;

  // AVLTree constructor
  public AVLTree() {}

  // private Node class
  private class Node {

    // data field
    private int data;
    // height of node
    private int height;
    // left and right child
    private Node left;
    private Node right;

    // constructor (empty)
    public Node() {}

    // constructor (data)
    public Node(int data) {
      this.data = data;
    }
  }

  // insert node in AVL tree
  public void insert(int data) {
    // insert data into AVL tree according to BST properties
    // calculate height of each node during insertion
    BSTInsert(root);

    // store address of unbalanced node
    Node unbalanced = null;
    Node curr = root;

    // iterate through tree to inserted node
    while (curr != null) {
      // break loop if curr node is unbalanced and store address
      if ((unbalanced(curr)) > 1 || unbalanced(curr) < -1) {
        unbalanced = curr;
        break;
      }
      // update curr to traverse to left or right child
      if (data < curr.left) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }

    // call appropriate rotation on unbalanced node
    if (unbalanced != null) {

    }
  }

  // recursive node insertion according to BST properties
  // node height is calculated after insertion upon return
  private static Node BSTInsert(Node curr, int data) {
    // base case: check for null node in tree (insertion location of new node)
    if (curr == null) {
      // initialize new node with input data
      Node insertNode = new Node(data);
      // set inserted node height at 0 (leaf node)
      insertNode.height = 0;
      // return address of inserted node
      return insertNode;
    }
    // handle duplicates (come back to this)
    if (data == curr.data) {
      return;
    }
    // recursive call on left or right child after comparing curr's data to input data
    if (data < curr.data) {
      Node child = recursiveBSTInsert(curr.left, data);
      // link curr to returned child node
      curr.left = child;
      // calculate height of curr node and set height field
      curr.height = height(curr);
      return curr;
    } else {
      recursiveBSTInsert(curr.right, data);
      curr.right = child;
      curr.height = height(curr);
      return curr;
    }
  }

  // LL rotation
  private void LLRotate(Node unbalanced) {
    // balance factor of -2
    // move subtree root to right child
    Node newRoot = unbalanced.right;
    // point left node of right child back at unbalanced node
    newRoot.left = unbalanced;
    // point unbalanced right child to null;
    unbalanced.right = null;
  }

  // RR rotation
  private void RRRotate(Node unbalanced) {
    // balance factor of 2
    // move subtree root to left child
    Node newRoot = unbalanced.left;
    // point right node of left child back at unbalanced node
    newRoot.right = unbalanced;
    // point unbalanced left child to null;
    unbalanced.left = null;
  }

  // LR rotation
  private void LRRotate(Node unbalanced) {

  }

  // RL rotation
  private void RLRotate(Node unbalanced) {

  }

  // calculate height of node
  private static int height(Node curr) {
    // perform a postorder traversal starting at curr
    // leaf node = 0 because we're counting edges below the node
    // null tree = -1;

    // return -1 for null node
    // we add 1 when returning from a leaf node so the height of a leaf node ends up being 0
    if (curr == null) {
      return -1;
    }
    // recursive call on left and right child
    int leftSubtree = height(curr.left);
    int rightSubtree = height(curr.right);
    // calculate max of left and right subtree heights and add 1
    return Math.max(leftSubtree, rightSubtree) + 1;
  }

  // calculate balance factor of node
  private static int balanceFactor(Node curr) {
    if (curr.left == null) {
      return curr.right.height;
    } else if (curr.right == null) {
      return curr.left.height;
    }
    return curr.left.height - curr.right.height;
  }

  // main method
  public static void main(String[] args) {

  }
}
