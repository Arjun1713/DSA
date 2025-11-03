import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    public static int gcd(int a, int b)
    {
        if(b==0)
        {
            return a;
        }
        
        return gcd(b, a%b);
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(gcd(a, b));

	}
}
