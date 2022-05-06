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
  public int getSize() {
    return size;
  }

  // displays number of elements in array
  public int getLength() {
    return length;
  }

  // append value to array
  public void append(int appendVal) {
    if (length < size) {
      elems[length] = appendVal;
      length++;
    } else {
      System.out.println("Array is full.");
    }
  }

  // displays values of array
  public void display() {
    if (length != 0) {
      System.out.print("Elements in array: ");
      for(int i = 0 ; i < length ; i++) {
        System.out.print(this.elems[i] + " ");
      }
      System.out.println("");
    } else {
      System.out.println("Array is empty.");
    }
  }

  public static void main (String[] args) {
    Array arr = new Array(5);
    System.out.println(arr.getSize());
    arr.append(9);
    arr.append(7);
    arr.display();
    System.out.println(arr.getLength());
  }
}
