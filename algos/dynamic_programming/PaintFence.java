package algos.dynamic_programming;
import java.util.Scanner;
// Problem link: https://pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-fence-official/ojquestion
public class PaintFence {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(paintFenceBruteForce(n, k));
        sc.close();
    }
    private static int paintFenceBruteForce(int n, int k){
        // Base Case
        if(n == 1){
            return k;
        }else if(n == 2){
            return k * k;
        }
        // Main Case
        int same = paintFenceBruteForce(n - 1, k);
        int diff = paintFenceBruteForce(n - 2, k);
        return (same + diff) * (k - 1);
    }
    private static int paintFenceTab(int n, int k) {
        // Create the storage
        int[] dpSame = new int[n];
        int[] dpDiff = new int[n];
        // Initialize with base case
        dpDiff[0] = k;
        // Determine the direction of smallest sub-problem
        for (int i = 1; i < n; i++) {
            // Travel and fill the tables
            dpSame[i] = dpDiff[i - 1];
            dpDiff[i] = (dpDiff[i - 1] + dpSame[i - 1]) * (k - 1);
        }
        return dpSame[n - 1] + dpDiff[n - 1];
    }
}
