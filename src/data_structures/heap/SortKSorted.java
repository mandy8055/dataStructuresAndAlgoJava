package data_structures.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/sort-ksorted-official/ojquestion#!

public class SortKSorted {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        sortKSorted(arr, k);
    }

    private static void sortKSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.offer(arr[i]);
        }
        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(pq.poll());
            pq.offer(arr[i]);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}