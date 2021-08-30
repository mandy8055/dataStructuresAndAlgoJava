package algos.backtracking;
import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodFill(arr, 0, 0, "");
    }
    public static void floodFill(int[][] maze, int sr, int sc, String asf) {
        // Negative base case
        if(sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] == 1){
            return;
        }
        // Positive base case
        if(sr == maze.length - 1 && sc == maze[0].length - 1){
            System.out.println(asf);
            return;
        }
        // Main Case
        maze[sr][sc] = 1;
        floodFill(maze, sr - 1, sc, asf + 't'); // top
        floodFill(maze, sr, sc - 1, asf + 'l'); // left
        floodFill(maze, sr + 1, sc, asf + 'd'); // down
        floodFill(maze, sr, sc + 1, asf + 'r'); // right
        maze[sr][sc] = 0;
    }
}

