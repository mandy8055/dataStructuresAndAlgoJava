package data_structures.hashmap;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/lcqs-official/ojquestion#!

public class PrintLongestConsecutiveSequence {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        longestSequence(arr);
        sc.close();
    }
    private static void longestSequence(int @NotNull [] arr) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i : arr){
            // Considering every element as the starting point.
            map.put(i, true);
        }
        for(int i : arr){
            // Adjust the starting position
            if(map.containsKey(i - 1)){
                map.put(i, false);
            }
        }
        // Calculate the result
        int maxLen = 0;
        int msp = Integer.MIN_VALUE;
        for(int i : arr){
            // If variable i is the starting position
            if(map.get(i)){
                int temp = i;
                int tl = 0;
                while(map.containsKey(temp)){
                    tl++;
                    temp++;
                }
                if(tl > maxLen){
                    msp = i;
                    maxLen = tl;
                }
            }
        }
        // Print the result
        for(int i = msp; i < msp + maxLen; i++){
            System.out.println(i);
        }
    }
}
