package algos.sorting;

import java.util.Arrays;

public class RunnerClass {
    private static final int[] arr = {80, 20, 50, 5, 90, 23, 15};
    public static void main(String[] args){
        System.out.println("Array before sorting");
        printArr();
        System.out.println("Array after sorting");
//        InsertionSort.insertionSort(arr);
//        BubbleSort.bubbleSort(arr);
        SelectionSort.selectionSort(arr);
        printArr();
    }
    private static void printArr(){
        Arrays.stream(RunnerClass.arr).forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
}
