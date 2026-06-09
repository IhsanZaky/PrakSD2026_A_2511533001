package pekan9_2511533001;
import java.util.*;

public class GraphTraversal_2511533001 {
	private Map<String, List<String>> graph_3001 = new HashMap<>();
	
	public void addEdge_3001(String node1_3001, String node2_3001) {
		graph_3001.putIfAbsent(node1_3001, new ArrayList<>());
		graph_3001.putIfAbsent(node2_3001, new ArrayList<>());
		graph_3001.get(node1_3001).add(node2_3001);
		graph_3001.get(node2_3001).add(node1_3001);
	}
	
	public void printGraph_3001() {
		System.out.println("Graf Awal (Adjacency List):");
		for (String node_3001 : graph_3001.keySet()) {
			System.out.print(node_3001 + " -> ");
			List<String> neighbors_3001 = graph_3001.get(node_3001);
			System.out.println(String.join(",", neighbors_3001));
		}
		System.out.println();
	}
	
	public void dfs_3001(String start_3001) {
		Set<String> visited_3001 = new HashSet<>();
		System.out.println("Penelusuran DFS:");
		dfsHelper_3001(start_3001, visited_3001);
		System.out.println();
	}
	
	private void dfsHelper_3001(String current_3001, Set<String> visited_3001) {
		if (visited_3001.contains(current_3001)) return;
		visited_3001.add(current_3001);
		System.out.print(current_3001 + " ");
		for (String neighbor_3001 : graph_3001.getOrDefault(current_3001, new ArrayList<>())) {
			dfsHelper_3001(neighbor_3001, visited_3001);
		}
	}
	
	public void bfs_3001(String start_3001) {
		Set<String> visited_3001 = new HashSet<>();
		Queue<String> queue_3001 = new LinkedList<>();
		queue_3001.add(start_3001);
		visited_3001.add(start_3001);
		System.out.println("Penulusuran BFS:");
		while (!queue_3001.isEmpty()) {
			String current_3001 = queue_3001.poll();
			System.out.print(current_3001 + " ");
			for (String neighbor_3001 : graph_3001.getOrDefault(current_3001, new ArrayList<>())) {
				if (!visited_3001.contains(neighbor_3001)) {
					queue_3001.add(neighbor_3001);
					visited_3001.add(neighbor_3001);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		GraphTraversal_2511533001 graph_3001 = new GraphTraversal_2511533001();
		
		graph_3001.addEdge_3001("A", "B");
		graph_3001.addEdge_3001("A", "C");
		graph_3001.addEdge_3001("B", "D");
		graph_3001.addEdge_3001("B", "E");
		
		System.out.println("Graf Awal adalah: ");
		graph_3001.printGraph_3001();
		graph_3001.dfs_3001("A");
		graph_3001.bfs_3001("B");
	}
}