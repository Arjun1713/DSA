import java.util.*;
public class DPSolution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        //dp[i] = Min number of steps to make i go to 0 by subtracting 1 digit from i at a time
        //dp[i] = 1 + Min(dp[i - d]) where d traverses over all the digits of i
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // For 0 to go to 0, the minimum number of steps required are 0
        for(int i=1;i<=n;i++) // This loop will traverse over our dp array and go till n
        {
            int temp = i;
            for(int j = temp%10;temp>0;j = temp%10)
            {
                dp[i] = Math.min(dp[i], 1 + dp[i - j]);
                temp /= 10;
            }
        }

        System.out.println((int)dp[n]);
    }
    
}

// Time Complexity = O(n log n) -> n for the outer loop which traverses over the DP array. log n for the inner loop which goes through all the digits of i
// Space Complexity = O(n) -> For maintaining DP Array