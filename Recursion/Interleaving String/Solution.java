import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    public static boolean helper(String s1, String s2, String s3, int i1, int i2, int i3)
    {
        if(i3  == s3.length())
        {
            return true;
        }
        if((i1 < s1.length()) && (s1.charAt(i1) == s3.charAt(i3)))
        {
            return helper(s1,s2,s3,i1+1, i2, i3 + 1);
        }
        else if((i2 < s2.length()) && (s2.charAt(i2) == s3.charAt(i3)))
        {
            return helper(s1,s2,s3,i1,i2+1,i3+1);
        }
        else
        {
            return false;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		String s3 = sc.nextLine();
		boolean answer = helper(s1,s2,s3, 0,0,0);
		System.out.println(answer);

	}
}
