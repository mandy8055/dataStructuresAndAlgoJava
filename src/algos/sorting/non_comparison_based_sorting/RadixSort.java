package algos.sorting.non_comparison_based_sorting;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class RadixSort {
    public static void radixSort(int[] arr) {
        // Find the max element
        int max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        int exp = 1;
        while(exp <= max){
            countSort(arr, exp);
            exp *= 10;
        }
    }
    public static void countSort(int @NotNull [] arr, int exp) {
        // Create the auxiliary array for storing answer
        int[] ans = new int[arr.length];
        // Create the freq array
        int[] freq = new int[10];
        // Populate the frequency array
        for(int i:  arr){
            freq[(i / exp) % 10]++;
        }
        // Create a prefix sum array out of freq array
        freq[0] -= 1;
        for(int i = 1; i < freq.length; i++){
            freq[i] += freq[i - 1];
        }
        // Populate the ans array
        for(int i = arr.length - 1; i >= 0; i--){
            ans[freq[(arr[i] / exp) % 10]] = arr[i];
            freq[(arr[i] / exp) % 10]--;
        }
        // Copy the answer to the original array.
        System.arraycopy(ans, 0, arr, 0, ans.length);

        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }
    public static void print(int @NotNull [] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }

}
