import java.util.*;
public class GreedySolution {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int steps = 0;
        while(n > 0)
        {
            int maxDigit = 0;
            int temp = n;
            while(temp > 0)
            {
                maxDigit = Math.max(maxDigit, temp%10);
                temp /= 10;
            }
            n -= maxDigit;
            steps++;

        }
        System.out.println(steps);
    }
}

// Time Complexity -> Worst Case = O(n log n) because in the worst the number decreases by 1 every time which makes the outer loop n, and going over all the digits is log n
//                 -> Average Case = O(log n) because removing the biggest digit reduces the number significantly

// Space Complexiyy -> o(1)