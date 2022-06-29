import java.util.Queue;
import java.util.LinkedList;

public class UndirectedGraph {

  // adjacency matrix to store graph
  private int[][] graph;
  // vertices in graph
  private int vertices;

  // constructor
  public UndirectedGraph(int vertices) {
    this.vertices = vertices;
    // initialize matrix with size of vertices argument
    graph = new int[vertices][vertices];
  }

  // insert in graph
  public void insert(int vertex, int[] adjacent) {
    if (vertex < vertices) {
      // iterate through values in adjacent matrix
      for (int i = 0 ; i < adjacent.length ; i++) {
        // place a 1 at indices specified in adjacent list
        graph[adjacent[i]][vertex] = graph[vertex][adjacent[i]] = 1;
      }
    }
  }

  // display graph adjacency matrix
  public static void display(UndirectedGraph udGraph) {
    // store graph field in udGraph
    int[][] graph = udGraph.graph;

    System.out.print("/ ");
    for (int i = 0 ; i < graph.length ; i++) {
      System.out.print(i + " ");
    }
    System.out.println("");

    // graph.length gives the number of rows
    for (int i = 0 ; i < graph.length ; i++) {
      System.out.print(i + " ");

      // graph[i].length gives the number of columns in that row
      for (int j = 0 ; j < graph[i].length ; j++) {
        System.out.print(graph[i][j] + " ");
      }
      System.out.println("");
    }
    System.out.println("");
  }

  // breadth first search
  public static void bfs(UndirectedGraph udGraph, int start) {
    // start is the starting vertex for our bfs search
    // reference to graph field in udGraph
    int[][] graph = udGraph.graph;

    // initialize a boolean array to track vertices we've already visited
    // the array is the same size as the number of vertices in our graph (each index in the array corresponds to a vertex)
    // boolean array is initialized to false -> when we visit a node, we change value to true
    boolean[] visited = new boolean[udGraph.vertices];
    // initialize queue to store adjacent vertices of the current vertex
    // toVisit keeps track of all the vertices we should be visiting in future iterations
    Queue<Integer> toVisit = new LinkedList<Integer>();

    // add start to toVisit queue
    toVisit.offer(start);

    // iterate through queue as long as queue is not empty
    while (toVisit.peek() != null) {
      // dequeue from front of queue and store value in curr
      int curr = toVisit.poll();

      // visit the current vertex (if we haven't already visited it)
      if (!visited[curr]) {
        System.out.print(curr + " ");
        visited[curr] = true;
      }

      // iterate through row in adjacency matrix
      for (int i = 0 ; i < udGraph.vertices ; i++) {
        // enqueue adjacent vertices that we haven't visited yet
        if (graph[curr][i] != 0 && !visited[i]) {
          // add neighbor to queue
          toVisit.offer(i);
        }
      }
    }
    System.out.println("");
  }

  // main method
  public static void main(String[] args) {
    UndirectedGraph test = new UndirectedGraph(5);
    display(test);
    int[] adj1 = {2, 3};
    test.insert(1, adj1);
    int[] adj2 = {1, 4};
    test.insert(2, adj2);
    int[] adj3 = {1, 4};
    test.insert(3, adj3);
    display(test);

    bfs(test, 4);
  }
}
