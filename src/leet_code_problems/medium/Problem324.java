package leet_code_problems.medium;

import java.util.Arrays;

public class Problem324 {
    public void wiggleSort(int[] nums){
        // Create an auxiliary array
        int[] aux = new int[nums.length];
        // Copy the contents of nums to aux.
        System.arraycopy(nums, 0, aux, 0, nums.length);
        // Sort the auxiliary array
        Arrays.sort(aux);
        // fill the odd index
        int i = 1;
        int j = aux.length - 1;
        while(i < nums.length){
            nums[i] = aux[j];
            i += 2;
            j--;
        }
        // fill the even index
        i = 0;
        while(i < nums.length){
            nums[i] = aux[j];
            i += 2;
            j--;
        }
    }
}
