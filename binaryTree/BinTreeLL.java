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

  // main method
  public static void main(String[] args) {

  }
}
