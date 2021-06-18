package data_structures.arrays_2d;

public class MatrixMultiplication {
    public static void main(String[] args){
        int[][] arr1 = {{1, 2, 3}, {2, 1, 2}, {2, 3, 4}};
        int[][] arr2 = {{1, 1}, {2, 1}, {3, 1}};
        matrixMultiplication(arr1, arr2);
    }

    private static void matrixMultiplication(int[][] arr1, int[][] arr2){
        int rows1 = arr1.length;
        int cols1 = arr1[0].length;
        int rows2 = arr2.length;
        int cols2 = arr2[0].length;

        if(cols1 != rows2){
            System.out.println("Invalid input");
            return;
        }
        int[][] resArr = new int[rows1][cols2];
        for(int i = 0; i < rows1; i++){
            for(int j = 0; j < cols2; j++){
                for(int k = 0; k < rows2; k++){
                    resArr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        Print_2D_Array.print2DArray(resArr);
    }
}
