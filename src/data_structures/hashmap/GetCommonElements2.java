package data_structures.hashmap;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/hashmap-and-heap/gce2-official/ojquestion#!

public class GetCommonElements2 {
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
        gce2(arr1, arr2);
        sc.close();
    }
    private static void gce2(int @NotNull [] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            if (map.containsKey(i)) {
                int of = map.get(i);
                int nf = of + 1;
                map.put(i, nf);
            } else {
                map.put(i, 1);
            }
        }
        for(int i : arr2){
            if(map.containsKey(i)){
                if(map.get(i) == 1){
                    map.remove(i);
                }else{
                    int of = map.get(i);
                    int nf = of - 1;
                    map.put(i, nf);
                }
                System.out.println(i);
            }
        }
    }
}
