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

  // insert into array
  public void insert(int index, int insertVal) {
    // check that array isn't full
    if (length < size) {
      // iterate backwards through array up to index
      for (int i = length ; i > index ; i--) {
        // shift array elements to the right by one
        this.elems[i] = this.elems[i-1];
      }
      // insert insertVal at index
      this.elems[index] = insertVal;
      // update length
      length++;
    }
  }

  // delete from array
  public void delete(int index) {
    // iterate through array up to index
    for (int i = index ; i < length ; i++) {
      // shift array elements to the left by one
      this.elems[i] = this.elems[i+1];
    }
    // update length
    length--;
  }

  public static void main (String[] args) {
    Array arr = new Array(5);
    System.out.println(arr.getSize());
    arr.append(9);
    arr.append(7);
    arr.append(5);
    arr.display();
    arr.insert(1, 8);
    arr.display();
  }
}
