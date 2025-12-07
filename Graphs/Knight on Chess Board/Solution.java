//This question can be solved using BFS Traversal on the Graph
import java.util.*;
public class Solution {
    public int knight(int A, int B, int C, int D, int E, int F) {
        C--; D--;E--;F--; //Adjusting 1 based indexing for indexes to 0 based indexes
        boolean[][] visited = new boolean[A][B];
        int[][] directions = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {-1,2}, {1,-2}, {-1, -2}}; // All the directions in which a knight moves
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{C,D});
        visited[C][D] = true;
        int steps = 0;
        while(!deque.isEmpty())
        {
            int size = deque.size();
            while(size-- > 0)
            {
                int[] curr = deque.pollFirst();
                if(curr[0] == E && curr[1] == F)
                {
                    return steps;
                }
                for(int[] dir : directions)
                {
                    int newI = curr[0] + dir[0];
                    int newJ = curr[1] + dir[1];
                    
                    if(newI >= 0 && newI < A && newJ >=0 && newJ < B && !visited[newI][newJ])
                    {
                        visited[newI][newJ] = true;
                        deque.addLast(new int[]{newI, newJ});
                    }
                }
            }
            steps++;
            
            
        }

        return -1;
    }
}
