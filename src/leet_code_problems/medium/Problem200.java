package leet_code_problems.medium;

import org.jetbrains.annotations.NotNull;

public class Problem200 {
    public int numIslands(char[][] grid) {
        int counter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dft(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }
    private static void dft(char[][] grid, int i, int j){
        // Base Case
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        // Main Case
        grid[i][j] = '0';
        dft(grid, i, j + 1); // East direction
        dft(grid, i, j - 1); // West direction
        dft(grid, i - 1, j); // North direction
        dft(grid, i + 1, j); // South direction
    }
}
