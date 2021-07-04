package coding_bat_problems.recursion1;

// Problem link: https://codingbat.com/prob/p108997

public class Problem15 {
    public static boolean array6(int[] nums, int index) {
        // base case
        if(index == nums.length)return false;
        // main case
        return nums[index] == 6 || array6(nums, index + 1);
    }
}
