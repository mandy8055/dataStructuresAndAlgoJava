package algos.dynamic_programming;
import java.util.Scanner;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/dynamic-programming-1/tiling1-official/ojquestion

public class Tiling2x1 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        Integer[] dp = new Integer[n + 1];
        // System.out.println(tiling2x1Tab(n));
        System.out.println(tiling2x1Mem(n, dp));
        sc.close();
    }

    private static int tiling2x1Tab(int n) {
        // Create the storage
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        // Determine the direction of smaller problem
        for (int i = 2; i < dp.length; i++) {
            // Travel and fill the table
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1];
    }
    private static int tiling2x1BruteForce(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Main case
        int f1 = tiling2x1BruteForce(n - 1);
        int f2 = tiling2x1BruteForce(n - 2);
        return f1 + f2;
    }
    private static int tiling2x1Mem(int n, Integer[] dp) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Main case
        if(dp[n] != null){
            return dp[n];
        }
        int f1 = tiling2x1Mem(n - 1, dp);
        int f2 = tiling2x1Mem(n - 2, dp);
        int ans = f1 + f2;
        dp[n] = ans;
        return ans;
    }
}