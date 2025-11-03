import java.util.Scanner;

class Codechef {
    public static int countWays(int S) {
        // Write your code here
        if(S==0)
        {
            return 1;
        }
        if(S<0)
        {
            return 0;
        }
        return countWays(S-1) + (S-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        System.out.println(countWays(S));
    }
}