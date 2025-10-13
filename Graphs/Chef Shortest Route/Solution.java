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
		for(int i = 0 ; i<=n;i++)
		{
		    graph.add(new ArrayList<>());
		}
		for(int i = 0 ; i < m;i++)
		{
		    int u = sc.nextInt();
		    int v = sc.nextInt();
		    graph.get(u).add(v);
		    graph.get(v).add(u);
		}
		boolean[] visited = new boolean[n+1];
		Deque<Integer> deque = new ArrayDeque<>();
		deque.addLast(1);
		visited[1] = true;
		boolean found = false;
		int minDistance = 0;
		while(!deque.isEmpty())
		{
		    int size = deque.size();
		    minDistance++;
		    for(int i = 0 ; i < size ; i++)
		    {
		        int element = deque.peekFirst();
		        deque.removeFirst();
		        for(int neighbour : graph.get(element))
		        {
		            if(neighbour == n)
		            {
		                found = true;
		                break;
		            }
		            if(!visited[neighbour])
		            {
		                visited[neighbour] = true;
		                deque.addLast(neighbour);
		            }
		        }
		        if(found) break;
		    }
		    if(found) break;
		}
		if(found)
		{
		    System.out.println(minDistance + 1);
		}
		else
		{
		    System.out.println(-1);
		}
		

	}
}
