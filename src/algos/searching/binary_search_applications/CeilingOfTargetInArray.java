package algos.searching.binary_search_applications;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class CeilingOfTargetInArray {
    private static int ceilingOfANumber(int @NotNull [] arr, int num) {
        // Base Cases
        if (num < arr[0]) {
            return arr[0];
        }
        if (num > arr[arr.length - 1]) {
            return Integer.MAX_VALUE;
        }
//        int ceilIdx = modifiedBinarySearch1(arr, 0, arr.length - 1, num);
        int ceilIdx = modifiedBinarySearch2(arr, num);
        return arr[ceilIdx];
    }
    private static int modifiedBinarySearch1(int[] arr, int low, int high, int el) {
        int ceilIdx = -1;
        if (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] < el) {
                ceilIdx = modifiedBinarySearch1(arr, mid + 1, high, el);
            } else {
                int temp = modifiedBinarySearch1(arr, low, mid - 1, el);
                ceilIdx = temp == -1 ? mid : temp;
            }
        }
        return ceilIdx;
    }
    @Contract(pure = true)
    private static int modifiedBinarySearch2(int @NotNull [] arr, int el){
        int low = 0;
        int high = arr.length - 1;
        int ceilIdx = -1;
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(arr[mid] < el){
                low = mid + 1;
            }else{
                ceilIdx = mid;
                high = mid - 1;
            }
        }
        return ceilIdx;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int num = 10; // Cases to check: 14, 20, 4, 3, 1, 15
        System.out.println(ceilingOfANumber(arr, num));
    }
}
