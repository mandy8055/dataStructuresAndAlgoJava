package algos.dynamic_programming;
import java.util.*;

public class GoldmineDP {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++){
            max = Math.max(max, goldmineDP(arr, i, 0, dp));

        }
        System.out.println(max);
        // System.out.println(goldmineTab(arr));
    }

    private static int goldmineBruteForce(int[][] arr, int sr, int sc){
        // Negative Base Case
        if(sr >= arr.length || sc >= arr[0].length || sr < 0){
            return Integer.MIN_VALUE;
        }
        // Positive Base case
        if(sc == arr[0].length - 1){
            return arr[sr][sc];
        }
        // Main case
        int digPath1 = goldmineBruteForce(arr, sr - 1, sc + 1); // Right up
        int digPath2 = goldmineBruteForce(arr, sr, sc + 1); // Right
        int digPath3 = goldmineBruteForce(arr, sr + 1, sc + 1); // Right down

        return Math.max(digPath1, Math.max(digPath2, digPath3)) + arr[sr][sc];
    }

    private static int goldmineDP(int[][] arr, int sr, int sc, int[][] dp){
        // Negative base case
        if(sr >= arr.length || sc >= arr[0].length || sr < 0){
            return Integer.MIN_VALUE;
        }
        // Positive Base case
        if(sc == arr[0].length - 1){
            return arr[sr][sc];
        }

        // Main case
        // Check if dp contains pre-calculated result
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        int digPath1 = goldmineDP(arr, sr - 1, sc + 1, dp);
        int digPath2 = goldmineDP(arr, sr, sc + 1, dp);
        int digPath3 = goldmineDP(arr, sr + 1, sc + 1, dp);
        // Memoize the result
        dp[sr][sc] = Math.max(digPath1, Math.max(digPath2, digPath3)) + arr[sr][sc];
        return dp[sr][sc];
    }

    private static int goldmineTab(int[][] arr){
        // Create the storage
        int[][] tab = new int[arr.length][arr[0].length];
        // Determine the direction where the smaller problem lies.
        for(int j = arr[0].length - 1; j >= 0; j--){
            for(int i = 0; i < arr.length; i++){
                // Travel and fill the table
                if(j == arr[0].length - 1){
                    tab[i][j] = arr[i][j];
                }else if(i == 0){ // 2 choice --> right, right down
                    tab[i][j] = Math.max(tab[i][j + 1], tab[i + 1][j + 1]) + arr[i][j];
                }else if(i == arr.length - 1){ // 2 choice --> right up, right
                    tab[i][j] = Math.max(tab[i][j + 1], tab[i - 1][j + 1]) + arr[i][j];
                }else{ // 3 choices --> right up, right, right down
                    tab[i][j] = Math.max(tab[i][j + 1], Math.max(tab[i - 1][j + 1], tab[i + 1][j + 1])) + arr[i][j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int[] ints : tab) {
            max = Math.max(max, ints[0]);
        }
        return max;
    }


}
