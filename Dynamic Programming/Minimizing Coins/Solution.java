import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++)
        {
            coins[i] = sc.nextInt();
        }
        long[] dp = new long[x+1];
        // dp[i] = minimum number of coins required to make sum i
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 coins are required to make sum 0
        for(int i=1;i<=x;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i >= coins[j])
                {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        System.out.println(dp[x] == Integer.MAX_VALUE ? -1 : dp[x]);
        

    }
}