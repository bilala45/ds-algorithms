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

  // recursive node insertion in AVL tree according to BST properties
  // balancing is done as necessary after each insertion
  // node height is calculated after insertion upon return
  private static Node insert(Node curr, int data) {
    // base case: check for null node in tree (insertion location of new node)
    if (curr == null) {
      // initialize new node with input data
      Node insertNode = new Node(data);
      // set inserted node height at 0 (leaf node)
      insertNode.height = 0;
      // return address of inserted node
      return insertNode;
    }

    // handle duplicate data by returning current node
    if (data == curr.data) {
      return curr;
    }

    // recursive call on left or right child after comparing curr's data to input data
    if (data < curr.data) {
      Node child = insert(curr.left, data);
      // link curr to returned child node
      curr.left = child;
    } else {
      Node child = insert(curr.right, data);
      curr.right = child;
    }

    // the following procedures are common to both children
    // calculate height of curr node and set as height field
    // recursive so heights are updated from the inserted child up to the root node
    curr.height = height(curr);

    // balance nodes
    // calculate curr balance factor
    int bf = balanceFactor(curr);
    // balance curr if node is unbalanced
    if (Math.abs(bf) > 1) {
      balance(curr);
    }

    return curr;
  }

  // calculate height of node
  private static int height(Node curr) {
    //  height of left and right child
    int leftSubtree = curr.left != null ? curr.left.height : -1;
    int rightSubtree = curr.right != null ? curr.right.height : -1;
    // select max of left and right subtree heights and add 1
    return Math.max(leftSubtree, rightSubtree) + 1;
  }

  // calculate balance factor of node
  private static int balanceFactor(Node curr) {
    if (curr.left == null && curr.right == null) {
      return 0;
    } else if (curr.left == null) {
      return 0 - curr.right.height;
    } else if (curr.right == null) {
      return curr.left.height;
    }
    return curr.left.height - curr.right.height;
  }

  // balance node
  private static void balance(int balanceFactor, Node unbalanced) {
    // left skewed
    if (balanceFactor == 2) {
      // LR rotation - double rotation
      if (balanceFactor(curr.left) == -1) {
        LRRotate(curr);
      // RR - single rotation
      } else {
        RRRotate(curr);
      }
    // right skewed
    } else if (balanceFactor == -2) {
      // RL rotation - double rotation
      if (balanceFactor(curr.right) == 1) {
        RLRotate(curr);
      // LL - single rotation
      } else {
        LLRotate(curr);
      }
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

  // main method
  public static void main(String[] args) {

  }
}
