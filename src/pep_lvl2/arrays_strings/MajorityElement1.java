package pep_lvl2.arrays_strings;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/arrays-&-strings-level-2/majority-element-i/ojquestion
// leetcode link: problem 169
public class MajorityElement1 {
    public static void printMajorityElement(int[] arr){
        int potMaj = validMajorityElementUsingMooreVotingAlgo(arr);
        int count = 0;
        for(int i : arr){
            if(i == potMaj){
                count++;
            }
        }
        if(count > (arr.length / 2)){
            System.out.println(potMaj);
        }else{
            System.out.println("No Majority Element exist");
        }
    }
    @Contract(pure = true)
    private static int validMajorityElementUsingMooreVotingAlgo(int @NotNull [] arr){
        int count = 1;
        int val = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == val){
                count++;
            }else{
                if(count > 0){
                    count--;
                }else{
                    val = arr[i];
                    count = 1;
                }
            }
        }
        return val; // Potential Majority Element
    }
}
