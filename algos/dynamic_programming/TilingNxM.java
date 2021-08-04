package algos.dynamic_programming;
import java.util.Scanner;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/dynamic-programming-1/tiling2-official/ojquestion

public class TilingNxM {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Integer[] dp = new Integer[n + 1];
        // System.out.println(tilingnXmMem(n, m, dp));
        System.out.println(tilingnXmTab(n, m));
        sc.close();
    }
    private static int tilingnXmBruteForce(int n, int m) {
        // Base Case
        if (n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }

        // Main Case
        int f1 = tilingnXmBruteForce(n - 1, m);
        int f2 = tilingnXmBruteForce(n - m, m);
        return f1 + f2;
    }

    private static int tilingnXmMem(int n, int m, Integer[] dp) {
        // Base Case
        if (n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }

        // Main Case
        if(dp[n] != null){
            return dp[n];
        }
        int f1 = tilingnXmMem(n - 1, m, dp);
        int f2 = tilingnXmMem(n - m, m, dp);
        int ans = f1 + f2;
        dp[n] = ans;
        return ans;
    }

    private static int tilingnXmTab(int n, int m){
        // Create the storage
        int[] dp = new int[n + 1];
        // Determine the direction of smallest sub-problem
        for(int i = 0; i < dp.length; i++){
            if(i < m){
                dp[i] = 1;
            }else if(i == m){
                dp[i] = 2;
            }else{
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        return dp[dp.length - 1];
    }
}
