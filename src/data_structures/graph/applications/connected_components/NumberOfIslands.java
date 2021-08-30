package data_structures.graph.applications.connected_components;

public class NumberOfIslands {
    private static int countNumberOfIslands(int[][] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    dft(arr, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    private static void dft(int[][] arr, int i, int j) {
        // Base Case
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1) {
            return;
        }
        // Main Case
        arr[i][j] = 1;
        dft(arr, i, j + 1); // East direction
        dft(arr, i, j - 1); // West direction
        dft(arr, i - 1, j); // North direction
        dft(arr, i + 1, j); // South direction
    }
}
