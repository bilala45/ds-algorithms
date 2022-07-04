import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

  // custom sub-class for edge in graph
  public class Edge {
    // weight of edge connecting vertices
    // connected vertex
    private int vertex, weight;

    // constructor
    public Edge(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }
  }

  // vertices in graph
  private int vertices;
  // array of linked lists (List holds Edge objects)
  private LinkedList<Edge>[] graph;

  // constructor for Graph class
  public Graph(int vertices) {
    this.vertices = vertices;
    // initialize array of linked lists with size of vertices argument
    graph = new LinkedList[vertices];
  }

  // insert in graph (assuming undirected graph so weights are bidirectional)
  // builds an adjacency list
  public void insertEdge(int start, int end, int weight) {
    // check if vertex arguments are valid vertices in the graph
    if (start < vertices && end < vertices) {
      // Initialize list at vertex argument if list hasn't been initialized yet
      if (graph[start] == null) {
        // initialize linked list at start index in array
        graph[start] = new LinkedList<Edge>();
      }

      // store reference to linked list located at start index
      LinkedList<Edge> curr = graph[start];

      // insert edge at head of list at array[start]
      // we insert at head because insertion at head is constant. Inserting at the end of a linked list is linear.
      curr.add(0, new Edge(end, weight));

      // repeat for other direction
      if (graph[end] == null) {
        graph[end] = new LinkedList<Edge>();
      }

      curr = graph[end];
      curr.add(0, new Edge(start, weight));
    }
  }

  // display graph adjacency matrix
  public static void display(Graph graph) {
    // reference to array storing adjacency list
    LinkedList<Edge>[] adjList = graph.graph;

    // iterate through ArrayList of linked lists
    for (int i = 0 ; i < adjList.length ; i++) {
      System.out.print("[" + i + "] => ");
      // null list, continue to next iteration
      if (adjList[i] == null) {
        System.out.println("null");
        continue;
      }
      // iterate through list at each index in array
      for (Edge edge : adjList[i]) {
        // edge automatically takes the value of the current node in adjList[i]
        // print vertex at node of linked list
        System.out.print(edge.vertex + " -> ");
      }
      System.out.println("null");
    }
  }

  // depth first search
  public static void dfs(Graph graph, int start) {
    // reference to adjacency list storing graph
    LinkedList<Edge>[] adjList = graph.graph;
    // boolean array to track visited vertices
    boolean[] visited = new boolean[graph.vertices];
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
        System.out.print(curr + " ");
        visited[curr] = true;

        // record current vertex's neighbors in stack
        // we only need to record neighbours if we haven't visited that vertex yet
        for (Edge elem : adjList[curr]) {
          // add neighbour to stack if neighbor vertex has NOT been visited yet
          if (!visited[elem.vertex]) {
            toVisit.push(elem.vertex);
          }
        }
      }
    }
    System.out.println("");
  }

  // breadth first search
  public static void bfs(Graph graph, int start) {
    // start is the starting vertex for our bfs search
    // reference to graph field in graph class
    LinkedList<Edge>[] adjList = graph.graph;

    // initialize a boolean array to track vertices we've already visited
    // the array is the same size as the number of vertices in our graph (each index in the array corresponds to a vertex)
    // boolean array is initialized to false -> when we visit a node, we change value to true
    boolean[] visited = new boolean[graph.vertices];
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

        // iterate through linked list at adjacency list index
        for (Edge elem : adjList[curr]) {
          // enqueue adjacent vertices that we haven't visited yet
          if (!visited[elem.vertex]) {
            // add neighbor to queue
            toVisit.offer(elem.vertex);
          }
        }
      }
    }
    System.out.println("");
  }

  // main method
  public static void main(String[] args) {
    // graph with 5 vertices (0 - 4)
    Graph test = new Graph(5);
    test.insertEdge(0, 1, 1);
    test.insertEdge(0, 2, 1);
    test.insertEdge(1, 2, 1);
    test.insertEdge(2, 4, 1);
    test.insertEdge(2, 3, 1);
    test.insertEdge(3, 4, 1);
    display(test);
    dfs(test, 0);
    bfs(test, 0);
  }
}
