import java.util.*;
public class Solution {
    public class Pair {
        int type, value;
        public Pair(int type, int value)
        {
            this.type = type;
            this.value = value;
        }
    }
    public int solve(int[] A, int[] B) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        int n = A.length, m = B.length;
        int MOD = 1000000007;
        for(int a : A)
        {
            pq.add(new Pair(0, a));
        }
        for(int b : B)
        {
            pq.add(new Pair(1, b));
        }

        int answer = 0;
        n++;m++;
        while(!pq.isEmpty() && n>0 && m>0)
        {
            Pair p = pq.poll();
            if(p.type == 0)
            {
                answer = (answer + (p.value * m)) % MOD;
                n--;
            }
            else
            {
                answer = (answer + (p.value * n)) % MOD;
                m--;
            }
        }

        return answer;
    }
}
