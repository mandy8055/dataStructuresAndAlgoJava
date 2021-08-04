package miscelleneous_problems.recursion.rec_in_arrays;

public class PrintingArrayElements {
    public static void main(String[] args){
        int[] arr = {80, 20, 50, 5, 90, 23, 15};
//        printElementsInReverse1(arr, 0);
//        printElements(arr, 0);
        printElementsInReverse2(arr, arr.length - 1);
    }
    private static void printElements(int[] arr, int idx){
        // Base case
        if(idx > arr.length - 1)return;
        // Main work
        System.out.print(arr[idx] + " ");
        // faith
        printElements(arr, idx + 1);
    }

    private static void printElementsInReverse1(int[] arr, int idx){
        // Base case
        if(idx > arr.length - 1)return;
        // faith
        printElementsInReverse1(arr, idx + 1);
        // Main work
        System.out.print(arr[idx] + " ");
    }

    private static void printElementsInReverse2(int[] arr, int idx){
        // Base case
        if(idx < 0)return;
        // Main work
        System.out.print(arr[idx] + " ");
        // faith
        printElementsInReverse2(arr, idx - 1);
    }
}
