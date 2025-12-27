import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Graph {

    int noofVertices;
    List<List<Integer>> adjacencyList;

    public Graph(int vertices) {
        this.noofVertices = vertices;
        // now need to initialize the list
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < noofVertices; i++) {
            adjacencyList.add(new ArrayList());
        }
    }

    public void add(int source, int dest) {
        adjacencyList.get(source).add(dest);
        adjacencyList.get(dest).add(source);

    }

    // now we need to print list
    public void printGraph() {
        for (int i = 0; i < noofVertices; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(adjacencyList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void dfsHelper(int vertex, boolean[] visited) {
        // first make the verted visited
        // then go for the paths
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < adjacencyList.get(vertex).size(); i++) {
            // for each vertext path
            int neighbor = adjacencyList.get(vertex).get(i);

            // if the neighbor is not visited then call the function
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }

        }

    }

    public void dfsIterative(int start) {

        // need the stack
        boolean[] visited = new boolean[noofVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
                // get all the list of that and push to stack
// hey when doing iterative statck do the things in revise as not same as recursive
                for (int i=adjacencyList.get(node).size()-1;i>=0;i--) {
                    
                    int neighbor = adjacencyList.get(node).get(i);

                    if (!visited[neighbor]) {

                        stack.push(neighbor);
                    }
                }
            }

        }

    }
    public void dfsAll() {
    boolean[] visited = new boolean[noofVertices];
    for (int i = 0; i < noofVertices; i++) {
        if (!visited[i]) {
            dfsHelper(i, visited);
        }
    }
}

    public void dfs(int start) {
        boolean[] visited = new boolean[noofVertices];
        dfsHelper(start, visited);

    }

    public static void main(String[] args) {
        Graph gr = new Graph(5);

        gr.add(0, 1);
        gr.add(0, 3);
        gr.add(1, 2);
        gr.add(2, 3);

        gr.printGraph();
        gr.dfs(0);

        System.out.println("dfs iterative");
        gr.dfsIterative(0);


    }
}