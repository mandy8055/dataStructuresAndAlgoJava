package algos.dynamic_programming;

import java.util.*;

public class MinCostMazeTraversal {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // int[][] dp = new int[n + 1][m + 1];
        // System.out.println(minCostBruteForce(arr, 0, 0));
        // System.out.println(minCostMemoization(arr, 0, 0, dp));
        System.out.println(minCostTabulation(arr));
        sc.close();
    }

    private static int minCostBruteForce(int[][] arr, int sr, int sc) {
        // Negative Base Case
        if (sr >= arr.length || sc >= arr[0].length) {
            return Integer.MAX_VALUE;
        }
        // Positive Base Case
        if (sr == arr.length - 1 && sc == arr[0].length - 1) {
            return arr[sr][sc];
        }
        // Main Case
        int f1 = minCostBruteForce(arr, sr, sc + 1); // Horizontal
        int f2 = minCostBruteForce(arr, sr + 1, sc); // Vertical
        return Math.min(f1, f2) + arr[sr][sc];
    }

    private static int minCostMemoization(int[][] arr, int sr, int sc, int[][] dp) {
        // Negative Base Case
        if (sr >= arr.length || sc >= arr[0].length) {
            return Integer.MAX_VALUE;
        }
        // Positive Base Case
        if (sr == arr.length - 1 && sc == arr[0].length - 1) {
            return arr[sr][sc];
        }
        // Main Case
        // Check whether the called valus is pre-calculated
        if (dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        int f1 = minCostMemoization(arr, sr, sc + 1, dp); // Horizontal
        int f2 = minCostMemoization(arr, sr + 1, sc, dp); // Vertical
        // Memoize the solution
        dp[sr][sc] = Math.min(f1, f2) + arr[sr][sc];
        return dp[sr][sc];
    }

    private static int minCostTabulation(int[][] arr) {
        // Create the storage
        int[][] tab = new int[arr.length][arr[0].length];
        // Determine the direction where the smallest problem lies
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                // Travel and fill the table
                if (i == arr.length - 1 && j == arr[0].length - 1) {
                    tab[i][j] = arr[i][j];
                }else if (i == arr.length - 1) {
                    tab[i][j] = tab[i][j + 1] + arr[i][j];
                } else if (j == arr[0].length - 1) {
                    tab[i][j] = tab[i + 1][j] + arr[i][j];
                } else {
                    tab[i][j] = Math.min(tab[i][j + 1], tab[i + 1][j]) + arr[i][j];
                }
            }
        }
        return tab[0][0];
    }


}

