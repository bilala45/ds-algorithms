import java.util.LinkedList;

public class HashMap {

  // array of linked lists to store data in hash map
  private LinkedList<Integer>[] hashMap;

  // constructor
  public HashMap() {
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

  // main method
  public static void main(String[] args) {
    HashMap test = new HashMap();
    test.insert(5);
    test.insert(28);
    test.insert(13);
  }
}
