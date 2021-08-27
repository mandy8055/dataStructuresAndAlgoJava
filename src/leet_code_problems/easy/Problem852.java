package leet_code_problems.easy;

import org.jetbrains.annotations.NotNull;
// Also known as bi-tonic array problem
public class Problem852 {
    public int peakIndexInMountainArray(int @NotNull [] arr) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(mid - 1 >= 0 && mid <= arr.length - 1){
                if(arr[mid] < arr[mid + 1] && arr[mid] > arr[mid - 1]){
                    // We are at left side of the peak.
                    low = mid + 1;
                }else if(arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]){
                    // We are at the right of the peak.
                    high = mid - 1;
                }else{
                    return mid;
                }
            }else if(mid - 1 < 0){
                return high;
            }else{
                return low;
            }
        }
        return -1;
    }
}
