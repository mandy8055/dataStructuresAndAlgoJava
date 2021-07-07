package algos.sorting;

public class MergeSort {
    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }
    private static void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = low + ((high - low) / 2);
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    private static void merge(int[] arr, int low, int mid, int high){
        // calculate the sizes of auxiliary arrays
        int n1 = mid - low + 1;
        int n2 = high - mid;
        // Define auxiliary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        // Populate the auxiliary arrays
        System.arraycopy(arr, low, leftArr, 0, n1);
        for(int j = 0; j < n2; j++){
            rightArr[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = low;
        while(i < n1 && j < n2){
            if(leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i++];
            }else{
                arr[k] = rightArr[j++];
            }
            k++;
        }
        while(i < n1){
            arr[k++] = leftArr[i++];
        }
        while(j < n2){
            arr[k++] = rightArr[j++];
        }
    }
}
