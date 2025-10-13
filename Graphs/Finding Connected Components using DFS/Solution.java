import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void dfs(int source, boolean[] visited, ArrayList<ArrayList<Integer>> graph)
    {
        visited[source] = true;
        for(int neighbour : graph.get(source))
        {
            if(!visited[neighbour])
            {
                dfs(neighbour, visited, graph);
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
		for(int i = 0; i <= n; i++)
		{
		    graph.add(new ArrayList<>());
		}
		for(int i = 0; i<m;i++)
		{
		    int u = sc.nextInt();
		    int v = sc.nextInt();
		    graph.get(u).add(v);
		    graph.get(v).add(u);
		    
		}
		
		int connectedComponents = 0;
		boolean[] visited = new boolean[n+1];
		
		for(int node  = 1; node<=n;node++)
		{
		    if(!visited[node])
		    {
		        connectedComponents++;
		        dfs(node, visited, graph);
		    }
		}
		System.out.println(connectedComponents);
		

	}
}
