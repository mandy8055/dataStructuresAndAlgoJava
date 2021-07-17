package algos.dynamic_programming;
import java.util.Scanner;

// Problem link: https://pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/friends-pairing-official/ojquestion#!

public class FriendsPairing {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        // System.out.println(friendsPairingMem(n, dp));
        System.out.println(friendsPairingTab(n));
        sc.close();
    }
    private static int friendsPairingBruteForce(int n) {
        // Base Case
        if (n == 0 || n == 1)return 1;
        // Main Case
        int single = friendsPairingBruteForce(n - 1);
        int mingle = (n - 1) * friendsPairingBruteForce(n - 2);
        return single + mingle;
    }

    private static int friendsPairingMem(int n, int[] dp) {
        // Base Case
        if (n == 0 || n == 1)return 1;
        // Main Case
        if(dp[n] != 0){
            return dp[n];
        }
        int single = friendsPairingMem(n - 1, dp);
        int mingle = (n - 1) * friendsPairingMem(n - 2, dp);
        int ans = single + mingle;
        dp[n] = ans;
        return dp[n];
    }

    private static int friendsPairingTab(int n){
        // Create the storage
        int[] dp = new int[n + 1];
        // Determine the direction smaller sub-problem
        dp[0] = dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            // Travel and fill the table
            dp[i] = dp[i - 1] + (dp[i - 2] * (n - i + 1));
        }
        return dp[dp.length - 1];
    }
}