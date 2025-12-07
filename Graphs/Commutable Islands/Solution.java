import java.util.*;
public class Solution {
    //This is a MST Problem. Given a graph we have to get the Minimum Spanning Tree (MST)
    public class Pair{
        int vertex, weight;
        public Pair(int vertex, int weight)
        {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public int solve(int A, int[][] B) {
        int n = B.length;
        int m = B[0].length;
        boolean[] visited = new boolean[A+1];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        ArrayList<Pair> graph[] = new ArrayList[A+1];
        for(int i=1;i<=A;i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++)
        {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];
            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u,w));
        }
        for(Pair p : graph[1]) // We are taking 1 as our source node, hence adding all the neighbours of 1 with their weighted edges to min heap
        {
            minHeap.add(p);
        }
        int cost = 0;
        visited[1] = true;
        while(!minHeap.isEmpty())
        {
            Pair currentMinEdge = minHeap.poll();
            if(! visited[currentMinEdge.vertex])
            {
                cost += currentMinEdge.weight;
                visited[currentMinEdge.vertex] = true;
                for(Pair p : graph[currentMinEdge.vertex])
                {
                    if(!visited[p.vertex])
                    {
                        minHeap.add(p);
                    }
                    
                }
            }
        }    

        return cost;    

    }
}
