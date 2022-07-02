import java.util.Arrays;

public class DisjointSet {

  // array to hold sets
  private int[] sets;
  // cardinality of universal set
  private int cardinality;

  // constructor
  // accepts argument for number of elements in universal set
  // elements in universal set correspond to indices in sets (0 to cardinality - 1)
  public DisjointSet(int cardinality) {
    this.cardinality = cardinality;
    // initialize sets with input cardinality
    sets = new int[cardinality];
    // fill sets with -1, all sets are initially disjoint
    Arrays.fill(sets, -1);
  }

  // union (combines two sets)
  // accepts arguments for parents of setA and setB
  public void union(int setAParent, int setBParent) {

  }

  // find (returns parent of i)
  public static int findParent(DisjointSet set, int setElem) {
    // reference to sets array in DisjointSet
    int[] methodSet = set.sets;
    // pointer to current index
    int curr = setElem;

    // iterate as long as we're not on a parent element
    // parent element will have negative value at index
    while (methodSet[curr] >= 0) {
      // update curr to parent of current index
      curr = methodSet[curr];
    }

    return curr;
  }

  // main method
  public static void main(String[] args) {
    DisjointSet test = new DisjointSet(10);
    System.out.println(find(test,2));
  }
}
