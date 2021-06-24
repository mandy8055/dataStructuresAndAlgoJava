package data_structures.arrays_2d;


/*Question link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/2d-arrays/spiral-display-official/ojquestion
* */


import java.util.Scanner;
public class SpiralDisplay {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        spiralDisplay(arr);
        sc.close();
    }
    private static void spiralDisplay(int[][] arr){
        int min_row = 0;
        int min_col = 0;
        int max_row = arr.length - 1;
        int max_col = arr[0].length - 1;
        int totalNumberOfElements = (max_row + 1) * (max_col + 1);
        int counter = 0;
        while(counter < totalNumberOfElements){
            for(int i = min_row; i <= max_row && counter < totalNumberOfElements; i++){
                System.out.println(arr[i][min_col]);
                counter++;
            }min_col++;
            for(int i = min_col; i <= max_col && counter < totalNumberOfElements; i++){
                System.out.println(arr[max_row][i]);
                counter++;
            }max_row--;
            for(int i = max_row; i >= min_row && counter < totalNumberOfElements; i--){
                System.out.println(arr[i][max_col]);
                counter++;
            }max_col--;
            for(int i = max_col; i >= min_col && counter < totalNumberOfElements; i--){
                System.out.println(arr[min_row][i]);
                counter++;
            }min_row++;
        }
    }
}
