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
  public Node insert(Node curr, int data) {
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
      // update root if curr is also your root node
      if (root == curr) {
        // update curr with new root of balanced subtree
        curr = balance(bf, curr);
        root = curr;
      } else {
        curr = balance(bf, curr);
      }
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
    // height of null is -1
    if (curr.left == null && curr.right == null) {
      return 0;
    } else if (curr.left == null) {
      return -1 - curr.right.height;
    } else if (curr.right == null) {
      return curr.left.height - (-1);
    }
    return curr.left.height - curr.right.height;
  }

  // balance node
  private static Node balance(int balanceFactor, Node unbalanced) {
    // LR rotation - double rotation (left skewed)
    if (balanceFactor == 2 && balanceFactor(unbalanced.left) == -1) {
      return LRRotate(unbalanced);
    // RR - single rotation (left skewed)
    } else if (balanceFactor == 2 && balanceFactor(unbalanced.left) == 1) {
      return RRRotate(unbalanced);
    // RL - double rotation (right skewed)
  } else if (balanceFactor == -2 && balanceFactor(unbalanced.right) == 1) {
      return RLRotate(unbalanced);
    } else {
      return LLRotate(unbalanced);
    }
  }

  // LL rotation
  private static Node LLRotate(Node unbalanced) {
    // balance factor of -2
    // move subtree root to right child
    Node newRoot = unbalanced.right;

    // point unbalanced right child to left subtree of newRoot;
    unbalanced.right = newRoot.left;
    // point left node of newRoot back at unbalanced node
    newRoot.left = unbalanced;

    // calculate new heights
    unbalanced.height = height(unbalanced);
    newRoot.height = height(newRoot);

    return newRoot;
  }

  // RR rotation
  private static Node RRRotate(Node unbalanced) {
    // balance factor of 2
    // move subtree root to left child
    Node newRoot = unbalanced.left;
    // point unbalanced left child to right subtree of newRoot;
    unbalanced.left = newRoot.right;
    // point right node of left child back at unbalanced node
    newRoot.right = unbalanced;

    // calculate new heights
    unbalanced.height = height(unbalanced);
    newRoot.height = height(newRoot);

    return newRoot;
  }

  // LR rotation
  private static Node LRRotate(Node unbalanced) {
    // first rotation
    // store pointer to lowest node and left child of lowest node for first rotation
    Node lowest = unbalanced.left.right;
    Node tempLeft = lowest.left;

    // first rotation
    lowest.left = unbalanced.left;
    unbalanced.left.right = tempLeft;
    unbalanced.left = lowest;

    // calculate heights
    lowest.left.height = height(lowest.left);
    lowest.height = height(lowest);
    unbalanced.height = height(unbalanced);

    // second rotation
    return RRRotate(unbalanced);
  }

  // RL rotation
  private static Node RLRotate(Node unbalanced) {
    // first rotation
    // store lowest node
    Node lowest = unbalanced.right.left;
    // store right child of lowest node
    Node tempRight = lowest.right;

    // first rotation
    lowest.right = unbalanced.right;
    unbalanced.right.left = tempRight;
    unbalanced.right = lowest;

    // calculate heights
    lowest.right.height = height(lowest.right);
    lowest.height = height(lowest);
    unbalanced.height = height(unbalanced);

    // second rotation
    return LLRotate(unbalanced);
  }

  // post order traversal of tree to check if insertion is performed properly
  public static void postOrder(Node curr) {
    if (curr != null) {
      postOrder(curr.left);
      postOrder(curr.right);
      System.out.println("data: " + curr.data + ", height: " + curr.height);
    }
  }

  // main method
  public static void main(String[] args) {
    AVLTree test = new AVLTree();
    test.root = test.insert(test.root, 10);
    test.insert(test.root, 20);
    test.insert(test.root, 30);
    test.insert(test.root, 25);
    test.insert(test.root, 28);
    test.insert(test.root, 27);
    test.insert(test.root, 5);
    postOrder(test.root);
  }
}
