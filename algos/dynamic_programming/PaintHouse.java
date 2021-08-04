package algos.dynamic_programming;
import java.util.Scanner;

// Problem link: https://pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-official/ojquestion#resource

public class PaintHouse {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] matrix = new int[n][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // Integer[][] dp = new Integer[n][3];
        // System.out.println(paintHouse(matrix, n - 1, -1, dp));
        System.out.println(paintHouseTab(matrix));
        sc.close();
    }
    // Paint house Memoization --> May throw Stack overflow for large values of n.
    private static int paintHouseMem(int[][] arr, int rIdx, int color, Integer[][] dp) {
        // Base Case
        if (rIdx < 0) {
            return 0;
        }
        // Main Case
        if(color != -1 && dp[rIdx][color] != null){
            return dp[rIdx][color];
        }

        int ans;
        if (color == 0) { // Red Color
            int gCh = arr[rIdx][1] + paintHouseMem(arr, rIdx - 1, 1, dp);
            int bCh = arr[rIdx][2] + paintHouseMem(arr, rIdx - 1, 2, dp);
            ans = Math.min(gCh, bCh);
        } else if (color == 1) { // Green Color
            int rCh = arr[rIdx][0] + paintHouseMem(arr, rIdx - 1, 0, dp);
            int bCh = arr[rIdx][2] + paintHouseMem(arr, rIdx - 1, 2, dp);
            ans = Math.min(rCh, bCh);
        } else if (color == 2) { // Blue Color
            int rCh = arr[rIdx][0] + paintHouseMem(arr, rIdx - 1, 0, dp);
            int gCh = arr[rIdx][1] + paintHouseMem(arr, rIdx - 1, 1, dp);
            ans = Math.min(rCh, gCh);
        } else { // For first house
            int rCh = arr[rIdx][0] + paintHouseMem(arr, rIdx - 1, 0, dp);
            int gCh = arr[rIdx][1] + paintHouseMem(arr, rIdx - 1, 1, dp);
            int bCh = arr[rIdx][2] + paintHouseMem(arr, rIdx - 1, 2, dp);
            ans = Math.min(rCh, Math.min(gCh, bCh));
        }
        if(color == -1){
            dp[rIdx][color + 1] = ans;
        }else{
            dp[rIdx][color] = ans;
        }
        return ans;
    }
    // Paint house Tabulation
    private static int paintHouseTab(int[][] arr){
        // Create the storage
        int[][] dp = new int[arr.length][3];
        // Initialize dp with colors of first house
        dp[0][0] = arr[0][0]; // Red color on first house
        dp[0][1] = arr[0][1]; // Green color on first house
        dp[0][2] = arr[0][2]; // Blue color on first house
        // Determine the direction of smallest sub-problem
        int ans;
        for(int i = 1; i < arr.length; i++){
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]); // Red color
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]); // Green color
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]); // Blue color
        }
        ans = Math.min(dp[arr.length - 1][0], Math.min(dp[arr.length - 1][1], dp[arr.length - 1][2]));
        return ans;
    }

}