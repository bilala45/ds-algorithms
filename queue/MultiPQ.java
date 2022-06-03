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

  public void displayPQ() {
    // print PQ1
    System.out.print("Queue 1: [ ");
    for (int i = 0 ; i < pq1.length ; i++) {
      System.out.print(pq1[i] + " ");
    }
    System.out.println("]");

    // print PQ2
    System.out.print("Queue 2: [ ");
    for (int i = 0 ; i < pq2.length ; i++) {
      System.out.print(pq2[i] + " ");
    }
    System.out.println("]");
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

  // dequeue from priority queue according to priority
  public Integer dequeuePQ() {
    // check if PQ1 is empty
    if (!isEmpty(pq1, front1, back1)) {
      // dequeue from pq1
      int deqVal = pq1[front1];
      pq1[front1] = 0; // test
      front1 += 1;
      return deqVal;
    // if PQ1 is empty, dequeue from PQ2
    } else if (isEmpty(pq1, front1, back1)) {
      // check that PQ2 is non-empty
      if (!isEmpty(pq2, front2, back2)) {
        // dequeue from pq2
        int deqVal = pq2[front2];
        pq2[front2] = 0; // test
        front2 += 1;
        return deqVal;
      }
    }
    // both queues are empty
    System.out.println("Queues are empty");
    return null;
  }

  // helper method to check if queue is empty
  private static boolean isEmpty(int[] queue, int front, int back) {
    if (front == -1 || front > back) {
      return true;
    }
    return false;
  }

  // main method
  public static void main (String[] args) {
    MultiPQ test = new MultiPQ();
    test.enqueue(1,1);
    test.enqueue(3,1);
    test.enqueue(2,2);
    test.enqueue(4,2);
    test.displayPQ();
    test.dequeuePQ();
    test.dequeuePQ();
    test.displayPQ();
  }
}
