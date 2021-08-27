package algos.searching.binary_search_applications;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class FloorOfTargetInArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int num = 10; // Cases to check: 14, 20, 4, 3, 1, 15
        System.out.println(floorOfANumber(arr, num));
    }
    @Contract(pure = true)
    public static int floorOfANumber(int @NotNull [] arr, int num){
        if(num < arr[0]){
            return Integer.MIN_VALUE;
        }
        int low = 0;
        int high = arr.length - 1;
        int ceilIdx = -1;
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(arr[mid] > num){
                high = mid - 1;
            }else{
                ceilIdx = mid;
                low = mid + 1;
            }
        }
        return arr[ceilIdx];
    }
}
