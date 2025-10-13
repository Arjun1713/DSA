import java.util.*;

class Main {


    public static void dfs(int source, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList, int numNodes)
    {
        
        visited[source] = true;
        
        for(int element : adjacencyList.get(source))
        {
            if(!visited[element])
            {
                visited[element] = true;
                dfs(element, visited, adjacencyList, numNodes);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(n + 1);
        for(int i = 0;i <= n;i++)
        {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0;i < m;i++)
        {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjacencyList.get(u).add(v);
        }
        boolean[] visited = new boolean[n + 1];
        dfs(1, visited, adjacencyList, n);
        
        for(int i = 0 ; i < visited.length; i++)
        {
            if(visited[i])
            {
                System.out.print(i + " ");
            }
        }
        
    }
}
