// Ordered Set of coins - 1,2 Not equal to 2,1
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int MOD = 1000000007;
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++)
        {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[x+1];
        // dp[i] = number of was to make sum i with all the coins. You can use a coin multiple times.
        dp[0] = 1; // To make sum 0 there is 1 way - by choosing no coins.
        for(int i=1;i<=x;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i >= coins[j])
                {
                    dp[i] = (dp[i] + dp[i - coins[j]]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);

    }
}