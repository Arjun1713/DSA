import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static boolean visited(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> graph)
    {
        visited[node] = true;
        for(int neighbour : graph.get(node))
        {
            if(!visited[neighbour])
            {
                if(dfs(neighbour, node, visited, graph)) //The recursive call returned true for a cycle
                {
                    return true;
                }

            }
            else if(neighbour != parent) // I detected a cycle. One of my adjacent node is visited, and it is not my parent. 
            {
                return true;
            }
            
        }
        return false;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
		for(int i=0;i<=n;i++)
		{
		    graph.add(new ArrayList<>());
		}
		for(int i=0;i<m;i++)
		{
		    int u = sc.nextInt();
		    int v = sc.nextInt();
		    graph.get(u).add(v);
		    graph.get(v).add(u);
		}
		boolean[] visited = new boolean[n+1];
		boolean hasCycle = false;
		for(int i = 1; i<=n;i++)
		{
		    if(!visited[i])
		    {
		        hasCycle |= dfs(i,-1, visited, graph);
		    }
		}
		
		System.out.println(hasCycle ? "YES" : "NO");

	}
}
