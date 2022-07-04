import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {

  // custom sub-class for edge in graph
  public class Edge {
    // edge weight
    // connected vertex
    private int weight, vertex;

    // constructor
    public Edge(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }
  }

  // vertices in graph
  private int vertices;
  // array of linked lists (lists holds Edge objects)
  private List<Edge>[] graph;

  // constructor for Graph class
  public Graph(int vertices) {
    this.vertices = vertices;
    // initialize array of linked lists with size of vertices argument
    graph = new LinkedList[vertices];
  }

  // insert in graph
  // builds an adjacency list
  public void insert(int start, int end, int weight) {
    // check if vertex arguments are valid vertices in the graph
    if (start < vertices && end < vertices) {
      // Initialize list at vertex argument if list hasn't been initialized yet
      if (graph[start] == null) {
        graph[start] = new LinkedList<Edge>();
      }
      // create edge
      Edge insertEdge = new Edge(end, weight);
      // add to end of list
      graph[start].add(insertEdge);
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

  // depth first search
  public static void dfs(UndirectedGraph udGraph, int start) {
    // reference to graph matrix
    int[][] graph = udGraph.graph;
    // boolean array to track visited vertices
    boolean[] visited = new boolean[udGraph.vertices];
    // initialize stack to store vertices that we need to visit
    // stack is used because dfs returns back to the most recent vertex
    // in dfs, we're trying to expand out as quickly as possible, so we don't fully explore surrounding neighbors except on the way back
    Stack<Integer> toVisit = new Stack<>();

    // push start to stack
    toVisit.push(start);

    // iterate as long as stack is non-empty
    while (!toVisit.empty()) {
      // pop off the stack - set popped vertex as our current vertex
      int curr = toVisit.pop();
      // visit current vertex and record visitation (only if we haven't already visited the vertex)
      if (visited[curr] != true) {
        System.out.println(curr);
        visited[curr] = true;

        // record current vertex's neighbors in stack
        // we only need to record neighbours if we haven't visited that vertex yet since we've already recorded the neighbours of visited vertices
        for (int i = 0 ; i < graph[curr].length ; i++) {
          // add neighbour to stack if neighbor is present and neighbor vertex has NOT been visited yet
          if (graph[curr][i] != 0 && visited[i] != true) {
            toVisit.push(i);
          }
        }
      }
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

        // iterate through row in adjacency matrix
        for (int i = 0 ; i < udGraph.vertices ; i++) {
          // enqueue adjacent vertices that we haven't visited yet
          if (graph[curr][i] != 0 && !visited[i]) {
            // add neighbor to queue
            toVisit.offer(i);
          }
        }
      }
    }
    System.out.println("");
  }

  // main method
  public static void main(String[] args) {
    UndirectedGraph test = new UndirectedGraph(5);
    display(test);

    int[] adj0 = {1, 2, 3};
    int[] weight0 = {10, 2, 30};
    test.insertWeighted(0, adj0, weight0);

    int[] adj2 = {1, 4};
    int[] weight2 = {3, 6};
    test.insertWeighted(2, adj2, weight2);

    primsAlgo(test);

    display(test);
  }
}
