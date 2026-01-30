package Practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Graph {

    int noOfVertices;
    List<List<Integer>> adjacencyList;

    public Graph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.adjacencyList = new ArrayList<>();
        // initialize the list
        for (int i = 0; i < noOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

    }

    // now we need to add node ok
    public void addEdge(int source, int destination) {
        // here
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // graph traversing algorithm

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[noOfVertices];

        dfs(startVertex, visited);
    }

    private void dfs(int node, boolean[] visited) {
        visited[node] = true;
        // then check the neighbour
        System.out.print(node + " ");
        for (int neighbour : adjacencyList.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited);
            }
        }
    }

    // i will do the dfs iterative need stack to do it

    public void dfsIterative(int startVertex) {
        // craete array for tracking the visted
        boolean[] visited = new boolean[noOfVertices];
        Deque<Integer> stack = new ArrayDeque<>();

        // first push the start index
        stack.push(startVertex);
        // now we need to move around only the stack

        while (!stack.isEmpty()) {
            // get the node which is on top of the stack
            int node = stack.pop();
            // check that node is visted or not
            if (!visited[node]) {
                // not visited then mark it visited
                visited[node] = true;
                System.out.print(node + "  ");
                // now check the neigoubour of each
                for (int i = adjacencyList.get(node).size() - 1; i >= 0; i--) {
                    int neighbour = adjacencyList.get(node).get(i);
                    if (!visited[neighbour]) {
                        stack.push(neighbour);
                    }
                }
            }
        }

    }

    public void displayList() {

        // first need to get all the edge
        for (int i = 0; i < noOfVertices; i++) {
            System.out.print(i + " -> ");
            // for neighbour
            for (int neighbour : adjacencyList.get(i)) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }

    }

    // here the bfs
    public void bfs(int startVertex) {

        System.out.println("Bfs Traversal");
        boolean[] visited = new boolean[noOfVertices];
        java.util.Queue<Integer> queue = new LinkedList<>();

        // first make the vertex as visited
        visited[startVertex] = true;
        // then add that into the queue
        queue.offer(startVertex);

        // here now check the isemety till then opop
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            // now check all the vertex
            for (int vertex : adjacencyList.get(node)) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    queue.offer(vertex);
                }
            }

        }

    }

    public static void main(String[] args) {

        Graph gr = new Graph(6);
        gr.addEdge(0, 1);
        gr.addEdge(0, 2);
        gr.addEdge(1, 3);
        gr.addEdge(2, 4);
        gr.addEdge(3, 5);
        gr.addEdge(4, 5);

        gr.displayList();

        // gr.dfs(0);
        gr.bfs(4);
        System.out.println();
        gr.dfsIterative(0);

    }

}