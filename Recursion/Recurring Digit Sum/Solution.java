import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    public static int solve(int n)
    {
        if(n <10)
        {
            return n;
        }
        int sum = 0;
        while(n >0)
        {
            sum = sum % 10;
            n/=10;
        }
        return solve(sum);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solve(n));

	}
}
