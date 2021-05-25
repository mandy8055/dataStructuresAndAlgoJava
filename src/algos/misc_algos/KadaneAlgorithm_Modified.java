package algos.misc_algos;

/* KADANE's Algorithm
* The main purpose of using this algorithm is to find the maximum contiguous sub-array sum or sub-array containing maximum contiguous sub-array sum.
* IDEA:
*   The simple idea of Kadane’s algorithm is to look for all positive contiguous segments of the array.
*   And keep track of maximum sum contiguous segment among all positive segments.
* TIME COMPLEXITY: (NUMBER OF COMPARISONS)
*   O(N)
* SPACE COMPLEXITY:
*   O(1)
 * */


public class KadaneAlgorithm_Modified {

    public static int maxSum(int[] arr){
        int sumTillCurrentIndex = 0;
        int finalMaxSum = Integer.MIN_VALUE;
        for(int i : arr){
            sumTillCurrentIndex += i;
            if(sumTillCurrentIndex < i)
                sumTillCurrentIndex = i;
            if(finalMaxSum < sumTillCurrentIndex)
                finalMaxSum = sumTillCurrentIndex;
        }
        return finalMaxSum;
    }

    public static int maxProduct(int[] arr){
      int maxProductTillNow;
      int minProductTillNow;
      int previousMaxProduct = arr[0];
      int previousMinProduct = arr[0];
      int ans = arr[0];
      for(int i = 1; i < arr.length; i++){
          maxProductTillNow = getMax(previousMaxProduct * arr[i], previousMinProduct * arr[i], arr[i]);
          minProductTillNow = getMin(previousMaxProduct * arr[i], previousMinProduct * arr[i], arr[i]);
          ans = Math.max(ans, maxProductTillNow);
          previousMaxProduct = maxProductTillNow;
          previousMinProduct = minProductTillNow;
      }
      return ans;
    }

    public static void main(String[] args){
        int[] arr = {6, -3, -10, 0, 2};
        System.out.println(maxProduct(arr));
    }

    private static int getMax(int a, int b, int c){
        return (a > b)? Math.max(a, c) : Math.max(b, c);
    }
    private static int getMin(int a, int b, int c){
        return (a < b)? Math.min(a, c) : Math.min(b, c);
    }
}
