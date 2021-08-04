package data_structures.arrays_2d;
import java.util.Scanner;
public class RingRotate {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int[] ints : arr){
            for(int j = 0; j < arr[0].length; j++){
                ints[j] = sc.nextInt();
            }
        }
        int s = sc.nextInt();
        int r = sc.nextInt();
        shellRotate(arr, s, r);
        display(arr);
        sc.close();
    }

    private static void shellRotate(int[][] arr, int s, int r){
        // Travel in the shell and fill 1D from given arr
        int[] rotArr = fill1DFrom2D(arr, s);
        // Rotate the array by r
        rotate(rotArr, r);
        // Travel and update arr with the rotate value from 1D array.
        fill2Dfrom1D(arr, rotArr, s);
    }

    private static int[] fill1DFrom2D(int[][] arr, int s){
        int rMin = s - 1;
        int cMin = s - 1;
        int rMax = arr.length - s;
        int cMax = arr[0].length - s;
        int size = 2 * ((rMax - rMin) + (cMax - cMin));
        int[] res = new int[size];
        int counter = 0;
        for(int i = rMin; i <= rMax; i++){
            res[counter++] = arr[i][cMin];
        }
        cMin++;
        for(int i = cMin; i <= cMax; i++){
            res[counter++] = arr[rMax][i];
        }
        rMax--;
        for(int i = rMax; i >= rMin; i--){
            res[counter++] = arr[i][cMax];
        }
        cMax--;
        for(int i = cMax; i >= cMin; i--){
            res[counter++] = arr[rMin][i];
        }
        return res;
    }

    private static void fill2Dfrom1D(int[][] arr, int[] res, int s){
        int rMin = s - 1;
        int cMin = s - 1;
        int rMax = arr.length - s;
        int cMax = arr[0].length - s;
        int counter = 0;
        for(int i = rMin; i <= rMax; i++){
            arr[i][cMin] = res[counter++];
        }
        cMin++;
        for(int i = cMin; i <= cMax; i++){
            arr[rMax][i] = res[counter++];
        }
        rMax--;
        for(int i = rMax; i >= rMin; i--){
            arr[i][cMax] = res[counter++];
        }
        cMax--;
        for(int i = cMax; i >= cMin; i--){
            arr[rMin][i] = res[counter++];
        }
    }

    private static void rotate(int[] arr, int r){
        r %= arr.length;
        if(r < 0){
            r += arr.length;
        }
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, r - 1);
        reverse(arr, r, arr.length - 1);
    }
    private static void reverse(int[] arr, int st, int end){
        while(st < end){
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }
    private static void display(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
