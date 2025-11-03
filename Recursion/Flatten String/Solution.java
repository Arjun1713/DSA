import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static String helper(String s, StringBuilder result, int index)
    {
        if(index == s.length())
        {
            return result.toString();
        }
        
        if(s.charAt(index) == '(' || s.charAt(index) == ')')
        {
            return helper(s, result, index + 1);
        }
        else
        {
            return helper(s, result.append(s.charAt(index)), index + 1);
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder result = new StringBuilder();
		String r = helper(s, result, 0);
		System.out.println(r);

	}
}
