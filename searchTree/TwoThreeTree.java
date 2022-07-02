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

    // node constructor with data
    public Node(int data1, int data2) {
      // assign arguments to fields
      this.data1 = data1;
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
