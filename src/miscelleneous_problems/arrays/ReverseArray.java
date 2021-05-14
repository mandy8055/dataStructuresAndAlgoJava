package miscelleneous_problems.arrays;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ReverseArray {
    private static final int[] arr = {80, 20, 50, 5, 90, 23, 15};
    public static void main(String[] args){
//        iterativeReverseArr(arr, 0, arr.length - 1);
        recursiveReverseArr(arr, 0, arr.length - 1);
        System.out.print("Array after reversal: ");
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static void iterativeReverseArr(int @NotNull []arr, int start, int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    private static void recursiveReverseArr(int @NotNull []arr, int start, int end){
        // Termination condition
        if(start >= end)return;

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        recursiveReverseArr(arr, start + 1, end - 1);
    }
}
