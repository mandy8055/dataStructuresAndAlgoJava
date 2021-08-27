package leet_code_problems.easy;

import org.jetbrains.annotations.NotNull;

public class Problem744 {
    public char nextGreatestLetter(char @NotNull [] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(letters[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return letters[low % letters.length];
    }
}
