package pep_lvl2.arrays_strings;

import org.jetbrains.annotations.NotNull;
// Problem link:  https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/squares-of-a-sorted-array/ojquestion
// Leetcode problem: Problem 977
public class SquaresOfSortedArray {
    public static int @NotNull [] sortedSquares(int @NotNull [] nums) {
        int[] resArr = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = resArr.length - 1;
        while(k >= 0){
            if(Math.abs(nums[i]) < Math.abs(nums[j])){
                resArr[k--] = nums[j] * nums[j];
                j--;
            } else{
                resArr[k--] = nums[i] * nums[i];
                i++;
            }
        }
        return resArr;
    }
}
