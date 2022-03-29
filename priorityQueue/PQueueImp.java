// if we need a heap or a PQ, we use the PriorityQueue class in Java
import java.util.PriorityQueue;
// to implement a max heap or a PQ with max at the head, we need the Collections class (reverseOrder() method)
import java.util.Collections;

public class PQueueImp {
  public static void main (String[] args) {
    // by default, this is implemented with a MIN heap
    PriorityQueue<Integer> minpq = new PriorityQueue<>();

    // inserts an element into the priority queue
    // can also use offer()
    minpq.add(10);
    minpq.add(4);
    minpq.add(15);
    // peek() shows the element at head of PQ but does not remove it
    System.out.println(minpq.peek()); // 4
    // remove() removes the element at head of PQ
    System.out.println(minpq.remove()); // 4
    System.out.println(minpq.peek()); // 10
    minpq.add(20);
    minpq.add(0);
    minpq.add(30);
    System.out.println(minpq.remove()); // 0

    // to implement a PQ with a MAX heap, use the following:
    /* reverseOrder() returns a comparator that reverses the natural ordering (least to greatest) of a collection implementing the comparable interface
       A comparable object is an object that implements the comparable interface to compare instances of an object
       (this lets us compare objects with no natural ordering by overriding the compareTo() method) */
    // comparators allow us to impose additional ordering or change the natural ordering of a collection of objects
    PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
    // testing to see if it works
    maxpq.add(10);
    maxpq.add(4);
    maxpq.add(15);
    System.out.println(maxpq.peek()); // 15 (max value)

  }
}
