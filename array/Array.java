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
    elems = new int[size];
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
        System.out.print(elems[i] + " ");
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
        elems[i] = elems[i-1];
      }
      // insert insertVal at index
      elems[index] = insertVal;
      // update length
      length++;
    }
  }

  // delete from array
  public void delete(int index) {
    // iterate through array up to index
    for (int i = index ; i < length - 1 ; i++) {
      // shift array elements to the left by one
      elems[i] = elems[i+1];
    }
    // update length
    length--;
  }

  // get value at index
  public Integer get(int index) {
    if (index >= 0 && index < length) {
      return elems[index];
    }
    return null;
  }

  // set value at index
  public void set(int index, int updateVal) {
    if (index >= 0 && index < length) {
      elems[index] = updateVal;
    }
  }

  // linear search
  public int linSearch(int searchVal) {
    for (int i = 0 ; i < length ; i++) {
      if (elems[i] == searchVal) {
        return i;
      }
    }
    return -1;
  }

  // find max in array
  public int max() {
    // set integer max (0 doesn't work if our array contains negative values)
    int max = Integer.MIN_VALUE;
    for (int i = 0 ; i < length ; i++) {
      if (elems[i] > max) {
        max = elems[i];
      }
    }
    return max;
  }

  // find min in array
  public int min() {
    // set integer min
    int min = Integer.MAX_VALUE;
    for (int i = 0 ; i < length ; i++) {
      if (elems[i] < min) {
        min = elems[i];
      }
    }
    return min;
  }

  // find sum of elements in array
  public int sum() {
    int sum = 0;
    for (int i = 0 ; i < length ; i++) {
      sum += elems[i];
    }
    return sum;
  }

  public static void main (String[] args) {
    Array arr = new Array(5);
    System.out.println(arr.getSize()); // 5
    arr.append(9);
    arr.append(7);
    arr.append(5);
    arr.display(); // Elements in array: 9 7 5
    arr.insert(1, 8);
    arr.append(2);
    arr.display(); // Elements in array: 9 8 7 5 2
    System.out.println(arr.linSearch(6)); // -1
    System.out.println(arr.sum()); // 31
    System.out.println(arr.max()); // 9
    System.out.println(arr.min()); // 2
  }
}
