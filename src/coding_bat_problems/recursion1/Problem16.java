package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p135988
public class Problem16 {
    public int array11(int[] nums, int index) {
        // base case
        if(index == nums.length)return 0;
        // Main case
        if(nums[index] == 11){
            return 1 + array11(nums, index + 1);
        }else{
            return array11(nums, index + 1);
        }
    }
}
