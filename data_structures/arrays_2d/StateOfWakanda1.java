package data_structures.arrays_2d;
import java.util.Scanner;
/*
* Read the prompt here:
* https://classroom.pepcoding.com/myClassroom/the-switch-program-3/2d-arrays/wakanda-1-official/ojquestion
* */
public class StateOfWakanda1 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        printDesiredPath(arr);
        sc.close();
    }

    private static void printDesiredPath(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        for(int i = 0; i < cols; i++){
            if(i % 2 == 0){
                for (int[] ints : arr) {
                    System.out.println(ints[i]);
                }
            }else{
                for(int j = rows - 1; j >= 0; j--){
                    System.out.println(arr[j][i]);
                }
            }
        }
    }
}
