package leet_code_problems.medium;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = modifiedBinarySearch(nums, target, "first");
        res[1] = modifiedBinarySearch(nums, target, "last");
        return res;
    }
    @Contract(pure = true)
    private static int modifiedBinarySearch(int @NotNull [] nums, int target, String ans){
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(nums[mid] == target){
                if(ans.equals("first")){
                    idx = mid;
                    high = mid - 1;
                }else{ // if ans.equals("last")
                    idx = mid;
                    low = mid + 1;
                }
            } else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return idx;
    }
}
