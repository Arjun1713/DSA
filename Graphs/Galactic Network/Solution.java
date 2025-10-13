class Solution {
    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph)
    {
        visited[node] = true;
        for(int neighbour : graph.get(node))
        {
            if(!visited[neighbour])
            {
                dfs(neighbour, visited, graph);
            }
        }
    }
    public int findConnectedComponents(int n, int[][] edges) {
        // write your code here 
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v =edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int connectedComponents = 0;
        boolean[] visited = new boolean[n+1];
        for(int i=1; i<=n;i++)
        {
            if(!visited[i])
            {
                connectedComponents++;
                dfs(i, visited, graph);
            }
        }
        return connectedComponents;
        
    }
}
