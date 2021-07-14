package algos.dynamic_programming;
import java.util.Scanner;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/dynamic-programming-1/buy-sell-stocks-tta-official/ojquestion

public class StockBuyAndSellTwoTransactions {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(buyAndSellStocksTwoTransactions(arr));
        sc.close();
    }
    private static int buyAndSellStocksTwoTransactions(int[] arr){
        // Find max profit from left direction
        int leastSoFar = arr[0];
        int currentProfit;
        int[] dpLeft = new int[arr.length];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < leastSoFar){
                leastSoFar = arr[i];
            }
            currentProfit = arr[i] - leastSoFar;
            dpLeft[i] = Math.max(currentProfit, dpLeft[i - 1]);
        }
        // Find max profit from right direction
        int maxSoFar = arr[arr.length - 1];
        int[] dpRight = new int[arr.length];
        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] > maxSoFar){
                maxSoFar = arr[i];
            }
            currentProfit = maxSoFar - arr[i];
            dpRight[i] = Math.max(currentProfit, dpRight[i + 1]);
        }
        // Add the sum and return the maximum
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            if(dpLeft[i] + dpRight[i] > res){
                res = dpLeft[i] + dpRight[i];
            }
        }
        return res;
    }
}
