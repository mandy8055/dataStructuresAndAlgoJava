package data_structures.arrays_2d;

public class Print_2D_Array {
    public static void print2DArray(int[][] arr){
        print2D(arr);
    }
    private static void print2D(int[][] arr){
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
