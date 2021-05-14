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
}
