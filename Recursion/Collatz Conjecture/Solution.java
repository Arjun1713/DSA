import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int cC(long n)
    {
        if(n == 1)
        {
            return 0;
        }
        
        return 1 + ((n%2==0)?cC(n/2):cC(3*n + 1));
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		System.out.println(cC(n));

	}
}
