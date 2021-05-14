package algos.searching;

public class BinarySearch {
    public static int iterativeBinarySearch(int[] arr, int searchElement){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (int)Math.floor((low + high) / 2);
            if(arr[mid] == searchElement)
                return mid;
            else if(arr[mid] > searchElement)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    public static int recursiveBinarySearch(int[] arr, int searchElement, int low, int high){
        // Boundary Case
        if(low <= high){
            int mid = (int)Math.floor((low + high) / 2);
            if(arr[mid] == searchElement)
                return mid;
            else if(arr[mid] > searchElement)
                return recursiveBinarySearch(arr, searchElement, low, mid - 1);
            else
                return recursiveBinarySearch(arr, searchElement, mid + 1, high);
        }
        return -1;
    }
}
