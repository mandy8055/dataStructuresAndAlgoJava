package algos.sorting;

public class QuickSort {
    public static void quickSort(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
    }
    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int partitions = partition(arr, low, high);
            quickSort(arr, low, partitions - 1);
            quickSort(arr, partitions + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high){
        int i = -1, j = 0;
        int pivot = arr[high];
        for(; j < high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }
    // Utility function
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
