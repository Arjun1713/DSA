import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    public static boolean dfs (int node, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> graph)
    {
        visited[node] = true;
        pathVisited[node] = true;
        
        for(int neighbour : graph.get(node))
        {
            if(!visited[neighbour])
            {
                if(dfs(neighbour, visited, pathVisited, graph)) //Any of my neighbours detect a cycle
                {
                    return true;
                }
            }
            else if(pathVisited[neighbour]) // I detect a cycle
            {
                return true;
            }
            
        }
        pathVisited[node] = false;
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
		}
		boolean[] visited = new boolean[n+1];
		boolean[] pathVisited = new boolean[n+1];
		boolean hasCycle = false;
		for(int i = 1; i <= n;i++)
		{
		    if(!visited[i])
		    {
		        if(dfs(i, visited, pathVisited, graph))
		        {
		            hasCycle = true;
		            break;
		        }
		    }
		}
		
		System.out.println(hasCycle ? "YES" : "NO");
		

	}
}
