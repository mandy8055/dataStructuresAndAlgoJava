package leet_code_problems.medium;

public class Problem280 {
    public void wiggleSort1(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(i % 2 == 0){
                if(arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1);
                }
            }else{
                if(arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
