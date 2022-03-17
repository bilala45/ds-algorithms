import java.util.HashMap;

public class HashMapImp {

  public static void main(String[] args) {
    // Hash map with default capacity (16)
    // define as type HashMap rather than interface Map (not sure why it doesn't work with Map)
    HashMap<String, Integer> defCapacity = new HashMap<>();

    // updated capacity (pass in as argument to constructor)
    // No need to mess with load factor (default is ok)
    HashMap<String, Integer> setCapacity = new HashMap<>(30);

    String[] keyArr = {"a", "b", "c", "d", "e", "f"};
    int[] valueArr = {0, 1, 2, 3, 4, 5};

    // basic operations

    // associates key with value in hash map and returns null
    /* Can override a previously stored value for a key
       previous value is returned if it exists */
    // hash function works beneath the surface (ignore actual implementation)
    for (int i = 0; i < keyArr.length ; i++) {
      // arg1 is key, arg2 is value
      defCapacity.put(keyArr[i], valueArr[i]);
    }

    // returns value associated with key, null otherwise
    // we can use the null condition to check if a key is in our HashMap
    System.out.println(defCapacity);
    System.out.println(defCapacity.get("a")); // should print 0
  }
}
