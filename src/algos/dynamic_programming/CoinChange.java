package algos.dynamic_programming;
import java.util.Scanner;

// Combination Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/dynamic-programming-1/coin-change-combination-official/ojquestion

public class CoinChange {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int targetSum = sc.nextInt();
//        System.out.println(coinChangeCombTab1(arr, targetSum));
        System.out.println(coinChangeCombTab2(arr, targetSum));

        sc.close();

    }

    // Coin Change Combinations

    private static int coinChangeCombTab1(int[] arr, int target){
        // Create the storage
        int[] dp = new int[target + 1];
        // Initialize the smallest case
        dp[0] = 1;
        // Determine the direction of smaller sub-problem
        for (int k : arr) {
            for (int j = k; j < dp.length; j++) {
                // Travel and fill the table
                dp[j] += dp[j - k];
            }
        }
        return dp[dp.length - 1];
    }

    private static int coinChangeCombTab2(int[] arr, int amt) {
        // Create the storage
        int[][] dp = new int[arr.length + 1][amt + 1];
        // Initialize the extra added column value
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        // Determine the direction from where the smallest sub-problem lies
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // Travel and fill the table
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    private static int coinChangeCombBruteForceRec(int[] arr, int idx, int target){
        // Negative Base Case
        if(target < 0 || idx == arr.length)return 0;
        // Positive Base Case
        if(target == 0)return 1;
        // Main Case
        int ans;
        ans = coinChangeCombBruteForceRec(arr, idx, target - arr[idx]);
        ans += coinChangeCombBruteForceRec(arr, idx + 1, target);
        return ans;
    }

    private static int coinChangeCombMem(int[] arr, int idx, int target, Integer[][] dp){
        // Negative Base Case
        if(idx == arr.length || target < 0){
            return 0;
        }
        // Positive Base Case
        if(target == 0){
            return 1;
        }
        // Main Case
        int ans;
        if(dp[idx][target] != null){
            return dp[idx][target];
        }
        ans = coinChangeCombMem(arr, idx, target - arr[idx], dp);
        ans += coinChangeCombMem(arr, idx + 1, target, dp);
        dp[idx][target] = ans;
        return ans;
    }

    // Coin change Permutations
    private static int coinChangePermTab(int[] arr, int target){
        // Create the storage
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // Determine the direction
        for(int i = 1; i < dp.length; i++){
            for (int k : arr) {
                if (i - k >= 0) {
                    dp[i] += dp[i - k];
                }
            }
        }
        return dp[dp.length - 1];
    }

    // May give TLE. To rectify this problem use Memoized approach
    private static int coinChangePermBruteForce(int[] arr, int target){
        // Negative Base Case
        if(target < 0) {
            return 0;
        }
        // Positive Base Case
        if(target == 0){
            return 1;
        }
        // Main case
        int ans = 0;
        for (int j : arr) {
            ans += coinChangePermBruteForce(arr, target - j);
        }
        return ans;
    }

    private static int coinChangePermMem(int[] arr, int target, Integer[] dp){
        // Negative Base Case
        if(target < 0){
            return 0;
        }
        // Positive Base Case
        if(target == 0){
            return 1;
        }
        // Main Case
        int ans = 0;
        if(dp[target] != null){
            return dp[target];
        }
        for(int i : arr){
            ans += coinChangePermMem(arr, target - i, dp);
        }
        dp[target] = ans;
        return ans;
    }
}
