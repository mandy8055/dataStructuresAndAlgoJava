package coding_bat_problems.recursion1;
// problem link: https://codingbat.com/prob/p173469

public class Problem17 {
    public boolean array220(int[] nums, int index) {
        // base case
        if(index == nums.length || index == nums.length - 1){
            return false;
        }
        // Main case
        return nums[index] * 10 == nums[index + 1] ||
                array220(nums, index + 1);
    }
}
