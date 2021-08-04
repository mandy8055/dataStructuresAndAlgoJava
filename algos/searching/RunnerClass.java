package algos.searching;

import algos.searching.binary_search_applications.SquareRootWithoutUsingLib;

import java.util.Arrays;

public class RunnerClass {
    private static final int[] arr = {80, 20, 50, 5, 90, 23, 15};
    private static final int searchElement = 90;
    public static void main(String[] args){
////        System.out.println(LinearSearch.linearSearch(arr, searchElement));
//        Arrays.sort(arr);
////        System.out.println(BinarySearch.iterativeBinarySearch(arr, searchElement));
//        System.out.println(BinarySearch.recursiveBinarySearch(arr, searchElement, 0, arr.length - 1));
        System.out.println(SquareRootWithoutUsingLib.squareRoot(24));

    }
}
