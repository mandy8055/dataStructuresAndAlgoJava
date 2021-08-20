package data_structures.hashmap;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/gce1-official/ojquestion#!

public class GetCommonElements1 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        gce1(arr1, arr2);
        sc.close();
    }
    private static void gce1(int @NotNull [] arr1, int[] arr2) {
        Set<Integer> hs = new HashSet<>();
        for(int i : arr1){
            hs.add(i);
        }
        for (int i : arr2) {
            if (hs.contains(i)) {
                System.out.println(i);
                hs.remove(i);
            }
        }
    }
}
