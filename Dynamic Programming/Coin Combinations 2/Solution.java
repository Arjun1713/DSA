//To solve this variation, we go in order. That means, first we take coin x, and take it as many times as we can. 
//Once we cannot take x anymore, then we move to the next coin y. Then we take y as many times as we can. 
//This way, we ensure that combinations like 1,2 and 2,1 are not counted separately.
// For example, if we have coins 1 and 2, and we want to make sum 3,
// we first consider coin 1, and take it as many times as we can: 1,1,1
// Then we move to coin 2, and we take it as many times as we can. Here we can take it only once .
// So at 3, we can do ways[3-1]  + ways[3-2].

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
        // dp[i] = number of ways to make sum i with all the coins. You can use a coin multiple times.
        dp[0] = 1; // To make sum 0 there is 1 way - by choosing no coins.
        for(int j = 0;j<n;j++) // First we traverse over the coins. We do this so that we can take a single coin for all the capacities as many times as we want before moving on to another coin. 
        {
            for(int i=1;i<=x;i++)
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