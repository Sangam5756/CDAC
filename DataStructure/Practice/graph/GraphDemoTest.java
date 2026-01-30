package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implements 
 *
 */
class Graph{
	
	int noOfVertices;
	List<List<Integer>> adjacencyList;
	
	public Graph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		this.adjacencyList = new ArrayList<>();
		
		for(int  i = 0 ; i <noOfVertices;i++) {
			adjacencyList.add(new ArrayList<>());
		}
	}
	
	/**
	 * Creates a 2 way edge between source and destination
	 * @param source
	 * @param destination
	 */
	public void addEdge(int source ,int destination) {
		adjacencyList.get(source).add(destination);
		adjacencyList.get(destination).add(source);
	}
	
	public void displayAdjacencyList() {
		for(int i = 0 ; i < noOfVertices ; i++) {
			System.out.print( i + " -> ");
			for(int neighbour : adjacencyList.get(i)) {
				System.out.print(neighbour + " ");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * Find dfs.
	 * @param startVertex
	 */
	public void dfs(int startVertex) {
		boolean [] visited = new boolean[noOfVertices];
		System.out.println("Recursive DFS ");
		dfs(startVertex,visited);
	}
	
	private void dfs(int node, boolean [] visited) {
		visited[node] = true;
		System.out.print(node + " ");
		for(int neighbour : adjacencyList.get(node)) {
			if(!visited[neighbour]) {
				dfs(neighbour,visited);
			}
		}
	}
	
	
	/**
	 * This is the iterative dfs.Refer to notes
	 * @param startVertex
	 */
	public void dfsIterative(int startVertex) {
	
		System.out.println("\nIterative DFS : ");
		boolean []visited = new boolean[noOfVertices];
		Deque<Integer> stack  = new ArrayDeque<>();
		
		stack.push(startVertex);
		
		while(!stack.isEmpty()) {
			int node = stack.pop();
			if(!visited[node]) {  //Should we even process?
				visited[node] = true;
				System.out.print(node + " ");
				
				for(int i = adjacencyList.get(node).size()-1; i >=0 ; i --) {
					int neighbour = adjacencyList.get(node).get(i);
					if(!visited[neighbour]) { // Avoid putting on stack-efficiency
						stack.push(neighbour);	
					}		
				}
			}
		}
		
	}
	
	/**
	 * Implements Breadth First Search - Queue
	 * @param startVertex
	 */
	public void bfs(int startVertex) {
		System.out.println("BFS Traversal...");
		boolean [] visited = new boolean[noOfVertices];
		Queue<Integer> queue = new LinkedList<>();
		
		visited[startVertex] = true;
		queue.offer(startVertex);
	
		while(!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			
			for(int vertex : adjacencyList.get(node) ) {
				if(!visited[vertex]) {
					visited[vertex] = true;
					queue.offer(vertex);	
				}		
			}
		}
	
	}
}

public class GraphDemoTest {
	
	public static void main(String[] args) {
		Graph graph = new Graph(6);

		// Add edges according to this example
        //     A(0)
        //    /   \
        //   B(1)  C(2)
        //   |     |
        //   D(3)  E(4)
        //    \   /
        //     F(5)
        
        graph.addEdge(0, 1);  // A - B
        graph.addEdge(0, 2);  // A - C
        graph.addEdge(1, 3);  // B - D
        graph.addEdge(2, 4);  // C - E
        graph.addEdge(3, 5);  // D - F
        graph.addEdge(4, 5);  // E - F	   
        graph.displayAdjacencyList();

	    graph.dfs(0);
	    graph.dfsIterative(0);
	    
	    graph.bfs(0);
	}

}
