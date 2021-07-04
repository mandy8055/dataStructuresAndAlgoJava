package algos.sorting;
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            boolean swapped = false;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!swapped)break;
        }
    }
}
