package algos.backtracking;
import java.util.Scanner;

// Problem link: https://pepcoding.com/resources/online-java-foundation/recursion-backtracking/knights-tour-official/ojquestion#!

public class KnightsTour {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] chess = new int[n][n];
        printKnightsTour(chess, row, col, 1);
        sc.close();
    }
    public static void printKnightsTour(int[][] chess, int r, int c, int step) {
        // Negative Base Case
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] != 0){
            return;
        }
        // Positive Base Case
        if(step == chess.length * chess.length){
            chess[r][c] = step;
            displayBoard(chess);
            chess[r][c] = 0; // Backtrack
            return;
        }
        // Place the step number on chess[r][c]
        chess[r][c] = step;
        printKnightsTour(chess, r - 2, c + 1, step + 1);
        printKnightsTour(chess, r - 1, c + 2, step + 1);
        printKnightsTour(chess, r + 1, c + 2, step + 1);
        printKnightsTour(chess, r + 2, c + 1, step + 1);
        printKnightsTour(chess, r + 2, c - 1, step + 1);
        printKnightsTour(chess, r + 1, c - 2, step + 1);
        printKnightsTour(chess, r - 1, c - 2, step + 1);
        printKnightsTour(chess, r - 2, c - 1, step + 1);
        chess[r][c] = 0; // Backtrack
    }
    public static void displayBoard(int[][] chess) {
        for (int[] ints : chess) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
