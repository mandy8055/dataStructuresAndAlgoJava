package algos.dynamic_programming;
import java.util.Scanner;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/dynamic-programming-1/buy-and-sell-stocks-ota-official/ojquestion

public class StockBuyAndSellOneTransaction {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(buyAndSellStocksOneTransactionBruteForce(arr));
        sc.close();
    }
    private static int buyAndSellStocksOneTransactionBruteForce(int[] arr){
        int maxProfit = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                int currentProf = arr[i] - arr[j];
                if(currentProf > maxProfit){
                    maxProfit = currentProf;
                }
            }
        }
        return maxProfit;
    }
    private static int buyAndSellStocksOneTransactionGreedy(int[] arr){
        int leastSoFar = Integer.MAX_VALUE;
        int currentProfit;
        int maxProfit = 0;
        for (int j : arr) {
            if (j < leastSoFar) {
                leastSoFar = j;
            }
            currentProfit = j - leastSoFar;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }

}
