public class TwoThreeTree {

  // node class
  public class Node {

    // data fields
    private int data1;
    private int data2;

    // child fields
    private Node left;
    private Node middle;
    private Node right;

    // empty node constructor
    public Node() {}

    // node constructor with data for both key fields
    public Node(int data1, int data2) {
      // assign arguments to fields
      this.data1 = data1;
      this.data2 = data2;
    }

    // node constructor with data for single key field
    public Node(int data1) {
      this.data1 = data1;
    }

    public Node(int data2) {
      this.data2 = data2;
    }
  }

  // root node
  private Node root;

  // 2-3 tree constructor
  public TwoThreeTree() {}

  // main method
  public static void main(String[] args) {

  }
}
