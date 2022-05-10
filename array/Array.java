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

  // reverse elements of array
  public void reverse() {
    int start = 0;
    // use length field to swap actual elements of array (not garbage values)
    int end = length - 1;

    while (start < end) {
      // swap start and end values
      int temp = elems[start];
      elems[start] = elems[end];
      elems[end] = temp;
      // update start and end pointers
      start++;
      end--;
    }
  }

  // left-shift elements of array
  public void leftShift() {
    int start = 0;

    // update element with element to the right
    while (start < length - 1) {
      elems[start] = elems[start + 1];
      start++;
    }
    length--;
  }

  // right-shift elements of array
  public void rightShift() {

    if (length + 1 <= size) {
      int end = length;

      // update element with element to the left
      while (end > 0) {
        elems[end] = elems[end - 1];
        end--;
      }

      // update length to reflect added value
      length++;
      // set 0th index to null value
      elems[0] = 0;
    } else {
      System.out.println("Array is not big enough to accommodate right shift.");
    }
  }


  // check if array is sorted (ascending)
  public boolean isSorted() {
    int start = 0;

    // iterate to second last value (to prevent ArrayIndexOutOfBounds exception)
    while (start < length - 1) {
      if (elems[start] > elems[start + 1]) {
        return false;
      }
      start++;
    }
    return true;
  }


  public static void main (String[] args) {
    Array arr = new Array(8);
    System.out.println(arr.getSize()); // 8
    arr.append(2);
    arr.append(3);
    arr.append(4);
    arr.append(9);
    arr.append(11);
    arr.append(13);
    arr.display(); // Elements in array: 2 3 4 9 11 13
    arr.rightShift();
    arr.display(); // Elements in array: 0 2 3 4 9 11 13
  }
}
