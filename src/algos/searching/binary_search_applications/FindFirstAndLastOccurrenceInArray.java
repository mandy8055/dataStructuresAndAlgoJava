package algos.searching.binary_search_applications;

import java.util.ArrayList;

public class FindFirstAndLastOccurrenceInArray {
    private static final int[] arr = {5, 15, 20, 20, 20, 23, 50, 80, 90};
    private static final int searchElement = 23;
    private static final String id_first = "first";
    private static final String id_last = "last";

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>(2);
        arrayList.add(modifiedBinarySearch(arr, searchElement, id_first));
        arrayList.add(modifiedBinarySearch(arr, searchElement, id_last));
        // [-1, -1] indicates the element is not present in the array
        System.out.println(arrayList);
    }
    // Finding first occurrence
    private static int modifiedBinarySearch(int[] arr, int searchElement, String id){
        int low = 0;
        int high = arr.length - 1;
        int result = -1;
        while(low <= high){
            int mid = (int)Math.floor((low + high) / 2);
            if(arr[mid] == searchElement) {
                result = mid;
                if(id.equals("first"))
                    high = mid - 1;
                else if(id.equals("last"))
                    low = mid + 1;
            }
            else if(arr[mid] < searchElement)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return result;
    }
}
