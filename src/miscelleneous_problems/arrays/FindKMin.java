package miscelleneous_problems.arrays;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKMin {
    public static void main(String[] args) {
        int[] arr = {80, 20, 50, 5, 90, 23, 15};
//        System.out.println(getKMin(arr, 0, arr.length - 1, 3));
        System.out.println(getKMinSec(arr,4));
    }

    private static int getKMin(int[] arr, int low, int high, int k) {
        int partitions = partition(arr, low, high);
        if (partitions == k - 1) {
            return arr[partitions];
        } else if (partitions < k - 1)
            return getKMin(arr, partitions + 1, high, k);
        else
            return getKMin(arr, low, partitions - 1, k);
    }


    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = -1;
        for (int j = 0; j < high; j++) {
            if (pivot > arr[j]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }
    private static int getKMinSec(int[] arr, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int j : arr) {
            priorityQueue.add(j);
            while (priorityQueue.size() > k)
                priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
