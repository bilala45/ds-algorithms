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

    for (int i = 0 ; i < graph.length ; i++) {
      System.out.print(i + " ");
      for (int j = 0 ; j < graph.length ; j++) {
        System.out.print(graph[i][j] + " ");
      }
      System.out.println("");
    }
    System.out.println("");
  }

  // breadth first search


  // main method
  public static void main(String[] args) {
    UndirectedGraph test = new UndirectedGraph(5);
    display(test);
    int[] adj1 = {2, 4};
    test.insert(1, adj1);
    display(test);
  }
}
