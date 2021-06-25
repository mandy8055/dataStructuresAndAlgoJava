package miscelleneous_problems.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class SearchInArray {
    private static final int[] arr = {80, 5, 20, 50, 5, 90, 90, 23, 15, 90};
    public static void main(String[] args){
        int x = 90;
//        int x = 5;
//        int x = 52;
//        System.out.println(getFirstIndex(arr, x, 0));
//        System.out.println(getLastIndex(arr, x, arr.length - 1));
        int[] resArr = getAllIndices(arr, x, 0, 0);
        Arrays.stream(resArr).forEach(num -> System.out.print(num + " "));
    }
    // Get first index of search element. If element is not present in the array return -1.
    private static int getFirstIndex(int[] arr, int search, int idx){
        // base case
        if(idx > arr.length - 1)return -1;
        // Main work
        if(arr[idx] == search)return idx;
        // faith
        return getFirstIndex(arr, search, idx + 1);
    }

    // Get last index of search element. If element is not present in the array return -1.
    private static int getLastIndex(int[] arr, int search, int idx){
        // base case
        if(idx < 0)return -1;
        // Main work
        if(arr[idx] == search)return idx;
        // faith
        return getLastIndex(arr, search, idx - 1);
    }

    // Get all the indices of the search element. If the element is not present return -1;
    private static int[] getAllIndices(int[] arr, int x, int idx, int fsf){
        // Base Case
        if(idx > arr.length - 1){
            return new int[fsf];
        }
        // Main work
        if(arr[idx] == x){
            fsf++;
        }
        // faith
        int[] rr = getAllIndices(arr, x, idx + 1, fsf);
        // Main work
        if(arr[idx] == x){
            rr[fsf - 1] = idx;
        }
        return rr;
    }
}
