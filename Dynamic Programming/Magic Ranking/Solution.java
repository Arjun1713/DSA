import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
		    int n = sc.nextInt();
		    ArrayList<ArrayList<Integer>> triangle = new ArrayList<>(n);
		    for(int i=0;i<n;i++)
		    {
		        triangle.add(new ArrayList<>());
		    }
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<=i;j++)
		        {
		            triangle.get(i).add(sc.nextInt());
		        }
		    }
		
		int[][] dp = new int[101][101];
		dp[0][0] = triangle.get(0).get(0);
		for(int i=1;i<n;i++)
		{
		    for(int j = 0;j<=i;j++)
		    {
		        if(j - 1 >= 0)
		        {
		            dp[i][j] = triangle.get(i).get(j) + Math.max(dp[i-1][j-1], dp[i-1][j]);
		        }
		        else 
		        {
		            dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
		        }
		    }
		}
		
		int max = dp[n-1][0];
		for(int i=0;i<101;i++)
		{
		    max = Math.max(max, dp[n-1][i]);
		}
		System.out.println(max);
		}

	}
}
