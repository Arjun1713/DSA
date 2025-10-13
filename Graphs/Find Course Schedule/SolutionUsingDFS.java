import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack)
    {
        visited[node] = true;
        pathVisited[node] = true;
        
        for(int neighbour : graph.get(node))
        {
            if(!visited[neighbour])
            {
                if(dfs(neighbour, graph, visited, pathVisited, stack)) // One my my neighbours detect a cycle 
                {
                    return true;
                }
            }
            else if(pathVisited[neighbour]) // I detect a cycle
            {
                return true;
            }
            
            
        }
        
        stack.push(node);
        pathVisited[node] = false; //Remove the node from the current path
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
		 //USING DFS METHOD
		for(int i =0;i< m;i++)
		{
		    int u = sc.nextInt();
		    int v = sc.nextInt();
		    graph.get(u).add(v);
		}
		
		boolean[] visited = new boolean[n+1];
		boolean[] pathVisited = new boolean[n+1];
		Stack<Integer> stack = new Stack<>();
		boolean hasCycle = false;
		
		for(int i=1; i<=n;i++)
		{
		    if(!visited[i])
		    {
		        if(dfs(i, graph, visited, pathVisited, stack)) //Cycle detected
		        {
		            hasCycle = true;
		            break;
		        }
		    }
		    
		}
		
		if(hasCycle)
		{
		    System.out.println(-1);
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
