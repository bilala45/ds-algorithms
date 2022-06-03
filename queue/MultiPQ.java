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

  // insert into priority queue
  public void enqueue(int val, int priority) {
    // insert item in queue corresponding to priority
    if (priority == 1) {
      // handles queue with no inserted values yet
      if (front1 == -1) {
        // update front and back pointers
        front1 = back1 = 0;
        pq1[front1] = val;
      // handles full queue
    } else if (back1 == pq1.length - 1) {
        System.out.println("Queue 1 is full");
      // insert into queue
      } else {
        back1 += 1;
        pq1[back1] = val;
      }
    } else if (priority == 2) {
      // handles queue with no inserted values yet
      if (front2 == -1) {
        // update front and back pointers
        front2 = back2 = 0;
        pq2[front2] = val;
      // handles full queue
    } else if (back2 == pq2.length - 1) {
        System.out.println("Queue 2 is full");
      // insert into queue
      } else {
        back2 += 1;
        pq2[back2] = val;
      }
    } else {
      System.out.println("Invalid priority");
    }
  }

  public static void main (String[] args) {
    MultiPQ test = new MultiPQ();
    test.enqueue(1,1);
    test.enqueue(3,1);
    test.enqueue(5,1);
    test.enqueue(7,1);
    test.enqueue(2,2);
    test.enqueue(4,2);
    test.enqueue(9,1);
    test.enqueue(11,1);
  }
}
