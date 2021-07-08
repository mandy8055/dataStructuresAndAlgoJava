package algos.dynamic_programming;

import java.util.Scanner;

public class ClimbStairsDP {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        System.out.println(climbStairsDPMemoization(n, dp));
        sc.close();
    }
    private static int climbStairsDPMemoization(int n, int[] dp){
        // Negative Base Case
        if(n < 0)return 0;
        // Positive Base Case
        if(n == 0)return 1;
        // Main Case
        if(dp[n] != 0){
            return dp[n];
        }
        int path1 = climbStairsDPMemoization(n - 1, dp);
        int path2 = climbStairsDPMemoization(n - 2, dp);
        int path3 = climbStairsDPMemoization(n - 3, dp);
        dp[n] = path1 + path2 + path3;
        return dp[n];
    }
    private static int climbStairsDPTabulation(int n){
        // Create Storage
        int[] dp = new int[n + 1];
        // Determine in which direction the smaller problem lies.
        for(int i = 0; i <= n; i++){
            // Solve along the way.
            if(i == 0)dp[i] = 1;
            else{
                if(i - 2 >= 0){
                    dp[i] += dp[i - 2];
                }
                if(i - 3 >= 0){
                    dp[i] += dp[i - 3];
                }
                dp[i] += dp[i - 1];
            }
        }
        return dp[n];
    }
}
