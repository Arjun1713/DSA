import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{   
    
    public static void DtoB(int n)
    {
        if(n == 0)
        {
            return;
        }
        DtoB(n/2);
        System.out.print(n%2);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(DtoB(n));

	}
}
