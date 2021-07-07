package miscelleneous_problems.recursion.rec_in_arraylist;

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-stair-paths-official/ojquestion#!

import java.util.*;

public class GetStairsPath {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        System.out.println(getStairPaths(n));
        sc.close();
    }

    public static ArrayList<String> getStairPaths(int n) {
        // Negative base case
        if(n < 0){
            return new ArrayList<>();
        }
        // Base case
        if(n == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        // Main case
        ArrayList<String> jump1 = getStairPaths(n - 1); // 1 jump
        ArrayList<String> jump2 = getStairPaths(n - 2); // 2 jumps
        ArrayList<String> jump3 = getStairPaths(n - 3); // 3 jumps
        ArrayList<String> result = new ArrayList<>();
        for(String s : jump1){
            result.add("1" + s);
        }
        for(String s : jump2){
            result.add("2" + s);
        }
        for(String s: jump3){
            result.add("3" + s);
        }
        return result;
    }
}
