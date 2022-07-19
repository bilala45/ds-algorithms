import java.util.LinkedList;

public class ClosedHashMap {

  // array of linked lists to store data in hash map
  private LinkedList<Integer>[] hashMap;

  // constructor
  public ClosedHashMap() {
    // initialize hash map of size 10
    hashMap = new LinkedList[10];
  }

  // hash function
  private static int hashFunction(int key) {
    // mod key with 10 and return result
    return key%10;
  }

  // insert value in hash map
  public void insert(int key) {
    // hash key to get mapping index
    int index = hashFunction(key);

    // handle collisions with chaining
    if (hashMap[index] == null) {
      hashMap[index] = new LinkedList<Integer>();
    }
    // insert key at index
    hashMap[index].add(key);
  }

  // search value in hash map
  public boolean search(int key) {
    // hash key to get mapping index
    int index = hashFunction(key);

    // hash key and then check if key is located in list at index
    if (hashMap[index] != null && hashMap[index].contains(key)) {
      return true;
    }
    return false;
  }

  // delete value from hash map
  public Integer delete(int key) {
    // hash key to get mapping index
    int index = hashFunction(key);

    // hash key and then check if key is located in list at index
    if (hashMap[index] != null) {
      // retrieve index of key in list
      int listIndex = hashMap[index].indexOf(key);

      // indexOf returns -1 if value is not in list
      // remove from list if value is in list
      if (listIndex != -1) {
        return hashMap[index].remove(listIndex);
      }
    }
    return null;
  }

  // main method
  public static void main(String[] args) {
    ClosedHashMap test = new ClosedHashMap();
    test.insert(5);
    test.insert(28);
    test.insert(13);
    test.insert(23);
    System.out.println(test.search(13));
    System.out.println(test.search(28));
    System.out.println(test.delete(5));
    System.out.println(test.delete(242));
    System.out.println(test.search(5));
    System.out.println(test.search(23));
  }
}
