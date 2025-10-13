import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static boolean dfs (int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack)
    {
        visited[node] = true;
        pathVisited[node] = true;
        
        for(int neighbour : graph.get(node))
        {
            if(!visited[neighbour])
            {
                if(dfs(neighbour, graph, visited,pathVisited, stack)) // Any of my neighbours have cycles
                {
                    return true;
                }
            }
            else if(pathVisited[neighbour]) // I detect a cycle myself
            {
                return true;
            }
        }
        stack.push(node);
        pathVisited[node] = false;
        return false;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
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
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[n+1];
		boolean[] pathVisited = new boolean[n+1];
		boolean hasCycle = false;
		for(int i=1;i<=n;i++)
		{
		    if(!visited[i])
		    {
		        hasCycle |= dfs(i, graph, visited,pathVisited,  stack);
		    }
		}
		if(hasCycle)
		{
		    System.out.println("-1");
		}
		else
		{
    		 while(!stack.isEmpty())
    		 {
    		     System.out.print(stack.pop() + " ");
    		 }
		}
	}
}
