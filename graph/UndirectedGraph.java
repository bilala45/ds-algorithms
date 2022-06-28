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
    // initialize visited array to track vertices that have already been visited (and printed to the screen)
    int[] visited = new int[graph.length];
    // initialize queue to store adjacent vertices of current vertex
    Queue<Integer> toVisit = new LinkedList<Integer>();

    // add start to toVisit queue
    toVisit.offer(start);
    // print start and update value in visited list
    System.out.print(start + " ");
    visited[start] = start;

    // iterate through queue as long as queue is not empty
    while (toVisit.peek() != null) {
      // dequeue from front of queue and store in curr
      int curr = toVisit.poll();

      // iterate through row in adjacency matrix
      for (int i = 0 ; i < udGraph.vertices ; i++) {
        // enqueue, print, and update non-zero values in visited list
        if (graph[curr][i] != 0 && visited[i] != i) {
          // add start to toVisit queue
          toVisit.offer(i);
          // print start and update value in visited list
          System.out.print(i + " ");
          visited[i] = i;
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
