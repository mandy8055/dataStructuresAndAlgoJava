package algos.sorting;

import java.util.Arrays;

public class RunnerClass {
    private static int[] arr = {80, 20, 50, 5, 90, 23, 15};
    public static void main(String[] args){
        System.out.println("Array before sorting");
        printArr(arr);
        System.out.println("Array after sorting");
        InsertionSort.insertionSort(arr);
        printArr(arr);
    }
    private static void printArr(int[] arr){
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}
