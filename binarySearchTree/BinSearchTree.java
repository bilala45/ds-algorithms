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

  // recursive insert node in BST
  public Node recurInsert(Node curr, int insertData) {
    if (curr == null) {
      // initialize node with insertData
      Node insertNode = new Node(insertData);
      return insertNode;
    }
    // conditions for node that is not null
    // duplicate node data not allowed
    if (curr.data == insertData) {
      return null;
    } else if (insertData > curr.data) {
      curr.right = recurInsert(curr.right, insertData);
    } else {
      curr.left = recurInsert(curr.left, insertData);
    }
    // return curr so that previous node points to curr
    // maintains links up the tree from the newly inserted node
    return curr;
  }

  // iterative delete node in BST
  public void iterDelete(int deleteVal) {
    // node to track current node
    Node curr = root;
    // node to track parent of current node
    Node parent = null;

    // stop iterating when curr is null
    while (curr != null) {
      if (curr.data == deleteVal) {
        replaceCurr(curr, parent);
      }
      // continue traversing if deleteVal doesn't match current node
      parent = curr;
      if (deleteVal > curr.data) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }
    }
  }

  // helper function to replace value at curr with inorder predecessor or successor (if present)
  private static void replaceCurr(Node curr, Node parent) {
    // find inorder predecessor or successor
    // initialize node to store replacement
    Node replace = curr;
    // initialize node to track parent of replacement
    Node repParent = pred;
    // move pred to inorder predecessor
    if (replace.left != null) {
      inPre(replace, repParent, curr);
    // move pred to inorder successor if left is null
    } else if (replace.right != null) {
      inSuc(replace, repParent, curr);
    } else {
      if (parent.right == curr) {
        parent.right = null;
      } else {
        parent.left = null;
      }
    }
  }

  // helper function to find inorder predecessor of node
  private static void inPre(Node pred, Node predParent, Node curr) {
    pred = pred.left;

    if (pred.right != null) {
      // iterate to inorder predecessor
      while (pred.right != null) {
        predParent = pred;
        pred = pred.right;
      }
      // set data in curr to data in pred
      curr.data = pred.data;
      // set parent of pred to null
      predParent.right = null;
    } else {
      // set data in curr to data in pred
      curr.data = pred.data;
      // set parent of pred to null
      predParent.left = null;
    }
  }

  // helper function to find inorder successor of node
  private static void inSuc(Node suc, Node sucParent, Node curr) {
    suc = suc.right;

    if (suc.left != null) {
      // iterate to inorder predecessor
      while (suc.left != null) {
        sucParent = suc;
        suc = suc.left;
      }
      // set data in curr to data in pred
      curr.data = suc.data;
      // set parent of pred to null
      sucParent.left = null;
    } else {
      // set data in curr to data in pred
      curr.data = suc.data;
      // set parent of pred to null
      sucParent.right = null;
    }
  }

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
    test.root = test.recurInsert(test.root, 5);
    test.recurInsert(test.root, 7);
    test.recurInsert(test.root, 6);
    test.recurInsert(test.root, 11);
    test.recurInsert(test.root, 9);
    test.recurInsert(test.root, 3);
    System.out.println("Traversal");
    inOrderTrav(test.root);
    test.iterDelete(7);
    System.out.println("Traversal after delete");
    inOrderTrav(test.root);
  }
}
