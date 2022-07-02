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
    // determine larger set
    if (sets[setAParent] < sets[setBParent]) {
      // update setAParent with sum of values in set A and set B
      sets[setAParent] = sets[setAParent] + sets[setBParent];
      // store head of set B as index of set A's parent
      sets[setBParent] = setAParent;
    } else {
      sets[setBParent] = sets[setAParent] + sets[setBParent];
      sets[setAParent] = setBParent;
    }
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

  // display set
  private static void displayDisjointSet(DisjointSet set) {
    for (int i = 0 ; i < set.sets.length ; i++) {
      System.out.print(set.sets[i] + " ");
    }
    System.out.println("");
  }

  // main method
  public static void main(String[] args) {
    DisjointSet test = new DisjointSet(10);
    displayDisjointSet(test);
    test.union(2, 4);
    System.out.println(findParent(test,4));
    displayDisjointSet(test);
  }
}
