package algos.dynamic_programming;

import java.util.Scanner;

public class FibonacciDP {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
//        long[] dp = new long[n + 1];
//        System.out.println(fibonacciDPMemoization(n, dp));
        System.out.println(fibonacciDPTabulation(n));
        sc.close();
    }
    // We are required to calculate nth fibonacci term(Memoization)
    private static long fibonacciDPMemoization(int n, long[] arr){
        // Base case
        if(n == 0 || n == 1)return n;
        // Main case
        if(arr[n] != 0){
            return arr[n];
        }
        arr[n] = fibonacciDPMemoization(n - 1, arr) + fibonacciDPMemoization(n - 2, arr);
        return arr[n];
    }
    private static long fibonacciDPTabulation(int n){
        long[] dp = new long[n + 1];
        for(int i = 0; i <= n; i++){
            if(i == 0 || i == 1)
                dp[i] = i;
            else{
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
