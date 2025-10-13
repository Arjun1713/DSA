import java.util.*;

public class Main {

    // Function to perform BFS
    private static void bfs(int start, boolean[] visited, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        // Process nodes in the queue
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            // Enqueue unvisited neighbors
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();
        int numEdges = scanner.nextInt();
        List<List<Integer>> adjList = new ArrayList<>(numNodes + 1);

        // Initialize adjacency list
        for (int i = 0; i <= numNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adding edges to the graph
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Perform BFS starting from node 1
        boolean[] visited = new boolean[numNodes + 1];
        System.out.print("BFS traversal: ");
        bfs(1, visited, adjList);

        scanner.close();
    }
}
