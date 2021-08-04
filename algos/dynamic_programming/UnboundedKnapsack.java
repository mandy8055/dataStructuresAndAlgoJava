package algos.dynamic_programming;
import java.util.Scanner;

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/unbounded-knapsack-official/ojquestion#!

public class UnboundedKnapsack {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < values.length; i++) {
            values[i] = sc.nextInt();
        }
        int[] weights = new int[n];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = sc.nextInt();
        }
        int cap = sc.nextInt();
        // System.out.println(unboundedKnapsackRec(values, weights, cap, 0));
        System.out.println(unboundedKnapsackTab(values, weights, cap));
        sc.close();
    }

    private static int unboundedKnapsackRec(int[] values, int[] weights, int cap, int idx) {
        // Negative Base Case
        if (cap < 0) {
            return Integer.MIN_VALUE;
        }
        // Positive Base Case
        if (idx == values.length) {
            return 0;
        }
        // Main Case
        // Current indexed element will be added to the knapsack.
        int res1 = unboundedKnapsackRec(values, weights, cap - weights[idx], idx) + values[idx];
        // Current indexed element will be not added to the knapsack.
        int res2 = unboundedKnapsackRec(values, weights, cap, idx + 1);
        return Math.max(res1, res2);
    }

    private static int unboundedKnapsackTab(int[] values, int[] weights, int cap) {
        // Create the storage
        int[] dp = new int[cap + 1];
        // Identify the direction of smaller sub-problem
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < values.length; j++) {
                // Travel and fill the array
                if (i - weights[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
                }
            }
        }
        return dp[cap];
    }
}