import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> graph)
    {
        visited[i] = true;
        
        for(int neighbour : graph.get(i))
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
		for(int i = 0; i<=n;i++)
		{
		    graph.add(new ArrayList<>());
		}
		for(int i = 0; i < m; i++)
		{
		    int u = sc.nextInt();
		    int v = sc.nextInt();
		    graph.get(u).add(v);
		    graph.get(v).add(u);
		}
		
		boolean[] visited = new boolean[n+1];
		int noOfDisconnectedComponents = -1;
		for(int i=1; i<=n;i++)
		{
		    if(!visited[i])
		    {
		        noOfDisconnectedComponents++;
		        dfs(i, visited, graph);
		    }
		    
		}
		System.out.println(noOfDisconnectedComponents);
		

	}
}
