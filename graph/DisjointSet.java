import java.util.Arrays;

public class DisjointSet {

  // array to hold sets
  private int[] sets;
  // cardinality of universal set
  private int cardinality;

  public DisjointSet(int cardinality) {
    this.cardinality = cardinality;
    // initialize sets with input cardinality
    sets = new int[cardinality];
    // fill sets with -1, all sets are initially disjoint
    Arrays.fill(sets, -1);
  }

  // main method
  public static void main(String[] args) {
    DisjointSet test = new DisjointSet(10);
    System.out.println(test.sets[1]);
  }
}
