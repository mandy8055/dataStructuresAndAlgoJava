package miscelleneous_problems.arrays;

import java.util.Arrays;

public class RotateAnArray {
    private static void rotateArr(int[] arr, int k){
        k %= arr.length;
        // For left rotation
        if(k < 0){
            k += arr.length;
        }
        ReverseArray.iterativeReverseResult(arr, 0, arr.length - 1);
        ReverseArray.iterativeReverseResult(arr, 0, k - 1);
        ReverseArray.iterativeReverseResult(arr, k, arr.length - 1);
    }

    public static void main(String[] args){
        int[] arr = {80, 20, 50, 5, 90, 23, 15};
        int k = -9;
        // Array before rotation
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
        System.out.println();
        rotateArr(arr, k);
        // Array after rotation
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }
}
