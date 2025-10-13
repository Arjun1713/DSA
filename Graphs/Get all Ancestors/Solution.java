import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void getAncestors(int node, int ancestor, ArrayList<ArrayList<Integer>> graph, ArrayList<TreeSet<Integer>> ancestors)
    {
        if(node != ancestor)
        {
            ancestors.get(node).add(ancestor);
        }
        
        for(int neighbour : graph.get(node))
        {
            getAncestors(neighbour, ancestor, graph, ancestors );
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
		ArrayList<TreeSet<Integer>> ancestors = new ArrayList<>(n);
		for(int i=0;i<n;i++)
		{
		    graph.add(new ArrayList<>());
		    ancestors.add(new TreeSet<>());
		}
		
		for(int i=0;i<m;i++)
		{
		    int u = sc.nextInt();
		    int v = sc.nextInt();
		    graph.get(u).add(v);
		    
		}
		
		for(int i=0;i<n;i++)
		{
		    getAncestors(i,i, graph, ancestors);
		}
		
		for(int i=0;i<n;i++)
		{
		    for(int x : ancestors.get(i))
		    {
		        System.out.print(x + " ");
		    }
		    System.out.println();
		}

	}
}
