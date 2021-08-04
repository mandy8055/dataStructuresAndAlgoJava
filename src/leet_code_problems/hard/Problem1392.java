package leet_code_problems.hard;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
public class Problem1392 {
    public String longestPrefix(@NotNull String pattern) {
        int[] arr = new int[pattern.length()];
        arr[0] = 0;
        int i = 1, j = 0;
        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
                arr[i] = j;
                i++;
            }else{
                if(j != 0)
                    j = arr[j - 1];
                else{
                    arr[i] = j;
                    i++;
                }
            }
        }
        return pattern.substring(0, j);
    }
}
