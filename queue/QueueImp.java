// Queue is the interface, LinkedList is the implementing class
// To use LinkedList as an implementation of the Queue interface, you need to import both
import java.util.Queue;
import java.util.LinkedList;

public class QueueImp {

  public static void main (String[] args) {

    // Queue is an interface implemented in the LinkedList class
    /* Don't create a queue with LinkedList<Integer> queue = new LinkedList<>
    because it'll give you access to methods that violate the FIFO principle of a queue */
    Queue<Integer> queue = new LinkedList<>();

    // adds item to tail of queuecd
    // queue.add(val) also works
    queue.offer(5);

    // removes item head of queue
    // queue.remove() also works
    queue.poll();
  }
}
