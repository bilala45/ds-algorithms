public class MultiPQ {

  // priority queue (PQ) supports 2 priorities
  // 1 is higher priority than 2
  private int[] pq1;
  private int[] pq2;
  // front and back pointers for each queue
  private int front1, back1, front2, back2;

  // constructor
  public MultiPQ() {
    pq1 = new int[5];
    pq2 = new int[5];
    front1 = back1 = front2 = back2 = -1;
  }

  public static void main (String[] args) {

  }
}
