import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
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
		 //USING KAHN's Algo
		 int[] inDegree = new int[n+1];
		for(int i =0;i< m;i++)
		{
		    int u = sc.nextInt();
		    int v = sc.nextInt();
		    graph.get(u).add(v);
		    inDegree[v]++;
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=1;i<=n;i++)
		{
		    if(inDegree[i] == 0)
		    {
		        deque.addLast(i);
		    }
		}
		ArrayList<Integer> result = new ArrayList<>();
		int numberOfProcessedNodes = 0;
		while(!deque.isEmpty())
		{
		    int node = deque.peekFirst();
		    deque.removeFirst();
		    numberOfProcessedNodes++;
		    result.add(node);
		    for(int neighbour : graph.get(node))
		    {
		        inDegree[neighbour]--;
		        if(inDegree[neighbour] == 0)
		        {
		            deque.addLast(neighbour);
		        }
		    }
		}
		
		if(numberOfProcessedNodes!=n)
		{
		    System.out.println(-1);
		}
		else
		{
		    for(int x : result)
		    {
		        System.out.print(x + " ");
		    }
		}

	}
}
