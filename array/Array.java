public class Array {

  // array contents
  private int[] elems;
  // total size of array
  private int size;
  // number of elements in array
  private int length = 0;

  // constructor
  public Array(int size) {
    this.size = size;
    // initialize elems with size passed into Array
    this.elems = new int[size];
  }

  // displays size of array
  public getSize() {
    return size;
  }

  // displays number of elements in array
  public getLength() {
    return length;
  }

  public static void main (String[] args) {
    Array arr = new Array(5);
  }
}
