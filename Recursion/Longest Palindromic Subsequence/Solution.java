import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    
    public static int helper(String s, int start, int end)
    {
        if(start > end)
        {
            return 0;
        }
        if(start == end)
        {
            return 1;
        }
        
        if(s.charAt(start) == s.charAt(end))
        {
            return 2 + helper(s, start + 1, end - 1);
        }
        else
        {
            //If the two characters do not match, we have two options:
            //1. Exclude the current start character and recurse
            //2. Exclude the current end character and recurse
            
            return Math.max(helper(s, start + 1, end), helper(s, start, end-1));
        }
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		System.out.println(helper(s, 0, s.length()-1));

	}
}
