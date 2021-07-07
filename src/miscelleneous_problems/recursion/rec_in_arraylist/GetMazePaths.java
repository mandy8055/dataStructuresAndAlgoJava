package miscelleneous_problems.recursion.rec_in_arraylist;

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-maze-paths-official/ojquestion#!

import java.util.*;

public class GetMazePaths {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getMazePaths(0, 0, n- 1, m - 1));
        sc.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // Negative base case
        if(sr > dr || sc > dc){
            return new ArrayList<>();
        }
        // base case
        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        //Main case
        ArrayList<String> horizontalPaths = getMazePaths(sr, sc + 1, dr, dc); // Horizontal paths just before the src
        ArrayList<String> verticalPaths = getMazePaths(sr + 1, sc, dr, dc); // Vertical paths just before the src
        ArrayList<String> result = new ArrayList<>();
        for (String s : horizontalPaths) {
            result.add("h" + s);
        }
        for (String s : verticalPaths) {
            result.add("v" + s);
        }
        return result;
    }

}
