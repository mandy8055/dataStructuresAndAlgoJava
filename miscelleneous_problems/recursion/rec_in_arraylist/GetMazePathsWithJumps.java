package miscelleneous_problems.recursion.rec_in_arraylist;

// problem link: https://pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-maze-path-with-jumps-official/ojquestion#!

import java.util.*;

public class GetMazePathsWithJumps {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getMazePaths(0, 0, n - 1, m - 1));
        sc.close();
    }
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // Negative Base case
        if(sr > dr || sc > dc){
            return new ArrayList<>();
        }
        // Positive base case
        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        // Main Case
        ArrayList<String> result = new ArrayList<>();
        for (int jump = 1; jump <= dc; jump++) {
            ArrayList<String> getHorizontalPaths = getMazePaths(sr, sc + jump, dr, dc);
            for (String s : getHorizontalPaths) {
                result.add("h" + jump + s);
            }
        }
        for (int jump = 1; jump <= dr; jump++) {
            ArrayList<String> getVerticalPaths = getMazePaths(sr + jump, sc, dr, dc);
            for (String s : getVerticalPaths) {
                result.add("v" + jump + s);
            }
        }
        for (int jump = 1; jump <= Math.min(dr, dc); jump++) {
            ArrayList<String> getDiagonalPaths = getMazePaths(sr + jump, sc + jump, dr, dc);
            for (String s : getDiagonalPaths) {
                result.add("d" + jump + s);
            }
        }
        return result;
    }
}