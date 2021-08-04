package algos.sorting.non_comparison_based_sorting;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

// Problem link: https://pepcoding.com/resources/online-java-foundation/time-and-space-complexity/count-sort-official/ojquestion#!

public class CountSort {
    private static void countSort(int @NotNull [] arr, int min, int max){
        // Create an auxiliary array to store the sorted result
        int[] ans = new int[arr.length];
        // Create a freq array
        int[] freq = new int[max - min + 1];
        // Populate the freq array
        for (int i : arr) {
            freq[i - min]++;
        }
        // Create a prefix sum array out of freq array
        freq[0] -= 1;
        for(int i = 1; i < freq.length; i++){
            freq[i] += freq[i - 1];
        }
        // Populate the ans array
        for(int i = arr.length - 1; i >= 0; i--){
            ans[freq[arr[i] - min]] = arr[i];
            freq[arr[i] - min]--;
        }
        // Store the result back to original array
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }
    private static void print(int @NotNull [] arr) {
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }
}