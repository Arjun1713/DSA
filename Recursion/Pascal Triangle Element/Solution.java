import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    public static int pascal(int n, int m)
    {
        if(n<0 || m<0)
        {
            return 0;
        }
        if(n == 0 || m == n || m == 0)
        {
            return 1;
        }
        return pascal(n-1, m-1) + pascal(n-1, m);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(pascal(n,m));
		
	}
}
