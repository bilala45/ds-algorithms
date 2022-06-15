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
    private Node() {}

    // constructor with data passed in
    private Node(int data) {
      this.data = data;
    }
  }

  // constructor
  public BinSearchTree() {}

  // iterative insert node in BST
  public void iterInsert(int nodeData) {
    // checks for non-empty tree
    if (root != null) {
      // initialize node to point at root
      Node curr = root;
      // initialize node to point at parent of current node
      Node parent = null;

      // iterate while current Node pointer is not null
      while (curr != null) {
        // no repeats in BST
        if (nodeData == curr.data) {
          return;
        }
        // insert into tree
        // move parent node to current node
        parent = curr;
        if (nodeData > curr.data) {
          // move current node to right child
          curr = curr.right;
        } else {
          curr = curr.left;
        }
      }

      // initialize new node with nodeData
      Node insertNode = new Node(nodeData);
      // assign insertNode to left or right child of parent after comparison
      if (nodeData > parent.data) {
        parent.right = insertNode;
      } else {
        parent.left = insertNode;
      }
    // handles empty tree, initialize node containing nodeData and set as root
    } else {
      root = new Node(nodeData);
    }
  }

  // // recursive insert node in BST
  // public static Node recurInsert(Node curr, int insertData) {
  //   if (curr == null) {
  //     // initialize node with nodeData and return
  //     return new Node(insertData);
  //   } else {
  //     if (curr.data == insertData) {
  //       return;
  //     } else if (insertData > curr.data) {
  //       curr.right = recurInsert(curr.right, insertData);
  //     } else {
  //       curr.left = recurInsert(curr.left, insertData);
  //     }
  //   }
  // }

  // iterative search in BST
  // returns address of node
  public static Node iterSearchBST(BinSearchTree tree, int key) {
    // check that tree contains values
    if (tree.root != null) {
      // initialize curr pointer at tree root
      Node curr = tree.root;

      // traverse tree levels until leaf node is reached
      while (curr != null) {
        // break loop if key matches data at current node
        if (curr.data == key) {
          return curr;
        // move to right subtree if key is greater than data at current node
        } else if (key > curr.data) {
          curr = curr.right;
        // move to left subtree if key is less than data at current node
        } else {
          curr = curr.left;
        }
      }
    }
    // return null if value is not found or if tree is empty
    return null;
  }

  // recursive search in BST
  public static Node recurSearchBST(Node curr, int key) {
    // check for null node
    if (curr == null) {
      return null;
    }
    // compare key to data in curr
    if (curr.data == key) {
      return curr;
    } else if (key > curr.data) {
      return recurSearchBST(curr.right, key);
    } else {
      return recurSearchBST(curr.left, key);
    }
  }

  // in order traversal of BST
  public static void inOrderTrav(Node curr) {
    if (curr != null) {
      inOrderTrav(curr.left);
      System.out.println(curr.data);
      inOrderTrav(curr.right);
    }
  }

  // main method
  public static void main(String[] args) {
    BinSearchTree test = new BinSearchTree();
    test.iterInsert(5);
    test.iterInsert(2);
    test.iterInsert(7);
    test.iterInsert(9);
    test.iterInsert(3);
    test.iterInsert(11);
    test.iterInsert(15);
    inOrderTrav(test.root);
    System.out.println(recurSearchBST(test.root, 3));
    System.out.println(iterSearchBST(test, 3));
  }
}
