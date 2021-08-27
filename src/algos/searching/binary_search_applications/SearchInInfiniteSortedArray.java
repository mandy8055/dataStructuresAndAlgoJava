package algos.searching.binary_search_applications;

import algos.searching.BinarySearch;
import org.jetbrains.annotations.NotNull;

public class SearchInInfiniteSortedArray {
    private static int findElement(int @NotNull [] arr, int target) {
        // first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;
        // condition for the target to lie in the range
        while (target > arr[end]) {
            int temp = end + 1; // this is my new start
            // double the box value
            // end = previous end + sizeOfBox * 2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return BinarySearch.recursiveBinarySearch(arr, target, start, end);
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(findElement(arr, target));
    }
}
